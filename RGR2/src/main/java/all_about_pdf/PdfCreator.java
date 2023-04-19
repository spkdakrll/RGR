package all_about_pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <b> Класс реализующий создание и заполнение типового PDF файла.</b>
 * @author Kazantsev AV
 * @version 2.0
 * В классе один конструктор c 2 параметрами.
 * Класс основан на библиотеки itextpdf.
 *
 * Для создания PDF файла необходимо создать экземпляр объекта CreatePDF и далее добавлять необходимые вставки (текст, рисунки и таблицы). После окончания добавления необходимо выполнить метод getClose, который закроет и сохранить PDF документ.
 *
 */

public final class PdfCreator {

    /** Поле базового используемого шрифта */
    private BaseFont times = null;
    /** Поле с именем создаваемого PDF файла */
    private String name_file;
    /** Поле с сслыкой на создаваемый документ */
    private Document document;
    /** */
    private PdfPTable table;
//private PdfPage page;

    /**
     * Конструктор - создание объекта с генерацией PDF
     * @param Namefile - имя выводимого файла
     * @param BaseFontPDF - шрифт для вывода
     */
    public PdfCreator(String Namefile, BaseFont BaseFontPDF) {
        this.name_file=Namefile;
        this.times=BaseFontPDF;

        this.document = new Document(); //создание объекта Document
        try {
            PdfWriter.getInstance(document, new FileOutputStream(this.name_file)); //выходной поток для создания PDF, а внутри создается поток записи с конкретным именем
        } catch (FileNotFoundException | DocumentException e) { //Исключение когда файл не найден
            System.out.println("Doc is not found");
            e.printStackTrace();
        }

        document.open(); //открытие для возможности записи

    }

    /**
     * Метод добавления строк в таблицу
     * @param table - таблица для заполнения
     * @param arrayCell - двумерный массив со значения ячеек
     */

    private final void add_rows(PdfPTable table, String[][] arrayCell) {
        //установка значения и шрифта для выводимого текста в ячейки
        int SizeTwo = arrayCell.length; //количество строк
        int SizeOne = arrayCell[0].length; //подразумеваем количество столбцов

        for (int j=0; j<SizeTwo; j++) {
            for (int i=0; i<SizeOne; i++) {
                table.addCell(new Phrase(arrayCell[j][i], new Font(times,14)));
            }
        }
    }

    /**
     * Метод заполнения шапки таблицы
     * @param table - таблица для заполнения
     */

    private final void set_header(PdfPTable table, String[] NameCellHat) { //метод для работы с шапкой таблицы
        for (int i=0; i<NameCellHat.length; i++) {
            PdfPCell header = new PdfPCell(); //реализация ячейки в таблице
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            //установка значения и шрифта для выводимого текста в ячейки
            header.setPhrase(new Phrase(NameCellHat[i],new Font(times,14)));
            table.addCell(header);
        }
    }

    /**
     * Метод для получения ссылка на создаваемый документ
     * @return возваращет ссылку на создаваемый документ
     */

    public final Document get_document() {
        return this.document;
    }

    /**
     * Метод для закрытия и сохранения PDF файла
     */

    public final void get_close() {
        this.document.close();
    }

    /**
     * Метод добавления картинки в PDF файл
     * @param url - ссылка на изображение
     * @param document - ссылка на создаваемый документ
     * @param position1 - абсолютная позиция по оси X
     * @param position2 - абсолютная позиция по оси Y
     */
    public void add_picture(URL url, Document document, int position1, int position2) {
        Image img = null;
        try {
            img = Image.getInstance(url.toString());
        } catch (BadElementException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        img.scaleAbsolute(120, 125);
        img.setAbsolutePosition(position1, position2); //позиционирование изображения в PDF

        try {
            document.add(img);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод добавления текста в PDF документ. Добавление происходит с начала документа.
     * @param document - ссылка на создаваемый документ
     * @param Text - задаваемый текст
     * @param SizeFont - размер шрифта
     * @param Space - указание требуется ли перейти на новую строку
     */

    public final void add_text(Document document, String Text, int SizeFont, boolean Space ) {
        Paragraph paragraph = new Paragraph(); //создание объекта "параграф" для возможности записи данных в файл
        Paragraph paragraphadd = new Paragraph(Text, new Font(times,SizeFont));
        paragraphadd.setAlignment(Element.ALIGN_JUSTIFIED);
        paragraph.add(paragraphadd);

        try {
            document.add(paragraph);
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
        paragraph.clear();

        if (Space) {

            String string_pdf3 = " ";
            paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));

            try {
                document.add(paragraph);
            } catch (DocumentException e1) {
                e1.printStackTrace();
            }
        }

        paragraph=null;
    }

    /**
     * Метод инициализации таблицы и добавления шапки в таблице.
     * @param document - ссылка на создаваемый документ
     * @param NameCellHat - данные для шапки таблицы
     */

    public final void init_table_and_add_hat (Document document, String[] NameCellHat) {

        table = new PdfPTable(NameCellHat.length);
        set_header(table,NameCellHat); //задание заголовка (шапки таблицы)

    }

    /**
     * Метод получения ссылки на создаваемую таблицу, которую нужно наполнить (геттер).
     * @return возвращает ссылку на созданную таблицу
     */

    public final PdfPTable getTable () {
        return table;
    }

    /**
     * Метод инициализации таблицы и добавления шапки в таблице.
     * @param Table - ссылка на создаваемую таблицу, которая получена методом {@link //InitTableAndAddHat}
     * @param arrayCell - данные для строк в таблице (представляется в виде двумерного массива)
     */

    public final void addRowsInTable(PdfPTable Table, String[][] arrayCell) {
        add_rows(Table, arrayCell);

    }

    /**
     * Метод добавления таблицы в PDF документ.
     * @param document - ссылка на создаваемый документ
     * @param Table - ссылка на создаваемую таблицу, которая получена методом {@link //InitTableAndAddHat}
     */

    public final void addTable(Document document, PdfPTable Table) {
        try {
            document.add(Table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}