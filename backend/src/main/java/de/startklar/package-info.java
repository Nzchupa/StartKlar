/**
 * Wurzelpaket des StartKlar-Backends.
 *
 * <p>Aufbau in Schichten, jede Schicht hat ein eigenes Paket:</p>
 * <pre>
 * controller  →  nimmt Anfragen vom Frontend entgegen (/api/...)
 * service     →  Geschäftslogik und Berechnungen
 * repository  →  Daten speichern und laden
 * model       →  fachliche Objekte (BusinessPlan, Chapter, ...)
 * dto         →  Daten, die als JSON zum Frontend gehen oder von dort kommen
 * config      →  Spring-Konfiguration
 * exception   →  eigene Ausnahmen und Fehlerbehandlung
 * </pre>
 *
 * <p>Eine Anfrage läuft immer in dieser Richtung: Controller → Service → Repository.
 * Keine Schicht überspringt eine andere.</p>
 */
package de.startklar;
