package nomomo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.function.Function;

@Path("commits")
public class CommitsEndpoint {

    private final Function<String, Optional<Commit>> service;

    public CommitsEndpoint(
            final Function<String, Optional<Commit>> service) {
        this.service = service;
    }

    @GET
    @Path("{sha}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCommit(
            @PathParam("sha") final String sha) {
        return service.apply(sha).map(Record::toString).orElse("NO COMMIT");
    }
}
