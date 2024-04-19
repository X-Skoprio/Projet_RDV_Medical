package model;
import java.util.*;

/**
 * La classe {@code Employe} représente un employé dans le système de gestion de l'hôpital.
 * Elle stocke des informations personnelles de l'employé et gère une liste de patients associés.
 * <p>
 * Cette classe fournit des méthodes pour accéder aux informations de l'employé et pour manipuler
 * la liste des patients que l'employé peut gérer.
 * </p>
 */
public class Employe {
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    private static List<Patient> listPatientTotal;


    /**
     * Constructeur pour créer un nouvel employé avec ses informations de base.
     *
     * @param nom Le nom de l'employé.
     * @param prenom Le prénom de l'employé.
     * @param email L'email de l'employé.
     * @param mdp Le mot de passe de l'employé
     */
    public Employe(String nom, String prenom, String email, String mdp)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }


    //getters
    /**
     * Obtient le nom de l'employé.
     *
     * @return Le nom de famille de l'employé.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient le prénom de l'employé.
     *
     * @return Le prénom de l'employé.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Obtient l'email de l'employé.
     *
     * @return L'email de l'employé.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Obtient le mot de passe de l'employé.
     *
     * @return Le mot de passe de l'employé.
     */
    public String getMdp() {
        return mdp;
    }


    /**
     * Supprime un patient de la liste des patients gérés par cet employé.
     *
     * @param MonPatient Le patient à supprimer de la liste.
     */
    public void supprimerPatient(Patient MonPatient) {
        this.listPatientTotal.remove(MonPatient);
    }

    /**
     * Ajoute un patient à la liste des patients gérés par cet employé.
     *
     * @param MonPatient Le patient à ajouter à la liste.
     */
    public void ajouterPatient(Patient MonPatient) {
        this.listPatientTotal.add(MonPatient);
    }
}
