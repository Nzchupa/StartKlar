# Dokumentation Sprint 2

**Projekt:** StartKlar – Businessplantool  
**Gruppe:** 5  
**Zeitraum:** 27.11.2026 – 10.12.2026  
**Stand:** 20.11.2026  
**Status:** Entwurf – wird im Sprint Planning am 26.11.2026 bestätigt

## 1. Sprint-Ziel

Das Ziel von Sprint 2 ist es, den MVP von StartKlar als echte Anwendung lauffähig zu machen.

Ein Nutzer soll einen Businessplan mit einer Branche anlegen können. Anschließend soll er schrittweise durch die fünf Kapitel geführt werden und diese mithilfe von Hilfetexten und Beispielen ausfüllen können.

Außerdem sollen Mitarbeiter und Kosten eingetragen werden können. Die Anwendung soll Gewinn beziehungsweise Verlust berechnen und anzeigen. Die eingegebenen Daten sollen gespeichert werden und nach einem Neustart weiterhin verfügbar sein.

Sprint 1 diente der Erarbeitung der Anforderungen, des MVP-Umfangs, des Projektgerüsts und des Klick-Entwurfs. In Sprint 2 soll daraus eine funktionsfähige Anwendung entstehen.

## 2. Umfang des Sprints

Im Sprint 2 werden folgende Anforderungen umgesetzt:

| Anforderung | Beschreibung |
|---|---|
| FA-02 | Businessplan anlegen |
| FA-03 | Schrittweise durch die fünf Kapitel führen |
| FA-04 | Daten speichern und später fortsetzen |
| FA-05 | Hilfetexte und Beispiele pro Kapitel |
| FA-10 | Branche auswählen |
| FA-11 | Vorlage mit allen Gliederungspunkten |
| FA-14 | Gewinn und Verlust berechnen |
| FA-16 | Mitarbeiter und Kosten eintragen |
| NFA-09 | Verständliche Fehlermeldungen |
| NFA-15 | Daten bleiben nach Neustart erhalten |
| NFA-16 | Geldbeträge auf zwei Nachkommastellen genau |

Nicht Bestandteil von Sprint 2 sind Login (FA-01), PDF-Export (FA-08 und FA-19) sowie die Fortschrittsanzeige (FA-06). Diese Anforderungen werden im Sprint Planning von Sprint 3 neu bewertet.

## 3. Wichtige Termine

| Datum | Termin / Ergebnis |
|---|---|
| 26.11.2026 | Sprint Planning: Sprint-Ziel bestätigen, Aufgaben verteilen und Aufwände abstimmen |
| 01.12.2026 | API-Schnittstelle und Model-Klassen fertig |
| 04.12.2026 | Endpunkte für Businesspläne und Kapitel fertig |
| 08.12.2026 | Alle Seiten an das Backend angebunden; Testphase beginnt |
| 09.12.2026 | Fehler aus den Tests behoben; Stand auf main |
| 10.12.2026 | Sprint Review, Retrospektive und Planning Sprint 3 |

## 4. Aufgaben im Bereich UX/Usability

Im Bereich UX/Usability sind für Sprint 2 insbesondere folgende Aufgaben vorgesehen:

### 4.1 Design aus dem Klick-Entwurf übernehmen (S2-09)

Die Farben und Bausteine des Klick-Entwurfs sollen in den CSS-Dateien `variables.css` und `components.css` übernommen werden.

Dabei sollen feste Farbwerte außerhalb der vorgesehenen Variablen vermieden werden. Der Kontrast soll mindestens 4,5:1 betragen.

**Geplantes Ergebnis:** Ein einheitliches Design, das auf den vorhandenen Klick-Entwurf aufbaut.

### 4.2 Kapitel-Seite mit Navigation und Hilfetexten (S2-12)

Die Kapitel-Seite soll den Nutzer durch die fünf Kapitel des Businessplans führen.

Vorgesehen sind:
- Navigation zwischen den fünf Kapiteln
- „Weiter“- und „Zurück“-Funktion
- Hilfetext und Beispiel für jedes Kapitel
- Erhalt der Eingaben nach dem Neuladen der Seite

**Geplantes Ergebnis:** Eine verständliche und schrittweise Bedienung der Kapitel.

## 5. Geplante Umsetzung und Zusammenarbeit

Das Backend- und Frontend-Team arbeiten parallel.

Das Backend-Team übernimmt unter anderem Model-Klassen, Datenspeicherung, Endpunkte und Berechnungen.

Das Frontend-Team übernimmt die Gestaltung und Umsetzung der Seiten sowie deren Anbindung an das Backend über `api.js`.

Die API-Schnittstelle soll zuerst gemeinsam festgelegt werden. Bis die Backend-Endpunkte verfügbar sind, kann das Frontend-Team mit Beispieldaten arbeiten.

Jede Aufgabe wird über ein eigenes GitHub Issue bearbeitet. Für die Umsetzung wird ein eigener Branch erstellt. Änderungen werden über einen Pull Request eingebracht und von mindestens einer anderen Person geprüft.

## 6. Qualitätssicherung und Definition of Done

Eine Aufgabe gilt erst als abgeschlossen, wenn:

- das Ergebnis über einen eigenen Branch und Pull Request in `main` übernommen wurde,
- mindestens eine andere Person den Pull Request geprüft hat,
- das Akzeptanzkriterium der Aufgabe erfüllt ist,
- bei Backend-Aufgaben `mvnw test` ohne Fehler durchläuft,
- öffentliche Klassen und Methoden JavaDoc besitzen,
- neue Endpunkte in `backend/README.md` dokumentiert sind,
- selbst erstellter oder KI-unterstützter Code erklärt werden kann,
- die Arbeitszeit in der eigenen Zeiterfassung eingetragen wurde,
- das zugehörige Issue geschlossen wurde.

## 7. Dokumentationsstatus

Diese Dokumentation beschreibt den geplanten Ablauf und die Ziele von Sprint 2.

Die tatsächlichen Ergebnisse, getroffenen Entscheidungen, Testergebnisse und offenen Punkte werden während des Sprints ergänzt.

Nach Abschluss des Sprints wird die Dokumentation überprüft und mit dem Team abgestimmt.

## 8. Offene Punkte

Die folgenden Punkte werden im Sprint Planning am 26.11.2026 bestätigt:

- endgültige Aufgabenverteilung
- geschätzte Aufwände
- Abstimmung der API-Schnittstelle zwischen Frontend und Backend
- Bestätigung des Sprint-Ziels und des Sprint-Umfangs

## 9. Sprint Review und Retrospektive

Am 10.12.2026 soll der umgesetzte MVP im Sprint Review vorgestellt werden. Dabei werden die erreichten Ergebnisse demonstriert und Feedback gesammelt.

Anschließend findet die Retrospektive statt. Das Team bespricht, was gut funktioniert hat, welche Schwierigkeiten aufgetreten sind und welche Verbesserungen für Sprint 3 vereinbart werden.

Die konkreten Ergebnisse und Vereinbarungen werden nach dem Meeting in diesem Abschnitt ergänzt.