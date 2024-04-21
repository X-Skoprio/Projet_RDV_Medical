package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Patient;

/**
 * La classe {@code RendezVous} représente un rendez-vous médical que le patient va pouvoir faire.
 * <p>
 * Elle stocke les détails d'un rendez-vous, incluant les participants (médecin et patient),
 * les dates de début et de fin, ainsi qu'une description du rendez-vous.
 * </p>
 */
public class RendezVous {

    private List<RendezVous> listRendezVousTotal;
    public static int dernierId=0;
    public static int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private String emailPatient;
    private String emailMedecin;
    private String description;



    /**
     * Constructeur pour créer un nouveau rendez-vous avec les informations spécifiées.
     *
     * @param emailPatient L'email du patient
     * @param emailMedecin L'email du médecin
     * @param dateDebut La date et l'heure de début du rendez-vous.
     * @param dateFin La date et l'heure de fin du rendez-vous.
     * @param description Une brève description du rendez-vous.
     */
    public RendezVous(String emailPatient, String emailMedecin, LocalDateTime dateDebut, LocalDateTime dateFin, String description) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.emailPatient = emailPatient;
        this.emailMedecin = emailMedecin;
        this.description = description;
    }


    /**
     * Ajoute un rendez-vous à la liste totale des rendez-vous.
     *
     * @param rdv Le rendez-vous à ajouter.
     */
    public void ajouterRendezVous(RendezVous rdv) {
        this.listRendezVousTotal.add(rdv);
    }

    /**
     * Supprime un rendez-vous de la liste totale des rendez-vous.
     *
     * @param rdv Le rendez-vous à supprimer.
     */
    public void supprimerRendezVous(RendezVous rdv) {
        this.listRendezVousTotal.remove(rdv);
    }






    /**
     * Renvoie la date et l'heure de début du rendez-vous.
     *
     * @return La date et l'heure de début.
     */
    // Getter pour la date de début
    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    /**
     * Définit la date et l'heure de début du rendez-vous.
     *
     * @param dateDebut La nouvelle date et heure de début.
     */
    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Renvoie la date et l'heure de fin du rendez-vous.
     *
     * @return La date et l'heure de fin.
     */
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    /**
     * Définit la date et l'heure de fin du rendez-vous.
     *
     * @param dateFin La nouvelle date et heure de fin.
     */
    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * methode qui va afficher tt les details du patient avec la fonction toString pour l'afficher en String
     */
    public void afficherDetails() {
        System.out.println("Rendez-vous du " + dateDebut.toString() + " au " + dateFin.toString());
    }

    /**
     * Renvoie l'email du patient participant au rendez-vous.
     *
     * @return L'email du patient.
     */
    public String getEmailPatient(){return emailPatient;}

    /**
     * Renvoie l'email du médecin participant au rendez-vous.
     *
     * @return L'email du médecin.
     */
    public String getEmailMedecin(){return emailMedecin;}

    /**
     * Renvoie la description du rendez-vous.
     *
     * @return La description du rendez-vous.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Définit la description du rendez-vous.
     *
     * @param description La nouvelle description du rendez-vous.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "listRendezVousTotal=" + listRendezVousTotal +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", emailPatient='" + emailPatient + '\'' +
                ", emailMedecin='" + emailMedecin + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
