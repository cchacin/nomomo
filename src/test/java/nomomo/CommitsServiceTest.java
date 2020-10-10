package nomomo;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommitsServiceTest implements WithAssertions {

    @Test
    @DisplayName("Should return from local")
    void shouldReturnFromLocal(
            @Mock final Repository localRepository,
            @Mock final Repository gitHubRepository) throws Exception {
        // Given
        when(localRepository.commitBySha(anyString()))
                .thenReturn(Optional.of(new Commit("local", List.of("local.txt"))));

        // When
        final var commit = new CommitsService(localRepository, gitHubRepository).commitBySha("sha");

        // Then
        assertThat(commit).contains(new Commit("local", List.of("local.txt")));
        verify(gitHubRepository, never()).commitBySha(anyString());
    }

    @Test
    @DisplayName("Should return from github when local is empty")
    void shouldReturnFromGithubWhenLocalIsEmpty(
            @Mock final Repository localRepository,
            @Mock final Repository gitHubRepository) throws Exception {
        // Given
        when(localRepository.commitBySha(anyString()))
                .thenReturn(Optional.empty());
        when(gitHubRepository.commitBySha(anyString()))
                .thenReturn(Optional.of(new Commit("git", List.of("git.txt"))));

        // When
        final var commit = new CommitsService(localRepository, gitHubRepository).commitBySha("sha");

        // Then
        assertThat(commit).contains(new Commit("git", List.of("git.txt")));
        verify(localRepository, times(1)).commitBySha(anyString());
        verify(gitHubRepository, times(1)).commitBySha(anyString());
    }

}