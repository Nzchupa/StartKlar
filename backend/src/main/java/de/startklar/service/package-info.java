/**
 * Services: die Geschäftslogik der Anwendung.
 *
 * <p>Hier passiert die eigentliche Arbeit, z. B. einen Businessplan anlegen,
 * Gewinn und Verlust berechnen oder prüfen, ob alle Kapitel ausgefüllt sind.
 * Ein Service weiß nichts über HTTP oder HTML. Er bekommt Daten, verarbeitet sie
 * und gibt ein Ergebnis zurück. Dadurch lässt er sich leicht testen (siehe NFA-17).</p>
 *
 * <p><b>Regeln</b></p>
 * <ul>
 *   <li>Klassenname endet auf {@code Service}, z. B. {@code BusinessPlanService}, {@code FinanceService}.</li>
 *   <li>Annotation {@code @Service} an der Klasse.</li>
 *   <li>Wird vom Controller aufgerufen und nutzt selbst das Repository.</li>
 *   <li>Geldbeträge mit {@code BigDecimal} rechnen, nicht mit {@code double} (NFA-16).</li>
 *   <li>Zu jedem Service gehört ein Test in {@code src/test/java/de/startklar/service}.</li>
 * </ul>
 *
 * <p><b>Ablauf einer Anfrage:</b> Frontend → Controller → Service → Repository</p>
 */
package de.startklar.service;
