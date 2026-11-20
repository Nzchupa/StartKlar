/**
 * Controller: die Schnittstelle zwischen Frontend und Backend.
 *
 * <p>Ein Controller nimmt HTTP-Anfragen vom Browser entgegen (z. B. {@code GET /api/plans}),
 * ruft den passenden Service auf und gibt das Ergebnis als JSON zurück.
 * Ein Controller enthält <b>keine</b> Geschäftslogik und rechnet nichts selbst.</p>
 *
 * <p><b>Regeln</b></p>
 * <ul>
 *   <li>Klassenname endet auf {@code Controller}, z. B. {@code BusinessPlanController}.</li>
 *   <li>Annotation {@code @RestController} an der Klasse.</li>
 *   <li>Alle Pfade beginnen mit {@code /api/...}, damit sie sich nicht mit den
 *       Frontend-Seiten überschneiden.</li>
 *   <li>Daten werden als DTO aus dem Paket {@code dto} zurückgegeben, nicht direkt als Model.</li>
 *   <li>Jeder neue Endpunkt wird in {@code backend/README.md} eingetragen.</li>
 * </ul>
 *
 * <p>Beispiel: {@link de.startklar.controller.StatusController}</p>
 */
package de.startklar.controller;
