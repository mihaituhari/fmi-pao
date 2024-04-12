package Modele;

import java.util.List;

public class Facultate extends ModelBaza {
    private List<Student> studenti;
    private List<Disciplina> discipline;

    // Constructor
    public Facultate(int id, List<Student> studenti, List<Disciplina> discipline) {
        this.id = id;
        this.studenti = studenti;
        this.discipline = discipline;
    }

    // Getters
    public List<Student> getStudenti() {
        return studenti;
    }

    public List<Disciplina> getDiscipline() {
        return discipline;
    }

    // Setters
    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    public void setDiscipline(List<Disciplina> discipline) {
        this.discipline = discipline;
    }

    // Methods for adding and removing students and disciplines
    public void adaugaStudent(Student student) {
        this.studenti.add(student);
    }

    public void stergeStudent(Student student) {
        this.studenti.remove(student);
    }

    public void adaugaDisciplina(Disciplina disciplina) {
        this.discipline.add(disciplina);
    }

    public void stergeDisciplina(Disciplina disciplina) {
        this.discipline.remove(disciplina);
    }
}
