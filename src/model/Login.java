package model;

/**
 * La classe {@code Login} sert à gérer l'email de connexion de l'utilisateur.
 * <p>
 * Elle va stocker le mail .
 * @author JOUD PREVOST MAAREK
 */
public class Login {

    /**
     * Email de l'utilisateur.
     */
    private static String email;

    //getters
    /**
     * Récupère l'email actuellement stocké.
     *
     * @return L'email de l'utilisateur.
     */
    public static String getEmail() {
        return email;
    }

    //setters
    /**
     * Définit l'email de l'utilisateur.
     *
     * @param email L'email à stocker.
     */
    public static void setEmail(String email) {
        Login.email = email;
    }
}
