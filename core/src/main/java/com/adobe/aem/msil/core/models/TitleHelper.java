package com.adobe.aem.msil.core.models;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.adobe.granite.asset.api.AssetManager;
import com.adobe.granite.asset.api.AssetMetadata;
import com.day.cq.dam.api.Asset;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import lombok.Getter;

@Getter
@Model(adaptables = SlingHttpServletRequest.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TitleHelper {
	
	@RequestAttribute
	private String pageUrl;
	
	
	
	private String title;
	
	@SlingObject
	ResourceResolver rr;
	
	@SlingObject
	PageManager pm;
	
	@PostConstruct
	public void init()
	{
		
		//Title using Resource and Page Adapting
		
		Resource pagePathResource = rr.getResource(pageUrl);
		Page pageProvided = pagePathResource.adaptTo(Page.class);
		String pagetitleusingResource = pageProvided.getTitle();
	
		// Title USing PageManager and ValueMap

		PageManager pm = pagePathResource.getResourceResolver().adaptTo(PageManager.class);
		Page containingPage = pm.getContainingPage(pagePathResource);
		ValueMap pageProperties = containingPage.getProperties();
		String pageTitleusingValueMap = pageProperties.get("pagetitle",String.class);
		
		title = pagetitleusingResource != null?pagetitleusingResource:pageTitleusingValueMap;
		
	}

}
