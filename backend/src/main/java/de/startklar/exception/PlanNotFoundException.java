package de.startklar.exception;
/** Ein angeforderter Plan oder Eintrag ist nicht vorhanden. */
public class PlanNotFoundException extends RuntimeException {
    /**
 * Erstellt die Fehlermeldung.
 * @param message Meldung
 */
    public PlanNotFoundException(String message) { super(message); }
}
