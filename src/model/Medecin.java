package model;


/**
 * La classe {@code Medecin} représente un médecin.
 * Elle contient les informations personnelles et professionnelles du médecin.
 * <p>
 * Cette classe permet de gérer les informations d'identification d'un médecin,
 * ainsi que sa spécialisation dans un domaine particulier de la médecine.
 * </p>
 * @author MAAREK PREVOST JOUD
 */
public class Medecin {
    private String nom;
    private String prenom;
    private String email;
    private String specialisation;

    /**
     * Constructeur qui initialise un nouveau médecin avec ses informations de base.
     *
     * @param nom Le nom de famille du médecin.
     * @param prenom Le prénom du médecin.
     * @param email L'adresse email du médecin.
     * @param specialisation La spécialisation médicale du médecin.
     */
    public Medecin(String nom, String prenom, String email, String specialisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialisation = specialisation;
    }

    /**
     * Renvoie le nom de famille du médecin.
     *
     * @return Le nom de famille du médecin.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de famille du médecin.
     *
     * @param nom Le nouveau nom de famille du médecin.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Renvoie le prénom du médecin.
     *
     * @return Le prénom du médecin.
     */
    public String getPrenom() {
        return prenom;
    }


    /**
     * Définit le prénom du médecin.
     *
     * @param prenom Le nouveau prénom du médecin.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Renvoie l'adresse email du médecin.
     *
     * @return L'adresse email du médecin.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définit l'adresse email du médecin.
     *
     * @param email La nouvelle adresse email du médecin.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Renvoie la spécialisation médicale du médecin.
     *
     * @return La spécialisation du médecin.
     */
    public String getSpecialisation() {
        return specialisation;
    }

    /**
     * Définit la spécialisation médicale du médecin.
     *
     * @param specialisation La nouvelle spécialisation du médecin.
     */
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
