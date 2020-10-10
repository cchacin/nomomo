package nomomo;

import java.util.Optional;

public record CommitsService(
        Repository localRepository,
        Repository githubRepository) {

    Optional<Commit> commitBySha(
            final String sha) {
        return localRepository().commitBySha(sha)
                .or(() -> githubRepository().commitBySha(sha));
    }
}
