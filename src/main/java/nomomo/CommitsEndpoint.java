package nomomo;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
    @Produces(MediaType.TEXT_PLAIN)
    public String getCommit(
            @PathParam("sha") final String sha) {
        return service.apply(sha).map(Record::toString).orElse("NO COMMIT");
    }
}
