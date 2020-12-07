package com.servisoft.nomina.modelo;

import com.servisoft.nomina.persistencia.GestorArchivoExcel;
import java.io.IOException;
import java.util.List;

public class ServicioExportarArchivos {

    private GestorArchivoExcel gestorArchivos;

    public ServicioExportarArchivos() {
        this.gestorArchivos = new GestorArchivoExcel();
    }

    public void exportarFormatoPrenomina(String ruta) throws IOException {
        gestorArchivos.exportarFormatoPrenomina(ruta);
    }

    public void exportarFormatoNovedades(String ruta) throws IOException {
        gestorArchivos.exportarFormatoNovedades(ruta);
    }

    public void exportarReporteFinal(String ruta, List<String> datosCedulasPrenomina,
            List<String> datosNombresPrenomina, List<String> codigoConcepto,
            List<String> descripcionConcepto, List<Integer> tiempoPrenomina,
            List<Integer> tiempoNovedades, List<String> diferencia) throws IOException {
        gestorArchivos.exportarReporteFinal(ruta, datosCedulasPrenomina,
                datosNombresPrenomina, codigoConcepto,
                descripcionConcepto, tiempoPrenomina,
                tiempoNovedades, diferencia);
    }
}
