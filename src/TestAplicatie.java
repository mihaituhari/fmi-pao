import Modele.Disciplina;
import Modele.Student;
import Servicii.ServiciuCatalog;

import java.util.Scanner;

public class TestAplicatie {
    public static void main(String[] args) {
        ServiciuCatalog serviciuCatalog = new ServiciuCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("👨‍🎓 ⎯ STUDENTI ⎯");
            System.out.println("1. Listare | 2. Adăugare | 3. Actualizare | 4. Ștergere");
            System.out.println();

            System.out.println("📖 ⎯ DISCIPLINE ⎯");
            System.out.println("5. Listare | 6. Adăugare | 7. Actualizare | 8. Ștergere");
            System.out.println();

            System.out.println("0. Ieșire");

            int optiune = scanner.nextInt();

            switch (optiune) {
                // Studenti
                case 1:
                    serviciuCatalog.afiseazaStudenti();
                    break;
                case 2:
                    adaugaStudent(serviciuCatalog, scanner);
                    break;
                case 3:
                    actualizeazaStudent(serviciuCatalog, scanner);
                    break;
                case 4:
                    stergeStudent(serviciuCatalog, scanner);
                    break;

                // Discipline
                case 5:
                    serviciuCatalog.afiseazaDiscipline();
                    break;
                case 6:
                    adaugaDisciplina(serviciuCatalog, scanner);
                    break;
                case 7:
                    actualizeazaDisciplina(serviciuCatalog, scanner);
                    break;
                case 8:
                    stergeDisciplina(serviciuCatalog, scanner);
                    break;

                case 0:
                    System.out.println("La revedere!");
                    return;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        }
    }

    // Studenti
    private static void adaugaStudent(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul studentului: ");
        int idStudent = scanner.nextInt();

        System.out.print("Introduceți prenumele studentului: ");
        String prenumeStudent = scanner.next();

        System.out.print("Introduceți numele studentului: ");
        String numeStudent = scanner.next();

        Student student = new Student(idStudent, numeStudent, prenumeStudent);
        serviciuCatalog.adaugaStudent(student);

        System.out.println("Studentul a fost adăugat cu succes.");
    }

    private static void actualizeazaStudent(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul studentului pe care doriți să-l actualizați: ");
        int idStudent = scanner.nextInt();

        Student student = serviciuCatalog.gasesteStudent(idStudent);
        if (student == null) {
            System.out.println("Studentul cu ID-ul dat nu există.");
            return;
        }

        System.out.print("Introduceți noul prenume al studentului: ");
        String prenumeStudent = scanner.next();

        System.out.print("Introduceți noul nume al studentului: ");
        String numeStudent = scanner.next();

        serviciuCatalog.actualizeazaStudent(idStudent, numeStudent, prenumeStudent);

        System.out.println("Detaliile studentului au fost actualizate cu succes.");
    }

    private static void stergeStudent(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul studentului pe care doriți să-l stergeti: ");
        int idStudent = scanner.nextInt();

        Student student = serviciuCatalog.gasesteStudent(idStudent);
        if (student == null) {
            System.out.println("Studentul cu ID-ul dat nu există.");
            return;
        }

        serviciuCatalog.stergeStudent(idStudent);
        System.out.println("Student sters cu succes.");
    }

    // Discipline
    private static void adaugaDisciplina(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul disciplinei: ");
        int idDisciplina = scanner.nextInt();

        System.out.print("Introduceți numele disciplinei: ");
        String numeDisciplina = scanner.next();

        System.out.print("Introduceți codul disciplinei: ");
        String codDisciplina = scanner.next();

        Disciplina disciplina = new Disciplina(idDisciplina, codDisciplina, numeDisciplina);
        serviciuCatalog.adaugaDisciplina(disciplina);

        System.out.println("Disciplina a fost adăugată cu succes.");
    }

    private static void actualizeazaDisciplina(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul disciplinei pe care doriți să o actualizați: ");
        int idDisciplina = scanner.nextInt();

        Disciplina disciplina = serviciuCatalog.gasesteDisciplina(idDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina cu ID-ul dat nu există.");
            return;
        }

        System.out.print("Introduceți noul nume al disciplinei: ");
        String numeDisciplina = scanner.next();

        System.out.print("Introduceți noul cod al disciplinei: ");
        String codDisciplina = scanner.next();

        serviciuCatalog.actualizeazaDisciplina(idDisciplina, codDisciplina, numeDisciplina);

        System.out.println("Detaliile disciplinei au fost actualizate cu succes.");
    }

    private static void stergeDisciplina(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul disciplinei pe care doriți să o ștergeți: ");
        int idDisciplina = scanner.nextInt();

        Disciplina disciplina = serviciuCatalog.gasesteDisciplina(idDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina cu ID-ul dat nu există.");
            return;
        }

        serviciuCatalog.stergeDisciplina(idDisciplina);
        System.out.println("Disciplina a fost ștearsă cu succes.");
    }
}
