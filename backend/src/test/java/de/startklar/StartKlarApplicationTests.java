package de.startklar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Prüft, ob die Anwendung überhaupt starten kann.
 *
 * <p>Schlägt dieser Test fehl, ist meist eine Klasse falsch konfiguriert
 * (z. B. fehlende Annotation oder doppelter Endpunkt).</p>
 */
@SpringBootTest
class StartKlarApplicationTests {

    @Test
    void contextLoads() {
        // Kein Code nötig: Der Test ist erfolgreich, wenn Spring ohne Fehler startet.
    }
}
