package com.example.form;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PcDetailForm {

	private String name;
	private String os;
	private String cpu;
	private double ghz;
	private String description;
	private int ram;
	private int hddCapa;
	private int ssdCapa;
	private String manufacturers;
	private String strWifi;

    private String byt;  //容量
	public String getByt() {
	return byt;
}
	private String byt2;  //容量
	public String getByt2() {
	return byt2;
}
	private String gpu;
	private String resolution; //解像度
	private double lcd; //画面サイズ

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date release_date;  //発売日

	private String release;

	//--------------------------
	private String eth;
	public String getEth() {
		return eth;
	}
	private String os_radio;
	public String getOs_radio() {
		return os_radio;
	}
	private List<String> wifi;
	public List<String> getWifi(){
		return wifi;

	//----------------------------
	}

	public void setOs_radio(String os_radio) {
		this.os_radio = os_radio;
	}
	public void setEth(String eth) {
	    this.eth = eth;
	}
	public void setWifi(List<String> wifi) {
		this.wifi = wifi;
	}

}
