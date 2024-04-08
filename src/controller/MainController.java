package controller;

import javax.swing.*;

import view.*;
import controller.*;


class MainController extends JFrame {
    private static ViewLogin viewLogin;
    private static ControlleurLogin controlleurLogin;
    private static ViewLoginDetails viewLoginDetails;

    public MainController() {
    }













    public static void main(String[] args) {
        ViewLogin viewLogin = new ViewLogin();
        ControlleurLogin controlleurLogin = new ControlleurLogin(viewLogin);

        controlleurLogin.showLoginWindow();
    }
}
