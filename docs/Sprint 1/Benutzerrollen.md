# Benutzerrollen und Berechtigungen

**StartKlar – Businessplantool** · Gruppe 5 · Stand: 23.11.2026 · Version 0.1 · Entwurf, wird im Team abgestimmt

Dieses Dokument legt fest, welche Rollen es in StartKlar gibt und was jede Rolle darf. Es ist die Grundlage für Login, Admin-Bereich, Gast-Ansicht, die Use Cases pro Rolle und die Rechteprüfung im Backend.

---

## 1. Überblick

| Rolle | Wer ist das? | Konto nötig |
| --- | --- | --- |
| **Gast** | Besucher, der StartKlar kennenlernen will und noch kein Konto hat | nein |
| **Nutzer** (Gründer/in) | Registrierte Person, die einen oder mehrere Businesspläne erstellt | ja |
| **Admin** | Betreiber von StartKlar (Mitglied des Projektteams), pflegt die Anwendung | ja |

Jedes Konto hat genau **eine** Rolle. Ein Admin ist kein „Super-Nutzer“: Er verwaltet die Anwendung, aber er arbeitet nicht in fremden Businessplänen.

---

## 2. Die Rollen im Detail

### 2.1 Gast

- Sieht die Startseite mit einer Erklärung von StartKlar, den Ablauf (Kapitel, Finanzplan) und Beispiele.
- Kann die Hilfetexte, das Glossar sowie Impressum, Datenschutzerklärung und Nutzungsbedingungen lesen.
- Kann sich registrieren und anmelden.
- Kann **keine** Businesspläne anlegen oder speichern.

### 2.2 Nutzer (Gründer/in)

- Hat alle Rechte des Gastes.
- Legt Businesspläne an, bearbeitet sie und löscht sie (FA-02, FA-03, FA-09).
- Füllt die Kapitel aus, trägt Mitarbeiter und Kosten ein und sieht Gewinn bzw. Verlust (FA-14, FA-16).
- Exportiert eigene Pläne als Datei (FA-08, FA-19).
- Sieht und bearbeitet **nur die eigenen** Businesspläne (NFA-14).
- Verwaltet das eigene Konto: Passwort ändern, Konto mit allen Daten löschen (NFA-04).

### 2.3 Admin

- Sieht eine Liste aller Konten (E-Mail, Rolle, Registrierungsdatum, Status).
- Kann Konten sperren, entsperren und löschen, z. B. bei Missbrauch oder auf Wunsch des Nutzers.
- Pflegt die Inhalte der Anwendung: Branchenliste, Hilfetexte, Beispiele, Glossar.
- Sieht nur Kennzahlen zu Businessplänen (z. B. Anzahl pro Nutzer), **nicht deren Inhalt**.
- Hat selbst keine eigenen Businesspläne. Wer testen will, nutzt ein zweites Konto mit der Rolle Nutzer.

---

## 3. Rechtematrix

✔ = erlaubt · ✘ = nicht erlaubt · (eigene) = nur für eigene Daten

| Aktion | Gast | Nutzer | Admin | Bezug |
| --- | :---: | :---: | :---: | --- |
| Startseite, Hilfetexte, Glossar ansehen | ✔ | ✔ | ✔ | FA-05, FA-15 |
| Impressum, Datenschutz, Nutzungsbedingungen ansehen | ✔ | ✔ | ✔ | NFA-04 |
| Registrieren | ✔ | – | – | FA-01 |
| Anmelden / Abmelden | ✔ | ✔ | ✔ | FA-01 |
| Businessplan anlegen | ✘ | ✔ | ✘ | FA-02 |
| Businessplan ansehen und bearbeiten | ✘ | ✔ (eigene) | ✘ | FA-03, NFA-14 |
| Businessplan löschen | ✘ | ✔ (eigene) | ✘ | FA-09 |
| Mitarbeiter und Kosten eintragen | ✘ | ✔ (eigene) | ✘ | FA-16 |
| Gewinn / Verlust ansehen | ✘ | ✔ (eigene) | ✘ | FA-14 |
| Businessplan exportieren | ✘ | ✔ (eigene) | ✘ | FA-08, FA-19 |
| Passwort ändern | ✘ | ✔ (eigenes) | ✔ (eigenes) | NFA-03 |
| Eigenes Konto mit allen Daten löschen | ✘ | ✔ | ✘ | NFA-04 |
| Liste aller Konten ansehen | ✘ | ✘ | ✔ | neu |
| Konto sperren / entsperren / löschen | ✘ | ✘ | ✔ | neu |
| Branchen, Hilfetexte, Glossar pflegen | ✘ | ✘ | ✔ | neu |
| Inhalt fremder Businesspläne ansehen | ✘ | ✘ | ✘ | NFA-14, DSGVO |

---

## 4. Entscheidungen und Begründungen

| Frage | Entscheidung (Vorschlag) | Begründung |
| --- | --- | --- |
| Darf der Admin Businesspläne lesen? | **Nein**, nur Kennzahlen | Businesspläne enthalten Geschäftsideen und Finanzdaten. Datensparsamkeit nach DSGVO; NFA-14 gilt auch für den Admin. |
| Darf ein Gast einen Plan ausprobieren? | **Nein**, ein Gast sieht nur Beispiele | Ein Plan ohne Konto müsste trotzdem gespeichert werden. Das macht Datenhaltung und Löschung unnötig kompliziert. Kann in einem späteren Sprint als „Demo-Modus“ ergänzt werden. |
| Wie entsteht der erste Admin? | Wird beim ersten Start fest angelegt (Zugangsdaten nicht im Repository) | Kein Registrierungsweg zum Admin, damit sich niemand selbst Admin-Rechte geben kann. |
| Kann ein Konto mehrere Rollen haben? | **Nein**, genau eine Rolle | Einfacher zu prüfen und zu testen. |
| Was passiert beim Löschen eines Kontos? | Konto und alle zugehörigen Businesspläne werden endgültig gelöscht | Recht auf Löschung (Art. 17 DSGVO), NFA-04. |

Offene Punkte für das Gespräch mit dem Stakeholder:
- Reicht es, wenn der Admin Konten sperren kann, oder braucht er weitere Funktionen?
- Soll ein Gast später einen Demo-Plan ohne Speichern ausprobieren können?

---

## 5. Auswirkungen auf die Anforderungen

Vorschlag für neue funktionale Anforderungen (Ergänzung im Anforderungsdokument):

| ID | Anforderung | Priorität | Akzeptanzkriterium |
| --- | --- | --- | --- |
| FA-22 | Das System muss Gästen ohne Konto eine Startseite mit Erklärung und Beispielen anzeigen. | Must | Ohne Anmeldung sind Startseite, Hilfetexte und Rechtstexte erreichbar; Seiten mit Businessplänen leiten zur Anmeldung weiter. |
| FA-23 | Das System muss Administratoren eine Übersicht aller Konten anzeigen. | Should | Ein angemeldeter Admin sieht alle Konten mit E-Mail, Rolle und Status; ein Nutzer erreicht diese Seite nicht. |
| FA-24 | Das System soll Administratoren ermöglichen, Konten zu sperren, zu entsperren und zu löschen. | Should | Ein gesperrtes Konto kann sich nicht anmelden; Löschen erfolgt erst nach Bestätigung. |
| FA-25 | Das System soll Administratoren ermöglichen, Branchen und Hilfetexte zu pflegen. | Could | Eine neue Branche erscheint nach dem Speichern in der Auswahl beim Anlegen eines Plans. |
| FA-26 | Das System muss Nutzern ermöglichen, ihr Konto mit allen Daten zu löschen. | Must | Nach Bestätigung sind Konto und alle Businesspläne entfernt; eine Anmeldung ist nicht mehr möglich. |

Im **Use-Case-Diagramm** kommen die Akteure **Gast** und **Admin** dazu. Der bisherige Akteur „Gründer/in“ entspricht der Rolle **Nutzer**.

---

## 6. Hinweise zur Umsetzung

- Rollen im Backend als Enum: `Role { GUEST, USER, ADMIN }`. Ein Gast hat kein Konto; die Rolle GUEST steht für „nicht angemeldet“.
- Jeder Businessplan gehört genau einem Nutzer (`@ManyToOne`). Bei jedem Zugriff prüft der Service, ob der angemeldete Nutzer der Eigentümer ist (NFA-14).
- Passwörter werden nur gehasht gespeichert, z. B. mit BCrypt (NFA-03).
- Endpunkte des Admin-Bereichs beginnen mit `/api/admin/...`, damit die Rechteprüfung an einer Stelle erfolgen kann.
- Testfälle: mit zwei Nutzerkonten prüfen, dass Nutzer A die Pläne von Nutzer B weder sehen noch ändern kann; mit einem Nutzerkonto prüfen, dass `/api/admin/...` gesperrt ist.

---

## 7. Änderungshistorie

| Version | Datum | Änderung |
| --- | --- | --- |
| 0.1 | 23.11.2026 | Erster Entwurf: Rollen, Rechtematrix, Entscheidungen, neue Anforderungen |
