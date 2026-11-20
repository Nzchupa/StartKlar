package de.startklar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.startklar.dto.StatusResponse;

/**
 * Liefert den Status des Backends.
 *
 * <p>Damit lässt sich prüfen, ob das Backend läuft und das Frontend es erreicht.
 * Die Klasse dient gleichzeitig als Vorlage für neue Controller.</p>
 *
 * <p>Aufruf im Browser: <a href="http://localhost:8080/api/status">http://localhost:8080/api/status</a></p>
 */
@RestController
@RequestMapping("/api/status")
public class StatusController {

    /**
     * Gibt zurück, dass das Backend erreichbar ist.
     *
     * @return Status als JSON, z. B. {@code {"status":"ok","application":"StartKlar"}}
     */
    @GetMapping
    public StatusResponse getStatus() {
        return new StatusResponse("ok", "StartKlar");
    }
}
