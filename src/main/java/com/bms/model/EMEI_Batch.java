package com.bms.model;

import com.opencsv.bean.CsvBindByName;

public class EMEI_Batch {

	    @CsvBindByName
	    private String SNo;
	    @CsvBindByName
	    private String Batch_Name;
	    @CsvBindByName
	    private String Imei;
	    @CsvBindByName(column = "country")
	    private String Tcu;
	    @CsvBindByName
	    private String Bms;
	    @CsvBindByName
	    private String Cfg;
	    
		public EMEI_Batch(String sNo, String batch_Name, String imei, String tcu, String bms, String cfg) {
			super();
			SNo = sNo;
			Batch_Name = batch_Name;
			Imei = imei;
			Tcu = tcu;
			Bms = bms;
			Cfg = cfg;
		}
	    
	    
	    
		
}
