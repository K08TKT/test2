package com.example.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RegForm {


	@NotBlank
	private String name;  //PC名

	@NotBlank
	private String cpu;


    @Min(0)
	private double ghz;

	private String description; //メモ欄


	@Min(2)
	private int ram;


	private int hddCapa;
	private int ssdCapa;

	private String manufacturers;  //メーカー


	private String strWifi;



	private String os;


	//private int version;

	private String byt;  //容量
	public String getByt() {
	return byt;
	}

	private String byt2;  //容量
	public String getByt2() {
	return byt2;
}

	@NotBlank
	@Length(min=3, max=50)
	private String gpu;


	@Length(min=7,max=9)
	private String resolution; //解像度


    @Min(7)
    @Max(25)
	private double lcd; //画面サイズ


	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date release_date;  //発売日


	private String release;

	//--------------------------
	@NotNull
	private String eth;
	public String getEth() {
		return eth;
	}

	@NotNull
	private String os_radio;
	public String getOs_radio() {
		return os_radio;
	}

	@NotNull
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
