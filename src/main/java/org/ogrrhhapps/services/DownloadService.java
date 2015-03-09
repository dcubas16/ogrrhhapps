package org.ogrrhhapps.services;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

public interface DownloadService {

	public void download(String type, String token, String serDocIdAct, HttpServletResponse response);

	public void write(String token, HttpServletResponse response,
			ByteArrayOutputStream baos);
}
