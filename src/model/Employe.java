package model;
import java.util.*;

public class Employe {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    private static List<Patient> listPatientTotal;

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



    public void supprimerPatient(Patient MonPatient) {
        this.listPatientTotal.remove(MonPatient);
    }
    public void ajouterPatient(Patient MonPatient) {
        this.listPatientTotal.add(MonPatient);
    }
}
