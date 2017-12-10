package be.civadis.stc.web.rest.api;

import org.restlet.representation.InputRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * @author yvp
 */
public class DefaultResource extends ServerResource {

  @Get
  public InputRepresentation execute() {
      throw new RuntimeException("No router defined");
  }

}
