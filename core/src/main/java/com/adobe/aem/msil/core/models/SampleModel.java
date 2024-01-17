package com.adobe.aem.msil.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,adapters = SampleInterface.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SampleModel implements SampleInterface{

	@ValueMapValue
	private String cannonicalUrl;
	
	@ValueMapValue
	private String seoData;
	
	@Override
	public String getCannonicalUrl() {

		return cannonicalUrl;
	}

	@Override
	public String getSeoData() {

		return seoData;
	}

}
