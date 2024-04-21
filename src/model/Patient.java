package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Patient;
import model.RendezVous;


/**
 * La classe {@code Patient} représente un patient dans un système de gestion médicale.
 * Elle stocke des informations personnelles du patient et gère une liste de ses rendez-vous médicaux.
 * @author PREVOST JOUD MAAREK
 */

public class Patient {

    private List<RendezVous> listRendezVous;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private int age;
    private String details;


    /**
     * Construit un nouveau patient avec les informations spécifiées.
     *
     * @param nom Le nom du patient.
     * @param prenom Le prénom du patient.
     * @param email L'adresse email du patient.
     * @param mdp Le mot de passe du patient
     * @param age L'âge du patient.
     * @param details Des détails supplémentaires sur le patient.
     */

    public Patient(String nom, String prenom, String email, String mdp, int age, String details) {
        this.listRendezVous = new ArrayList<>();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.age = age;
        this.details = details;
    }

    /**
     * Supprime un rendez-vous de la liste de rendez-vous du patient.
     *
     * @param rdv Le rendez-vous à supprimer.
     */
    public void supprimerRendezVous(RendezVous rdv) {
        this.listRendezVous.remove(rdv);
        rdv.supprimerRendezVous(rdv);
    }
    /**
     * Ajoute un rendez-vous à la liste de rendez-vous du patient.
     *
     * @param rdv Le rendez-vous à ajouter.
     */
    public void ajouterRendezVous(RendezVous rdv) {
        this.listRendezVous.add(rdv);
        rdv.ajouterRendezVous(rdv);
    }




    //Getters
    /**
     * Renvoie le nom du patient.
     *
     * @return Le nom de famille du patient.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Renvoie le prénom du patient.
     *
     * @return Le prénom du patient.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Renvoie l'email du patient.
     *
     * @return L'adresse email du patient.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Renvoie le mot de passe du patient.
     *
     * @return Le mot de passe du patient.
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Renvoie l'âge du patient.
     *
     * @return L'âge du patient.
     */
    public int getAge() {
        return age;
    }

    /**
     * Renvoie la liste des rendez-vous du patient.
     *
     * @return Une liste des rendez-vous du patient.
     */
    public List<RendezVous> getListRendezVous() {
        return listRendezVous;
    }

    /**
     * Renvoie des détails supplémentaires sur le patient.
     *
     * @return Les détails supplémentaires sur le patient.
     */
    public String getDetails() {
        return details;
    }



    //Setters
    /**
     * Définit le nom du patient.
     *
     * @param nom Le nouveau nom de famille du patient.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Définit le prénom du patient.
     *
     * @param prenom Le nouveau prénom du patient.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Définit l'email du patient.
     *
     * @param email La nouvelle adresse email du patient.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Définit le mot de passe du patient.
     *
     * @param mdp Le nouveau mot de passe du patient.
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Définit l'âge du patient.
     *
     * @param age Le nouvel âge du patient.
     */
    public void setAge(int age) {
        this.age = age;
    }


}
