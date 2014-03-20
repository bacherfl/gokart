package at.fbacher.gokart.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import at.fbacher.gokart.model.Driver;

@RequestScoped
@Named
public class DriverImageController {
	
	
	public StreamedContent getImageForDriver(Driver driver) {
		StreamedContent image = null;
		try {
			
			File file = new File("../gokart-data/images/" + driver.getPhotoUrl());
			byte[] b = new byte[(int)file.length()];
			InputStream stream = new FileInputStream(file);
			stream.read(b);
			image = new DefaultStreamedContent(new ByteArrayInputStream(b));
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
}
