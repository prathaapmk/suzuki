package com.adobe.aem.msil.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.msil.core.services.PracticeService;
import com.adobe.aem.msil.core.services.SampleService;

@Component(service = SampleService.class,immediate = true)
@ServiceRanking(value = 1000)
public class SampleServiceImpl implements SampleService{


	 private final Logger logger = LoggerFactory.getLogger(getClass());
	 
	 @Reference(target = "(component.name=com.adobe.aem.msil.core.services.impl.PracticeServiceImplementation1)")
	 PracticeService ps;
	@Override
	public String getName() {
		////All your business logic 
		logger.info("I am Writing Bussiness logic here");	
		return ps.getSomeString();
	}

	
	@Activate
	public void activate()
	{
		
		logger.info("I will be called during the starting of My Bundle");	
		
	}
	
	
	@Deactivate
	public void deactivate()
	{
		
		logger.info("I will be called during the Deactivating of My Bundle");	
		
	}
	
	
}
