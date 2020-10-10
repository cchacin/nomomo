package nomomo;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class CommitsServiceTest implements WithAssertions {

    @Test
    @DisplayName("Should return from local")
    void shouldReturnFromLocal() throws Exception {
        // Given

        // When
        final var commit = new CommitsService(
                sha -> Optional.of(new Commit("local", List.of("local.txt"))),
                sha -> Optional.empty()
        ).commitBySha("sha");

        // Then
        assertThat(commit).contains(new Commit("local", List.of("local.txt")));
    }

    @Test
    @DisplayName("Should return from github when local is empty")
    void shouldReturnFromGithubWhenLocalIsEmpty() throws Exception {
        // Given

        // When
        final var commit = new CommitsService(
                sha -> Optional.empty(),
                sha -> Optional.of(new Commit("git", List.of("git.txt")))
        ).commitBySha("sha");

        // Then
        assertThat(commit).contains(new Commit("git", List.of("git.txt")));
    }

}