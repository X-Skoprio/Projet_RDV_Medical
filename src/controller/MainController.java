package controller;

import javax.swing.*;

import controller.Login.*;
import controller.Employe.*;
import view.*;
import model.CliniqueImpl;

import java.sql.SQLException;


class MainController extends JFrame {
    private static ViewLogin viewLogin;
    private static ControlleurLogin controlleurLogin;
    private static ViewLoginDetails viewLoginDetails;
    private static ViewEmploye viewEmploye;

    public MainController() {

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        CliniqueImpl clinique = new CliniqueImpl();


        ViewLogin viewLogin = new ViewLogin();
        ControlleurLogin controlleurLogin = new ControlleurLogin(viewLogin);
        controlleurLogin.showLoginWindow();

        clinique.disconnect();
    }


}
