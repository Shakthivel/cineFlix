package com.cineFlix.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;

public class HTMLtoPDF {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        HtmlConverter.convertToPdf(new FileInputStream("src/main/resources/index.jsp"),
                new FileOutputStream("ticket.pdf"));

        System.out.println("PDF Created!");
    }
}
