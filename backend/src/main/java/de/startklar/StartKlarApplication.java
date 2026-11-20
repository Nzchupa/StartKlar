package de.startklar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Einstiegspunkt der Anwendung StartKlar.
 *
 * <p>Beim Start sucht Spring Boot in diesem Paket und allen Unterpaketen
 * ({@code controller}, {@code service}, ...) nach Klassen mit Annotationen wie
 * {@code @RestController} oder {@code @Service} und erstellt sie automatisch.
 * Neue Klassen müssen deshalb immer unterhalb von {@code de.startklar} liegen.</p>
 *
 * <p>Nach dem Start ist die Anwendung unter
 * <a href="http://localhost:8080">http://localhost:8080</a> erreichbar.</p>
 */
@SpringBootApplication
public class StartKlarApplication {

    /**
     * Startet den eingebauten Webserver und die gesamte Anwendung.
     *
     * @param args Kommandozeilenargumente (werden an Spring Boot weitergereicht)
     */
    public static void main(String[] args) {
        SpringApplication.run(StartKlarApplication.class, args);
    }
}
