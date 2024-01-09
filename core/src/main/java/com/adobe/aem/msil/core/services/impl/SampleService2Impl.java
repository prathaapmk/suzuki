package com.adobe.aem.msil.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

import com.adobe.aem.msil.core.services.SampleService;

@Component(service=SampleService.class,immediate = true)
@ServiceRanking(value=999)
public class SampleService2Impl implements SampleService{

	@Override
	public String getName() {
		
		return "Heloo I am Learning Service But the Value from here is from Service2";
	}

	

}
