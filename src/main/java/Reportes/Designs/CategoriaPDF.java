package Reportes.Designs;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
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
import Reportes.plReporteCategorias;

/**
 *
 * @author KEVIN EP
 */
public class CategoriaPDF {

    private String nombreArchivoPDFVenta = "";

    public void generarBoletaPDF() {

        try {
            nombreArchivoPDFVenta = "ReporteCategorias.pdf";
            /*File carpetaPdf = new File("src/Pdf");
            
            if (!carpetaPdf.exists()) {
                carpetaPdf.mkdir();
            }*/

            FileOutputStream archivo;
            File file = new File("src/main/java/Pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            //Image img = Image.getInstance("src/main/java/Imagenes/logoboleta.jpg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            /*LocalDate fechaActual = LocalDate.now();
            String fechaConvertida = fechaActual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            fecha.add("Boleta: " + plPedido.lblNumeroPedido.getText() + "\nFecha: " + fechaConvertida + "\n\n");*/

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);

            float[] ColumnaEncabezado = new float[]{5f, 70f, 5f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            //Encabezado.addCell(img);
            Encabezado.addCell("");

            String ruc = "10026113739";
            String nombre = "ABASTO";
            String telefono = "(073) 703215";
            String direccion = "Av. Sullana 1063 - Lima - Lima";

            //Encabezado.addCell("");
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion);
            Encabezado.addCell("");
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //AGREGAR PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(2);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);

            //TAMAÑO DE CELDAS
            float[] ColumnaProducto = new float[]{50f, 100f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Codigo: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Nombre Categoria: ", negrita));

            //QUITAR BORDES
            producto1.setBorder(0);
            producto2.setBorder(0);

            //AGREGAR COLOR AL ENCABEZADO DEL PRODUCTO
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //AGREGAR CELDA A LA TABLA
            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);

//            for (int i = 0; i < plReporteCategorias.tbCategoria.getRowCount(); i++) {
//                String codigo = plReporteCategorias.tbCategoria.getValueAt(i, 0).toString();
//                String nombrecategoria = plReporteCategorias.tbCategoria.getValueAt(i, 1).toString();
//
//                tablaProducto.addCell(codigo);
//                tablaProducto.addCell(nombrecategoria);
//            }

            for (int i = 0; i < plReporteCategorias.tbCategoria.getRowCount(); i++) {
                Object codigoObj = plReporteCategorias.tbCategoria.getValueAt(i, 0);
                Object nombreCategoriaObj = plReporteCategorias.tbCategoria.getValueAt(i, 1);

                if (codigoObj != null && nombreCategoriaObj != null) {
                    String codigo = codigoObj.toString();
                    String nombrecategoria = nombreCategoriaObj.toString();

                    tablaProducto.addCell(codigo);
                    tablaProducto.addCell(nombrecategoria);
                }
            }

            //AGREGAR AL DOCUMENTO
            doc.add(tablaProducto);

            doc.close();
            archivo.close();

            //ABRIR EL DOCUMENTO
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }
}
