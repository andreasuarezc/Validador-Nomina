
package com.servisoft.nomina;

import com.servisoft.nomina.vista.IngresoApp;
import com.servisoft.nomina.modelo.Conexion;
public class NominaApp {

    
    public static void main(String[] args) {
        new IngresoApp().setVisible(true);
        new Conexion().establecerConexion();
    }
    
}
