package controller;

import javax.swing.*;

import view.*;
import controller.*;
import model.CliniqueImpl;

import java.sql.SQLException;


class MainController extends JFrame {
    private static ViewLogin viewLogin;
    private static ControlleurLogin controlleurLogin;
    private static ViewLoginDetails viewLoginDetails;

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
