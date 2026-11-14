# Problemstellung, Zielsetzung und Zielgruppe

**StartKlar – Businessplantool** · Gruppe 5 · Einführung in die Informatik I · Hochschule Mittweida · WS 2026/27
Sprint 1 · Version 0.1 · Stand: 14.11.2026 · Entwurf zur Abstimmung im Team

> Dieses Dokument ist Teil der Anforderungsanalyse (Abgabe 19.11.2026) und dient später als Grundlage für Kapitel 1 „Problembeschreibung“ im Beleg.

---

## 1. Problemstellung

Wer ein Unternehmen gründen möchte, braucht fast immer einen Businessplan – für die eigene Planung, für Gespräche mit Banken und Förderstellen oder für einen Gründungszuschuss. Viele Unterstützungsangebote stellen dafür bisher **Excel-Dateien oder ähnliche Tabellenvorlagen** bereit. In der Praxis führt das zu mehreren Problemen:

| Problem | Was das für Gründerinnen und Gründer bedeutet |
| --- | --- |
| **Unübersichtlich** | Lange Tabellen mit vielen Reitern. Es ist unklar, wo man anfangen soll und welche Felder wirklich wichtig sind. |
| **Fehleranfällig** | Formeln werden versehentlich überschrieben oder falsch erweitert. Rechenfehler im Finanzteil fallen oft erst spät auf – manchmal erst bei der Bank. |
| **Wenig Erklärung** | Fachbegriffe wie Liquidität, Break-even oder Rentabilität werden vorausgesetzt. Ohne betriebswirtschaftliche Vorkenntnisse weiß man oft nicht, was man eintragen soll. |
| **Keine Führung, kein Fortschritt** | Die Vorlage zeigt nicht, welche Schritte erledigt sind und was noch fehlt. Was bei einer Gründung in der eigenen Branche zu beachten ist (z. B. Genehmigungen), bleibt offen. |
| **Eingeschränkt gemeinsam nutzbar** | Dateien werden per E-Mail an Berater oder Mitgründer geschickt. Es entstehen mehrere Versionen, und niemand weiß, welche aktuell ist. |
| **Technische Hürden** | Man braucht eine passende Tabellenkalkulation; die Darstellung unterscheidet sich je nach Programm und Gerät. |

**Folge:** Gründungsinteressierte brechen die Planung ab oder geben einen unvollständigen bzw. fehlerhaften Plan ab.

**Kernfrage des Projekts:**
Wie kann ein digitales Werkzeug Gründerinnen und Gründer ohne Vorkenntnisse so durch die Erstellung führen, dass am Ende ein vollständiger und nachvollziehbarer Businessplan entsteht – **ohne Excel als technische Grundlage**?

---

## 2. Zielsetzung

### 2.1 Projektziel

Ziel ist die Konzeption und prototypische Entwicklung der Webanwendung **StartKlar**. Sie führt Gründerinnen und Gründer Schritt für Schritt durch die Erstellung eines Businessplans und bündelt die wichtigsten Funktionen in einer Oberfläche: Geschäftsidee ausarbeiten, Finanzen planen, Aufgaben abhaken, Fortschritt verfolgen und das Ergebnis exportieren.

### 2.2 Teilziele (woran wir den Erfolg erkennen)

1. **Geführter Ablauf:** Nutzer legen einen Businessplan an und füllen ihn kapitelweise aus (Geschäftsidee, Markt und Wettbewerb, Marketing, Team/Organisation, Finanzplan).
2. **Automatische Berechnung:** Aus eingegebenen Umsätzen und Kosten berechnet das Tool Gewinn bzw. Verlust. Nutzer müssen keine Formeln selbst bauen.
3. **Verständlichkeit:** Zu jedem Abschnitt gibt es kurze Erklärungen, Beispiele und ein Glossar für Fachbegriffe.
4. **Orientierung:** Das Tool zeigt den Bearbeitungsfortschritt und eine Checkliste mit Aufgaben für die Gründung.
5. **Weitergabe:** Der fertige Plan lässt sich speichern, später weiterbearbeiten und als PDF exportieren.
6. **Lernziel im Modul:** Das Team setzt das Projekt agil mit Scrum um (Sprints, Backlog, Dokumentation, Zeiterfassung).

### 2.3 Abgrenzung (nicht Teil des Projekts – „Won't have“)

- keine Steuer- oder Rechtsberatung
- keine Anbindung an Bankkonten, Steuersysteme oder andere externe Datenquellen (außerhalb der Systemgrenze)
- keine mobile App (nur Webanwendung im Browser)
- keine Online-Bezahlfunktion
- keine gleichzeitige Bearbeitung eines Plans durch mehrere Nutzer in Echtzeit

---

## 3. Zielgruppe

### 3.1 Primäre Zielgruppe: Gründungsinteressierte ohne Vorerfahrung

- Einzelgründerinnen und -gründer oder kleine Teams (1–3 Personen)
- Kleingründungen, z. B. Gastronomie, Handwerk, Dienstleistung, Freiberuf, Online-Handel – auch Gründungen im Nebenerwerb und Studierende mit einer Gründungsidee
- wenig oder keine Kenntnisse in Betriebswirtschaft und Finanzplanung
- durchschnittliche Computerkenntnisse; Nutzung am Laptop oder PC im Browser

**Bedürfnisse und abgeleitete Erwartungen an die Software**

| Bedürfnis der Zielgruppe | Erwartung an StartKlar | Bezug |
| --- | --- | --- |
| „Ich weiß nicht, wo ich anfangen soll.“ | Vorlage mit Gliederung und geführter Ablauf | FA-03, FA-11 |
| „Ich verstehe die Fachbegriffe nicht.“ | Hilfetexte, Beispiele, Glossar | FA-05, FA-15 |
| „Rechnet sich meine Idee?“ | automatische Berechnung von Gewinn und Verlust | FA-14 |
| „Was muss ich in meiner Branche beachten?“ | Auswahl der Branche und passende Hinweise | FA-10, FA-12 |
| „Ich habe nicht alles auf einmal Zeit.“ | Speichern und später an derselben Stelle weitermachen | FA-04 |
| „Wie weit bin ich?“ | Fortschrittsanzeige und Checkliste | FA-06 |
| „Ich muss den Plan bei Bank oder Berater abgeben.“ | Export als PDF | FA-19 |

### 3.2 Sekundäre Zielgruppe

- **Gründungsberaterinnen und -berater** (z. B. an Hochschulen, IHK, Handwerkskammer): erwarten vollständige, plausible Pläne mit einheitlicher Gliederung, damit sie schneller beraten können. Sie nutzen vor allem den exportierten Plan.
- **Lehrende**: können das Tool in Lehrveranstaltungen zum Thema Gründung einsetzen und erwarten nachvollziehbare Berechnungen.

### 3.3 Beispiel-Personas (fiktiv)

**Persona 1 – Lena, 27, Konditorin**
Möchte in ihrer Stadt ein kleines Café eröffnen. Kennt ihr Handwerk sehr gut, hat aber noch nie einen Finanzplan erstellt. Hat eine Excel-Vorlage aus dem Internet heruntergeladen und nach einer Stunde aufgegeben, weil sie nicht wusste, was „Rentabilitätsvorschau“ bedeutet.
*Ziel:* einen Plan, den sie bei der Bank vorlegen kann. *Frust:* Fachsprache, Angst vor Rechenfehlern.

**Persona 2 – Jonas, 22, Student**
Möchte neben dem Studium als Freelancer Webseiten erstellen. Plant nebenbei, meist abends in kurzen Etappen.
*Ziel:* schnell herausfinden, ob sich das lohnt und was er anmelden muss. *Frust:* Er verliert den Überblick, was er schon erledigt hat.

---

## 4. Stakeholder (Überblick)

> Kurzfassung für den Anforderungskatalog. Die ausführliche Stakeholderanalyse (Macht-Interesse-Matrix, Salience-Modell) folgt als eigenes Konzeptdokument bis 10.12.2026.

| Stakeholder | Intern/extern | Rolle | Interesse / Erwartung | Einfluss |
| --- | --- | --- | --- | --- |
| Gründerinnen und Gründer | extern | Endnutzer | einfache Bedienung, verständliche Erklärungen, aussagekräftiges Ergebnis | hoch |
| Prof. Dr.-Ing. Baumgart | extern | Auftraggeber, Bewertung | nachvollziehbarer Projektprozess, realistischer MVP, gute Dokumentation; bringt Erfahrung als Gründungsberater mit | sehr hoch |
| Entwicklungsteam Gruppe 5 | intern | Umsetzung | realisierbarer Umfang im Semester, wartbarer Code, faire Aufgabenverteilung | hoch |
| Gründungsberatung (Hochschule, IHK, HWK) | extern | Fachexperten | plausible, vollständige Pläne, einheitliche Gliederung | mittel |
| Banken, Kapitalgeber, Förderstellen | extern | Leser des Businessplans (indirekt) | vollständiger, glaubwürdiger Plan mit korrekten Zahlen | niedrig (kein direkter Kontakt) |
| Datenschutz (DSGVO) | extern | Rahmenbedingung | Datensparsamkeit, sichere Speicherung von Finanz- und Personendaten | mittel |

**Wesentliche Erwartungen an die Software (abgeleitet):**
einfache, geführte Bedienung · korrekte und nachvollziehbare Berechnungen · verständliche Sprache · sichere Speicherung · exportierbares Ergebnis · machbarer Umfang für ein Semesterprojekt.

---

## 5. Offene Fragen für das Gespräch mit dem Stakeholder (19.–26.11.)

1. Soll eine Registrierung Pflicht sein, oder reicht im MVP eine Nutzung ohne Konto? (Aktuell FA-01 = Muss.)
2. Welche Kapitel des Businessplans sind für den MVP zwingend?
3. Wie detailliert soll der Finanzplan sein – jährlich oder monatlich (Liquiditätsplan)?
4. Für welche Branchen sollen Hinweise vorhanden sein (Anzahl, Auswahl)?
5. Wie wichtig ist die Aufgaben-/Checklisten-Funktion aus der Aufgabenstellung im Vergleich zum Finanzplan?
