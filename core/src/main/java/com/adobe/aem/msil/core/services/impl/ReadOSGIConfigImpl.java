package com.adobe.aem.msil.core.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.msil.core.config.MyFirstOSGIConfig;
import com.adobe.aem.msil.core.services.ReadOSGICOnfig;

@Component(service = ReadOSGICOnfig.class,immediate = true)
@Designate(ocd=MyFirstOSGIConfig.class)
public class ReadOSGIConfigImpl implements ReadOSGICOnfig{

	 private final Logger logger = LoggerFactory.getLogger(getClass());
	private String someName;
	private String payment;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return someName;
	}
	
	
	@Activate @Modified
	public void activate(MyFirstOSGIConfig config)
	{
		logger.info(config.getName() +"::::::::::" +config.getPaymentGateway());
		someName = config.getName();
		payment=config.getPaymentGateway();
	}
	
	@Deactivate 
	public void deactivate(MyFirstOSGIConfig config)
	{
		
		someName = StringUtils.EMPTY;
		logger.info("Are we Getting EMpty?????"+config.getName());
	}
	

	public String getPayment() {
		return payment;
	}


	public String getSomeName() {
		return someName;
	}


	@Override
	public String getPaymentfromService() {
		// TODO Auto-generated method stub
		return payment;
	}
	
	
}
