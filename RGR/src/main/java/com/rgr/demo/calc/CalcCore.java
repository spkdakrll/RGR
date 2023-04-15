package com.rgr.demo.calc;

public class CalcCore extends AbstractValidator {

    Float NB, NS, PV, PK, L;
    Core core;

    public CalcCore(
            Float NB,
            Float NS,
            Float PV,
            Float PK,
            Float L
    ) {
        // Проводим валидацию значений (из абстрактного класса)

        not_large(NB);
        not_large(NS);
        not_large(PV);
        not_large(PK);
        not_large(L);
        not_negative(NB);
        not_negative(NS);
        not_negative(PV);
        not_negative(PK);
        not_negative(L);

        this.NB = NB;
        this.NS = NS;
        this.PV = PV;
        this.PK = PK;
        this.L = L;

        // Объект рекорд класса (геттеры, тухэш, тустринг)

        core = new Core(NB, NS, PV, PK, L);
    }

    // Переопределяем метод валидации
    @Override
    void not_large(float value) {
        if (value > MAX_VALUE) {
            throw new IllegalArgumentException(value + " too large: " + value + " < " + MAX_VALUE);
        }
    }

    // Переопределяем метод валидации
    @Override
    void not_negative(float value) {
        if (value < 0){
            throw new IllegalArgumentException(value + " must not be less than zero");
        }
    }

    public Float get_formula_value() {
        return core.formula(); // Реализация инкапсуляции (вернет готовое значение "из коробки")
    }

    public String get_values() {
        // Возвращаем строку со значениями всех переменных
        return core.toString();
    }

    // Реализация перегрузки (Overloading), название метода одно и то же
    // Но логика разная (перегрузка из-за добавляемого параметра intvar)

    public String get_values(int intvar) {
        return switch (intvar) {
            // Лямбда функция, аналог case i: return var + " ";
            case 0 -> NB + " ";
            case 1 -> NS + " ";
            case 2 -> PV + " ";
            case 3 -> PK + " ";
            case 4 -> L + " ";
            // Если intvar не 0-4, то вернется default - null
            default -> null;
        };
    }
}
