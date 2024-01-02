package com.adobe.aem.msil.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.day.cq.wcm.api.Page;

import lombok.Getter;

@Getter
@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleHelper {
	
	@RequestAttribute
	private String pageUrl;
	
	private String title;
	
	@SlingObject
	ResourceResolver rr;
	
	@PostConstruct
	public void init()
	{
		
		Resource pagePathResource = rr.getResource(pageUrl);
		
		Page pageProvided = pagePathResource.adaptTo(Page.class);
		title = pageProvided.getPageTitle();
		
		
	}

}
