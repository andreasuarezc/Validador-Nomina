package com.servisoft.nomina.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Prenomina {
    private Map<Integer, List<String>> datosPrenomina;
    private List<String> datosCedulasPrenomina, datosNombresPrenomina,
            codigoConcepto, descripcionConcepto, encabezadoPrenomina;
    private List<Integer> tiempoPrenomina;

    public Prenomina() {
    }

    public void setEncabezadoPrenomina() {
        encabezadoPrenomina = Arrays.asList("CODIGO EMPLEADO", "NOMBRE EMPLEADO", "CODIGO CONCEPTO",
                "DESCRIPCION CONCEPTO", "CODIGO TURNO", "DESCRIPCION TURNO",
                "CODIGO CENTRO DE COSTO", "DESCRIPCION CENTRO DE COSTO",
                "SALARIO", "VINCULACION", "NRO. PRESTAMO", "TIEMPO", "VALOR");
    }

    public List<String> getDatosCedulasPrenomina() {
        return datosCedulasPrenomina;
    }

    public List<String> getDatosNombresPrenomina() {
        return datosNombresPrenomina;
    }

    public List<String> getCodigoConcepto() {
        return codigoConcepto;
    }

    public List<String> getDescripcionConcepto() {
        return descripcionConcepto;
    }

    public List<Integer> getTiempoPrenomina() {
        return tiempoPrenomina;
    }

    public List<String> getEncabezadoPrenomina() {
        setEncabezadoPrenomina();
        return encabezadoPrenomina;
    }

    public void obtenerDatosPrenomina(Map<Integer, List<String>> prenomina) throws IOException {
        datosPrenomina = prenomina;
        obtenerDatosCedula();
        obtenerDatosNombre();
        obtenerDatosCodigoConcepto();
        obtenerDatosNombreConcepto();
        obtenerDatosTiempo();
    }

    public void obtenerDatosCedula() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        datosCedulasPrenomina = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String cedula = fila.get(0);
            String cedulaCorrecto = cedula.trim();
            datosCedulasPrenomina.add(cedulaCorrecto);
        }
    }

    public void obtenerDatosNombre() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        datosNombresPrenomina = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String nombre = fila.get(1);
            String nombreCorrecto = nombre.trim();
            datosNombresPrenomina.add(nombreCorrecto);
        }
    }

    public void obtenerDatosCodigoConcepto() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        codigoConcepto = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String codigo = fila.get(2);
            String codigoCorrecto = codigo.trim();
            codigoConcepto.add(codigoCorrecto);
        }
    }

    public void obtenerDatosNombreConcepto() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        descripcionConcepto = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String concepto = fila.get(3);
            String conceptoCorrecto = concepto.trim();
            descripcionConcepto.add(conceptoCorrecto);
        }
    }

    public void obtenerDatosTiempo() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        tiempoPrenomina = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String tiempoL = fila.get(11);
            String tiempoCorrecto = tiempoL.trim();
            if (tiempoCorrecto.contains(".")) {
                tiempoCorrecto = tiempoCorrecto.substring(0, tiempoCorrecto.length() - 2);
            }
            int tiempoCo = Integer.parseInt(tiempoCorrecto);
            tiempoPrenomina.add(tiempoCo);
        }
    }

}
