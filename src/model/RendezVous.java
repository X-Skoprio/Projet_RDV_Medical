package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

public class RendezVous {

    private List<RendezVous> listRendezVousTotal;
    public static int dernierId=0;
    public int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String emailPatient;
    private String emailMedecin;
    private String Description;



    // Constructeur
    public RendezVous(String emailPatient, String emailMedecin, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.id = ++dernierId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.emailPatient = emailPatient;
        this.emailMedecin = emailMedecin;
    }


    //ajoute un rdv
    public void ajouterRendezVous(RendezVous rdv) {
        this.listRendezVousTotal.add(rdv);
    }

    public void supprimerRendezVous(RendezVous rdv) {
        this.listRendezVousTotal.remove(rdv);
    }



    // Getter pour la date de début
    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    // Setter pour la date de début
    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    // Getter pour la date de fin
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    // Setter pour la date de fin
    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    // Méthode pour afficher les informations du rendez-vous
    public void afficherDetails() {
        System.out.println("Rendez-vous du " + dateDebut.toString() + " au " + dateFin.toString());
    }


    public String getEmailPatient(){return emailPatient;}
    public String getEmailMedecin(){return emailMedecin;}

    //Getters
    public String getDescription() {
        return Description;
    }

    //Setter
    public void setDescription(String description) {
        Description = description;
    }
}
