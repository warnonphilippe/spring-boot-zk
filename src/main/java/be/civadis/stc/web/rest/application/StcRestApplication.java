package be.civadis.stc.web.rest.application;

import be.civadis.stc.web.rest.api.DefaultResource;
import be.civadis.stc.web.rest.api.TestResource;
import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.ChallengeScheme;
import org.restlet.routing.Router;
import org.restlet.security.ChallengeAuthenticator;
import org.restlet.security.SecretVerifier;
import org.restlet.security.Verifier;

/**
 * Application centrale REST (Dispatcher de méthode)
 * @author phw
 */
public class StcRestApplication extends Application {

    private ChallengeAuthenticator authenticator;

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        
        Verifier verifier = new SecretVerifier() {

            @Override
            public int verify(String username, char[] password) throws IllegalArgumentException {
                return RESULT_VALID;
            }
        };
        authenticator = new ChallengeAuthenticator(null, false, ChallengeScheme.HTTP_BASIC,
                "StcService Realm") {

            @Override
            protected boolean authenticate(Request request, Response response) {
                return true;
            }
        };
        authenticator.setVerifier(verifier);

        Router router = new Router(getContext());

        router.attachDefault(DefaultResource.class);


        //pour test
        router.attach("/test", TestResource.class);

        authenticator.setNext(router);
        
        return authenticator;

        // Pour supprimer le http basic authentication, il suffit de retourner router au lieu d'authentication ....
        // return router;
    }

    public String authenticate(Request request, Response response) {
        if (!request.getClientInfo().isAuthenticated()) {
            authenticator.challenge(response, false);
            return null;
        }
        return request.getClientInfo().getUser().getIdentifier();
    }

}
