package controllers;

import all_about_pdf.ListenerPDF;
import calc.CalcCore;
import constructors.DialogConstructor;
import handler.ItemsHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public static Stage stage = new Stage();

    Float NB, NS, PV, PK, L;

    @FXML
    private Button btnCalc;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnPDF;


    @FXML
    private Label labelResult;

    @FXML
    private Button btnInfo;

    @FXML
    private ComboBox<String> cbBenefit;

    @FXML
    private ComboBox<String> cbCoefficient;

    @FXML
    private ComboBox<String> cbPeriodOfUsage;

    @FXML
    private ComboBox<String> cbTax;

    @FXML
    private TextField tfHorsePower;

    ItemsHandler itemHandler = new ItemsHandler();
    public ListenerPDF listenerPDF = new ListenerPDF();

    public void initialize() {
        // Заполнение ComboBox айтемами
        cbPeriodOfUsage.setItems(itemHandler.periodOptions);
        cbCoefficient.setItems(itemHandler.coefOptions);
        cbBenefit.setItems(itemHandler.benefitOptions);
    }

    @FXML
    void actionPDF(ActionEvent event) {
        try {
            CalcCore calc = new CalcCore(this.NB, this.NS, this.PV, this.PK, this.L);
            listenerPDF.set_L(this.L);
            listenerPDF.set_PK(this.PK);
            listenerPDF.set_PV(this.PV);
            listenerPDF.set_NB(this.NB);
            listenerPDF.set_final_value(Math.round(calc.get_formula_value() * 10f) / 10f);
            listenerPDF.createPDF();
        }catch (NullPointerException e){
            labelResult.setText("Нужно ввести значения!");
        }
    }

    // Собираем все значения с полей
    void getAllValues(String L, String PV, String PK, String NB) {
        this.PV = Float.parseFloat(PV) / 12;
        this.NB = Float.valueOf(NB);
        if (this.NB < 100f) this.NS = 10f;
        else if(this.NB > 100f && this.NB < 150f) this.NS = 23f;
        else if(this.NB > 150f && this.NB < 200f) this.NS = 50f;
        else if(this.NB > 200f && this.NB < 250f) this.NS = 75f;
        else this.NS = 150f;
        switch (PK) {
            case "3-5 млн. рублей (до 3 лет)" -> this.PK = 1.1f;
            case "5-10 млн. рублей (до 5 лет)" -> this.PK = 2f;
            case "10-15 млн. рублей (до 10 лет)", "Более 15 млн. рублей (до 20 лет)" -> this.PK = 3f;
            case "Другие условия" -> this.PK = 1f;
        }
        switch(L){
            case "Нет льготы" -> this.L = 0f;
            case    "Ветеран Великой отечественной войны",
                    "Ветеран военной службы",
                    "Инвалид 1-ой,2-ой,3-ей категории",
                    "Родитель ребенка - инвалида" -> this.L = this.NB * this.NS * this.PV * this.PK;
            case "Ветеран труда (если мощность двигателя ≤ 149.9)", "Родитель многодетной семьи (если мощность двигателя ≤ 149.9 л.с.)" -> {
                if (this.NB <= 149.9f) this.L = this.NB * this.NS * this.PV * this.PK;
                else this.L = 0f;
            }
        }
    }

    @FXML
    void actionCalc(ActionEvent event) {
        // Обработчик конпки расчета
        try{
            getAllValues(
                    cbBenefit.getSelectionModel().getSelectedItem(),
                    cbPeriodOfUsage.getSelectionModel().getSelectedItem(),
                    cbCoefficient.getSelectionModel().getSelectedItem(),
                    tfHorsePower.getText()
            );
            CalcCore calc = new CalcCore(this.NB, this.NS, this.PV, this.PK, this.L);
            System.out.println(calc.get_values());
            labelResult.setText(Float.toString(Math.round(calc.get_formula_value() * 10f) / 10f));
        } catch (NullPointerException e) {
            labelResult.setText("Нужно ввести значения!");
        } catch (IllegalArgumentException e) {
            labelResult.setText("Некорректные значения значения!");
        }
    }

    @FXML
    void actionExit(ActionEvent event) {
        new DialogConstructor(Alert.AlertType.CONFIRMATION, "Выход",
                "Подтверждение выхода","Вы точно хотите выйти?");
    }

    @FXML
    public void actionInfo(ActionEvent event) throws IOException {
        FXMLLoader fxml_loader = new FXMLLoader(getClass().getResource("/fxmls/info-frame.fxml"));
        Scene scene = new Scene(fxml_loader.load(), 388, 234);
        stage.setTitle("Информация о разработчиках");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void hpInput(KeyEvent event) {
        // ...
    }

}
