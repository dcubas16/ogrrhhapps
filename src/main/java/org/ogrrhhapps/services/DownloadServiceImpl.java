package org.ogrrhhapps.services;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.ogrrhhapps.dto.RemuneracionPorMesesDto;
import org.ogrrhhapps.dtoservices.RemPorMesesDtoConvert;
import org.ogrrhhapps.entities.Remuneracion;
import org.ogrrhhapps.entities.Servidor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@Service
public class DownloadServiceImpl implements DownloadService {

	public static final String TEMPLATE = "/report/ReporteDU03794.jrxml";
	public static final String LOGO = "/report/logo.jpg";
	protected static Logger logger = Logger.getLogger("service");
 
	@Autowired
	private JasperDatasourceService datasource;
	
	@Autowired
	private ExporterService exporter;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private ServidoresService servidoresService;
	
	@Autowired
	private RemuneracionService remuneracionService;
	
	public void download(String type, String token, String serDocIdAct , HttpServletResponse response) {
		 
		try {
			// 1. Add report parameters
			Servidor servidor = servidoresService.getServidor(serDocIdAct);
			List<Remuneracion> remuneraciones = remuneracionService.getRemuneraciones(serDocIdAct);
			List<RemuneracionPorMesesDto> remuneracionPorMesesDtos = new RemPorMesesDtoConvert(remuneraciones).getRemuneracionesPorMesesDtos();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date currentDate = new Date();
			
			HashMap<String, Object> params = new HashMap<String, Object>(); 
			params.put("serDocIdAct", servidor.getSerDocIdAct());
			params.put("serApePat", servidor.getSerApePat());
			params.put("serApeMat", servidor.getSerApeMat());
			params.put("serNombres", servidor.getSerNombres());
			params.put("fechaActual", dateFormat.format(currentDate));
			params.put("logo", this.getClass().getResourceAsStream(LOGO));
			 
			// 2.  Retrieve template
			InputStream reportStream = this.getClass().getResourceAsStream(TEMPLATE); 
			 
			// 3. Convert template to JasperDesign
			JasperDesign jd = JRXmlLoader.load(reportStream);
			 
			// 4. Compile design to JasperReport
			JasperReport jr = JasperCompileManager.compileReport(jd);
			 
			// 5. Create the JasperPrint object
			// Make sure to pass the JasperReport, report parameters, and data source
			JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(remuneracionPorMesesDtos));
			 
			// 6. Create an output byte stream where data will be written
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			 
			// 7. Export report
			exporter.export(type, jp, response, baos);
			 
			// 8. Write to reponse stream
			write(token, response, baos);
		
		} catch (JRException jre) {
//			logger.error("Unable to process download");
			System.out.println("Entro aqui download exeption");
			throw new RuntimeException(jre);
		}
	}
	
	/**
	* Writes the report to the output stream
	*/
	public void write(String token, HttpServletResponse response,
			ByteArrayOutputStream baos) {
		 
		try {
			System.out.println("Entro aqui write");
//			logger.debug(baos.size());
			
			// Retrieve output stream
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to output stream
			baos.writeTo(outputStream);
			// Flush the stream
			outputStream.flush();
			
			// Remove download token
			tokenService.remove(token);
			
		} catch (Exception e) {
			System.out.println("Entro aqui write exeption");
//			logger.error("Unable to write report to the output stream");
			throw new RuntimeException(e);
		}
	}

}
