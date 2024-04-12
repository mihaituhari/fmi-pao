package Servicii;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiciuLogging {
    private static final String LOG_FILE = "log.csv";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logAction(String actionName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(actionName + "," + LocalDateTime.now().format(formatter));
        } catch (IOException e) {
            System.out.println("Eroare la scrierea in fisierul de log: " + e.getMessage());
        }
    }
}
