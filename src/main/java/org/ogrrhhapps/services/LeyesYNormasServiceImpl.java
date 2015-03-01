package org.ogrrhhapps.services;

import java.util.List;

import org.ogrrhhapps.dao.LeyNormaDAO;
import org.ogrrhhapps.entities.LeyNorma;
import org.ogrrhhapps.filereader.HtmlFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeyesYNormasServiceImpl implements LeyesYNormasService{
	
	private LeyNormaDAO leyNormaDAO;
	
	@Autowired
	private HtmlFileReader htmlFileReader;
	
	@Autowired
	public LeyesYNormasServiceImpl(LeyNormaDAO leyNormaDAO){
		this.leyNormaDAO = leyNormaDAO;
	}
	
	@Override
	public List<LeyNorma> obtenerLeyesYNormas(){
		return leyNormaDAO.obtenerLeyesYNormas();
	}
	
	@Override
	public List<LeyNorma> obtenerLeyesYNormasPorBuscador(String criterioBusqueda) {
		return leyNormaDAO.obtenerLeyesYNormasPorBuscador(criterioBusqueda);
	}

	@Override
	public String readHtmlFile(String url) {
		return htmlFileReader.readFile(url);
	}
}
