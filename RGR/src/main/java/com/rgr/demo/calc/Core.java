package com.rgr.demo.calc;

// Рекорд содержит числовые поля NB ... L
// Использование класса-обертки Integer
public record Core(
        Float NB,
        Float NS,
        Float PV,
        Float PK,
        Float L
) implements MainFormula {
    @Override // Реализация полиморфизма (Override)
    // Задаем новое поведение методу formula из интерфейса MainFormula
    public Float formula() {
        return NB * NS * PV * PK - L;
    }
}
