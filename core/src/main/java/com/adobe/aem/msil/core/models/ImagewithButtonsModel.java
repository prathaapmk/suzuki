package com.adobe.aem.msil.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import lombok.Getter;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = "/apps/msil/components/imagewithbuttons")
@Getter
@Exporter(name = "jackson",extensions = "json")
public class ImagewithButtonsModel {
	
	@ValueMapValue
	private String title;
	
	@ValueMapValue
	private String image;
	
	@ValueMapValue(name = "sling:vanityPath")
	private String[] vanityPath;
	
	@ChildResource
	List<ImageCTA> buttonProps;

}
