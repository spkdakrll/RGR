package com.rgr.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemsHandler {

    public ObservableList<String> periodOptions = FXCollections.observableArrayList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
    );


    public ObservableList<String> coefOptions = FXCollections.observableArrayList(
                "3-5 млн. рублей (до 3 лет)",
                "5-10 млн. рублей (до 5 лет)",
                "10-15 млн. рублей (до 10 лет)",
                "Более 15 млн. рублей (до 20 лет)",
                "Другие условия"
    );

    public ObservableList<String> benefitOptions = FXCollections.observableArrayList(
                "Нет льготы",
                "Ветеран Великой отечественной войны",
                "Ветеран военной службы",
                "Инвалид 1-ой,2-ой,3-ей категории",
                "Ветеран труда (если мощность двигателя ≤ 149.9)",
                "Родитель многодетной семьи (если мощность двигателя ≤ 149.9 л.с.)",
                "Родитель ребенка - инвалида"
    );

}