package com.techiekernel.ws.jaxws.mtom;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * Service end point interface
 * 
 * @author satish
 * 
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface ImageServer {
	// download a image from server
	@WebMethod
	public Image downloadImage(String name);

	// update image to server
	@WebMethod
	public String uploadImage(Image data, String name);
}
