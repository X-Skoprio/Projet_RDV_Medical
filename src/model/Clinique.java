package model;

import java.sql.SQLException;
import java.util.List;

public interface Clinique {

    /**
     Établir la connexion à la base de données à partir de ses 3 paramètres suivants :
     - URLDataBase : URL de la base de données
     - LoginDataBase : login de la base de données
     - PwdDataBase : password de la base de données
     L’exception SQLException est levée et propagée si aucun driver n’est trouvé pour l’URLDataBase
     L’exception ClassNotFoundException est levée et propagée si le chargement du driver échoue
     */
    public void connect() throws SQLException, ClassNotFoundException;

    // Fermer la connexion à la base de données
    public void disconnect() throws SQLException ;

    // EMPLOYE //
    // Récupérer tous les employes de la base de données dans une liste
    public List<Employe> getAllEmploye() throws SQLException ;
    // Insérer un nouveau employe dans la base de données
    public void insertEmploye(Employe employe) throws SQLException ;

    // PATIENT //
    public List<Patient> getAllPatient() throws SQLException ;
    public void insertPatient(Patient patient) throws SQLException ;

    // MEDECIN //

    public List<Medecin> getAllMedecin() throws SQLException ;

    public void insertMedecin(Medecin medecin) throws SQLException ;

    // RENDEZ-VOUS //
    public List<RendezVous> getAllRendezVous() throws SQLException ;

    public void insertRDV(RendezVous rdv) throws SQLException ;
}
