/**
 * Repositories: der Zugriff auf gespeicherte Daten.
 *
 * <p>Ein Repository speichert, lädt und löscht Objekte aus dem Paket {@code model}.
 * Wo die Daten liegen (in einer lokalen H2-Datenbank),
 * weiß nur das Repository. Services müssen dafür nicht geändert werden.</p>
 *
 * <p><b>Regeln</b></p>
 * <ul>
 *   <li>Klassenname endet auf {@code Repository}, z. B. {@code BusinessPlanRepository}.</li>
 *   <li>Annotation {@code @Repository} an der Klasse.</li>
 *   <li>Nur Speichern, Laden, Suchen, Löschen. Keine Berechnungen.</li>
 *   <li>Wird nur von Services benutzt, nie direkt vom Controller.</li>
 * </ul>
 *
 * <p>Hinweis: Businesspläne werden dauerhaft in der lokalen H2-Datenbank gespeichert.</p>
 */
package de.startklar.repository;
