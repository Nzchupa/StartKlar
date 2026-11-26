# Sprintplan – Sprint 2

**StartKlar – Businessplantool** · Gruppe 5 · Stand: 26.11.2026 · im Sprint Planning am 26.11. bestätigt

| | |
| --- | --- |
| **Zeitraum** | Fr 27.11.2026 – Do 10.12.2026 (2 Wochen) |
| **Sprint Planning** | Do 26.11.2026 nach der MVP-Vorstellung |
| **Sprint Review & Retrospektive** | Do 10.12.2026 nach dem Gruppencoaching |
| **Board** | GitHub Issues, Milestone „Sprint 2“ |

---

## 1. Sprint-Ziel

> **Am 10.12. läuft der MVP vollständig im Browser: Ein Nutzer legt einen Businessplan mit Branche an, füllt die fünf Kapitel mit Hilfetexten aus, trägt Mitarbeiter und Kosten ein und sieht Gewinn bzw. Verlust. Alle Seiten sind an das Backend angebunden, die Daten bleiben nach einem Neustart erhalten. Außerdem stellen wir am 10.12. die Stakeholderanalyse vor.**

Die drei Fragen des Sprint Plannings:

- **Warum ist der Sprint wichtig?** Das MVP-Backend (REST-API, Datenbank, Berechnungen) ist seit Ende Sprint 1 fertig (PR #58). Das Frontend ist aber noch ein statischer Klick-Entwurf. Erst wenn beide verbunden sind, haben wir eine echte Anwendung, auf der alle weiteren Sprints aufbauen.
- **Was müssen wir tun?** Seitenstruktur festlegen, `api.js` ausbauen, Frontend-Seiten an das Backend anbinden, Design vereinheitlichen, testen und die Stakeholderanalyse erarbeiten.
- **Wie erledigen wir es?** Der Schwerpunkt liegt auf dem Frontend. Das Backend-Team unterstützt bei der Anbindung und sichert das Backend mit Tests ab. Jede Aufgabe ist ein Issue, pro Aufgabe ein eigener Branch, jeder Pull Request wird von einer anderen Person geprüft.

---

## 2. Ausgangslage (Ende Sprint 1)

Bereits auf `main` vorhanden (PR #58, #59):

| Bereich | Stand |
| --- | --- |
| Model-Klassen | `BusinessPlan`, `Chapter`, `Industry` (5 Branchen), `Employee`, `CostItem` mit JavaDoc, Geldbeträge als `BigDecimal` |
| Datenspeicherung | H2-Datenbank (Datei unter `~/.startklar/`), Spring Data JPA |
| Endpunkte | Pläne, Kapitel, zuletzt bearbeitetes Kapitel, Mitarbeiter, Kosten, Umsatz, Finanzübersicht – dokumentiert in `backend/MVP-API.md` |
| Berechnung | `FinanceService` (Gewinn/Verlust, zwei Nachkommastellen) |
| Fehlerbehandlung | `GlobalExceptionHandler`, 400/404 mit deutscher Meldung |
| Frontend | Klick-Prototyp (statische Seiten), Design-System-CSS, `api.js` mit Grundfunktion `request()`, Login/Registrierung als Prototyp |

---

## 3. MVP-Anforderungen in diesem Sprint

| ID | Anforderung | Backend | Frontend |
| --- | --- | --- | --- |
| FA-02 | Businessplan anlegen | ✅ erledigt | S2-04 |
| FA-03 | Schrittweise durch die fünf Kapitel führen | ✅ erledigt | S2-05 |
| FA-04 | Daten speichern und später fortsetzen | ✅ erledigt | S2-05 |
| FA-05 | Hilfetexte und Beispiele pro Kapitel | ✅ erledigt | S2-05 |
| FA-10 | Branche auswählen | ✅ erledigt | S2-04 |
| FA-11 | Vorlage mit allen Gliederungspunkten | ✅ erledigt | S2-05 |
| FA-14 | Gewinn und Verlust berechnen | ✅ erledigt | S2-06 |
| FA-16 | Mitarbeiter und Kosten eintragen | ✅ erledigt | S2-06 |
| NFA-09 | Verständliche Fehlermeldungen | ✅ erledigt | S2-03 (Anzeige im Frontend) |
| NFA-15 | Daten bleiben nach Neustart erhalten | ✅ umgesetzt, Test fehlt → S2-08 | – |
| NFA-16 | Geldbeträge auf zwei Nachkommastellen genau | ✅ erledigt | S2-06 (Anzeige) |

Nicht in Sprint 2: Login (FA-01), PDF-Export (FA-08, FA-19), Fortschrittsanzeige (FA-06). Der vorhandene Login-Prototyp bleibt unverändert und wird nicht angebunden. Diese Punkte werden im Planning von Sprint 3 neu bewertet.

---

## 4. Wichtige Termine

| Datum | Was |
| --- | --- |
| Do 26.11. | Sprint Planning: Plan bestätigen, Aufgaben verteilen |
| Di 01.12. | **Teamfrist:** Seitenstruktur festgelegt, `api.js` mit allen Funktionen fertig |
| Fr 04.12. | Übersicht und „Plan anlegen“ angebunden, Kapitel-Seite im Grundgerüst |
| Di 08.12. | Alle Seiten an das Backend angebunden, Testphase beginnt |
| Mi 09.12. | Fehler aus den Tests behoben, Stand auf `main`; Präsentation Stakeholderanalyse in Nextcloud |
| **Do 10.12.** | **Stakeholderanalyse · Sprint Review** · danach Retrospektive, Planning Sprint 3 |
| Do 17.12. | Ausblick: Zwischenpräsentation (Sprint 3) |

---

## 5. Sprint Backlog

Priorität nach MoSCoW: **M** = Must, **S** = Should, **C** = Could. Aufwand = geschätzte Gesamtstunden. „Vorschlag“ ist nur ein Vorschlag – jede/r darf sich Aufgaben selbst nehmen.

### Gemeinsam

| ID | Aufgabe | Ergebnis / Akzeptanzkriterium | Prio | Aufwand | Vorschlag | Fällig |
| --- | --- | --- | --- | --- | --- | --- |
| S2-01 | Seitenstruktur und API abstimmen | Festgelegt, welche Seiten bleiben: Übersicht, Kapitel-Seite, Finanzen. `unternehmensdaten.html`, `kosten-umsatz.html` und `businessplan.html` werden ersetzt oder entfernt. `backend/MVP-API.md` von beiden Teams gelesen und bestätigt; Link im `backend/README.md` | M | 2 h | Leon + Ali | 01.12. |

### Frontend

| ID | Aufgabe | Ergebnis / Akzeptanzkriterium | Prio | Aufwand | Vorschlag | Fällig |
| --- | --- | --- | --- | --- | --- | --- |
| S2-02 | `api.js` erweitern | Eine Funktion pro Endpunkt aus `MVP-API.md`; kein `fetch()` außerhalb von `api.js` | M | 3 h | Mohamad | 01.12. |
| S2-03 | Fehleranzeige im Frontend | Meldungen aus `{"message": ...}` werden verständlich angezeigt; `response.ok` wird überall geprüft | S | 2 h | Mohamad | 08.12. |
| S2-04 | Übersicht und „Plan anlegen“ | Neuer Plan mit Name und Branche (Auswahl aus `/api/industries`) erscheint in der Übersicht; Klick öffnet den Plan beim zuletzt bearbeiteten Kapitel | M | 4 h | Ali | 04.12. |
|
