package Servicii;

import DAO.StudentDAO;
import Modele.Student;

public class ServiciuAutentificare {
    public Student autentifica(String email, String parola) {
        ServiciuLogging.logAction("autentifica");

        StudentDAO studentDAO = new StudentDAO();

        return studentDAO.autentifica(email, parola);
    }
}
