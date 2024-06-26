package controller;

import javax.swing.*;

import controller.Login.*;
import view.*;
import view.ViewEmploye;

import java.sql.SQLException;

import static model.CliniqueImpl.connect;
import static model.CliniqueImpl.disconnect;


class MainController extends JFrame {
    private static ViewLogin viewLogin;
    private static ControlleurLogin controlleurLogin;
    private static ViewLoginDetails viewLoginDetails;
    private static ViewEmploye viewEmploye;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        connect();


        ViewLogin viewLogin = new ViewLogin();
        ControlleurLogin controlleurLogin = new ControlleurLogin(viewLogin);
        controlleurLogin.showLoginWindow();

       disconnect();
    }


}
