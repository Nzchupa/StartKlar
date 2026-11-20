/**
 * DTOs (Data Transfer Objects): die Daten, die zwischen Frontend und Backend ausgetauscht werden.
 *
 * <p>Ein DTO beschreibt genau die Felder, die das Frontend sendet oder bekommt.
 * Spring wandelt DTOs automatisch in JSON um und zurück. So bleibt das Model
 * (Paket {@code model}) intern und kann sich ändern, ohne dass das Frontend bricht.</p>
 *
 * <p><b>Regeln</b></p>
 * <ul>
 *   <li>Am einfachsten als Java-{@code record}, z. B. {@code record BusinessPlanRequest(String name, String industry)}.</li>
 *   <li>Name beschreibt die Richtung: {@code ...Request} (vom Frontend), {@code ...Response} (zum Frontend).</li>
 *   <li>Keine Logik, nur Daten.</li>
 * </ul>
 *
 * <p>Beispiel: {@link de.startklar.dto.StatusResponse}</p>
 */
package de.startklar.dto;
