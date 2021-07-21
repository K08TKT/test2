package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PcApplicationService {

	public Map<String,String> getWifiMap(){
		Map<String,String> wifiMap = new LinkedHashMap<>();
		wifiMap.put("無し","無し");
		wifiMap.put("a","a");
		wifiMap.put("bgn","bgn");
		wifiMap.put("ac","ac");
		wifiMap.put("ax","ax");
		return wifiMap;
	}

}
