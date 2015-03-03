package org.ogrrhhapps.controllers;

import org.ogrrhhapps.services.ServidoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private ServidoresService servidoresService;
	
	@RequestMapping(value="home.htm", method=RequestMethod.GET )
	public String home(Model model)
	{
		return "home";
	}
	
	@RequestMapping(value="buscarServidores.htm", method=RequestMethod.GET )
	public @ResponseBody String buscarServidores(@RequestParam("serDocIdAct") String serDocIdAct
			,@RequestParam("serApePat") String serApePat
			,@RequestParam("serApeMat") String serApeMat
			,@RequestParam("serNombres") String serNombres
			,Model model)
	{
		
		return servidoresService.getServidores(serDocIdAct, serApePat, serApeMat, serNombres);
	}
	
}