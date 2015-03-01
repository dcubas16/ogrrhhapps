package org.ogrrhhapps.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class HtmlFileReader implements FileReader {

	@Override
	public String readFile(String url) {

		String pageContent = "No se encontro el contenido";

		try {
			File stockInputFile = new File(
					"../ogrrhhapps/resources/javascript/DL_1017.html");

			FileInputStream fileInputStream = new FileInputStream(
					stockInputFile);

			pageContent = fileInputStream.toString();

			fileInputStream.close();
			
			return pageContent;
		} catch (FileNotFoundException e) {
			System.err.println("FileStreamsReadnWrite: " + e);
		} catch (IOException e) {
			System.err.println("FileStreamsReadnWrite: " + e);
		}
		
		return pageContent;

	}

}
