package org.ogrrhhapps.services;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.ogrrhhapps.dao.ServidoresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JasperDatasourceServiceImpl implements JasperDatasourceService {

	@Autowired
	private ServidoresDAO servidoresDAO;
	
	@Override
	public JRDataSource getServidorDataSource() {

//		Servidor servidor = servidoresDAO.getServidor("43953815");
		
//		ServidorDto servidorDto = new ServidorDto(servidor.getSerApePat(), servidor.getSerApeMat(), servidor.getSerNombres());
		
		return new JRBeanCollectionDataSource(null);
	}

}
