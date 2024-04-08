package view;

import javax.swing.*;


public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewLogin viewLogin = new ViewLogin();
            viewLogin.setTitle("Login Window"); // Set the window title
            viewLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the application exits when the window is closed
            viewLogin.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewLogin.setLocationRelativeTo(null); // Center the window on the screen
            viewLogin.setVisible(true); // Make the window visible
        });
    }
}
