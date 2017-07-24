package com.ehome.niuyunyang.nyylib.util.dateutil;

public enum DatePrex {
	hh_mm("HH:mm"),
	hh_mm_ss("HH:mm:ss"),
	yyMMdd("yyMMdd"),
	yyyyMM("yyyyMM"),
	yyyyMMdd("yyyyMMdd"),
	yyyyMMddHH("yyyyMMddHH"),
	yyyy_MM_dd("yyyy-MM-dd"),
	yyyy_mm("yyyy-MM"),
	MM_dd("MM-dd"),
	yyyy_MM("yyyy.MM"),
	yyyy_MM_DD("yyyy.MM.dd"),
	dd("dd"),
	MMdd("MMdd"),
	yyyy_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
	yyyy__MM__dd("yyyy/MM/dd"),
	yyyy("yyyy"),
	yy__MM__dd("yy/MM/dd");

	String prex;

	DatePrex(String prex){
		this.prex = prex;
	};

	@Override
	public String toString(){
		return this.prex;
	}
}
