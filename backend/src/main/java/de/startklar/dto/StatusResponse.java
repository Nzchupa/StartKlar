package de.startklar.dto;

/**
 * Antwort des Status-Endpunkts {@code GET /api/status}.
 *
 * <p>Ein {@code record} ist eine kurze Schreibweise für eine Klasse, die nur Daten hält.
 * Konstruktor, Getter, {@code equals} und {@code toString} erzeugt Java automatisch.</p>
 *
 * @param status      aktueller Zustand des Backends, z. B. "ok"
 * @param application Name der Anwendung
 */
public record StatusResponse(String status, String application) {
}
