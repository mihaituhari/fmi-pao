package Modele;

public class ModelPersoana extends ModelBaza {
    protected String nume;
    protected String prenume;

    // Setters
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    // Getters
    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    // Helpers
    @Override
    public String toString() {
        return String.format("%s {id=%d, nume='%s', prenume='%s'}", getClass().getSimpleName(), id, nume, prenume);
    }
}
