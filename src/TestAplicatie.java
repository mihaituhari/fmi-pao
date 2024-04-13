import Modele.Disciplina;
import Modele.Student;
import Servicii.ServiciuAutentificare;
import Servicii.ServiciuCatalog;

import java.util.Scanner;

public class TestAplicatie {
    public static void main(String[] args) {
        ServiciuCatalog serviciuCatalog = new ServiciuCatalog();
        Scanner scanner = new Scanner(System.in);

        testConexiune();

        while (true) {
            System.out.println();
            System.out.println("👨‍🎓 ⎯ STUDENTI ⎯");
            System.out.println("1. Listare | 2. Adăugare | 3. Modificare | 4. Ștergere");
            System.out.println();

            System.out.println("📖 ⎯ DISCIPLINE ⎯");
            System.out.println("5. Listare | 6. Adăugare | 7. Modificare | 8. Ștergere");
            System.out.println();

            System.out.println("💻 ⎯ ALTE COMENZI ⎯");
            System.out.println("9. Login student | 0. Ieșire");

            System.out.println();
            System.out.println("Alege optiune:");

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
                    modificaStudent(serviciuCatalog, scanner);
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
                    modificaDisciplina(serviciuCatalog, scanner);
                    break;
                case 8:
                    stergeDisciplina(serviciuCatalog, scanner);
                    break;

                // Alte comenzi
                case 9:
                    autentificaStudent(scanner);
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

        System.out.print("Introduceți emailul studentului: ");
        String emailStudent = scanner.next();

        System.out.print("Introduceți parola studentului: ");
        String parolaStudent = scanner.next();

        Student student = new Student(idStudent, prenumeStudent, numeStudent, emailStudent, parolaStudent);
        serviciuCatalog.adaugaStudent(student);

        System.out.println("Studentul a fost adăugat cu succes.");
    }

    private static void modificaStudent(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul studentului pe care doriți să-l modificati: ");
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

        System.out.print("Introduceți noul email al studentului: ");
        String emailStudent = scanner.next();

        serviciuCatalog.modificaStudent(idStudent, numeStudent, prenumeStudent, emailStudent);

        System.out.println("Detaliile studentului au fost modificate cu succes.");
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

    private static void autentificaStudent(Scanner scanner) {
        System.out.print("Introduceți emailul studentului: ");
        String emailStudent = scanner.next();

        System.out.print("Introduceți parola studentului: ");
        String parolaStudent = scanner.next();

        ServiciuAutentificare serviciuAutentificare = new ServiciuAutentificare();
        Student student = serviciuAutentificare.autentifica(emailStudent, parolaStudent);

        if (student != null) {
            System.out.println("Autentificare reușită!");
            System.out.println("👋 Salut " + student.getPrenume() + " " + student.getNume() + "!");
        } else {
            System.out.println("🔐 Autentificare eșuată. Verificați emailul și parola.");
        }
    }

    // Conexiune baza de date
    private static void testConexiune() {
        try {
            if (DAO.Conexiune.getConnection() != null) {
                System.out.println("🚀 Conexiunea la baza de date a fost stabilită cu succes.");
            } else {
                System.out.println("😱 Conexiunea la baza de date a eșuat.");
                System.exit(1);
            }
        } catch (Exception e) {
            System.out.println("😱 A apărut o eroare la stabilirea conexiunii la baza de date: " + e.getMessage());
            System.exit(1);
        }
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

    private static void modificaDisciplina(ServiciuCatalog serviciuCatalog, Scanner scanner) {
        System.out.print("Introduceți ID-ul disciplinei pe care doriți să o modificati: ");
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

        serviciuCatalog.modificaDisciplina(idDisciplina, codDisciplina, numeDisciplina);

        System.out.println("Detaliile disciplinei au fost modificate cu succes.");
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
