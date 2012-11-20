package com.techiekernel.ws.jaxws.mtom;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.xml.ws.WebServiceException;
import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.techiekernel.ws.jaxws.mtom.ImageServer")
public class FileImageServer implements ImageServer {

	final static String PATH = "/home/satish/";
	
	public Image downloadImage(String name) {
		try {
			//Create a file object with file name and read the image
			File image = new File(PATH + name);
			return ImageIO.read(image);
		} catch (IOException e) {
			e.printStackTrace();
			throw new WebServiceException("Download Failed");
		}
	}

	public String uploadImage(Image data, String name) {
		if (data != null) {
			try {
				File image = new File(PATH + name);
				ImageIO.write((BufferedImage)data, "jpg", image);
			} catch (IOException e) {
				e.printStackTrace();
				throw new WebServiceException("Upload Failed");
			}
			return "Upload Successful";
		}
		throw new WebServiceException("No data to upload.");
	}
}
