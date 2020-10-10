package nomomo;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class LocalRepository {

    public Optional<Commit> commitBySha(
            final String sha) {
        if (new Random().nextBoolean()) {
            return Optional.empty();
        }
        return Optional.of(
                new Commit(
                        "Commit from local",
                        List.of("filea.txt,", "fileb.txt")
                )
        );
    }

    public List<Commit> commitsByRepo(
            final String repository) {
        return List.of(
                new Commit(
                        "Commit 1 from local",
                        List.of("filea.txt,", "fileb.txt")
                ),
                new Commit(
                        "Commit 2 from local",
                        List.of("filec.txt,", "filed.txt")
                )
        );
    }
}
