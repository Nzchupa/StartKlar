package de.startklar.exception;
/** Eine Benutzereingabe ist ungültig. */
public class InvalidInputException extends RuntimeException {
    /**
 * Erstellt die Fehlermeldung.
 * @param message Meldung
 */
    public InvalidInputException(String message) { super(message); }
}
