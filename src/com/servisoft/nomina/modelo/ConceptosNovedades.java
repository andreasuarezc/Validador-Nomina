package com.servisoft.nomina.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConceptosNovedades {

    private List<String> basico001, incapGen031, licRemunerada015,
            vacaciones052, licMaternidad036, licNoRemunerada016,
            suspension017, ausencia067, accidenteTrabajo033;
    private Conexion conexion;

    public ConceptosNovedades() {

    }

    public List<String> getBasico001() {
        return basico001;
    }

    public List<String> getIncapGen031() {
        return incapGen031;
    }

    public List<String> getLicRemunerada015() {
        return licRemunerada015;
    }

    public List<String> getVacaciones052() {
        return vacaciones052;
    }

    public List<String> getLicMaternidad036() {
        return licMaternidad036;
    }

    public List<String> getLicNoRemunerada016() {
        return licNoRemunerada016;
    }

    public List<String> getSuspension017() {
        return suspension017;
    }

    public List<String> getAusencia067() {
        return ausencia067;
    }

    public List<String> getAccidenteTrabajo033() {
        return accidenteTrabajo033;
    }

    public void extraerDatosBd() {
        conexion = new Conexion();
        String SQL = "SELECT * FROM tbl_novedades_nomina";
        conexion.establecerConexion();
        basico001 = new ArrayList<>();
        incapGen031 = new ArrayList<>();
        licRemunerada015 = new ArrayList<>();
        vacaciones052 = new ArrayList<>();
        licMaternidad036 = new ArrayList<>();
        licNoRemunerada016 = new ArrayList<>();
        suspension017 = new ArrayList<>();
        ausencia067 = new ArrayList<>();
        accidenteTrabajo033 = new ArrayList<>();
        try {
            Statement instruccion = conexion.getConexion().createStatement();
            ResultSet resultado = instruccion.executeQuery(SQL);

            while (resultado.next()) {

                String codigo = resultado.getString("codigo_concepto");
                String sigla = resultado.getString("sigla");
                if (null != resultado.getString("codigo_concepto")) {
                    switch (codigo) {
                        case "001":
                            basico001.add(sigla);
                            break;
                        case "031":
                            incapGen031.add(sigla);
                            break;
                        case "015":
                            licRemunerada015.add(sigla);
                            break;
                        case "052":
                            vacaciones052.add(sigla);
                            break;
                        case "036":
                            licMaternidad036.add(sigla);
                            break;
                        case "016":
                            licNoRemunerada016.add(sigla);
                            break;
                        case "017":
                            suspension017.add(sigla);
                            break;
                        case "067":
                            ausencia067.add(sigla);
                            break;
                        case "033":
                            accidenteTrabajo033.add(sigla);
                            break;
                        default:
                            break;
                    }
                }
            }

        } catch (SQLException e) {

        }
        conexion.cerrarConexion();
    }

}
