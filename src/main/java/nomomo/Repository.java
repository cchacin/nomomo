package nomomo;

import java.util.List;
import java.util.Optional;

public interface Repository {

    Optional<Commit> commitBySha(String sha);

    List<Commit> commitsByRepo(String repository);
}
