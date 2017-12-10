package be.civadis.stc.web.rest.api;

import org.restlet.data.Header;
import org.restlet.representation.Representation;
import org.restlet.resource.Options;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;

/**
 * Ancêtre commun aux ressources REST
 * @author yvp
 */
public abstract class ResourceBase extends ServerResource {
  
   @Options
   public void doOptions(Representation entity) {
       Series<Header> responseHeaders = getHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Methods", "POST,GET,PUT,DELETE,OPTIONS");
        responseHeaders.add("Access-Control-Allow-Headers", "Content-Type"); 
        responseHeaders.add("Access-Control-Max-Age", "60"); 
    } 	
   
   protected void enableAllOrigins(){
       Series<Header> responseHeaders = getHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
   }

   private Series<Header> getHeaders(){
       Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers");
        if (responseHeaders == null) { 
            responseHeaders = new Series(Header.class);
            getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders); 
        } 
        return responseHeaders;
   }
   
}
