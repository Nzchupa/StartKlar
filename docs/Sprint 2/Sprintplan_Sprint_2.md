# Sprintplan – Sprint 2

**StartKlar – Businessplantool** · Gruppe 5 · Stand: 20.11.2026 · Entwurf, wird im Sprint Planning am 26.11. bestätigt

| | |
| --- | --- |
| **Zeitraum** | Fr 27.11.2026 – Do 10.12.2026 (2 Wochen) |
| **Sprint Planning** | Do 26.11.2026 nach der MVP-Vorstellung |
| **Sprint Review & Retrospektive** | Do 10.12.2026 nach dem Gruppencoaching |
| **Board** | GitHub Issues, Milestone „Sprint 2“ |

---

## 1. Sprint-Ziel

> **Am 10.12. läuft der MVP als echte Anwendung: Ein Nutzer legt einen Businessplan mit Branche an, füllt die fünf Kapitel mit Hilfetexten aus, trägt Mitarbeiter und Kosten ein und sieht Gewinn bzw. Verlust. Die Daten bleiben nach einem Neustart erhalten.**

Die drei Fragen des Sprint Plannings:

- **Warum ist der Sprint wichtig?** In Sprint 1 haben wir Anforderungen, MVP-Umfang, Projektgerüst und Klick-Entwurf erarbeitet. Jetzt wird daraus eine lauffähige Anwendung, auf der alle weiteren Sprints aufbauen.
- **Was müssen wir tun?** Schnittstelle zwischen Frontend und Backend festlegen, Backend-Logik und Datenspeicherung umsetzen, Frontend-Seiten aus dem Klick-Entwurf an das Backend anbinden, testen.
- **Wie erledigen wir es?** Zwei Teams (Backend und Frontend) arbeiten parallel. Jede Aufgabe ist ein Issue, pro Aufgabe ein eigener Branch, jeder Pull Request wird von einer anderen Person geprüft.

---

## 2. MVP-Anforderungen in diesem Sprint

| ID | Anforderung | Umsetzung in |
| --- | --- | --- |
| FA-02 | Businessplan anlegen | S2-04, S2-11 |
| FA-03 | Schrittweise durch die fünf Kapitel führen | S2-05, S2-12 |
| FA-04 | Daten speichern und später fortsetzen | S2-03, S2-05 |
| FA-05 | Hilfetexte und Beispiele pro Kapitel | S2-12 |
| FA-10 | Branche auswählen | S2-02, S2-11 |
| FA-11 | Vorlage mit allen Gliederungspunkten | S2-04 |
| FA-14 | Gewinn und Verlust berechnen | S2-07, S2-13 |
| FA-16 | Mitarbeiter und Kosten eintragen | S2-06, S2-13 |
| NFA-09 | Verständliche Fehlermeldungen | S2-08 |
| NFA-15 | Daten bleiben nach Neustart erhalten | S2-03 |
| NFA-16 | Geldbeträge auf zwei Nachkommastellen genau | S2-07 |

Nicht in Sprint 2: Login (FA-01), PDF-Export (FA-08, FA-19), Fortschrittsanzeige (FA-06). Diese Punkte werden im Planning von Sprint 3 neu bewertet.

---

## 3. Wichtige Termine

| Datum | Was |
| --- | --- |
| Do 26.11. | Sprint Planning: Plan bestätigen, Aufgaben verteilen |
| Di 01.12. | **Teamfrist:** API-Schnittstelle und Model-Klassen fertig |
| Fr 04.12. | Backend-Endpunkte für Pläne und Kapitel fertig |
| Di 08.12. | Alle Seiten an das Backend angebunden, Testphase beginnt |
| Mi 09.12. | Fehler aus den Tests behoben, Stand auf `main` |
| **Do 10.12.** | **Sprint Review** · danach Retrospektive, Planning Sprint 3 |

---

## 4. Sprint Backlog

Priorität nach MoSCoW: **M** = Must, **S** = Should, **C** = Could. Aufwand = geschätzte Gesamtstunden. „Vorschlag“ ist nur ein Vorschlag – jede/r darf sich Aufgaben selbst nehmen.

### Gemeinsam

| ID | Aufgabe | Ergebnis / Akzeptanzkriterium | Prio | Aufwand | Vorschlag | Fällig |
| --- | --- | --- | --- | --- | --- | --- |
| S2-01 | API-Schnittstelle festlegen | Alle Endpunkte (Pfad, Methode, JSON-Beispiel) in `backend/README.md`; Frontend- und Backend-Team haben zugestimmt | M | 2 h | Leon + [Neu 2] | 01.12. |

### Backend

| ID | Aufgabe | Ergebnis / Akzeptanzkriterium | Prio | Aufwand | Vorschlag | Fällig |
| --- | --- | --- | --- | --- | --- | --- |
| S2-02 | Model-Klassen anlegen | `BusinessPlan`, `Chapter`, `Industry` (mind. 5 Branchen), `Employee`, `CostItem` mit JavaDoc; Geldbeträge als `BigDecimal` | M | 3 h | Leon | 01.12. |
| S2-03 | Datenspeicherung (Repository) | Pläne werden gespeichert und geladen, z. B. als JSON-Datei; nach Neustart vorhanden; Test für Speichern und Laden | M | 5 h | [Neu 1] | 04.12. |
| S2-04 | Endpunkte Businessplan anlegen und abrufen | `POST /api/plans`, `GET /api/plans`, `GET /api/plans/{id}`; neuer Plan enthält alle 5 Kapitel mit leeren Feldern; Tests | M | 4 h | Leon | 04.12. |
| S2-05 | Endpunkte Kapitel speichern und laden | Eingaben eines Kapitels werden gespeichert und geladen; zuletzt bearbeitetes Kapitel wird gemerkt; Tests | M | 4 h | [Neu 1] | 04.12. |
| S2-06 | Mitarbeiter und Kosten verwalten | Hinzufügen, Ändern, Löschen; Summen werden zurückgegeben; Tests | M | 4 h | Leon | 08.12. |
| S2-07 | Gewinn- und Verlustberechnung | `FinanceService`: 10.000 € Umsatz, 7.000 € Kosten → 3.000 € Gewinn; Verlust als negativer Wert; mind. 3 Unit-Tests | M | 3 h | [Neu 1] | 08.12. |
| S2-08 | Zentrale Fehlerbehandlung | `GlobalExceptionHandler`: 404 und 400 mit deutscher Meldung ohne technische Codes | S | 2 h | Leon oder [Neu 1] | 08.12. |

### Frontend

| ID | Aufgabe | Ergebnis / Akzeptanzkriterium | Prio | Aufwand | Vorschlag | Fällig |
| --- | --- | --- | --- | --- | --- | --- |
| S2-09 | Design aus dem Klick-Entwurf übernehmen | Farben und Bausteine in `variables.css` und `components.css`; keine festen Farbwerte außerhalb; Kontrast mind. 4,5:1 | S | 3 h | Yousef | 01.12. |
| S2-10 | `api.js` erweitern | Funktionen für alle Endpunkte aus S2-01; kein `fetch()` außerhalb von `api.js` | M | 2 h | [Neu 2] | 04.12. |
| S2-11 | Übersicht und „Plan anlegen“ anbinden | Neuer Plan mit Name und Branche erscheint in der Übersicht; Branche wird angezeigt | M | 4 h | [Neu 2] | 08.12. |
| S2-12 | Kapitel-Seite mit Navigation und Hilfetexten | 5 Kapitel mit „Weiter“/„Zurück“; Eingaben bleiben nach Neuladen erhalten; pro Kapitel ein Hilfetext und ein Beispiel | M | 6 h | Yousef | 08.12. |
| S2-13 | Finanzen-Seite | Mitarbeiter und Kosten eintragen, ändern, löschen; Summen und Gewinn/Verlust aktualisieren sich sofort | M | 5 h | [Neu 2] | 08.12. |

### Qualität und Organisation

| ID | Aufgabe | Ergebnis / Akzeptanzkriterium | Prio | Aufwand | Vorschlag | Fällig |
| --- | --- | --- | --- | --- | --- | --- |
| S2-14 | MVP testen | Testfälle aus den Akzeptanzkriterien; Durchlauf in Chrome, Firefox und Edge (NFA-06); Testprotokoll in `docs/Sprint 2/`; Fehler als Issues | M | 5 h | Maximilian | 09.12. |
| S2-15 | Dokumentation Sprint 2 | Ergebnisse, Entscheidungen und offene Punkte in `docs/Sprint 2/Dokumentation_Sprint_2.md`; in Nextcloud | M | 2 h | Nazar | 10.12. |
| S2-16 | Sprint Review, Retrospektive, Planning Sprint 3 | Protokoll mit konkreten Vereinbarungen für Sprint 3 | M | 1,5 h p. P. | alle | 10.12. |

---

## 5. Definition of Done

Eine Aufgabe ist erst **fertig**, wenn:

- [ ] das Ergebnis über einen eigenen Branch und Pull Request in `main` gelangt ist,
- [ ] mindestens eine andere Person den Pull Request geprüft hat,
- [ ] das Akzeptanzkriterium aus der Tabelle erfüllt ist,
- [ ] `mvnw test` ohne Fehler durchläuft (bei Backend-Aufgaben),
- [ ] öffentliche Klassen und Methoden JavaDoc haben (NFA-07),
- [ ] neue Endpunkte in `backend/README.md` eingetragen sind,
- [ ] mit KI erstellter Code von der Person selbst erklärt werden kann,
- [ ] die Arbeitszeit in der eigenen Zeiterfassung eingetragen ist,
- [ ] das Issue geschlossen ist (`Closes #…` im Pull Request).

---

## 6. Meetings im Sprint

| Meeting | Wann | Inhalt |
| --- | --- | --- |
| Sprint Planning | 26.11. | Ziel bestätigen, Aufwände schätzen, Aufgaben verteilen |
| Abstimmung API | bis 01.12. | Backend- und Frontend-Team legen die Endpunkte gemeinsam fest |
| Kurz-Check-in | Mo + Mi, 15 Min. (Discord oder WhatsApp) | Was habe ich gemacht? Was mache ich als Nächstes? Was blockiert mich? |
| Sprint Review | 10.12. | Lauffähige Anwendung vorführen, Feedback sammeln |
| Retrospektive | 10.12. | Was lief gut? Was war schwierig? Was machen wir in Sprint 3 anders? |

---

## 7. Teams im Sprint

| Team | Mitglieder | Schwerpunkt |
| --- | --- | --- |
| Backend | Leon, [Neu 1] | Model, Datenspeicherung, Endpunkte, Berechnungen |
| Frontend | [Neu 2], Yousef | Design, Seiten, Anbindung über `api.js` |
| Qualität und Organisation | Maximilian, Nazar | Tests, Dokumentation, Reviews, Unterstützung beider Teams |

Wer mit seinen Aufgaben fertig ist, übernimmt offene Issues aus dem anderen Team.

---

## 8. Risiken

| Risiko | Gegenmaßnahme |
| --- | --- |
| Frontend wartet auf das Backend | API-Schnittstelle zuerst festlegen (S2-01); Frontend arbeitet bis dahin mit Beispieldaten |
| Neue Teammitglieder brauchen Einarbeitung | READMEs und `package-info.java` lesen; bei Fragen im Check-in melden; Pair-Programming |
| Merge-Konflikte | Kleine Branches pro Aufgabe, häufig `main` in den eigenen Branch holen |
| Git-Probleme durch OneDrive-Sync | Repository außerhalb von OneDrive klonen (z. B. `C:\dev\StartKlar`) |
| Aufgaben zu umfangreich | Should-Aufgaben (S2-08, S2-09) bei Zeitmangel in Sprint 3 verschieben |
