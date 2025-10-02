package lotto.util;

import java.util.function.Supplier;
import java.util.function.Consumer;

public class Retry {

    private Retry() {}

    public static <T> T untilValid(Supplier<T> attempt, Consumer<String> onError) {
        while (true) {
            try {
                return attempt.get();
            } catch (IllegalArgumentException e) {
                onError.accept(e.getMessage());
            }
        }
    }
}
