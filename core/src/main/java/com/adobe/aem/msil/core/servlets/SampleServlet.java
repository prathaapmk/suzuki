package com.adobe.aem.msil.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceDescription;

@Component(service = Servlet.class, property={
        "sling.servlet.methods=" + "GET",
        "sling.servlet.paths="+ "/bin/msil/test",
        "sling.servlet.resourceTypes="+"/msil/components/ajaxbutton",
        "sling.servlet.extensions=" + "txt"
})
@ServiceDescription("Sample Demo Servlet")
public class SampleServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

	/*
	 * @Reference ReadJsonFromAPIService readJsonFromAPIService;
	 * 
	 * @Reference FetchDataServicefromJson fetchdata;
	 */

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws IOException {

        String json= StringUtils.EMPTY;
        try {
         json=  "Heloo I am from Servlet";
        		 
        		 //fetchdata.fetchDatafromJsonApi();
        		 //readJsonFromAPIService.readJsonfromAPI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       // final String str = "This is Demo Servlet";
        resp.setContentType("text/plain");
        resp.getWriter().write(json);
    }


}
