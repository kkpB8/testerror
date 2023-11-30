package com.rmspl.app.data.connector;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import com.rmspl.app.data.service.DataFetcher;

/**
 * This is the factory class to create a JDBC connection. Internally it uses 
 * JDBC pool to manage a pool of connections. By design, this class is an singleton
 * class. The returned connection can be used normally.
 * @author abhiroopd
 *
 */

public class JDBCConnectionFactory {
	
	private static Log log = LogFactory.getLog(JDBCConnectionFactory.class);
	
	private static String DB_SERVER = null;
	
	private static String JDBC_DRIVER = null;
	
	private static String USER_NAME = null;
	
	private static String PASSWORD = null;
	
	private static String DB_SCHEMA = null;
	
	private static StringBuilder DB_URL = new StringBuilder();
	
	private static DataSource dataSource = null;
	
	private static GenericObjectPool connectionPool = null; 
	
	private static String JDBC_PROPERTIES_PATH = "whizmap-jdbc.properties";
	
	private static int INIT_CACHE_SIZE = 1;
	
	private static int MAX_CACHE_SIZE = 1;
	
	private static int MIN_EVICT_IDLE_TIME = 0;
	
	private static int TIME_BTWN_EVICT_MILL = 0;
	
	private static int NUM_PER_EVICT_MILL = 0;
	
	private static boolean TEST_ON_BORROW = false;
	
	private static String VALIDATE_SQL = "";
	
	private static String NOACCESSTOPROCEDUREBODIES = null;
	
	/**
	 * Private constructor, required for Singleton design
	 */
	private JDBCConnectionFactory(){
		try{
			loadProperties();
			dataSource = setupDataSource();
		} catch(ClassNotFoundException cnf){
			System.out.println("Database driver class not found.....");
			System.out.println(cnf);
		} catch(IOException ioe){
			System.out.println("Failed to load JDBC properties.....");
			System.out.println(ioe);
		}
		
	}
	
	/**
	 * API to get the only available instance of the factory.
	 * @return
	 */
	public static JDBCConnectionFactory getInstance(){
		return JDBCConnectionFactoryHolder.instance;
	}
	
	/**
	 * Reads the properties file and loads the related properties into variables.
	 * @throws IOException	If fails to read the property file
	 */
	private void loadProperties() throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader()
									.getResourceAsStream(JDBC_PROPERTIES_PATH);
		
		Properties jdbcProps = new Properties();
		jdbcProps.load(is);
		
		DB_SERVER = readProperty("jdbc.components.db.url",jdbcProps);
		JDBC_DRIVER = readProperty("jdbc.components.db.driver", jdbcProps);
		USER_NAME = readProperty("jdbc.components.db.userName", jdbcProps);
		PASSWORD = readProperty("jdbc.components.db.password", jdbcProps);
		DB_SCHEMA = readProperty("jdbc.components.db.schema", jdbcProps);
		INIT_CACHE_SIZE = Integer.parseInt(readProperty("jdbc.components.db.initialSize", jdbcProps));
		MAX_CACHE_SIZE = Integer.parseInt(readProperty("jdbc.components.db.maxActive", jdbcProps));
		TIME_BTWN_EVICT_MILL = Integer.parseInt(readProperty("timeBetweenEvictionRunsMillis", jdbcProps));
		MIN_EVICT_IDLE_TIME = Integer.parseInt(readProperty("minEvictableIdleTimeMillis", jdbcProps));
		NUM_PER_EVICT_MILL = Integer.parseInt(readProperty("numTestsPerEvictionRun", jdbcProps));
		TEST_ON_BORROW = Boolean.parseBoolean(readProperty("jdbc.components.db.testOnBorrow", jdbcProps));
		VALIDATE_SQL = readProperty("jdbc.components.db.validationQuery", jdbcProps);
		NOACCESSTOPROCEDUREBODIES = readProperty("jdbc.components.db.noAccessToProcedureBodies", jdbcProps);
		
		DB_URL.append("jdbc:mysql://")
			.append(DB_SERVER).append("/").append(DB_SCHEMA).append("?")
				.append("useUnicode=true&characterEncoding=UTF-8&")
				.append("user=").append(USER_NAME).append("&password=")
				.append(PASSWORD).append("&noAccessToProcedureBodies=")
				.append(NOACCESSTOPROCEDUREBODIES);
		
		//log.info(DB_URL);
	}
	
	/**
	 * Reads a given property from the passed properties. If the property is found
	 * null for the given key, an <code>IllegalArgumentException</code> is thrown.
	 * @param propertyKey			The key to read the property
	 * @param jdbcProperties		The properties
	 * @return						The retrieved property value
	 */
	private String readProperty(String propertyKey, Properties jdbcProperties){
		if(jdbcProperties.getProperty(propertyKey) == null) {
			throw new IllegalArgumentException(propertyKey + " is null");
		} else{
			return jdbcProperties.getProperty(propertyKey);
		}
	}
	
	/**
	 * Returns a new instance of a poolable connection. If a free instance of the connection
	 * is available in the pool, the same returned. Otherwise a new instance of the connection
	 * is returned. If the pool got exhausted, the request waits till a connection is returned
	 * into the pool. Once the caller finishes the task, it should call the close method on the
	 * connection to allow the connection to return into the pool for further use.
	 * The connection is transaction aware i.e. it can take part in a transaction.
	 * @return					The connection
	 * @throws SQLException		If fails to create a connection
	 */
	public Connection getConnection() throws SQLException{
		return getConnection(false);
	}
	
	/**
	 * Returns a new instance of a poolable connection. If a free instance of the connection
	 * is available in the pool, the same returned. Otherwise a new instance of the connection
	 * is returned. If the pool got exhausted, the request waits till a connection is returned
	 * into the pool. Once the caller finishes the task, it should call the close method on the
	 * connection to allow the connection to return into the pool for further use.
	 * Transaction handling mode of the connection can be managed through <code>transacted</code>
	 * flag. If <code>true<code>, the connection can take part in a transaction.
	 * @param transacted		Flag to indicate whether needs the transaction mode
	 * @return					The connection
	 * @throws SQLException		If fails to create a connection
	 */
	public Connection getConnection(boolean transacted) throws SQLException {
		Connection conn = dataSource.getConnection();
		// relation of the transacted flag and auto commit behavior are reversed. i.e. if marked
		// transacted, the auto commit behavior should be false.
		conn.setAutoCommit(!transacted);
		return conn;
	}
	
	private DataSource setupDataSource() throws ClassNotFoundException {
		// load the properties required to connect the database
		Class.forName(JDBC_DRIVER);
        //
        // First, we'll need a ObjectPool that serves as the
        // actual pool of connections.
        //
        // We'll use a GenericObjectPool instance, although
        // any ObjectPool implementation will suffice.
        //
        connectionPool = new GenericObjectPool(null);
        connectionPool.setMinIdle(INIT_CACHE_SIZE);
        connectionPool.setMaxActive(MAX_CACHE_SIZE);

        connectionPool.setMinEvictableIdleTimeMillis(MIN_EVICT_IDLE_TIME);
        connectionPool.setTimeBetweenEvictionRunsMillis(TIME_BTWN_EVICT_MILL);
        connectionPool.setNumTestsPerEvictionRun(NUM_PER_EVICT_MILL);
        
        connectionPool.setTestOnBorrow(TEST_ON_BORROW);
        
        //
        // Next, we'll create a ConnectionFactory that the
        // pool will use to create Connections.
        // We'll use the DriverManagerConnectionFactory,
        // using the connect string passed in the command line
        // arguments.
        //
        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(DB_URL.toString(),null);

        //
        // Now we'll create the PoolableConnectionFactory, which wraps
        // the "real" Connections created by the ConnectionFactory with
        // the classes that implement the pooling functionality.
        //
        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
        										connectionFactory,connectionPool,null,VALIDATE_SQL,false,true);
        //
        // Finally, we create the PoolingDriver itself,
        // passing in the object pool we created.
        //
        PoolingDataSource dataSource = new PoolingDataSource(connectionPool);

        return dataSource;
    }
	
	/**
	 * An inner class to act as a holder of the only instance of the outer class. A better
	 * way to create a sigleton class lazyly. The class loader takes care about the 
	 * synchronization issue for a multi-threaded environment. 
	 * @author abhiroopd
	 */
	private static class JDBCConnectionFactoryHolder {
        static JDBCConnectionFactory instance = new JDBCConnectionFactory();
    }

	public int getActiveSize(){
		return connectionPool.getNumActive();
	}
	
	public int getIdleSize(){
		return connectionPool.getNumIdle();
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("DB_SERVER -- " )
			.append(DB_SERVER)
			.append("\n")
			.append("JDBC_DRIVER -- " )
			.append(JDBC_DRIVER)
			.append("\n")
			.append("USER_NAME -- " )
			.append(USER_NAME)
			.append("\n")
			.append("PASSWORD -- " )
			.append(PASSWORD)
			.append("\n")
			.append("DB_SCHEMA -- " )
			.append(DB_SCHEMA)
			.append("\n")
			.append("DB_URL -- " )
			.append(DB_URL.toString())
			.append("\n")
			.append("JDBC_PROPERTIES_PATH -- " )
			.append(JDBC_PROPERTIES_PATH);
		
		return stb.toString();
	}	
}