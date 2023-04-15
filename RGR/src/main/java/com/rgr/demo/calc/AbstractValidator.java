package com.rgr.demo.calc;

public abstract class AbstractValidator {

    // Максимальное возможное значение
    final Float MAX_VALUE = 100000000f;

    abstract void not_negative(float value);

    abstract void not_large(float value);
}
