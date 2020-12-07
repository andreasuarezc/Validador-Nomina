package com.servisoft.nomina.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Novedades {
    private Map<Integer, List<String>> datosNovedades;
    private List<String> cedulas, encabezadoNovedades, nombreCompleto;
    private List<Integer> recNocturno, rnFestivo, heDiurna, heNocturna,
            heDiurnaDominical, heNocturnaDominical, tiempoPrenomina,
            tiempoNovedades;
    private List<String> datosCedulasPrenomina, codigoConcepto, diferencia,
            basico001, incapGen031, licRemunerada015, vacaciones052,
            licMaternidad036, licNoRemunerada016, suspension017, ausencia067,
            accidenteTrabajo033;
    private List<Integer> basico001Lista, incapGen031Lista,
            licRemunerada015Lista, vacaciones052Lista, licMaternidad036Lista,
            licNoRemunerada016Lista, suspension017Lista, ausencia067Lista,
            accidenteTrabajo033Lista;
    private ConceptosNovedades novedades;

    public Novedades() {
        novedades = new ConceptosNovedades();
        novedades.extraerDatosBd();
    }

    public void setIncapGen031() {
        incapGen031 = novedades.getIncapGen031();
    }

    public void setLicRemunerada015() {
        licRemunerada015 = novedades.getLicRemunerada015();
    }

    public void setVacaciones052() {
        vacaciones052 = novedades.getVacaciones052();
    }

    public void setLicMaternidad036() {
        licMaternidad036 = novedades.getLicMaternidad036();
    }

    public void setLicNoRemunerada016() {
        licNoRemunerada016 = novedades.getLicNoRemunerada016();
    }

    public void setSuspension017() {
        suspension017 = novedades.getSuspension017();
    }

    public void setAusencia067() {
        ausencia067 = novedades.getAusencia067();
    }

    public void setAccidenteTrabajo033() {
        accidenteTrabajo033 = novedades.getAccidenteTrabajo033();
    }

    public List<String> getEncabezadoNovedades() {
        setEncabezadoNovedades();
        return encabezadoNovedades;
    }

    public Map<Integer, List<String>> getDatosNovedades() {
        return datosNovedades;
    }

    public List<Integer> getTiempoNovedades() {
        return tiempoNovedades;
    }

    public List<String> getDiferencia() {
        return diferencia;
    }

    public void setBasico001() {
        basico001 = novedades.getBasico001();
    }

    public void setEncabezadoNovedades() {
        encabezadoNovedades = Arrays.asList("ITEM", "CENTRO DE COSTOS", "ROL", "CEDULA",
                "NOMBRE COMPLETO", "FECHA DE RETIRO", "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "OBSERVACIONES", "RECARGO NOCTURNO", "RN FESTIVO", "HE DIURNA",
                "HE NOCTURNA", "HE DIURNA DOMINICAL", "HE NOCTURNA DOMINICAL");
    }

    public void obtenerDatosNovedades(Map<Integer, List<String>> novedades, List<String> datosCedulasPrenomina, List<String> codigoConcepto,
            List<Integer> tiempoPrenomina) throws IOException {
        datosNovedades = novedades;
        this.datosCedulasPrenomina = datosCedulasPrenomina;
        this.codigoConcepto = codigoConcepto;
        this.tiempoPrenomina = tiempoPrenomina;
        obtenerDatosCedulaEmpleado();
        obtenerDatosNombreEmpleado();
        obtenerDatosRecNocturno();
        obtenerDatosRnFestivo();
        obtenerDatoHeDiurna();
        obtenerDatosHeNocturna();
        obtenerDatosHeDiurnaDominical();
        obtenerDatoHeNocturnaDominical();
        obtenerDiasLaborados();
        obtenerTiempoNovedades();
        obtenerDiferencia();
    }

    public void obtenerDatosCedulaEmpleado() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        cedulas = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String cedula = fila.get(3);
            String cedulaCorrecta = cedula.trim();
            cedulas.add(cedulaCorrecta);
        }
    }

    public void obtenerDatosNombreEmpleado() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        nombreCompleto = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String nombre = fila.get(4);
            String nombreCorrecto = nombre.trim();
            nombreCompleto.add(nombreCorrecto);
        }
    }

    public void obtenerDatosRecNocturno() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        recNocturno = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String valor = fila.get(37);
            String valorCorrecto = valor.trim();
            if (valorCorrecto == null || valorCorrecto.isEmpty()) {
                valorCorrecto = "0";
            }
            int recNoct = Integer.parseInt(valorCorrecto);
            recNocturno.add(recNoct);
        }
    }

    public void obtenerDatosRnFestivo() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        rnFestivo = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String valor = fila.get(38);
            String valorCorrecto = valor.trim();
            if (valorCorrecto == null || valorCorrecto.isEmpty()) {
                valor = "0";
            }
            int rnFes = Integer.parseInt(valor);
            rnFestivo.add(rnFes);
        }
    }

    public void obtenerDatoHeDiurna() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        heDiurna = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String valor = fila.get(39);
            String valorCorrecto = valor.trim();
            if (valorCorrecto == null || valorCorrecto.isEmpty()) {
                valor = "0";
            }
            int heDiur = Integer.parseInt(valor);
            heDiurna.add(heDiur);
        }
    }

    public void obtenerDatosHeNocturna() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        heNocturna = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String valor = fila.get(40);
            String valorCorrecto = valor.trim();
            if (valorCorrecto == null || valorCorrecto.isEmpty()) {
                valor = "0";
            }
            int heNoct = Integer.parseInt(valor);
            heNocturna.add(heNoct);
        }
    }

    public void obtenerDatosHeDiurnaDominical() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        heDiurnaDominical = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String valor = fila.get(41);
            String valorCorrecto = valor.trim();
            if (valorCorrecto == null || valorCorrecto.isEmpty()) {
                valor = "0";
            }
            int heDiurDo = Integer.parseInt(valor);
            heDiurnaDominical.add(heDiurDo);
        }
    }

    public void obtenerDatoHeNocturnaDominical() {
        List<String> fila;
        int cantidad = datosNovedades.size();
        heNocturnaDominical = new ArrayList<>();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            String valor = fila.get(42);
            String valorCorrecto = valor.trim();
            if (valorCorrecto == null || valorCorrecto.isEmpty()) {
                valor = "0";
            }
            int heNoctDo = Integer.parseInt(valor);
            heNocturnaDominical.add(heNoctDo);
        }
    }

    public void obtenerTiempoNovedades() {
        String cedulaPrenomina;
        int cantidad = datosCedulasPrenomina.size();
        tiempoNovedades = new ArrayList<>();
        int i;
        for (i = 0; i < cantidad; i++) {
            cedulaPrenomina = datosCedulasPrenomina.get(i);
            int posicionCedula = cedulas.indexOf(cedulaPrenomina);
            String codigo = codigoConcepto.get(i);
            if ("002".equals(codigo) && posicionCedula != -1) {
                int tiempo = heDiurna.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("003".equals(codigo) && posicionCedula != -1) {
                int tiempo = heNocturna.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("006".equals(codigo) && posicionCedula != -1) {
                int tiempo = recNocturno.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("011".equals(codigo) && posicionCedula != -1) {
                int tiempo = heDiurnaDominical.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("012".equals(codigo) && posicionCedula != -1) {
                int tiempo = heNocturnaDominical.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("014".equals(codigo) && posicionCedula != -1) {
                int tiempo = rnFestivo.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("001".equals(codigo) && posicionCedula != -1) {
                int tiempo = basico001Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("031".equals(codigo) && posicionCedula != -1) {
                int tiempo = incapGen031Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("015".equals(codigo) && posicionCedula != -1) {
                int tiempo = licRemunerada015Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("052".equals(codigo) && posicionCedula != -1) {
                int tiempo = vacaciones052Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("036".equals(codigo) && posicionCedula != -1) {
                int tiempo = licMaternidad036Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("016".equals(codigo) && posicionCedula != -1) {
                int tiempo = licNoRemunerada016Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("017".equals(codigo) && posicionCedula != -1) {
                int tiempo = suspension017Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("067".equals(codigo) && posicionCedula != -1) {
                int tiempo = ausencia067Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else if ("033".equals(codigo) && posicionCedula != -1) {
                int tiempo = accidenteTrabajo033Lista.get(posicionCedula);
                tiempoNovedades.add(tiempo);
            } else {
                tiempoNovedades.add(0);
            }
        }
    }

    public void obtenerDiasLaborados() {
        setBasico001();
        setIncapGen031();
        setAccidenteTrabajo033();
        setAusencia067();
        setLicMaternidad036();
        setLicNoRemunerada016();
        setSuspension017();
        setVacaciones052();
        setLicRemunerada015();
        basico001Lista = new ArrayList<>();
        incapGen031Lista = new ArrayList<>();
        licRemunerada015Lista = new ArrayList<>();
        vacaciones052Lista = new ArrayList<>();
        licMaternidad036Lista = new ArrayList<>();
        licNoRemunerada016Lista = new ArrayList<>();
        suspension017Lista = new ArrayList<>();
        ausencia067Lista = new ArrayList<>();
        accidenteTrabajo033Lista = new ArrayList<>();
        List<String> fila;
        int cantidad = datosNovedades.size();
        int i;
        for (i = 2; i < cantidad; i++) {
            fila = datosNovedades.get(i);
            int basico = 0;
            int incapGen = 0;
            int licRemunerada = 0;
            int vacaciones = 0;
            int licMaternidad = 0;
            int licNoRemunerada = 0;
            int suspension = 0;
            int ausencia = 0;
            int accidenteTrabajo = 0;
            String sigla;
            int x;
            for (x = 6; x < 36; x++) {
                sigla = fila.get(x);
                sigla = sigla.trim();
                if (basico001.contains(sigla)) {
                    basico++;
                }
                if (incapGen031.contains(sigla)) {
                    incapGen++;
                }
                if (licRemunerada015.contains(sigla)) {
                    licRemunerada++;
                }
                if (vacaciones052.contains(sigla)) {
                    vacaciones++;
                }
                if (licMaternidad036.contains(sigla)) {
                    licMaternidad++;
                }
                if (licNoRemunerada016.contains(sigla)) {
                    licNoRemunerada++;
                }
                if (suspension017.contains(sigla)) {
                    suspension++;
                }
                if (ausencia067.contains(sigla)) {
                    ausencia++;
                }
                if (accidenteTrabajo033.contains(sigla)) {
                    accidenteTrabajo++;
                }
            }
            basico001Lista.add(basico * 8);
            incapGen031Lista.add(incapGen * 8);
            licRemunerada015Lista.add(licRemunerada * 8);
            vacaciones052Lista.add(vacaciones * 8);
            licMaternidad036Lista.add(licMaternidad * 8);
            licNoRemunerada016Lista.add(licNoRemunerada * 8);
            suspension017Lista.add(suspension * 8);
            ausencia067Lista.add(ausencia * 8);
            accidenteTrabajo033Lista.add(accidenteTrabajo * 8);
        }
    }

    public void obtenerDiferencia() {
        int cantidad = datosCedulasPrenomina.size();
        diferencia = new ArrayList<>();
        int i;
        for (i = 0; i < cantidad; i++) {
            int tiempoPre = tiempoPrenomina.get(i);
            int tiempoNove = tiempoNovedades.get(i);
            if (tiempoPre == tiempoNove) {
                diferencia.add("No");
            } else {
                diferencia.add("Si");
            }
        }
    }
}
