package controller;

import view.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurLogin {
    private ViewLogin view;

    public ControlleurLogin(ViewLogin view) {
        this.view = view;

        // Register action listeners
        this.view.getPatientButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onButtonEmployeClick();
            }
        });

        this.view.getEmployeeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onButtonEmployeClick();
            }
        });
    }

    private void onButtonPatientClick() {
        // Handle patient button click
        System.out.println("Patient button clicked");
    }

    private void onButtonEmployeClick() {
        // Handle employee button click
        System.out.println("Employee button clicked");
    }

    public static void main(String[] args) {
        // Initialize the view and the controller
        ViewLogin view = new ViewLogin();
        new ControlleurLogin(view);
    }
}
