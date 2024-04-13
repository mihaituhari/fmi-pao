package DAO;

import Modele.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String TABLE_NAME = "studenti";

    public List<Student> lista() {
        List<Student> studenti = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLE_NAME;

        try (
                Connection connection = Conexiune.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String prenume = resultSet.getString("prenume");
                String nume = resultSet.getString("nume");
                String email = resultSet.getString("email");
                String parola = resultSet.getString("parola");

                Student student = new Student(id, prenume, nume, email, parola);
                studenti.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studenti;
    }

    public void adauga(Student student) {
        String sql = "INSERT INTO " + TABLE_NAME + " (id, prenume, nume, email, parola) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection connection = Conexiune.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getPrenume());
            statement.setString(3, student.getNume());
            statement.setString(4, student.getEmail());
            statement.setString(5, student.getParola());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifica(Student student) {
        String sql = "UPDATE " + TABLE_NAME + " SET prenume = ?, nume = ?, email = ?, parola = ? WHERE id = ?";

        try (
                Connection connection = Conexiune.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, student.getPrenume());
            statement.setString(2, student.getNume());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getParola());
            statement.setInt(5, student.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sterge(int id) {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

        try (
                Connection connection = Conexiune.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // In StudentDAO.java
    public Student autentifica(String email, String parola) {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE email = ? AND parola = ?";

        try (
                Connection connection = Conexiune.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, email);
            statement.setString(2, parola);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String prenume = resultSet.getString("prenume");
                String nume = resultSet.getString("nume");

                return new Student(id, prenume, nume, email, parola);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
