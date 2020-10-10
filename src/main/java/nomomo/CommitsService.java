package nomomo;

import java.util.Optional;
import java.util.function.Function;

public record CommitsService(
        Function<String, Optional<Commit>> localRepository,
        Function<String, Optional<Commit>> githubRepository) {

    Optional<Commit> commitBySha(
            final String sha) {
        return localRepository().apply(sha)
                .or(() -> githubRepository().apply(sha));
    }
}
