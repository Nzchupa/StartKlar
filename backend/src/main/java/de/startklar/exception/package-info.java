/**
 * Fehlerbehandlung: eigene Ausnahmen und ihre Übersetzung in verständliche Fehlermeldungen.
 *
 * <p>Wenn z. B. ein Businessplan nicht existiert, wirft der Service eine eigene Ausnahme
 * wie {@code BusinessPlanNotFoundException}. Eine zentrale Klasse
 * ({@code GlobalExceptionHandler} mit {@code @RestControllerAdvice}) fängt sie ab
 * und schickt dem Frontend eine deutsche Fehlermeldung ohne technische Codes (NFA-09).</p>
 *
 * <p><b>Regeln</b></p>
 * <ul>
 *   <li>Klassenname endet auf {@code Exception}.</li>
 *   <li>Eigene Ausnahmen erben von {@code RuntimeException}.</li>
 *   <li>Fehlermeldungen für Nutzer immer auf Deutsch und ohne Stacktrace.</li>
 * </ul>
 */
package de.startklar.exception;
