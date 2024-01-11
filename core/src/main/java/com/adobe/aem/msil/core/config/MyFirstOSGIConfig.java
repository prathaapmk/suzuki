package com.adobe.aem.msil.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My First OSGI COnfig",description = "This is my First OSGI Config Description")
public @interface MyFirstOSGIConfig {
	
	@AttributeDefinition(name = "Some String",type = AttributeType.STRING,description = "My first Attribute")
	public String getName() default "Some String";

	@AttributeDefinition(name = "Payment Gateway String",type = AttributeType.STRING,description = "My Payment Gateway")
	public String getPaymentGateway() default "https://www.payment.test.gatway.com";
}
