package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.pc.model.Reg;
import com.example.domain.pc.service.PcService;
import com.example.form.PcDetailForm;

import lombok.extern.slf4j.Slf4j;
@Controller
@RequestMapping("/pc")
@Slf4j
public class PcDetailController {

	@Autowired
	private PcService pcService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/detail/{name}")

	public String getPc(PcDetailForm form,Model model,
			@PathVariable("name")String name) {
		log.info(form.toString());
	Reg reg = pcService.getPcOne(name);

	reg.setName(name);

	form = modelMapper.map(reg, PcDetailForm.class);

	model.addAttribute("pcDetailForm",form);

	return "pc/detail";
	}
	@PostMapping(value="/detail",params="update")
	public String updatePc(PcDetailForm form,Model model) {


		pcService.updatePcOne(form.getName(),
				form.getOs(),
				form.getCpu(),
				form.getGhz(),
				form.getGpu(),
				form.getRam(),
				form.getHddCapa(),
				form.getByt(),
				form.getSsdCapa(),
				form.getByt2(),
				form.getEth(),
				form.getStrWifi(),
				form.getResolution(),
				form.getLcd(),
				form.getManufacturers(),
				form.getRelease(),
				form.getDescription());


		return "redirect:/pc/list";
	}

	@PostMapping(value="/detail",params="delete")
	public String deletePc(PcDetailForm form,Model model) {

		pcService.deletePcOne(form.getName());

		return "redirect:/pc/list";

		}



}
