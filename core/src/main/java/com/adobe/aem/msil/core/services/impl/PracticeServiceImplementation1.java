package com.adobe.aem.msil.core.services.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

import com.adobe.aem.msil.core.services.PracticeService;
@Component(service=PracticeService.class,immediate = true)
@ServiceRanking(value = 10000)
public class PracticeServiceImplementation1 implements PracticeService{

	@Override
	public String getSomeString() {

		return "Some String From PracticeServiceImplementation1";
	}

}
