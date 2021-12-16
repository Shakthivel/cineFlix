package com.cineFlix.service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import com.cineFlix.model.Ticket;
import com.itextpdf.text.Image;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

@Service
public class PdfService {
    public void generatePdf(Ticket ticket) throws MalformedURLException, IOException {

        Document doc = new Document();

        String projectDirectory = Paths.get("").toAbsolutePath().toString();
        String pdfDirectory = projectDirectory + "\\src\\main\\resources\\static\\pdf\\";
        String fileName = pdfDirectory + "Ticket_" + ticket.getTicketId() + ".pdf";

        try {
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            System.out.println("PDF created.");
            doc.open();

            Rectangle rect = new Rectangle(30, 30, 550, 800);
            rect.setBorder(4);
            rect.setBorderColor(BaseColor.BLACK);
            rect.setBorder(Rectangle.BOX);
            rect.setBorderWidth(4);
            doc.add(rect);


            doc.add(Chunk.NEWLINE);
            Image img = Image.getInstance("https://res.cloudinary.com/dfep0loer/image/upload/v1638596050/CineFlix/cineflix-black_nleijx.png");
            doc.add(img);
            doc.add(Chunk.NEWLINE);


            doc.add(Chunk.NEWLINE);
            Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph paragraph = new Paragraph("Movie Name: " + ticket.getMovieName(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);

            paragraph = new Paragraph("Theatre Name: " + ticket.getTheatreName(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);

            paragraph = new Paragraph("Screen Name: " + ticket.getScreenName(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);

            paragraph = new Paragraph("Show Date: " + ticket.getShowDate(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);

            paragraph = new Paragraph("Show Timing: " + ticket.getShowTiming(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);
            
            paragraph = new Paragraph("No. of Seats: " + ticket.getNoOfSeats(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);
            
            paragraph = new Paragraph("Seat Numbers: " + ticket.getSeatNumbers(), font);
            doc.add(paragraph);
            doc.add(Chunk.NEWLINE);


            paragraph = new Paragraph("Enjoy the show!!", font);
            paragraph.setAlignment(Element.ALIGN_CENTER);
            doc.add(paragraph);

            doc.close();
            writer.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (DocumentException e1) {
            e1.printStackTrace();
        }
    }
}