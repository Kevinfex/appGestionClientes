/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes.Designs;

import Reportes.plReporteTablaVisita;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import TransferObject.CategoriaDTO;
import TransferObject.ClienteDTO;
import TransferObject.DetallePedidoDTO;
import TransferObject.EmpleadoDTO;
import TransferObject.PedidoDTO;

import DataAccessObject.VisitaDAO;
import static Reportes.plReporteTablaVisita.listaVisitasPedidos;
//import static Reportes.plReporteTablaVisita.listaVisitasPedidos;
import TransferObject.VisitaDTO;
import TransferObject.VisitaPedidoDTO;
import java.util.List;
//import static Presentacion.plVenta.txtMeseroBoleta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BRYAM CORREA
 */
public class VisitaPedidoPDF {
    
    String codigoempleado;
    String dniempleado;
    String nombrecompletoempleado;
    EmpleadoDTO empleadoDTO;

    String codigocliente;
    String dnicliente;
    String nombrecompletocliente;
    ClienteDTO clienteDTO;
 
    String codigocarta;
    String nomcarta;
    String nombrecarta;
    String codigocategoriacarta;

    CategoriaDTO categoriaDTO;
    String nombrecategoria;

    String numeroS;
    String codigoV;
    PedidoDTO pedidoDTO;

    DetallePedidoDTO detallepedidoDTO;

    DefaultTableModel modelo;
    
    private String nombreArchivoPDFVenta = "";

    public void generarBoletaPDF() {
        

        try {
            //nombreArchivoPDFVenta = "ReporteVisitas.pdf";
            plReporteTablaVisita rtv = new plReporteTablaVisita();
            nombreArchivoPDFVenta = "Visita_" + rtv.nombreempleado + "_" + rtv.nombrecliente + ".pdf";
            /*File carpetaPdf = new File("src/Pdf");
            
            if (!carpetaPdf.exists()) {
                carpetaPdf.mkdir();
            }*/
            
            FileOutputStream archivo;
            File file = new File("src/main/java/Pdf/" + nombreArchivoPDFVenta);
            //File file = new File("/Pdf/"+nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            //Image img = Image.getInstance("src/main/java/Imagenes/logoboleta.jpg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            /*LocalDate fechaActual = LocalDate.now();
            String fechaConvertida = fechaActual.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            fecha.add("Boleta: " + plPedido.lblNumeroPedido.getText() + "\nFecha: " + fechaConvertida + "\n\n");*/
            
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            
            float [] ColumnaEncabezado = new float[]{5f, 70f, 5f, 40f};
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
            
            /*//CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del Cliente: " + "\n\n");
            doc.add(cliente);
            
            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(2);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            
            //TAMAÑO DE CELDAS
            float [] ColumnaCliente = new float[]{25f, 45f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Dni: ", negrita));
            
            //QUITAR BORDES
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            
            //AGREGAR CELDA A LA TABLA
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(plPedido.lblNombreCliente.getText());
            tablaCliente.addCell(plPedido.txtClienteBoleta.getText());
            
            //AGREGAR AL DOCUMENTO
            doc.add(tablaCliente);
            
            //ESPACIO EN BLANCO
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);*/
            
            //AGREGAR PRODUCTOS
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            
            //TAMAÑO DE CELDAS
            float[] ColumnaProducto = new float[]{30f, 15f, 20f, 20f};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            //PdfPCell producto1 = new PdfPCell(new Phrase("Codigo: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Producto: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto5 = new PdfPCell(new Phrase("Importe: ", negrita));
            
            //QUITAR BORDES
            //producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto5.setBorder(0);
            
            //AGREGAR COLOR AL ENCABEZADO DEL PRODUCTO
            //producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            //AGREGAR CELDA A LA TABLA
            //tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);
            tablaProducto.addCell(producto5);
                      
            /*VisitaDAO visitaDAO = new VisitaDAO();
            List<VisitaDTO>lista = visitaDAO.listarVisita();*/
            //codigoV = visitaDAO.listarVisita();

            /*int increment = Integer.parseInt(codigoP);
            increment = increment + 1;
            int codigoobtenido = increment;*/
            Object[] dato = new Object[4];
            for (VisitaPedidoDTO p : rtv.listaVisitasPedidos) {
                dato[0] = p.getProducto();
                dato[1] = p.getPrecio().toString();
                dato[2] = p.getCantidad().toString();
                dato[3] = p.getImporte().toString();
                
                tablaProducto.addCell(dato[0].toString());
                tablaProducto.addCell(dato[1].toString());
                tablaProducto.addCell(dato[2].toString());
                tablaProducto.addCell(dato[3].toString());
   
            }
            
            /*for (int i=0; i<plReporteTablaVisita.tbReporteVisitas.getRowCount(); i++) {
                String codigo = plReporteTablaVisita.tbReporteVisitas.getValueAt(i, 0).toString();
                String nombreempleado = plReporteTablaVisita.tbReporteVisitas.getValueAt(i, 1).toString();
                String nombrecliente = plReporteTablaVisita.tbReporteVisitas.getValueAt(i, 2).toString();
                String fechav = plReporteTablaVisita.tbReporteVisitas.getValueAt(i,3).toString();
                String venta = plReporteTablaVisita.tbReporteVisitas.getValueAt(i,4).toString();
                
                tablaProducto.addCell(codigo);
                tablaProducto.addCell(nombreempleado);
                tablaProducto.addCell(nombrecliente);
                tablaProducto.addCell(fechav);
                tablaProducto.addCell(venta);
            }*/
            
            //AGREGAR AL DOCUMENTO
            doc.add(tablaProducto);
            
            /*//TOTAL A PAGAR
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + plPedido.lblTotal.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);*/
            
            /*Paragraph mensajeBoleta = new Paragraph();
            mensajeBoleta.add(Chunk.NEWLINE);
            mensajeBoleta.add("Gracias por su compra");
            mensajeBoleta.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensajeBoleta);*/
            
            doc.close();
            archivo.close();
            
            //ABRIR EL DOCUMENTO
            Desktop.getDesktop().open(file);
        }
        catch(DocumentException | IOException e){
            System.out.println("Error en: " + e);
        }
    }
}
