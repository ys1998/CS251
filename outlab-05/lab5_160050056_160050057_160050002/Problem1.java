//https://www.tutorialspoint.com/pdfbox/pdfbox_reading_text.htm
//https://stackoverflow.com/questions/39993683/alternative-to-deprecated-getcelltype
//https://www.tutorialspoint.com/apache_poi/apache_poi_spreadsheets.htm
//https://www.tutorialspoint.com/apache_poi_word/apache_poi_word_text_extraction.htm
//https://stackoverflow.com/questions/7488643/how-to-convert-comma-separated-string-to-arraylist
//https://stackoverflow.com/questions/3571945/find-if-a-string-is-present-in-an-array

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import java.util.*;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Problem1 {

    public static void main(String args[]) throws Exception {
        String defStopwords = "and,the,or,is,in,at,of,her,him,his";
        Map<String, Integer> table;
        if (args[0].endsWith("doc") || args[0].endsWith("docx") || args[0].endsWith("docs")) {
            table = parse.extract(doc.main(args[0]), defStopwords);
        } else if (args[0].endsWith("xlsx") || args[0].endsWith("xls")) {
            table = parse.extract(workbook.main(args[0]), defStopwords);
        } else if (args[0].endsWith("pdf")) {
            table = parse.extract(pdf.main(args[0]), defStopwords);
        } else {
            return;
        }
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

class parse {

    public static Map<String, Integer> extract(String text, String listofstopword) {
        ArrayList<String> arr = new ArrayList<String>();

        //text = text.replaceAll("[\n\r]", "");
        String[] result = text.split("\\p{Punct}|\\s+");
        List<String> stopwords = Arrays.asList(listofstopword.split(","));
        for (String S : result) {
            S = S.toLowerCase();

            if (S.trim().equals("") || stopwords.contains(S)) {
                continue;
            }
            //System.out.println(S);
            arr.add(S);
        }
        //Collections.sort(arr);
        Map<String, Integer> table = new TreeMap<String, Integer>();
        //for(String S : arr){
        for (String S : arr) {
            //if(S.trim().equals("")) continue;                
            //for(String S : count)        
            table.put(S, Collections.frequency(arr, S));
            //System.out.println(S + " " + Collections.frequency(arr, S) );
        }
        return table;
    }
}

class doc {

    public static String main(String args) throws Exception {
        XWPFDocument docx = new XWPFDocument(new FileInputStream(args));
        //using XWPFWordExtractor Class
        XWPFWordExtractor we = new XWPFWordExtractor(docx);
        String text;
        text = we.getText();
        we.close();
        return text;
    }
}

class workbook {

    static XSSFRow row;
    static String text;

    public static String main(String args) throws Exception {
        FileInputStream fis = new FileInputStream(
                new File(args));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator< Row> rowIterator = spreadsheet.iterator();
        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator< Cell> cellIterator = row.cellIterator();
            Cell cell=null;
            while (cellIterator.hasNext()) {
                cell = cellIterator.next();
                if (cell != null) {
                    switch (cell.getCellTypeEnum()) {
                        case NUMERIC:
                            text = cell.getNumericCellValue() + "," + text;
                            break;
                        case STRING:
                            text = cell.getStringCellValue() + "," + text;
                            break;
                    }
                }
            }

        }
        fis.close();
        return text;
    }
}

/*
import java.io.*;
import org.apache.poi.xssf.usermodel.*;
public class OpenWorkBook
{
   public static void main(String args[])throws Exception
   { 
      File file = new File("openworkbook.xlsx");
      FileInputStream fIP = new FileInputStream(file);
      //Get the workbook instance for XLSX file 
      XSSFWorkbook workbook = new XSSFWorkbook(fIP);
      if(file.isFile() && file.exists())
      {
         System.out.println(
         "openworkbook.xlsx file open successfully.");
      }
      else
      {
public class pdf {
         System.out.println(
         "Error to open openworkbook.xlsx file.");
      }
   }
}
 */
class pdf {

    public static String main(String args) throws IOException {

        //Loading an existing document
        File file = new File(args);
        PDDocument document = PDDocument.load(file);

        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();

        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);

        //Closing the document
        document.close();

        return text;

    }
}
