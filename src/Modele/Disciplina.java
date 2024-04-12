package Modele;

public class Disciplina extends ModelBaza implements Comparable<Disciplina> {
    private String cod;
    private String nume;

    // Constructor
    public Disciplina(int id, String cod, String nume) {
        this.id = id;
        this.cod = cod;
        this.nume = nume;
    }

    // Setters
    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    // Getters
    public String getCod() {
        return cod;
    }

    public String getNume() {
        return nume;
    }

    // Helpers
    @Override
    public String toString() {
        return String.format("Disciplina {id=%d, cod='%s', nume='%s'}", id, cod, nume);
    }

    @Override
    public int compareTo(Disciplina other) {
        return this.nume.compareTo(other.nume); // Sortare dupa nume
    }
}
