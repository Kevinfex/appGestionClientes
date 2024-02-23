package main.appgestionclientes;

import Presentacion.frameLogin;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author KEVIN EP
 */
public class AppGestionClientes {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        frameLogin frmLogin = new frameLogin();
        frmLogin.setVisible(true);
    }
}
