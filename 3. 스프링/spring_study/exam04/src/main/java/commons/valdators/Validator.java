package commons.valdators;

public interface Validator<T> {
    void validate(T value);
}