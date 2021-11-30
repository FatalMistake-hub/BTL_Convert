package model.bo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import model.bean.PDF;

public class Handle_Thread {
	public static void AddtoThread(PDF pdf) {
        Runnable r = new MyRunnable(pdf);
        new Thread(r).start();
    }
}

class MyRunnable implements Runnable {
    model.bean.PDF word;

    public MyRunnable(model.bean.PDF word) {
        this.word = word;
    }

    public void run() {
        try {
        	 model.dao.PDF_DAO data = new model.dao.PDF_DAO();
                try {
                    data.setURLResult(word.getFilePath(), 1);
                    String inputFile = word.getFilePath();
                    String outputFile = word.getTargetPath();
                    
                    InputStream docFile = new FileInputStream(new File(inputFile));
            		XWPFDocument doc = new XWPFDocument(docFile);
            		PdfOptions pdfOptions = PdfOptions.create();
            		OutputStream out = new FileOutputStream(new File(outputFile));
            		PdfConverter.getInstance().convert(doc, out, pdfOptions);
            		doc.close();
            		out.close();

                    System.out.println("Succeed");
                    data.setURLResult(word.getFilePath(), 2);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    System.out.println("Failed");
                    data.setURLResult(word.getFilePath(), -1);
                }
            
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
