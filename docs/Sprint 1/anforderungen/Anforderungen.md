# Anforderungsdokument StartKlar

**Gruppe 5** · Einführung in die Informatik I · Hochschule Mittweida · WS 2026/27
Sprint 1 · Version 0.2 · Stand: 16.11.2026

| Version | Datum | Änderung |
| --- | --- | --- |
| 0.1 | 11.11.2026 | Erste Fassung (Word) mit FA-01 bis FA-21, NFA, Rahmenbedingungen, Abgrenzung |
| 0.2 | 16.11.2026 | Übertragung nach Markdown; Spalten Kategorie und Akzeptanzkriterium ergänzt; Priorisierung nach MoSCoW; Akteure ergänzt; MVP-Abgrenzung und offene Punkte ergänzt |

---

## 1. Einleitung

**Zweck:** StartKlar ist ein Businessplantool, das Gründerinnen und Gründer Schritt für Schritt durch die Erstellung eines Businessplans führt.

**Zielgruppe:** Gründerinnen und Gründer ohne Vorerfahrung in der Businessplanung. Ausführlich: [Problemstellung, Zielsetzung und Zielgruppe](../Problemstellung_und_Zielgruppe.md)

Dieses Dokument beschreibt, was das System leisten muss (funktionale Anforderungen), welche Qualitätsmerkmale es erfüllen soll (nichtfunktionale Anforderungen) und welche Vorgaben für die Umsetzung gelten (Rahmenbedingungen). Die funktionalen Anforderungen entsprechen den Use Cases im Use-Case-Diagramm.

**Priorisierung nach MoSCoW:**

| Priorität | Bedeutung |
| --- | --- |
| **Must** | zwingend für die Abgabe |
| **Should** | wichtig, wird umgesetzt, wenn die Zeit reicht |
| **Could** | optional, nice to have |
| **Won't** | in diesem Projekt nicht (siehe Abschnitt 5) |

---

## 2. Funktionale Anforderungen

Akteur aller funktionalen Anforderungen: **Gründer/in**. Die Spalte **MVP** zeigt, was in die erste MVP-Version (Sprint 1, 26.11.2026) kommt.

| ID | Anforderung | Kategorie | Priorität | Akzeptanzkriterium | MVP |
| --- | --- | --- | --- | --- | --- |
| FA-01 | Das System muss Nutzern die Registrierung und Anmeldung mit E-Mail-Adresse und Passwort ermöglichen. | Konto | Must | Ein neues Konto lässt sich mit E-Mail und Passwort anlegen. Anmeldung mit korrekten Daten gelingt, bei falschem Passwort erscheint eine Fehlermeldung. | – (klären) |
| FA-02 | Das System muss Nutzern ermöglichen, einen neuen Businessplan anzulegen. | Planerstellung | Must | Nach „Neuer Businessplan“ und Eingabe eines Namens erscheint der Plan in der Übersicht. | ✔ |
| FA-03 | Das System muss Nutzer schrittweise durch die Kapitel des Businessplans führen: Geschäftsidee, Markt- und Wettbewerbsanalyse, Marketing, Team/Organisation und Finanzplan. | Planerstellung | Must | Alle fünf Kapitel sind in fester Reihenfolge erreichbar; mit „Weiter“ und „Zurück“ wechselt man zwischen den Kapiteln. | ✔ |
| FA-04 | Das System muss die eingegebenen Daten speichern, damit Nutzer die Bearbeitung später an derselben Stelle fortsetzen können. | Datenhaltung | Must | Nach Schließen und erneutem Öffnen sind alle Eingaben vorhanden und das zuletzt bearbeitete Kapitel ist geöffnet. | ✔ |
| FA-05 | Das System soll für jeden Abschnitt Hilfetexte und Beispiele bereitstellen. | Hilfe & Erklärung | Should | Jedes Kapitel zeigt mindestens einen Hilfetext und ein Beispiel. | ✔ |
| FA-06 | Das System soll den Bearbeitungsfortschritt des Businessplans anzeigen, beispielsweise „3 von 5 Kapiteln“. | Übersicht | Should | Die Übersicht zeigt „x von 5 Kapiteln erledigt“; der Wert steigt, sobald ein Kapitel als erledigt markiert wird. | (✔) |
| FA-07 | Das System soll auf Grundlage der eingegebenen Kosten und Umsätze einfache Finanzkennzahlen berechnen. | Finanzen | Should | Bei Umsatz 10.000 € und Kosten 7.000 € zeigt das Tool Gewinn 3.000 € und Umsatzrendite 30 %. | – |
| FA-08 | Das System soll den Export des Businessplans im PDF-Format ermöglichen. | Export | Should | Die exportierte Datei lässt sich in einem gängigen PDF-Reader öffnen und enthält alle ausgefüllten Kapitel. | – |
| FA-09 | Das System kann Nutzern ermöglichen, mehrere Businesspläne zu verwalten, zu bearbeiten und zu löschen. | Verwaltung | Could | Mehrere Pläne erscheinen in der Übersicht; Löschen erfolgt erst nach Bestätigung, danach ist der Plan nicht mehr sichtbar. | – |
| FA-10 | Das System muss dem Nutzer ermöglichen, zu Beginn eine Kategorie (Branche) für sein Unternehmen auszuwählen. | Planerstellung | Must | Beim Anlegen ist eine Branche aus einer Liste (mind. 5 Branchen) wählbar; die gewählte Branche wird am Plan angezeigt. | ✔ |
| FA-11 | Das System muss eine Vorlage mit den wichtigsten Gliederungspunkten bereitstellen, damit der Nutzer schnell eine erste Version seines Businessplans erstellen kann. | Planerstellung | Must | Ein neuer Plan enthält sofort alle Gliederungspunkte mit leeren Eingabefeldern. | ✔ |
| FA-12 | Das System soll vor Beginn anzeigen, was bei einer Gründung in der gewählten Kategorie zu beachten ist (z. B. Genehmigungen, Pflichten). | Hilfe & Erklärung | Should | Nach Wahl der Branche erscheint eine Hinweisseite mit mindestens drei branchenspezifischen Punkten. | – |
| FA-13 | Das System kann vergleichbare Unternehmen aus der gewählten Kategorie anzeigen. | Hilfe & Erklärung | Could | Für die gewählte Branche werden mindestens zwei Beispielunternehmen angezeigt. | – |
| FA-14 | Das System muss aus den eingegebenen Umsätzen und Kosten mögliche Gewinne und Verluste berechnen. | Finanzen | Must | Umsatz 10.000 € und Kosten 7.000 € ergeben Gewinn 3.000 €; sind die Kosten höher als der Umsatz, wird ein Verlust (negativer Wert) angezeigt. Ergebnisse stimmen mit einer Referenzrechnung überein. | ✔ |
| FA-15 | Das System soll wichtige Fachbegriffe einfach und verständlich erklären (z. B. per Tooltip oder Glossar). | Hilfe & Erklärung | Should | Mindestens 10 Fachbegriffe sind erklärt; die Erklärung erscheint per Tooltip oder im Glossar. | – |
| FA-16 | Das System muss dem Nutzer ermöglichen, Mitarbeiter und Kosten individuell einzutragen. | Finanzen | Must | Mitarbeiter (Funktion, Gehalt) und Kostenpositionen (Bezeichnung, Betrag) lassen sich hinzufügen, ändern und löschen; die Summen aktualisieren sich sofort. | ✔ |
| FA-17 | Das System soll Einstellungen speichern und in einen neuen Businessplan importieren können. | Verwaltung | Should | Branche und Kostenpositionen eines bestehenden Plans lassen sich in einen neuen Plan übernehmen. | – |
| FA-18 | Das System kann dem Nutzer ermöglichen, einzelne Abschnitte des Businessplans auszublenden. | Verwaltung | Could | Ein ausgeblendeter Abschnitt erscheint weder in der Navigation noch im Export und lässt sich wieder einblenden. | – |
| FA-19 | Das System muss den Businessplan als Datei speichern können (z. B. PDF). | Export | Must | Der Plan lässt sich als Datei herunterladen und wieder vollständig öffnen bzw. lesen. | – (Sprint 2) |
| FA-20 | Das System soll dem Nutzer ermöglichen, eine Persona der Zielgruppe anzulegen (Name, Alter, Beruf, Bedürfnisse, Probleme). | Planerstellung | Should | Eine Persona mit allen fünf Feldern lässt sich anlegen, bearbeiten und wird im Kapitel Markt angezeigt. | – |
| FA-21 | Das System soll dem Nutzer ermöglichen, Unternehmensziele festzulegen (z. B. Umsatzziel, Zeitraum) und ihren Status (erreicht/offen) zu verwalten. | Übersicht | Should | Ein Ziel mit Beschreibung, Zielwert und Zeitraum lässt sich anlegen; der Status wechselt zwischen „offen“ und „erreicht“. | – |

---

## 3. Nichtfunktionale Anforderungen

Kategorien nach ISO/IEC 25010.

| ID | Kategorie | Anforderung | Priorität | Akzeptanzkriterium |
| --- | --- | --- | --- | --- |
| NFA-01 | Benutzbarkeit | Die Benutzeroberfläche soll neuen Nutzern ermöglichen, ohne zusätzliche Anleitung einen Businessplan anzulegen. | Should | Mindestens 4 von 5 Testpersonen legen ohne Hilfe innerhalb von 5 Minuten einen Businessplan an. |
| NFA-02 | Sprache | Die Benutzeroberfläche muss in deutscher Sprache bereitgestellt werden. | Must | Bei Durchsicht aller Seiten sind sämtliche Texte, Buttons und Meldungen auf Deutsch. |
| NFA-03 | Sicherheit | Das System muss Passwörter in gehashter Form speichern. | Must | In der Datenbank steht kein Passwort im Klartext, sondern nur ein Hashwert (z. B. bcrypt). |
| NFA-04 | Datenschutz | Das System muss personenbezogene Daten gemäß den Anforderungen der DSGVO verarbeiten. | Must | Es werden nur notwendige Daten erhoben; ein Datenschutzhinweis ist vorhanden; ein Konto lässt sich samt Daten löschen. |
| NFA-05 | Leistung | Die Ladezeit der Seiten soll weniger als 2 Sekunden betragen. | Should | In der Testumgebung (lokal, Plan mit 50 Kostenpositionen) laden 95 % der Seitenaufrufe in unter 2 Sekunden. |
| NFA-06 | Kompatibilität | Das System muss mit den aktuellen Versionen von Chrome, Firefox und Edge kompatibel sein. | Must | Der Hauptablauf (Plan anlegen, ausfüllen, speichern) funktioniert in allen drei Browsern ohne Darstellungsfehler. |
| NFA-07 | Wartbarkeit | Der Quellcode soll mit JavaDoc dokumentiert und im GitHub-Repository verwaltet werden. | Should | Alle öffentlichen Klassen und Methoden haben JavaDoc; Änderungen gelangen nur per Pull Request in `main`. |

---

## 4. Rahmenbedingungen

| ID | Aspekt | Festlegung |
| --- | --- | --- |
| R-01 | Programmiersprache | Für das Backend ist Java und für das Frontend HTML vorgesehen. Die endgültige Entscheidung fällt in Sprint 1 (Issue #7). |
| R-02 | Plattform | Umsetzung als Webanwendung, die im Browser läuft. |
| R-03 | Entwicklungsumgebung | Die Wahl der Entwicklungsumgebung ist den einzelnen Teammitgliedern freigestellt. |
| R-04 | Versionsverwaltung | Die Versionsverwaltung erfolgt mit Git und GitHub im Repository Nzchupa/StartKlar. |
| R-05 | Team und Zeit | Das Projekt wird von Gruppe 5 mit vier Mitgliedern im Wintersemester 2026/27 bearbeitet (Abschluss 28.01.2027). |

---

## 5. Abgrenzung (Won't have)

Folgende Punkte sind nicht Bestandteil des Projekts:

- keine mobile App (nur Webanwendung)
- keine Online-Bezahlfunktion
- keine gleichzeitige Bearbeitung eines Plans durch mehrere Nutzer in Echtzeit
- keine Steuer- oder Rechtsberatung
- keine Anbindung an Bankkonten, Steuersysteme oder andere externe Datenquellen

---

## 6. MVP-Abgrenzung (Sprint 1)

Die erste MVP-Version (Vorstellung am 26.11.2026) umfasst **FA-02, FA-03, FA-04, FA-05, FA-10, FA-11, FA-14, FA-16** und, wenn die Zeit reicht, **FA-06**.

Ablauf im MVP: Plan anlegen → Branche wählen → Kapitel mit Hilfetexten ausfüllen → Kosten, Mitarbeiter und Umsätze eintragen → Gewinn/Verlust sehen → speichern und später weitermachen.

Details und Aufgaben: [Sprintplan Sprint 1](../Sprintplan_Sprint_1.md)

---

## 7. Offene Punkte (Abstimmung mit dem Stakeholder)

1. **FA-07 und FA-14 überschneiden sich** (Finanzberechnung). Vorschlag: FA-14 = Gewinn/Verlust (Must), FA-07 = weitere Kennzahlen wie Umsatzrendite oder Break-even (Should).
2. **FA-08 und FA-19 überschneiden sich** (PDF-Export) und haben unterschiedliche Prioritäten (Should vs. Must). Vorschlag: zu einer Anforderung zusammenführen.
3. **FA-01 Registrierung:** Ist ein Konto Pflicht, oder reicht im MVP die Nutzung ohne Anmeldung? Davon hängen auch NFA-03 und NFA-04 ab.
4. Welche und wie viele Branchen soll es für FA-10 und FA-12 geben?
5. Wie detailliert soll der Finanzplan sein – jährlich oder monatlich?

---

*Quelle: gemeinsame Sammlung im Team (`Anforderungen.docx`, `Funktionale Anforderungen.docx`), Stand 14.11.2026.*
