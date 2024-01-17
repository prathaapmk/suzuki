package com.adobe.aem.msil.core.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public class CommonUtil {
	
	private static final String SYSTEM_USER_WRITE = "write_service";
	
	 public static ResourceResolver getResourceResolver(ResourceResolverFactory resourceResolverFactory ) throws LoginException {

	        Map<String, Object> param = new HashMap();
	        param.put(ResourceResolverFactory.SUBSERVICE, SYSTEM_USER_WRITE);
	        return resourceResolverFactory.getServiceResourceResolver(param);
	    }

}
