package Modele;

public class Student extends ModelPersoana {
    // Constructor
    public Student(int id, String prenume, String nume, String email, String parola) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.email = email;
        this.parola = parola;
    }

    protected String email;

    protected String parola;

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getParola() {
        return parola;
    }
}
