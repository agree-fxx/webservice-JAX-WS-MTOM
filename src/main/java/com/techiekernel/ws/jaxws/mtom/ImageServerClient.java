package com.techiekernel.ws.jaxws.mtom;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ImageServerClient {
	
	final static String PATH = "/home/satish/Desktop/";
	
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://localhost:8080/webservice-JAX-WS-MTOM/imageserver?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://mtom.jaxws.ws.techiekernel.com/",
				"FileImageServerService");

		Service service = Service.create(url, qname);

		ImageServer imageServer = service.getPort(ImageServer.class);

		File imageFile = new File(PATH + "natgeo.jpg");
		
		Image uimage = null;
		
		try {
			uimage =  ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// now upload the image 
		imageServer.uploadImage((BufferedImage)uimage, "natgeo_uploaded.jpg");
		
		//lets now download the uploaded image
		Image dimage = imageServer.downloadImage("natgeo_uploaded.jpg");
		File dimageFile = new File(PATH + "natgeo_downloaded.jpg");

		try {
			ImageIO.write((BufferedImage)dimage, "jpg", dimageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
