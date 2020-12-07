package com.servisoft.nomina.modelo;

import com.servisoft.nomina.persistencia.GestorArchivoExcel;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServicioImportarArchivos {

    private Map<Integer, List<String>> prenomina, novedades;
    private GestorArchivoExcel gestorArchivos;

    public ServicioImportarArchivos() {
        this.gestorArchivos = new GestorArchivoExcel();
    }

    public Map<Integer, List<String>> getPrenomina() {
        return prenomina;
    }

    public Map<Integer, List<String>> getNovedades() {
        return novedades;
    }

    public void importarPrenomina(File archivo) throws IOException {
        prenomina = gestorArchivos.importar(archivo);
    }

    public void importarNovedades(File archivo) throws IOException {
        novedades = gestorArchivos.importar(archivo);
    }

}
