package com.servisoft.nomina.persistencia;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import com.servisoft.nomina.modelo.Prenomina;
import com.servisoft.nomina.modelo.Novedades;
import java.util.Arrays;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

public class GestorArchivoExcel {

    private Workbook libroExcel;
    private Prenomina prenomina;
    private Novedades novedades;
    private List<String> encabezadoPrenomina, encabezadoNovedades, encabezadoReporteFinal;

    public GestorArchivoExcel() {
        this.prenomina = new Prenomina();
        this.novedades = new Novedades();
    }

    public List<String> asignarEncabezadoPrenomina() {
        encabezadoPrenomina = prenomina.getEncabezadoPrenomina();
        return encabezadoPrenomina;
    }

    public List<String> asignarEncabezadoNovedades() {
        encabezadoNovedades = novedades.getEncabezadoNovedades();
        return encabezadoNovedades;
    }

    public Map<Integer, List<String>> importar(File archivo) throws IOException {
        FileInputStream archivoExcel;
        Map<Integer, List<String>> dataExcel = new HashMap<>();
        archivoExcel = new FileInputStream(archivo);
        libroExcel = new XSSFWorkbook(archivoExcel);
        Sheet hojaExcel = libroExcel.getSheetAt(0);
        int i = 0;
        for (Row row : hojaExcel) {
            dataExcel.put(i, new ArrayList<>());
            for (Cell cell : row) {
                switch (cell.getCellTypeEnum()) {
                    case STRING:
                        dataExcel.get(i).add(cell.getRichStringCellValue().getString());
                        break;
                    case NUMERIC:
                        cell.setCellType(CellType.STRING);
                        dataExcel.get(i).add(cell.getRichStringCellValue().getString());
                        /*if (DateUtil.isCellDateFormatted(cell)) {
                            dataExcel.get(i).add(cell.getDateCellValue() + "");
                        } else {
                            dataExcel.get(i).add(cell.getNumericCellValue() + "");
                        }*/
                        break;
                    default:
                        dataExcel.get(i).add(" ");
                }
            }
            if (i >= 3) {
                Cell a = row.getCell(0);
                Cell b = row.getCell(1);
                Cell c = row.getCell(2);
                if (a == null || a.getCellType() == CellType.BLANK
                        || b == null || b.getCellType() == CellType.BLANK
                        || c == null || c.getCellType() == CellType.BLANK) {
                    dataExcel.remove(i);
                    i--;
                }
            }
            i++;
        }
        return dataExcel;
    }

    public boolean exportarFormatoPrenomina(String ruta) throws IOException {
        asignarEncabezadoPrenomina();
        File archivo = new File(ruta);
        archivo.createNewFile();

        libroExcel = new XSSFWorkbook();

        Sheet hoja1 = libroExcel.createSheet("Prenomina");
        hoja1.addMergedRegion(new CellRangeAddress(0, 0, 0, 12));
        hoja1.addMergedRegion(new CellRangeAddress(1, 1, 0, 12));
        hoja1.addMergedRegion(new CellRangeAddress(5, 5, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(6, 6, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(7, 7, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(8, 8, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(9, 9, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(10, 10, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(11, 11, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(12, 12, 1, 7));
        hoja1.addMergedRegion(new CellRangeAddress(13, 13, 1, 7));

        CellStyle estiloEncabezado = libroExcel.createCellStyle();
        estiloEncabezado.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        estiloEncabezado.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloEncabezado.setAlignment(HorizontalAlignment.CENTER);

        CellStyle estiloTitulos = libroExcel.createCellStyle();
        estiloTitulos.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        estiloTitulos.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloTitulos.setAlignment(HorizontalAlignment.CENTER);

        CellStyle estiloIndicacion = libroExcel.createCellStyle();
        estiloIndicacion.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        estiloIndicacion.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloIndicacion.setAlignment(HorizontalAlignment.CENTER);

        XSSFFont fuente = ((XSSFWorkbook) libroExcel).createFont();
        fuente.setFontName("Arial");
        fuente.setFontHeightInPoints((short) 8);
        fuente.setBold(true);
        estiloEncabezado.setFont(fuente);
        estiloTitulos.setFont(fuente);

        XSSFFont fuenteIndicacion = ((XSSFWorkbook) libroExcel).createFont();
        fuenteIndicacion.setFontName("Arial");
        fuenteIndicacion.setFontHeightInPoints((short) 10);
        fuenteIndicacion.setBold(false);
        estiloIndicacion.setFont(fuenteIndicacion);

        CellStyle estilo = libroExcel.createCellStyle();
        estilo.setWrapText(true);

        Row nombreEmpresa = hoja1.createRow(0);
        Cell celda = nombreEmpresa.createCell(0);
        celda.setCellStyle(estiloTitulos);
        celda.setCellValue("SERVISOFT S.A. - 800.240.660-2");

        Row nombreArchivo = hoja1.createRow(1);
        celda = nombreArchivo.createCell(0);
        celda.setCellStyle(estiloTitulos);
        celda.setCellValue("Prenómina Periódica Por Código (Alfabético)  MM-DD-AAAA");

        Row encabezado = hoja1.createRow(2);

        for (int i = 0; i < encabezadoPrenomina.size(); i++) {
            String nombre = encabezadoPrenomina.get(i);
            celda = encabezado.createCell(i);
            celda.setCellStyle(estiloEncabezado);
            celda.setCellValue(nombre);

        }

        Row indicacion = hoja1.createRow(5);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);

        indicacion = hoja1.createRow(6);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("INDICACIONES");

        indicacion = hoja1.createRow(7);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);

        indicacion = hoja1.createRow(8);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* El archivo prenomina adecuado para la validación de nómina debe contener una estructura similar a la reflejada en este archivo de ejemplo.");

        indicacion = hoja1.createRow(9);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* El archivo prenomina debe estar conformado por 13 columnas (Desde la columna A hasta la M).");

        indicacion = hoja1.createRow(10);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* En la final N°3 se deben encontrar los títulos de cada columna tal cual como se encuentran en este archivo.");

        indicacion = hoja1.createRow(11);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* No importa si los títulos estan escritos en mayuscula o minuscula, lo que se tiene en cuenta es que");

        indicacion = hoja1.createRow(12);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue(" las columnas tengan el mismo nombre y por tanto se encuentren en el mismo orden propuesto aquí.");

        indicacion = hoja1.createRow(13);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);

        for (int x = 0; x < hoja1.getRow(2).getPhysicalNumberOfCells(); x++) {
            hoja1.autoSizeColumn(x);
        }

        FileOutputStream exportable = new FileOutputStream(archivo);
        libroExcel.write(exportable);
        libroExcel.close();
        Desktop.getDesktop().open(archivo);
        return true;
    }

    public boolean exportarFormatoNovedades(String ruta) throws IOException {
        asignarEncabezadoNovedades();
        File archivo = new File(ruta);
        archivo.createNewFile();

        libroExcel = new XSSFWorkbook();

        Sheet hoja1 = libroExcel.createSheet("Novedades");
        hoja1.addMergedRegion(new CellRangeAddress(5, 5, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(6, 6, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(7, 7, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(8, 8, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(9, 9, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(10, 10, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(11, 11, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(12, 12, 1, 34));
        hoja1.addMergedRegion(new CellRangeAddress(13, 13, 1, 34));

        CellStyle estiloEncabezado = libroExcel.createCellStyle();
        estiloEncabezado.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        estiloEncabezado.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont fuente = ((XSSFWorkbook) libroExcel).createFont();
        fuente.setFontName("Arial");
        fuente.setFontHeightInPoints((short) 8);
        fuente.setBold(true);
        estiloEncabezado.setFont(fuente);

        CellStyle estiloIndicacion = libroExcel.createCellStyle();
        estiloIndicacion.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        estiloIndicacion.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloIndicacion.setAlignment(HorizontalAlignment.CENTER);

        XSSFFont fuenteIndicacion = ((XSSFWorkbook) libroExcel).createFont();
        fuenteIndicacion.setFontName("Arial");
        fuenteIndicacion.setFontHeightInPoints((short) 10);
        fuenteIndicacion.setBold(false);
        estiloIndicacion.setFont(fuenteIndicacion);

        CellStyle estilo = libroExcel.createCellStyle();
        estilo.setWrapText(true);

        Row encabezado = hoja1.createRow(1);

        for (int i = 0; i < encabezadoNovedades.size(); i++) {
            String nombre = encabezadoNovedades.get(i);
            Cell celda = encabezado.createCell(i);
            celda.setCellStyle(estiloEncabezado);
            celda.setCellValue(nombre);

        }

        Row indicacion = hoja1.createRow(5);
        Cell celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);

        indicacion = hoja1.createRow(6);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("INDICACIONES");

        indicacion = hoja1.createRow(7);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);

        indicacion = hoja1.createRow(8);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* El archivo novedades adecuado para la validación de nómina debe contener una estructura similar a la reflejada en este archivo de ejemplo.");

        indicacion = hoja1.createRow(9);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* El archivo novedades debe estar conformado por 43 columnas (Desde la columna A hasta la AQ).");

        indicacion = hoja1.createRow(10);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* En la final N°2 se deben encontrar los títulos de cada columna tal cual como se encuentran en este archivo.");

        indicacion = hoja1.createRow(11);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue("* No importa si los títulos estan escritos en mayuscula o minuscula, lo que se tiene en cuenta es que");

        indicacion = hoja1.createRow(12);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);
        celda.setCellValue(" las columnas tengan el mismo nombre y por tanto se encuentren en el mismo orden propuesto aquí.");

        indicacion = hoja1.createRow(13);
        celda = indicacion.createCell(1);
        celda.setCellStyle(estiloIndicacion);

        for (int x = 0; x < hoja1.getRow(1).getPhysicalNumberOfCells(); x++) {
            hoja1.autoSizeColumn(x);
        }

        FileOutputStream exportable = new FileOutputStream(archivo);
        libroExcel.write(exportable);
        libroExcel.close();
        Desktop.getDesktop().open(archivo);
        return true;
    }

    public boolean exportarReporteFinal(String ruta, List<String> datosCedulasPrenomina,
            List<String> datosNombresPrenomina, List<String> codigoConcepto,
            List<String> descripcionConcepto, List<Integer> tiempoPrenomina,
            List<Integer> tiempoNovedades, List<String> diferencia) throws IOException {
        encabezadoReporteFinal = Arrays.asList("CÉDULA", "NOMBRE EMPLEADO", "CONCEPTO", "NOMBRE CONCEPTO",
                "TIEMPO PRENOMINA", "TIEMPO NOVEDADES", "DIFERENCIA");
        File archivo = new File(ruta);
        archivo.createNewFile();

        libroExcel = new XSSFWorkbook();

        Sheet hoja1 = libroExcel.createSheet("Reporte Final");
        hoja1.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
        hoja1.addMergedRegion(new CellRangeAddress(1, 1, 0, 6));

        CellStyle estiloEncabezado = libroExcel.createCellStyle();
        estiloEncabezado.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        estiloEncabezado.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle estiloTitulos = libroExcel.createCellStyle();
        estiloTitulos.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        estiloTitulos.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        estiloTitulos.setAlignment(HorizontalAlignment.CENTER);

        CellStyle estiloDatos = libroExcel.createCellStyle();
        estiloDatos.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        estiloDatos.setFillPattern(FillPatternType.NO_FILL);
        estiloDatos.setAlignment(HorizontalAlignment.LEFT);

        XSSFFont fuente = ((XSSFWorkbook) libroExcel).createFont();
        fuente.setFontName("Arial");
        fuente.setFontHeightInPoints((short) 8);
        fuente.setBold(true);
        estiloEncabezado.setFont(fuente);
        estiloTitulos.setFont(fuente);

        XSSFFont fuenteDatos = ((XSSFWorkbook) libroExcel).createFont();
        fuenteDatos.setFontName("Arial");
        fuenteDatos.setFontHeightInPoints((short) 8);
        fuenteDatos.setBold(false);
        estiloDatos.setFont(fuenteDatos);

        CellStyle estilo = libroExcel.createCellStyle();
        estilo.setWrapText(true);

        Row nombreEmpresa = hoja1.createRow(0);
        Cell celda = nombreEmpresa.createCell(0);
        celda.setCellStyle(estiloTitulos);
        celda.setCellValue("SERVISOFT S.A. - 800.240.660-2");

        Row nombreArchivo = hoja1.createRow(1);
        celda = nombreArchivo.createCell(0);
        celda.setCellStyle(estiloTitulos);
        celda.setCellValue("Validador Novedades - Reporte Final");

        Row encabezado = hoja1.createRow(2);

        for (int i = 0; i < encabezadoReporteFinal.size(); i++) {
            String nombre = encabezadoReporteFinal.get(i);
            celda = encabezado.createCell(i);
            celda.setCellStyle(estiloEncabezado);
            celda.setCellValue(nombre);
        }

        int y = 3;
        int i = 0;
        int filasDatos = (datosCedulasPrenomina.size() + 3);

        while (y < filasDatos) {

            Row datos = hoja1.createRow(y);

            String dato = datosCedulasPrenomina.get(i);
            celda = datos.createCell(0);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(dato);

            dato = datosNombresPrenomina.get(i);
            celda = datos.createCell(1);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(dato);

            dato = codigoConcepto.get(i);
            celda = datos.createCell(2);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(dato);

            dato = descripcionConcepto.get(i);
            celda = datos.createCell(3);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(dato);

            int tiempoPre = tiempoPrenomina.get(i);
            celda = datos.createCell(4);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(tiempoPre);

            int tiempoN = tiempoNovedades.get(i);
            celda = datos.createCell(5);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(tiempoN);

            String dif = diferencia.get(i);
            celda = datos.createCell(6);
            celda.setCellStyle(estiloDatos);
            celda.setCellValue(dif);

            y++;
            i++;
        }

        for (int x = 0; x < hoja1.getRow(2).getPhysicalNumberOfCells(); x++) {
            hoja1.autoSizeColumn(x);
        }

        FileOutputStream exportable = new FileOutputStream(archivo);
        libroExcel.write(exportable);
        libroExcel.close();
        Desktop.getDesktop().open(archivo);
        return true;
    }
}
