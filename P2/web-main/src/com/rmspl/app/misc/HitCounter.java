package com.rmspl.app.misc;

import java.util.List;

import com.rmspl.app.data.service.DataFetcher;

/**
 * This class is used to manage Hit Counter
 * @author Sourav Das
 *
 */

public class HitCounter {

	/**
	 * Method to count the Hit counter
	 * @return Counter
	 */
	public static synchronized int getHitCount() {
        try {
			List<String[]> lstdata = DataFetcher.getData("SELECT counter FROM hits");
			int hits = Integer.parseInt(lstdata.get(0)[0]) + 1;
			DataFetcher.insertData("UPDATE hits SET counter = "+hits);
			return hits;
		} catch (Exception e) { 
			return 0;
		}
    }
}
