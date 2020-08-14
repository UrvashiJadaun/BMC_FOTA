package com.bms.model;

import com.opencsv.bean.CsvBindByName;

public class EMEI_Batch {

	    @CsvBindByName
	    private long id;
	    @CsvBindByName
	    private String name;
	    @CsvBindByName
	    private String email;
	    @CsvBindByName(column = "country")
	    private String countryCode;
	    @CsvBindByName
	    private int age;
	
}
