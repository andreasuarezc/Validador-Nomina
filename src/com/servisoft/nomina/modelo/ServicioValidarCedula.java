package com.servisoft.nomina.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ServicioValidarCedula {

    private boolean validacionCedulas;
    private Map<Integer, List<String>> datosPrenomina, datosNovedades;
    private List<String> cedulasPrenomina, cedulasNovedades, nombreEmpleadoPrenomina, nombreEmpleadoNovedades;
    private List<Integer> posicionCedulaPrenomina, posicionCedulaNovedades;

    public ServicioValidarCedula() {
    }

    public boolean getValidacionCedulas() {
        return validacionCedulas;
    }

    public List<String> getCedulasPrenomina() {
        return cedulasPrenomina;
    }

    public List<String> getCedulasNovedades() {
        return cedulasNovedades;
    }

    public List<String> getNombreEmpleadoPrenomina() {
        return nombreEmpleadoPrenomina;
    }

    public List<String> getNombreEmpleadoNovedades() {
        return nombreEmpleadoNovedades;
    }

    public List<Integer> getPosicionCedulaPrenomina() {
        return posicionCedulaPrenomina;
    }

    public List<Integer> getPosicionCedulaNovedades() {
        return posicionCedulaNovedades;
    }

    public void validarCedulas(Map<Integer, List<String>> prenomina, Map<Integer, List<String>> novedades) throws IOException {
        validacionCedulas = validarIgualdadCedulas(prenomina, novedades);
    }

    public boolean validarIgualdadCedulas(Map<Integer, List<String>> prenomina, Map<Integer, List<String>> novedades) {
        datosPrenomina = prenomina;
        datosNovedades = novedades;
        cedulasPrenomina = obtenerCedulasPrenomina();
        cedulasNovedades = obtenerCedulasNovedades();
        nombreEmpleadoPrenomina = obtenerDatosNombreprenomina();
        nombreEmpleadoNovedades = obtenerDatosNombreNovedades();
        posicionCedulaPrenomina = buscarCedulasPrenominaEnNovedades();
        posicionCedulaNovedades = buscarCedulasNovedadesaEnPrenomina();
        if (posicionCedulaPrenomina.isEmpty() && posicionCedulaNovedades.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> obtenerCedulasPrenomina() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        cedulasPrenomina = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String cedula = fila.get(0);
            cedulasPrenomina.add(cedula);
        }
        cedulasPrenomina = cedulasPrenomina.stream().distinct().collect(Collectors.toList());
        return cedulasPrenomina;
    }

    public List<String> obtenerCedulasNovedades() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        cedulasNovedades = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String cedula = fila.get(3);
            cedulasNovedades.add(cedula);
        }
        return cedulasNovedades;
    }

    public List<String> obtenerDatosNombreprenomina() {
        List<String> fila;
        int cantidad = datosPrenomina.size();
        nombreEmpleadoPrenomina = new ArrayList<>();
        int i;
        for (i = 3; i < cantidad; i++) {
            fila = datosPrenomina.get(i);
            String nombre = fila.get(1);
            String nombreCorrecto = nombre.trim();
            nombreEmpleadoPrenomina.add(nombreCorrecto);
        }
        nombreEmpleadoPrenomina = nombreEmpleadoPrenomina.stream().distinct().collect(Collectors.toList());
        return nombreEmpleadoPrenomina;
    }

    public List<String> obtenerDatosNombreNovedades() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        nombreEmpleadoNovedades = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String nombre = fila.get(4);
            String nombreCorrecto = nombre.trim();
            nombreEmpleadoNovedades.add(nombreCorrecto);
        }
        return nombreEmpleadoNovedades;
    }

    public List<Integer> buscarCedulasPrenominaEnNovedades() {
        int cantidad = cedulasPrenomina.size();
        posicionCedulaPrenomina = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String dato = cedulasPrenomina.get(i);
            if (cedulasNovedades.indexOf(dato) == -1) {
                posicionCedulaPrenomina.add(i);
            }
        }
        return posicionCedulaPrenomina;
    }

    public List<Integer> buscarCedulasNovedadesaEnPrenomina() {
        int cantidad = cedulasNovedades.size();
        posicionCedulaNovedades = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String dato = cedulasNovedades.get(i);
            if (cedulasPrenomina.indexOf(dato) == -1) {
                posicionCedulaNovedades.add(i);
            }
        }
        return posicionCedulaNovedades;
    }
}
