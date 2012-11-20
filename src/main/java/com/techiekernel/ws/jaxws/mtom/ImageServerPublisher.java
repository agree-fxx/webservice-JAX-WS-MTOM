package com.techiekernel.ws.jaxws.mtom;

import javax.xml.ws.Endpoint;

/**
 * End point publisher
 * @author satish
 *
 */
public class ImageServerPublisher {
	public static void main(String[] args) {
		System.out.println("main called");
		Endpoint.publish("http://localhost:8080/webservice-JAX-WS-MTOM/imageserver", new FileImageServer());
	}
}
