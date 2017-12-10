package be.civadis.stc.web.rest.api;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

import java.io.IOException;

/**
 * Ressource pour tester les services REST
 * @author yvp
 */
public class TestResource extends ResourceBase {
 
    @Get
    public String getTest() throws IOException {

        enableAllOrigins();
        
        return("Stc answer: OK");
    }
    
    @Put
    public String putTest(Representation entity) throws IOException {
        System.err.println("Parametre test : " + getQuery().getValues("test"));
        System.err.println("getText : " + entity.getText());
        
        return "{\"Test\":\"OK\"}";
    }

       
}
