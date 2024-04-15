package controller;

import javax.swing.*;

import model.Patient;
import view.*;
import controller.*;


class MainController extends JFrame {
    private static ViewLogin viewLogin;
    private static ControlleurLogin controlleurLogin;
    private static ViewLoginDetails viewLoginDetails;

    public MainController() {
    }













    public static void main(String[] args) {
        Patient patient = new Patient("prevost", "alexandre", "alex.prevost@test.com", "mdp", 21,"rien");
        ViewPatient viewPatient = new ViewPatient(patient);
        ControlleurPatient controlleurPatient = new ControlleurPatient(viewPatient);

        controlleurPatient.showPatientWindow(patient);
    }
}
