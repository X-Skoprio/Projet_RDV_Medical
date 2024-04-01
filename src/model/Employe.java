package model;

public class Employe {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    public Employe(String nom, String prenom, String email, String mdp)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }


    //getters

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }
}
