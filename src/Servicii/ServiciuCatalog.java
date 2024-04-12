package Servicii;

import DAO.StudentDAO;
import Modele.Disciplina;
import Modele.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ServiciuCatalog {
    private List<Student> studenti;
    private TreeSet<Disciplina> discipline;

    private StudentDAO studentDAO;

    public ServiciuCatalog() {
        this.studentDAO = new StudentDAO();

        this.studenti = studentDAO.lista();
        this.discipline = new TreeSet<>();
    }

    // Studenti
    public Student gasesteStudent(int id) {
        ServiciuLogging.logAction("gasesteStudent");

        for (Student student : studenti) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void adaugaStudent(Student student) {
        ServiciuLogging.logAction("adaugaStudent");
        studentDAO.adauga(student);
        studenti.add(student);
    }

    public void afiseazaStudenti() {
        ServiciuLogging.logAction("afiseazaStudenti");

        if (studenti.isEmpty()) {
            System.out.println("Nu există studenți");
        } else {
            for (Student student : studenti) {
                System.out.println(student);
            }
        }
    }

    public void actualizeazaStudent(int id, String numeNou, String prenumeNou) {
        ServiciuLogging.logAction("actualizeazaStudent");

        for (Student student : studenti) {
            if (student.getId() == id) {
                student.setNume(numeNou);
                student.setPrenume(prenumeNou);
                break;
            }
        }
    }

    public void stergeStudent(int id) {
        ServiciuLogging.logAction("stergeStudent");
        studenti.removeIf(student -> student.getId() == id);
    }

    // Discipline
    public Disciplina gasesteDisciplina(int id) {
        ServiciuLogging.logAction("gasesteDisciplina");

        for (Disciplina disciplina : discipline) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    public void adaugaDisciplina(Disciplina disciplina) {
        ServiciuLogging.logAction("adaugaDisciplina");
        discipline.add(disciplina);
    }

    public void afiseazaDiscipline() {
        ServiciuLogging.logAction("afiseazaDiscipline");

        if (discipline.isEmpty()) {
            System.out.println("Nu există discipline");
        } else {
            for (Disciplina disciplina : discipline) {
                System.out.println(disciplina);
            }
        }
    }

    public void actualizeazaDisciplina(int id, String codNou, String numeNou) {
        ServiciuLogging.logAction("actualizeazaDisciplina");

        for (Disciplina disciplina : discipline) {
            if (disciplina.getId() == id) {
                disciplina.setCod(codNou);
                disciplina.setNume(numeNou);
                break;
            }
        }
    }

    public void stergeDisciplina(int id) {
        ServiciuLogging.logAction("stergeDisciplina");
        discipline.removeIf(disciplina -> disciplina.getId() == id);
    }
}
