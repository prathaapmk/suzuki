package com.adobe.aem.msil.core.services.impl;

import org.osgi.service.component.annotations.Component;

import com.adobe.aem.msil.core.services.AgainInterface;

@Component(service = AgainInterface.class, immediate = true)
public class AgainServiceImpl implements AgainInterface {

	@Override
	public String getValue() {
		return "Hey How r u?";
	}

}
