package org.ogrrhhapps.controllers;

import javax.servlet.http.HttpServletResponse;

import org.ogrrhhapps.dto.StatusResponse;
import org.ogrrhhapps.services.DownloadService;
import org.ogrrhhapps.services.RemuneracionService;
import org.ogrrhhapps.services.ServidoresService;
import org.ogrrhhapps.services.TokenService;
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
	private DownloadService downloadService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private ServidoresService servidoresService;
	
	@Autowired
	private RemuneracionService remuneracionService;
	
	@RequestMapping(value="home.htm", method=RequestMethod.GET )
	public String home(Model model)
	{
//		List<Remuneracion> remuneracions = remuneracionService.getRemuneraciones("43953815");
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
	
	@RequestMapping(value="/download/progress")
	public @ResponseBody StatusResponse checkDownloadProgress(@RequestParam String token) {
//		System.out.println("checkDownloadProgress");
		return new StatusResponse(true, tokenService.check(token));
	}
	
	@RequestMapping(value="/download/token")
	public @ResponseBody StatusResponse getDownloadToken() {
//		System.out.println("getDownloadToken");
		return new StatusResponse(true, tokenService.generate());
	}
	
	@RequestMapping(value="/download")
	public void download(@RequestParam String type,
			@RequestParam String token, @RequestParam String serDocIdAct, 
			HttpServletResponse response) {
//		System.out.println("download");
		downloadService.download(type, token, serDocIdAct, response);
	}
	
}