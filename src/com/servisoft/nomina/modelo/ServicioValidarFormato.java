package com.servisoft.nomina.modelo;

import java.io.IOException;
import java.text.Collator;
import java.util.List;
import java.util.Map;

public class ServicioValidarFormato {

    private Map<Integer, List<String>> datosPrenomina, datosNovedades;
    private List<String> encabezadoPrenomina, encabezadoNovedades, encabezado;
    private boolean formatoNovedades, formatoPrenomina;
    private Prenomina prenomina;
    private Novedades novedades;

    public ServicioValidarFormato() {
        prenomina = new Prenomina();
        novedades = new Novedades();

    }

    public Boolean getFormatoNovedades() {
        return formatoNovedades;
    }

    public Boolean getFormatoPrenomina() {
        return formatoPrenomina;
    }

    public List<String> asignarEncabezadoPrenomina() {
        encabezadoPrenomina = prenomina.getEncabezadoPrenomina();
        return encabezadoPrenomina;
    }

    public List<String> asignarEncabezadoNovedades() {
        encabezadoNovedades = novedades.getEncabezadoNovedades();
        return encabezadoNovedades;
    }

    public void validarFormatoPrenomina(Map<Integer, List<String>> prenomina) throws IOException {
        formatoPrenomina = formatoPrenomina(prenomina);
    }

    public boolean formatoPrenomina(Map<Integer, List<String>> prenomina) {
        asignarEncabezadoPrenomina();
        datosPrenomina = prenomina;
        encabezado = datosPrenomina.get(2);
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.PRIMARY);
        String resultado = " ";
        int i;
        if (encabezado.size() >= 13) {
            for (i = 0; i < 13; i++) {
                String valor = encabezado.get(i);
                String nombre = encabezadoPrenomina.get(i);
                if (comparador.compare(valor, nombre) != 0) {
                    resultado = "break";
                    break;
                }
            }
            if (resultado.equals("break")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public void validarFormatoNovedades(Map<Integer, List<String>> novedades) throws IOException {
        formatoNovedades = formatoNovedades(novedades);
    }

    public boolean formatoNovedades(Map<Integer, List<String>> novedades) {
        asignarEncabezadoNovedades();
        datosNovedades = novedades;
        encabezado = datosNovedades.get(1);
        Collator comparador = Collator.getInstance();
        comparador.setStrength(Collator.PRIMARY);
        String resultado = " ";
        int i;
        if (encabezado.size() >= 13) {
            for (i = 0; i < encabezado.size(); i++) {
                String valor = encabezado.get(i);
                        
                if (valor.contains(".")) {
                     valor = valor.substring(0,valor.length()-2);
                }
                
                String nombre = encabezadoNovedades.get(i);
                if (comparador.compare(valor, nombre) != 0) {
                    resultado = "break";
                    break;
                }
            }
            if (resultado.equals("break")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

}
