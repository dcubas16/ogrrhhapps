package org.ogrrhhapps.services;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperPrint;

public interface ExporterService {
	public HttpServletResponse export(String type, JasperPrint jp,
			HttpServletResponse response, ByteArrayOutputStream baos);

	public void exportXls(JasperPrint jp, ByteArrayOutputStream baos);

	public void exportPdf(JasperPrint jp, ByteArrayOutputStream baos);
}
