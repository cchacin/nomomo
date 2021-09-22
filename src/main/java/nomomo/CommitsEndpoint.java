package nomomo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("commits")
public class CommitsEndpoint {

    private final CommitsService service;

    public CommitsEndpoint(
            final CommitsService service) {
        this.service = service;
    }

    @GET
    @Path("{sha}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCommit(
            @PathParam("sha") final String sha) {
        return service.commitBySha(sha).map(Record::toString).orElse("NO COMMIT");
    }
}
