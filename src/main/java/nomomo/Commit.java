package nomomo;

import java.util.List;

public record Commit(
        String message,
        List<String> filenames) {
}
