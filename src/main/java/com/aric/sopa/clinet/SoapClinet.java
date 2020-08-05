package com.aric.sopa.clinet;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.aric.sopa.loaneligibility.Acknowledgement;
import com.aric.sopa.loaneligibility.CustomerRequest;

@Service
public class SoapClinet {

	@Autowired
	private Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate  template;
	

	public Acknowledgement getLoanStatus(CustomerRequest request) {
		template = new WebServiceTemplate(marshaller);
		Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws", request);
		
		
		return acknowledgement;
	}
	
	
	
	
}
