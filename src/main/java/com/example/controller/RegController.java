package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.PcApplicationService;
import com.example.domain.pc.model.Reg;
import com.example.domain.pc.service.PcService;
import com.example.form.RegForm;
import com.example.repository.RegMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/pc")
@Slf4j
public class RegController {

	@Autowired
	private PcService pcService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PcApplicationService pcApplicationService;




	@GetMapping("/form")
	public String getReg(Model model,@ModelAttribute  RegForm form) { //,Reg reg){
		log.info(form.toString());
		//log.info(reg.toString());
		model.addAttribute("regForm", form);

        Map<String ,String> wifiMap = pcApplicationService.getWifiMap();
        model.addAttribute("wifiMap",wifiMap);

		model.addAttribute("os_radio",new RegForm());
		model.addAttribute("allOs",Arrays.asList("10-Home","10-Home-Sモード","10-Pro","10Pro-Sモード","10-S","その他"));
		model.addAttribute("byt",new RegForm());
		model.addAttribute("bytSelect",Arrays.asList("TB","GB"));
		model.addAttribute("byt2",new RegForm());
		model.addAttribute("bytSelect2",Arrays.asList("TB","GB"));
		model.addAttribute("eth",new RegForm());
		model.addAttribute("eth_radio",Arrays.asList("100","1000"));
		return "pc/form";




}

	@PostMapping("/form")
	public String postReg(Model model, @ModelAttribute @Validated RegForm form,
			BindingResult bindingResult,
			RegMapper rm) {

		if(bindingResult.hasErrors()) {
			return getReg(model,form);
		}
		log.info(form.toString());


		 Reg reg=modelMapper.map(form, Reg.class);
		    String strWf = String.join(",", form.getWifi());
		    String strOs = String.join(",", form.getOs_radio());
		    String str =new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(form.getRelease_date());


		    form.setOs(strOs);
			reg.setOs(strOs);
		    form.setStrWifi(strWf);
		    reg.setStrWifi(strWf);
		    form.setRelease(str);
		    reg.setRelease(str);


		    pcService.RegPc(reg);




		    model.addAttribute("RegForm", form);
		    System.out.println(form);



      return "redirect:/top";

	}
}