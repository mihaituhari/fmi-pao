package DAO;

import Modele.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> lista() {
        List<Student> studenti = new ArrayList<>();
        String sql = "SELECT * FROM studenti";

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
        String sql = "INSERT INTO studenti (id, prenume, nume, email, parola) VALUES (?, ?, ?, ?, ?)";

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
}
