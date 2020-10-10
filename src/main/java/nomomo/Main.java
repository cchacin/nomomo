package nomomo;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/";

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        final ResourceConfig rc = new ResourceConfig().register(
                new CommitsEndpoint(
                        new CommitsService(
                                new LocalRepository(),
                                new GithubRepository()
                        )
                )
        );

        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(final String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.printf("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...%n", BASE_URI);
        System.in.read();
        server.shutdown();
    }
}

