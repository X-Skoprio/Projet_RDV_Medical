package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import model.RendezVous;

public class Patient {

    private List<RendezVous> listRendezVous;

    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    private String details;

    private int age;


    //constructeur Patient
    public Patient(String nom, String prenom, String email, String mdp, int age, String details) {
        this.listRendezVous = new ArrayList<>();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.age = age;
        this.details = details;
    }


    public void supprimerRendezVous(RendezVous rdv) {
        this.listRendezVous.remove(rdv);
        rdv.supprimerRendezVous(rdv);
    }
    public void ajouterRendezVous(RendezVous rdv) {
        this.listRendezVous.add(rdv);
        rdv.ajouterRendezVous(rdv);
    }


    //Getters
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

    public int getAge() {
        return age;
    }

    public List<RendezVous> getListRendezVous() {
        return listRendezVous;
    }

    public String getDetails() {
        return details;
    }

    //Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
