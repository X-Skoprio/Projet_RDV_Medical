package model;


public class Medecin {
    private String nom;
    private String prenom;
    private String email;
    private String specialisation;

    public Medecin(String nom, String prenom, String email, String specialisation) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialisation = specialisation;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialisation() {
        return specialisation;
    }
    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
}
