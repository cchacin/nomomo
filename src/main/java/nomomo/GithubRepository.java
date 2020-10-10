package nomomo;

import java.util.List;
import java.util.Optional;

public class GithubRepository implements Repository {

    @Override
    public Optional<Commit> commitBySha(
            final String sha) {
        return Optional.of(new Commit("Commit from git", List.of("filea.txt,", "fileb.txt")));
    }

    @Override
    public List<Commit> commitsByRepo(
            final String repository) {
        return List.of(
                new Commit("Commit 1 from git", List.of("filea.txt,", "fileb.txt")),
                new Commit("Commit 2 from git", List.of("filec.txt,", "filed.txt"))
        );
    }
}
