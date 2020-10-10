package nomomo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("commits")
public class CommitsEndpoint {

    private final CommitsService service;

    public CommitsEndpoint(
            final CommitsService service) {
        this.service = service;
    }

    @GET
    @Path("{sha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCommit(
            @PathParam("sha") final String sha) {
        return service.commitBySha(sha).map(Record::toString).orElse("NO COMMIT");
    }
}
