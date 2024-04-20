package model;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CliniqueImpl {

    private static Connection connection;
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/clinique";
    private static final String USER = "root";
    private static final String PASS = "";


    public CliniqueImpl() throws SQLException, ClassNotFoundException {
        connect();
    }


    public static void connect()
            throws SQLException, ClassNotFoundException {

        // Chargement du pilote JDBC
        Class.forName(JDBC_DRIVER);

        // Connexion à la base de données
        connection = DriverManager.getConnection(DB_URL, USER, PASS);


    }


    public static void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


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

    public static void insertMedecin(Medecin medecin) throws SQLException {
        String query = "INSERT INTO employe (nom, prenom, email, mdp) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, medecin.getNom());
            preparedStatement.setString(2, medecin.getPrenom());
            preparedStatement.setString(3, medecin.getEmail());
            preparedStatement.setString(4, medecin.getSpecialisation());
            preparedStatement.executeUpdate();
        }
    }


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

    public static void insertPatient(Patient patient) throws SQLException {
        String query = "INSERT INTO patient (nom, prenom, age, email, mdp, details) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, patient.getNom());
            preparedStatement.setString(2, patient.getPrenom());
            preparedStatement.setInt(3, patient.getAge());
            preparedStatement.setString(4, patient.getEmail());
            preparedStatement.setString(5, patient.getMdp());
            preparedStatement.setString(6, patient.getDetails());
            preparedStatement.executeUpdate();
        }
    }

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


    public static String getNomPatient(String email) {

        String nom = getAttributePatient("nom", email);

        return nom;
    }

    public static String getPrenomPatient(String email) {

        String prenom = getAttributePatient("prenom", email);

        return prenom;
    }

    public static int getAgePatient(String email) {
            try {
                int age = Integer.parseInt(getAttributePatient("age", email));
                return age;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            };
            return 0;
    }

    public static String getMdpPatient(String email) {

        String mdp = getAttributePatient("mdp", email);

        return mdp;
    }

    public static String getDetailsPatient(String email) {

        String details = getAttributePatient("details", email);

        return details;
    }

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


}








