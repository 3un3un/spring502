package commons.valdators;

import org.springframework.util.StringUtils;

public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) {
        if (!StringUtils.hasText(str)) {
            throw e;
        }
    }

    // 참이 아닐때 예외 발생
    default void checkTrue(boolean result, RuntimeException e) {
        if (!result) {
            throw e;
        }
    }

    // 참일때 예외 발생
    default void checkFalse(boolean result, RuntimeException e) {
        if (result) {
            throw e;
        }
    }
}
