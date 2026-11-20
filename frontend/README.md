# StartKlar – Frontend

Die Oberfläche von StartKlar: reines HTML, CSS und JavaScript, ohne Framework.
Das Backend liefert diesen Ordner direkt aus, deshalb ist die Seite unter
**http://localhost:8080** erreichbar, sobald das Backend läuft.

## Starten

1. Backend starten (siehe [backend/README.md](../backend/README.md)).
2. Im Browser **http://localhost:8080** öffnen.
3. Dateien in diesem Ordner ändern, speichern, im Browser **Strg + F5** drücken.
   Das Backend muss dafür **nicht** neu gestartet werden.

> Die Seiten bitte nicht per Doppelklick als Datei öffnen (`file://...`).
> Dann funktionieren die Pfade und die Verbindung zum Backend nicht.

## Ordnerstruktur

```
frontend/
├── index.html            Startseite
├── pages/                weitere Seiten
│   └── vorlage.html      Vorlage zum Kopieren für neue Seiten
├── css/
│   ├── variables.css     Farben, Schriften, Abstände (nur hier festlegen!)
│   ├── base.css          Grundregeln für HTML-Elemente
│   ├── layout.css        Header, Footer, Container
│   └── components.css    Bausteine: Buttons, Karten, Formulare …
├── js/
│   ├── api.js            alle Anfragen an das Backend
│   ├── main.js           Code für alle Seiten
│   └── pages/            Code für einzelne Seiten, z. B. finanzen.js
└── assets/
    ├── img/              Bilder
    └── icons/            Icons, Favicon
```

## Neue Seite anlegen

1. `pages/vorlage.html` kopieren und umbenennen, z. B. `pages/plan-anlegen.html`.
2. `<title>`, Überschrift und Inhalt in `<main>` anpassen.
3. Braucht die Seite eigenes JavaScript: `js/pages/plan-anlegen.js` anlegen und in der
   Seite die auskommentierte `<script>`-Zeile aktivieren.
4. Aufrufen unter `http://localhost:8080/pages/plan-anlegen.html`.

## Regeln

- **Farben, Schriften, Abstände** nur über Variablen aus `variables.css`, z. B.
  `color: var(--color-primary);`. Keine festen Werte wie `#1f5fa8` in anderen Dateien.
- **Kein `style="..."`** direkt im HTML. Styles gehören in die CSS-Dateien.
- **Pfade immer mit `/` beginnen**, z. B. `/css/base.css`. Dann funktionieren sie auf jeder Seite.
- **Dateinamen** klein und mit Bindestrich: `plan-anlegen.html`, `finanzen.js`.
- **Alle Texte auf Deutsch** (NFA-02).
- **Anfragen an das Backend nur über `api.js`**, nie `fetch()` direkt in einer Seite.
  Fehlt eine Funktion, wird sie in `api.js` ergänzt.
- **Bedienbar mit Tastatur** (NFA-10): echte `<button>`- und `<a>`-Elemente benutzen,
  keine klickbaren `<div>`.

## Klickbarer Designentwurf

Der klickbare Entwurf für die Präsentation wird direkt als Seiten in `pages/` gebaut,
vorerst mit Beispieldaten. Später werden die Beispieldaten durch echte Daten aus dem
Backend ersetzt. So muss nichts doppelt gebaut werden.
