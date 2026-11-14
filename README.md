# StartKlar – Businessplantool

Semesterprojekt der **Gruppe 5** im Modul *Einführung in die Informatik I*
Hochschule Mittweida · Wintersemester 2026/27 · betreut von Prof. Dr.-Ing. Matthias Baumgart

**StartKlar** ist eine Webanwendung, die Gründerinnen und Gründer ohne Vorkenntnisse Schritt für Schritt durch die Erstellung eines Businessplans führt – ohne Excel-Tabellen.

---

## 📌 Aufgabenstellung

**Problemstellung:**
Wer ein Unternehmen gründen möchte, braucht einen Businessplan. Viele Unterstützungsangebote für Existenzgründungen stellen dafür bisher Excel-Dateien oder ähnliche Tabellenvorlagen bereit. Diese Vorlagen sind oft unübersichtlich und fehleranfällig: Formeln werden versehentlich überschrieben, Fachbegriffe werden nicht erklärt, und niemand zeigt, welche Schritte erledigt sind und was noch fehlt. Außerdem lassen sie sich nur eingeschränkt gemeinsam nutzen, etwa mit Beratern oder Mitgründern. Für Gründerinnen und Gründer ohne betriebswirtschaftliche oder technische Vorkenntnisse sind solche Lösungen daher nur bedingt geeignet. Viele brechen die Planung ab oder geben unvollständige Pläne ab. Es fehlt ein eigenständiges, benutzerfreundliches Werkzeug, das strukturiert durch die wesentlichen Schritte einer Gründung führt.

**Zielstellung:**
Ziel des Projekts ist die Konzeption und Entwicklung der Webanwendung **StartKlar**, die Gründerinnen und Gründer Schritt für Schritt durch die Erstellung ihres Businessplans führt – ohne Excel als technische Grundlage. Das Tool soll intuitiv bedienbar sein und die zentralen Funktionen in einer Oberfläche bündeln: Geschäftsidee und Geschäftsmodell ausarbeiten, Kosten und Umsätze erfassen und daraus Gewinn bzw. Verlust automatisch berechnen, Fachbegriffe verständlich erklären, Aufgaben für die Gründung abhaken, den Fortschritt anzeigen und den fertigen Plan speichern und exportieren. Im Semester entsteht ein lauffähiger Prototyp, der agil in Sprints weiterentwickelt wird.

**Zielgruppe:**
Die Anwendung richtet sich in erster Linie an Gründungsinteressierte ohne Vorerfahrung in der Businessplanung – zum Beispiel Einzelgründerinnen und -gründer oder kleine Teams in Gastronomie, Handwerk, Dienstleistung, Freiberuf oder Online-Handel, auch im Nebenerwerb oder als Studierende mit einer Gründungsidee. Sie haben wenig betriebswirtschaftliches Wissen, nutzen das Tool im Browser am Laptop oder PC und brauchen vor allem Orientierung, einfache Erklärungen und verlässliche Berechnungen. Sekundär richtet sich StartKlar an Gründungsberaterinnen und -berater sowie Lehrende, die vollständige und nachvollziehbare Businesspläne erhalten bzw. das Tool in der Lehre einsetzen möchten.

➡️ Ausführlich mit Bedürfnissen, Personas und Stakeholdern: [Problemstellung, Zielsetzung und Zielgruppe](docs/Sprint%201/Problemstellung_und_Zielgruppe.md)

### Geplante Kernfunktionen

- Businessplan anlegen und Branche auswählen
- Geführte Kapitel: Geschäftsidee · Markt & Wettbewerb · Marketing · Team · Finanzplan
- Hilfetexte, Beispiele und Glossar
- Automatische Berechnung von Gewinn und Verlust
- Fortschrittsanzeige und Gründungs-Checkliste
- Speichern, später weitermachen, Export als PDF

Alle Anforderungen mit Priorität: [Anforderungsdokument](docs/Sprint%201/anforderungen/Anforderungen.docx)

---

## 📅 Projektstand

| Sprint | Zeitraum | Ziel | Status |
| --- | --- | --- | --- |
| Sprint 0 | bis 05.11.2026 | Team, Rollen, Projektidee vorstellen | ✅ erledigt |
| **Sprint 1** | 13.11. – 26.11.2026 | Anforderungsanalyse (19.11.) und **erste lauffähige MVP-Version** (26.11.) | 🔄 läuft – [Sprintplan](docs/Sprint%201/Sprintplan_Sprint_1.md) |
| Sprint 2 | ab 27.11.2026 | wird am 26.11. geplant | ⏳ |

**Wichtige Termine:** 19.11. Anforderungsanalyse · 26.11. MVP · 10.12. Stakeholderanalyse · 17.12. Zwischenpräsentation · 28.01. Abschlusspräsentation · 31.01.2027 Beleg

---

## 👥 Team

| Name | GitHub | Rolle |
| --- | --- | --- |
| Nazar Chuprii | [@Nzchupa](https://github.com/Nzchupa) | Backend, Repository, Sprintplanung |
| Maximilian Mikusch | [@Maxi20081001](https://github.com/Maxi20081001) | Tester, Entwickler |
| Youssef Al Khallaf | _@nutzername_ | UX / Usability |
| Leon Rapp | [@lrapp06](https://github.com/lrapp06) | Hauptentwickler |

Aufgaben werden unabhängig von der Rolle frei gewählt.

---

## 📚 Wichtige Links

| Was | Link |
| --- | --- |
| Aufgaben (Issues) | [Issues](https://github.com/Nzchupa/StartKlar/issues) |
| GitHub-Anleitung für das Team | [GitHub-Anleitung StartKlar (PDF)](GitHub-Anleitung%20StartKlar.pdf) |
| Vorlesungsmaterialien (Folien, Übungen) | [MiCloud](https://micloud.hs-mittweida.de/index.php/s/9JPoaqfyKaTxk8F) |
| Unser Abgabeordner (Protokolle, Präsentationen, Beleg) | [MiCloud](https://micloud.hs-mittweida.de/index.php/s/G27cQJE8gwN3ztx) |

---

## 🛠️ Technik

- **Sprache:** Java (Backend), HTML (Frontend) – endgültige Entscheidung in Sprint 1 (Issue #7)
- **IDE:** freie Wahl; die Anleitung beschreibt Eclipse IDE for Java Developers
- **Versionsverwaltung:** Git + GitHub
- **Kommunikation:** WhatsApp (Absprachen), Discord (Online-Meetings), GitHub (Code, Aufgaben, Dokumente)

---

## 🚀 Erste Schritte

1. Einladung als Collaborator annehmen (kommt per E-Mail von @Nzchupa).
2. Repository klonen:

   ```bash
   git clone https://github.com/Nzchupa/StartKlar.git
   cd StartKlar
   ```

3. In Eclipse öffnen: **File → Import… → Git → Projects from Git (with smart import) → Existing local repository** → Ordner `StartKlar` wählen → **Finish**.

Ausführlich mit Screenshots: [GitHub-Anleitung StartKlar (PDF)](GitHub-Anleitung%20StartKlar.pdf)

---

## 🔁 Arbeitsweise

1. Vor dem Arbeiten: `git checkout main` und `git pull`
2. Eigenen Branch pro Issue anlegen: `git checkout -b 3-use-case-diagramm` (Issue-Nummer + kurzer Name)
3. Änderungen committen: `git add .` und `git commit -m "Kurze Beschreibung"`
4. Hochladen: `git push -u origin 3-use-case-diagramm`
5. Auf GitHub einen **Pull Request** öffnen, `Closes #3` in die Beschreibung schreiben, Reviewer eintragen
6. Nach dem Review in `main` mergen

**Regeln:**
- Nie direkt auf `main` committen.
- Jede Aufgabe ist ein Issue mit Milestone des aktuellen Sprints.
- Arbeitszeit immer in der eigenen Zeiterfassung eintragen (mind. 80 h pro Person im Semester).
- Abgabedokumente zusätzlich in den MiCloud-Abgabeordner hochladen.

---

## 📁 Projektstruktur

```
StartKlar/
├── README.md
├── GitHub-Anleitung StartKlar.pdf
└── docs/
    ├── Presentation/          Präsentationen (Sprint 0)
    └── Sprint 1/
        ├── Problemstellung_und_Zielgruppe.md
        ├── Sprintplan_Sprint_1.md
        ├── anforderungen/     Anforderungsdokument
        └── User-Case/         Use-Case-Diagramm
```

Der Quellcode kommt in einen eigenen Ordner, sobald das Java-Projekt angelegt ist (Sprint 1, MVP-01).
