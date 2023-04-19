package all_about_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import constructors.DialogConstructor;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.net.URL;

public class ListenerPDF {
    float L ,PV ,PK , NB, final_value;
    String LText;
    public final void createPDF(){
        String[] Hat = new String[5];
        //Массив шапочки таблицы
        Hat[0] = "Мощность авто";
        Hat[1] = "Период владения";
        Hat[2] = "Повышающий коэфициент";
        Hat[3] = "Льгота";
        Hat[4] = "Налог";

        String text_hat = "                 Налоговый калькулятор. Имущественный налог.\n         " +
                "                                   Команда №2 ПИ-228Б";
        if (get_L() == 0.0){
            LText = "без участия в льготной программе";
        } else { LText = "участвуя в льготной программе"; }
        String text_general = "        Для автомобиля мощностью " + get_NB() + " л.с., периодом владения " + get_PV() + " месяцев, а также с учетом повышенного коэффициента " + get_PK() +", " + LText + ", необходимо заплатить налог в размере " + get_final_value() + " руб.";

        URL Imagelink = getClass().getResource("/images/calculator.png");
        String Namefile = "ResultTable.pdf";
        BaseFont times = null;
        try {
            times = BaseFont.createFont(String.valueOf(getClass().getResource("/fonts/timesnewroman.ttf")), "cp1251", BaseFont.EMBEDDED);
        } catch (DocumentException e2) {
            e2.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        String[][] name_cell = new String[1][5];
        name_cell[0][0] = String.valueOf(get_NB() + " л.с.");
        name_cell[0][1] = String.valueOf(get_PV() + " месяцев/налоговый год");
        name_cell[0][2] = String.valueOf(get_PK());
        if (get_L() == 0.0){
        name_cell[0][3] = String.valueOf("Отсутствует");}
        else  {name_cell[0][3] = String.valueOf("Присутствует");}
        name_cell[0][4] = String.valueOf(get_final_value() + " руб.");

        PdfCreator pdf = new PdfCreator(Namefile,times);
        Document document = pdf.get_document();
        pdf.add_picture(Imagelink, document, 250, 375);
        pdf.add_text(document, text_hat, 18,true);
        pdf.add_text(document, text_general, 14,true);
        pdf.init_table_and_add_hat(document,Hat);
        pdf.addRowsInTable(pdf.getTable(), name_cell);
        pdf.addTable(document,pdf.getTable());
        pdf.get_close();
        new DialogConstructor(Alert.AlertType.INFORMATION,  "PDF-creator",
                "Создание файла", "Файл создан успешно!");
    }
    public final void set_L(float L){ this.L = L; }
    public final void set_PK(float PK){ this.PK = PK; }
    public final void set_PV(float PV){ this.PV = PV; }
    public final void set_NB(float NB){ this.NB = NB; }
    public final void set_final_value(float final_value){ this.final_value = final_value; }

    private float get_L(){ return L; }
    private float get_PV(){ return PV; }
    private float get_PK(){ return PK; }
    private float get_NB(){ return NB; }
    private float get_final_value(){ return final_value; }
}
