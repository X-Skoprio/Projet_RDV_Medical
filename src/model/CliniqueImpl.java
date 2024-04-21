package model;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui contrôle toutes les fonctions SQL. C'est la classe mère qui va controler tout le projet.
 */
public class CliniqueImpl {

    private static Connection connection;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/clinique";
    private static final String USER = "root";
    private static final String PASS = "";

    /**
     * Implementation de la clinique, lieu où sont stocké toutes les informations.
     * @throws SQLException  si la base de donnée de fonctionne pas
     * @throws ClassNotFoundException si la classe est introuvable.
     */
    public CliniqueImpl() throws SQLException, ClassNotFoundException {
        connect();
    }

    /**
     * Connection à la base de donnée.
     */
    public static void connect()
            throws SQLException, ClassNotFoundException {

        // Chargement du pilote JDBC
        Class.forName(JDBC_DRIVER);

        // Connexion à la base de données
        connection = DriverManager.getConnection(DB_URL, USER, PASS);


    }

    /**
     * Deconnexion de la Base de données.
     * @throws SQLException si la base SQL ne fonctionne pas
     */
    public static void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * Recupère tous les Employe de la BDD
     * @return tous les employés sous forme d'une liste
     * @throws SQLException si la BDD ne fonctionne pas
     */
    public static List<Employe> getAllEmploye() throws SQLException {
        List<Employe> employeList = new ArrayList<>();
        String query = "SELECT * FROM employe";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String mdp = resultSet.getString("mdp");
                Employe employe = new Employe(nom, prenom, email, mdp);
                employeList.add(employe);
            }
        }

        return employeList;
    }

    /**
     * Permet de rajouter un employe au tableau
     * @param employe Employe que l'on veut insérer
     * @throws SQLException si la base SQL ne fonctionne pas
     */
    public static void insertEmploye(Employe employe) throws SQLException {
        String query = "INSERT INTO employe (nom, prenom, email, mdp) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employe.getNom());
            preparedStatement.setString(2, employe.getPrenom());
            preparedStatement.setString(3, employe.getEmail());
            preparedStatement.setString(4, employe.getMdp());
            preparedStatement.executeUpdate();
        }
    }


    /**
     * Recupère tous les Medecins de la BDD
     * @return tous les medecins sous forme d'une liste
     * @throws SQLException si la base de données ne fonctionne pas
     */
    public static List<Medecin> getAllMedecin() throws SQLException {
        List<Medecin> medecinList = new ArrayList<>();
        String query = "SELECT * FROM medecin";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String specialisation = resultSet.getString("specialisation");
                Medecin medecin = new Medecin(nom, prenom, email, specialisation);
                medecinList.add(medecin);
            }
        }

        return medecinList;
    }

    /**
     * Permet à l'employe de rajouter un medecin à la BDD
     * @param nom nom du medecin
     * @param prenom prenom du medecin
     * @param email mail du medecin
     * @param specialisation spe du medecin
     * @return un bool qui confirme qu'on a bien inserer le medecin à la BDD
     * @throws SQLException
     */
    public static boolean  insertMedecin(String nom, String prenom, String email, String specialisation) throws SQLException {
        String query = "INSERT INTO employe (nom, prenom, email, mdp) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, specialisation);
            preparedStatement.executeUpdate();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Erreur insertion medecin ");
            return false;
        }
    }

    /**
     * récupere une liste de tout les patients de la BDD
     * @return liste des patients
     * @throws SQLException si la bdd ne fonctionne pas
     */
    public static List<Patient> getAllPatient() throws SQLException {
        List<Patient> patientList = new ArrayList<>();
        String query = "SELECT * FROM patient";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                String mdp = resultSet.getString("mdp");
                String details = resultSet.getString("details");
                Patient patient = new Patient(nom, prenom, email, mdp, age, details);
                patientList.add(patient);
            }
        }

        return patientList;
    }

    /**
     * Permet de rajouter un patient à la liste.
     * @param nom nom du patient
     * @param prenom prenom du patient
     * @param age age du patient
     * @param email mail du patient
     * @param password mdp du patient
     * @param details details concernant le patient
     * @return bool qui confirme si on a bien insérer le patient à la liste
     * @throws SQLException si la BDD fonctionne pas
     */
    public static boolean insertPatient(String nom, String prenom, int age, String email, String password, String details) throws SQLException {
        String query = "INSERT INTO patient (nom, prenom, age, email, mdp, details) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, prenom);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setString(6, details);
            preparedStatement.executeUpdate();
        }
        return true;
    }

    /**
     * Récupère tous les rendez-vous de la base de données.
     * @return Une liste contenant tous les rendez-vous.
     * @throws SQLException En cas d'erreur SQL.
     */
    public static List<RendezVous> getAllRendezVous() throws SQLException {
        List<RendezVous> RDVList = new ArrayList<>();
        String query = "SELECT * FROM rdv";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                LocalDateTime dateDeBut = resultSet.getTimestamp("dateDebut").toLocalDateTime();
                LocalDateTime dateFin = resultSet.getTimestamp("dateFin").toLocalDateTime();
                String emailPatient = resultSet.getString("emailPatient");
                String emailMedecin = resultSet.getString("emailMedecin");
                String description =  resultSet.getString("description");

                RendezVous rdv = new RendezVous(emailPatient, emailMedecin, dateDeBut, dateFin, description);
                RDVList.add(rdv);
            }
        }

        return RDVList;
    }

    /**
     * rajoute un nouveau rdv à la bdd
     * @param rdv Le rendez-vous à insérer.
     * @throws SQLException En cas d'erreur SQL.
     */
    public static void Prendre1Rdv(RendezVous rdv) throws SQLException {
        String query = "INSERT INTO rdv (dateDebut, dateFin, emailPatient, emailMedecin, description) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setTimestamp(1, java.sql.Timestamp.valueOf(rdv.getDateDebut()));
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(rdv.getDateFin()));
            preparedStatement.setString(3, rdv.getEmailPatient());
            preparedStatement.setString(4, rdv.getEmailMedecin());
            preparedStatement.setString(5, rdv.getDescription());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Vérifie que le mail et le mdp correspondent aux informations de la BDD
     * @param email mail en question
     * @param password mpd pour se connecter à la bdd
     * @return boolean qui va annoncer si le mail et le mdp correspondent
     */
    public static boolean checkEmailAndPassword(String email, String password) {

        // Liste des noms de table
        String[] tableNames = {"employe", "patient"};

        // Indicateur pour suivre si une correspondance a été trouvée
        boolean matchFound = false;

        // Requête SQL pour récupérer les lignes en fonction de l'email et du mot de passe
        String query = "SELECT * FROM %s WHERE email = ? AND mdp = ?";


        // Parcourir les tables
        for (String tableName : tableNames) {
            // Créer la requête SQL avec le nom de la table
            String formattedQuery = String.format(query, tableName);
            try (PreparedStatement preparedStatement = connection.prepareStatement(formattedQuery)) {
                // Remplacement des paramètres email et mot de passe dans la requête SQL
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                // Exécution de la requête
                ResultSet resultSet = preparedStatement.executeQuery();

                // Si une ligne est retournée, cela signifie que l'email et le mot de passe correspondent
                if (resultSet.next()) {
                    matchFound = true;
                    break; // Sortir de la boucle dès qu'une correspondance est trouvée
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(matchFound);
        return matchFound;

    }

    /**
     * Récupère une information spécifique d'un patient
     * @param column info que l'on désire.
     * @param email mail du patient que l'on recherche
     * @return la colonne que l'on veut
     */
    private static String getAttributePatient(String column, String email) {
        String sql = "SELECT " + column + " FROM patient WHERE email = ?";
        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(column);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * SOus programme déja créer pour trouver plus facilement le nom
     * @param email mail du patient que l'on désire
     * @return le nom du patient
     */
    public static String getNomPatient(String email) {

        String nom = getAttributePatient("nom", email);

        return nom;
    }

    /**
     * SOus programme déja créer pour trouver plus facilement le prénom
     * @param email mail du patient que l'on désire
     * @return le prénom du patient
     */
    public static String getPrenomPatient(String email) {

        String prenom = getAttributePatient("prenom", email);

        return prenom;
    }

    /**
     * SOus programme déja créer pour trouver plus facilement son age
     * @param email mail du patient que l'on désire
     * @return age du patient
     */
    public static int getAgePatient(String email) {
        try {
            int age = Integer.parseInt(getAttributePatient("age", email));
            return age;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        };
        return 0;
    }

    /**
     * SOus programme déja créer pour trouver plus facilement le mdp
     * @param email mail du patient que l'on désire
     * @return le mdp du patient
     */
    public static String getMdpPatient(String email) {

        String mdp = getAttributePatient("mdp", email);

        return mdp;
    }

    /**
     * SOus programme déja créer pour trouver plus facilement les détails
     * @param email mail du patient que l'on désire
     * @return les détails du patient
     */
    public static String getDetailsPatient(String email) {

        String details = getAttributePatient("details", email);

        return details;
    }

    /**
     * On vérifie les informations du patient sont correcte et correspondent
     * @param email mail du patient
     * @return boolean qui vérifie
     */
    public static boolean checkEmailInPatient(String email) {
        // Nom de la table à vérifier
        String tableName = "patient";

        // Requête SQL pour vérifier l'existence de l'email dans la table
        String query = "SELECT 1 FROM " + tableName + " WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Remplacement du paramètre email dans la requête SQL
            preparedStatement.setString(1, email);

            // Exécution de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si une ligne est retournée, cela signifie que l'email existe
            if (resultSet.next()) {
                return true; // L'email existe
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false; // L'email n'existe pas
    }

    // Méthode statique pour récupérer tous les rendez-vous d'un patient par email
    public static List<RendezVous> getRendezVousByEmailPatient(String emailPatient) {
        List<RendezVous> rendezVousList = new ArrayList<>();
        String sql = "SELECT * FROM rdv WHERE emailPatient = ?";

        try ( // Assurez-vous que cette méthode existe et est correcte
              PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, emailPatient);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateDebut = rs.getTimestamp("dateDebut").toLocalDateTime();
                LocalDateTime dateFin = rs.getTimestamp("dateFin").toLocalDateTime();
                String emailMedecin = rs.getString("emailMedecin");
                String description = rs.getString("description");

                RendezVous rdv = new RendezVous(emailPatient, emailMedecin, dateDebut, dateFin, description);
                rendezVousList.add(rdv);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return rendezVousList;
    }

    /**
     * On vérifie les informations de l'employe sont correcte et correspondent
     * @param email mail de l'employe
     * @return boolean qui vérifie
     */
    public static boolean checkEmailInEmploye(String email) {
        // Nom de la table à vérifier
        String tableName = "employe";

        // Requête SQL pour vérifier l'existence de l'email dans la table
        String query = "SELECT 1 FROM " + tableName + " WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Remplacement du paramètre email dans la requête SQL
            preparedStatement.setString(1, email);

            // Exécution de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si une ligne est retournée, cela signifie que l'email existe
            if (resultSet.next()) {
                return true; // L'email existe
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false; // L'email n'existe pas
    }

    /**
     * Récupère les heures de rendez-vous indisponibles pour un médecin pour une date précise
     * @param emailMedecin L'email du médecin.
     * @param date La date des rendez-vous.
     * @return liste localTime qui correspond aux tranches horaires indisponibles
     */
    public static List<LocalDateTime> rdvIndispo(String emailMedecin, LocalDate date) {
        List<LocalDateTime> bookedTimes = new ArrayList<>();
        String sql = "SELECT dateDebut FROM rdv WHERE emailMedecin = ? AND DATE(dateDebut) = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, emailMedecin);
            //pstmt.setDate(2, Date.valueOf(date));
            pstmt.setDate(2, Date.valueOf(date));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    bookedTimes.add(rs.getTimestamp("dateDebut").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookedTimes;
    }

    /**
     * Supprime un patient de la base de données.
     * @param email L'email du patient à supprimer.
     * @return true si le patient est supprimé avec succès, sinon false.
     * @throws SQLException En cas d'erreur SQL.
     */
    public static boolean supprimerPatient(String email) throws SQLException {
        // SQL statement to delete a patient based on email
        String query = "DELETE FROM patient WHERE email = ?";

        // Try-with-resources statement to auto-close the PreparedStatement
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the email parameter in the SQL query
            preparedStatement.setString(1, email);

            // Execute the update
            int affectedRows = preparedStatement.executeUpdate();

            // Return true if the row is deleted
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error when attempting to delete patient: " + e.getMessage());
            throw e;  // Rethrow the exception to handle it outside if necessary
        }
    }
/**
 * Supprime un rendez-vous de la base de données.
 * @param dateDebut La date de début du rendez-vous à supprimer.
 * @param emailMedecin L'email du médecin associé au rendez-vous.
 * @throws SQLException En cas d'erreur SQL.
 */
    public static void SupprimerRdv(LocalDateTime dateDebut, String emailMedecin){
        String sql = "DELETE FROM rdv WHERE emailMedecin = ? AND dateDebut = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, emailMedecin);
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(dateDebut));
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Deleting rdv failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Supprime un médecin de la base de données.
     * @param email L'email du médecin à supprimer.
     * @return true si le médecin est supprimé avec succès, sinon false.
     * @throws SQLException En cas d'erreur SQL.
     */
    public static boolean supprimerMedecin(String email) throws SQLException {
        // SQL statement to delete a patient based on email
        String query = "DELETE FROM medecin WHERE email = ?";

        // Try-with-resources statement to auto-close the PreparedStatement
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the email parameter in the SQL query
            preparedStatement.setString(1, email);

            // Execute the update
            int affectedRows = preparedStatement.executeUpdate();

            // Return true if the row is deleted
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression de medecin: " + e.getMessage());
            throw e;  // Rethrow the exception to handle it outside if necessary
        }

    }

    /**
     * Vérifie si un email appartient à un médecin enregistré dans la base de données.
     * @param email L'email à vérifier.
     * @return true si l'email appartient à un médecin, sinon false.
     */
    public static boolean checkEmailInMedecin(String email) {
        // Nom de la table à vérifier
        String tableName = "medecin";

        // Requête SQL pour vérifier l'existence de l'email dans la table
        String query = "SELECT 1 FROM " + tableName + " WHERE email = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Remplacement du paramètre email dans la requête SQL
            preparedStatement.setString(1, email);

            // Exécution de la requête
            ResultSet resultSet = preparedStatement.executeQuery();

            // Si une ligne est retournée, cela signifie que l'email existe
            if (resultSet.next()) {
                return true; // L'email existe
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false; // L'email n'existe pas
    }
    /**
     * Récupère tous les rendez-vous d'un médecin à partir de son email.
     * @param emailMedecin L'email du médecin.
     * @return Une liste contenant tous les rendez-vous du médecin.
     */
    public static List<RendezVous> getRendezVousByEmailMedecin(String emailMedecin) {
        List<RendezVous> rendezVousList = new ArrayList<>();
        String sql = "SELECT * FROM rdv WHERE emailMedecin = ?";

        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, emailMedecin);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDateTime dateDebut = rs.getTimestamp("dateDebut").toLocalDateTime();
                LocalDateTime dateFin = rs.getTimestamp("dateFin").toLocalDateTime();
                String emailPatient = rs.getString("emailPatient");
                String description = rs.getString("description");

                RendezVous rdv = new RendezVous(emailPatient, emailMedecin, dateDebut, dateFin, description);
                rendezVousList.add(rdv);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }

        for(RendezVous rdv:rendezVousList)
        {
            rdv.toString();
        }
        return rendezVousList;


    }

    /**
     * Met à jour la description d'un rendez-vous dans la base de données.
     * @param dateDebut La date de début du rendez-vous.
     * @param emailMedecin L'email du médecin associé au rendez-vous.
     * @param description La nouvelle description du rendez-vous.
     * @throws SQLException En cas d'erreur SQL.
     */
    public static void updateRdvDescription(LocalDateTime dateDebut, String emailMedecin, String description) throws SQLException {
        String sql = "UPDATE rdv SET description = ? WHERE emailMedecin = ? AND dateDebut = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, description);
            pstmt.setString(2, emailMedecin);
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(dateDebut));
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating the RDV failed, no rows affected.");
            }
        }
    }

}
