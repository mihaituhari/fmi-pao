package Servicii;

import Modele.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ServiciuAutentificare {
    private List<Profesor> profesori;

    public ServiciuAutentificare() {
        // Inițializare cadre didactice (într-o implementare reală, acestea ar fi citite dintr-o bază de date)
        this.profesori = new ArrayList<>();
    }

    public boolean autentifica(String nume, String parola) {
        for (Profesor profesor : profesori) {
            if (profesor.getNume().equals(nume) /* Verifică parola aici */) {
                return true; // Autentificare reușită
            }
        }
        return false; // Autentificare eșuată
    }

    // Metodă pentru adăugarea unui profesor (simplificată)
    public void adaugaProfesor(Profesor profesor) {
        profesori.add(profesor);
    }
}
