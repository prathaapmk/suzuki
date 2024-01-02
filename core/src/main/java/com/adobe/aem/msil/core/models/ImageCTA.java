package com.adobe.aem.msil.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import lombok.Getter;

@Getter
@Model(adaptables = Resource.class)
public class ImageCTA {
	
	@ValueMapValue
	private String ctaTitle;
	
	@ValueMapValue
	private String ctaLink;

}
