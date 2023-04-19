package calc;

public abstract class AbstractValidator {

    // Максимальное возможное значение
    final Float MAX_VALUE = 100000000f;

    abstract boolean not_negative(float value);

    abstract boolean not_large(float value);
}
