package com.devglan.service;


import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;
import java.sql.*;

public class PGFunctionProcedureService {
    @Value("${spring.tenant.datasource.url}")
    private String url_sp;
    @Value("${spring.tenant.datasource.username}")
    private String user_sp;
    @Value("${spring.tenant.datasource.password}")
    private String password_sp;

    public void update_meeting_summary(BigInteger id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(url_sp, user_sp, password_sp);
            System.out.println("Connected to the PostgreSQL server successfully.");
            pstmt = con.prepareStatement("call update_meeting_summary(?)");
            pstmt.setInt(1, id.intValueExact());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Call Procedure update_meeting_summary{?} Failed! - " + e.getMessage());
            throw new SQLException("Call Procedure update_meeting_summary{?} Failed!");
        }finally {
            pstmt.execute();
            pstmt.close();
            con.close();
        }
    }

    public void update_vo_meeting_summary(BigInteger id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DriverManager.getConnection(url_sp, user_sp, password_sp);
            System.out.println("Connected to the PostgreSQL server successfully.");
            pstmt = con.prepareStatement("call update_vo_meeting_summary(?)");
            pstmt.setInt(1, id.intValueExact());
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Call Procedure update_vo_meeting_summary{?} Failed! - "+ e.getMessage());
            throw new SQLException("Call Procedure update_vo_meeting_summary{?} Failed!");
        }finally {
            pstmt.execute();
            pstmt.close();
            con.close();
        }
    }
}
