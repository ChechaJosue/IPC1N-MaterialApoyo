/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author chechajosue
 */
public class Reportes {

    public static void generarPDFCarros() throws IOException {

        Document documento = new Document();

        try {

            // Creamos nuestro archivo pdf
            PdfWriter.getInstance(documento, new FileOutputStream("./Reportes/reporteCarros.pdf"));
            documento.open();

            // Fuentes
            Font fuenteEmpresa = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.GREEN);
            Font fuenteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD, BaseColor.BLACK);
            Font fuenteEncabezado = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.WHITE);

            // Nombre empresa para el pdf
            Paragraph nombreEmpresa = new Paragraph("FIUCar Dealership", fuenteEmpresa);
            nombreEmpresa.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreEmpresa);

            // Titulo para el pdf
            Paragraph titulo = new Paragraph("Listado de Carros\n\n", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            // Listado de carros
            PdfPTable tablaCarros = new PdfPTable(6);

            // Columnas de la tabla
//            tablaCarros.addCell("VIN");
//            tablaCarros.addCell("Fabricante");
//            tablaCarros.addCell("Modelo");
//            tablaCarros.addCell("Año");
//            tablaCarros.addCell("Precio");
            Phrase fraseNo = new Phrase("No.", fuenteEncabezado);
            PdfPCell celdaNo = new PdfPCell(fraseNo);
            celdaNo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaNo.setBackgroundColor(BaseColor.BLACK);
            tablaCarros.addCell(celdaNo);

            Phrase fraseVIN = new Phrase("VIN", fuenteEncabezado);
            PdfPCell celdaVIN = new PdfPCell(fraseVIN);
            celdaVIN.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaVIN.setBackgroundColor(BaseColor.BLACK);
            tablaCarros.addCell(celdaVIN);

            Phrase fraseFabricante = new Phrase("Fabricante", fuenteEncabezado);
            PdfPCell celdaFabricante = new PdfPCell(fraseFabricante);
            celdaFabricante.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaFabricante.setBackgroundColor(BaseColor.BLACK);
            tablaCarros.addCell(celdaFabricante);

            Phrase fraseModelo = new Phrase("Modelo", fuenteEncabezado);
            PdfPCell celdaModelo = new PdfPCell(fraseModelo);
            celdaModelo.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaModelo.setBackgroundColor(BaseColor.BLACK);
            tablaCarros.addCell(celdaModelo);

            Phrase fraseYear = new Phrase("Año", fuenteEncabezado);
            PdfPCell celdaYear = new PdfPCell(fraseYear);
            celdaYear.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaYear.setBackgroundColor(BaseColor.BLACK);
            tablaCarros.addCell(celdaYear);

            Phrase frasePrecio = new Phrase("Precio", fuenteEncabezado);
            PdfPCell celdaPrecio = new PdfPCell(frasePrecio);
            celdaPrecio.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaPrecio.setBackgroundColor(BaseColor.BLACK);
            tablaCarros.addCell(celdaPrecio);

            // Filas de carros
            int contador = 1;
            for (Carro carro : Serializacion.carros) {
                if (carro != null) {
                    tablaCarros.addCell(String.valueOf(contador));
                    tablaCarros.addCell(carro.getVIN());
                    tablaCarros.addCell(carro.getFabricante());
                    tablaCarros.addCell(carro.getModelo());
                    tablaCarros.addCell(String.valueOf(carro.getYear()));
                    tablaCarros.addCell(String.valueOf("Q" + carro.getPrecio()));
                    contador++;
                }
            }

            // Agregar la tabla al documento
            documento.add(tablaCarros);

        } catch (Exception e) {
            System.out.println("** Ocurrió un error generando el pdf");
            e.printStackTrace();
            return;
        } finally {
            documento.close();
        }

        JOptionPane.showMessageDialog(null, "Reporte listado carros creado");
        Desktop.getDesktop().open(new File("./Reportes/reporteCarros.pdf"));
    }
}
