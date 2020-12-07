package com.servisoft.nomina.controlador;

import com.servisoft.nomina.modelo.Novedades;
import com.servisoft.nomina.modelo.Prenomina;
import com.servisoft.nomina.modelo.ServicioExportarArchivos;
import com.servisoft.nomina.modelo.ServicioImportarArchivos;
import java.io.*;
import com.servisoft.nomina.modelo.ServicioValidarFormato;
import com.servisoft.nomina.modelo.ServicioValidarCedula;
import java.util.List;
import java.util.Map;

public class ControladorImporteArchivos {

    private ServicioImportarArchivos servicio;
    private ServicioValidarFormato servicioFormato;
    private ServicioValidarCedula servicioCedula;
    private ServicioExportarArchivos servicioExportar;
    private Prenomina datosPrenomina;
    private Novedades datosNovedades;
    private Map<Integer, List<String>> prenomina, novedades;
    private boolean formatoNovedades, formatoPrenomina, validacionCedulas, ejemploPrenomina;
    private List<String> cedulasPrenomina, cedulasNovedades,
            nombreEmpleadoPrenomina, nombreEmpleadoNovedades;
    private List<Integer> posicionCedulaPrenomina, posicionCedulaNovedades,
            tiempoPrenomina, tiempoNovedades;
    private List<String> datosCedulasPrenomina, datosNombresPrenomina,
            codigoConcepto, descripcionConcepto, diferencia;

    public ControladorImporteArchivos() {
        servicio = new ServicioImportarArchivos();
        servicioFormato = new ServicioValidarFormato();
        servicioCedula = new ServicioValidarCedula();
        servicioExportar = new ServicioExportarArchivos();
        datosPrenomina = new Prenomina();
        datosNovedades = new Novedades();
    }

    public boolean importarPrenomina(File archivo) {
        try {
            servicio.importarPrenomina(archivo);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean importarNovedades(File archivo) {
        try {
            servicio.importarNovedades(archivo);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public Map<Integer, List<String>> getPrenomina() {
        prenomina = servicio.getPrenomina();
        return prenomina;
    }

    public Map<Integer, List<String>> getNovedades() {
        novedades = servicio.getNovedades();
        return novedades;
    }

    public boolean getFormatoNovedades() {
        formatoNovedades = servicioFormato.getFormatoNovedades();
        return formatoNovedades;
    }

    public boolean getFormatoPrenomina() {
        formatoPrenomina = servicioFormato.getFormatoPrenomina();
        return formatoPrenomina;
    }

    public boolean getValidacionCedulas() {
        validacionCedulas = servicioCedula.getValidacionCedulas();
        return validacionCedulas;
    }

    public List<String> getCedulasPrenomina() {
        cedulasPrenomina = servicioCedula.getCedulasPrenomina();
        return cedulasPrenomina;
    }

    public List<String> getCedulasNovedades() {
        cedulasNovedades = servicioCedula.getCedulasNovedades();
        return cedulasNovedades;
    }

    public List<String> getNombreEmpleadoPrenomina() {
        nombreEmpleadoPrenomina = servicioCedula.getNombreEmpleadoPrenomina();
        return nombreEmpleadoPrenomina;
    }

    public List<String> getNombreEmpleadoNovedades() {
        nombreEmpleadoNovedades = servicioCedula.getNombreEmpleadoNovedades();
        return nombreEmpleadoNovedades;
    }

    public List<Integer> getPosicionCedulaPrenomina() {
        posicionCedulaPrenomina = servicioCedula.getPosicionCedulaPrenomina();
        return posicionCedulaPrenomina;
    }

    public List<Integer> getPosicionCedulaNovedades() {
        posicionCedulaNovedades = servicioCedula.getPosicionCedulaNovedades();
        return posicionCedulaNovedades;
    }

    public List<String> getDatosCedulasPrenomina() {
        datosCedulasPrenomina = datosPrenomina.getDatosCedulasPrenomina();
        return datosCedulasPrenomina;
    }

    public List<String> getDatosNombresPrenomina() {
        datosNombresPrenomina = datosPrenomina.getDatosNombresPrenomina();
        return datosNombresPrenomina;
    }

    public List<String> getCodigoConcepto() {
        codigoConcepto = datosPrenomina.getCodigoConcepto();
        return codigoConcepto;
    }

    public List<String> getDescripcionConcepto() {
        descripcionConcepto = datosPrenomina.getDescripcionConcepto();
        return descripcionConcepto;
    }

    public List<Integer> getTiempoPrenomina() {
        tiempoPrenomina = datosPrenomina.getTiempoPrenomina();
        return tiempoPrenomina;
    }

    public List<Integer> getTiempoNovedades() {
        tiempoNovedades = datosNovedades.getTiempoNovedades();
        return tiempoNovedades;
    }

    public List<String> getDiferencia() {
        diferencia = datosNovedades.getDiferencia();
        return diferencia;
    }

    public boolean exportarEjemploPrenomina(String ruta) {
        try {
            servicioExportar.exportarFormatoPrenomina(ruta);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean exportarEjemploNovedades(String ruta) {
        try {
            servicioExportar.exportarFormatoNovedades(ruta);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean exportarReporteFinal(String ruta, List<String> datosCedulasPrenomina,
            List<String> datosNombresPrenomina, List<String> codigoConcepto,
            List<String> descripcionConcepto, List<Integer> tiempoPrenomina,
            List<Integer> tiempoNovedades, List<String> diferencia) {
        try {
            servicioExportar.exportarReporteFinal(ruta, datosCedulasPrenomina,
                    datosNombresPrenomina, codigoConcepto,
                    descripcionConcepto, tiempoPrenomina, tiempoNovedades, diferencia);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean validarFormatoPrenomina(Map<Integer, List<String>> prenomina) {
        try {
            servicioFormato.validarFormatoPrenomina(prenomina);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean validarFormatoNovedades(Map<Integer, List<String>> novedades) {
        try {
            servicioFormato.validarFormatoNovedades(novedades);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean validarCedulas(Map<Integer, List<String>> prenomina, Map<Integer, List<String>> novedades) {
        try {
            servicioCedula.validarCedulas(prenomina, novedades);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean obtenerDatosPrenomina(Map<Integer, List<String>> prenomina) {
        try {
            datosPrenomina.obtenerDatosPrenomina(prenomina);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean obtenerDatosNovedades(Map<Integer, List<String>> novedades, List<String> datosCedulasPrenomina, List<String> codigoConcepto,
            List<Integer> tiempoPrenomina) {
        try {
            datosNovedades.obtenerDatosNovedades(novedades, datosCedulasPrenomina, codigoConcepto, tiempoPrenomina);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
