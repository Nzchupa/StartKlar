/**
 * Konfiguration: Einstellungen für Spring, die sich nicht in
 * {@code application.properties} ausdrücken lassen.
 *
 * <p>Beispiele für spätere Klassen: {@code WebConfig} (z. B. CORS-Regeln),
 * {@code SecurityConfig} (falls ein Login dazukommt).</p>
 *
 * <p><b>Regeln</b></p>
 * <ul>
 *   <li>Klassenname endet auf {@code Config}.</li>
 *   <li>Annotation {@code @Configuration} an der Klasse.</li>
 *   <li>Einfache Werte (Port, Pfade, Schalter) gehören in
 *       {@code src/main/resources/application.properties}, nicht hierher.</li>
 * </ul>
 *
 * <p>Aktuell ist keine eigene Konfigurationsklasse nötig: Port und Frontend-Ordner
 * stehen in {@code application.properties}.</p>
 */
package de.startklar.config;
