# StartKlar – MVP REST-API

Stand: 25.11.2026 – Implementierungsentwurf für lokale Demo. Alle Geldwerte in EUR pro Monat. Kein Login, kein öffentlicher Betrieb. Die Antworten aller schreibenden Plan-Endpunkte enthalten den vollständigen aktualisierten Plan.

| Methode | Pfad | JSON-Anfrage | Antwort (200, POST 201) |
|---|---|---|---|
| GET | `/api/status` | – | `{"status":"ok","application":"StartKlar"}` (bestehend) |
| GET | `/api/industries` | – | `[{"value":"GASTRONOMIE","label":"Gastronomie"},...]` |
| POST | `/api/plans` | `{"name":"Café","industry":"GASTRONOMIE"}` | Plan |
| GET | `/api/plans` | – | Array von Plänen |
| GET | `/api/plans/{id}` | – | Plan |
| GET | `/api/plans/{id}/chapters` | – | Array von Kapiteln |
| PUT | `/api/plans/{id}/chapters/{type}` | `{"content":"Flyer","completed":true}` | Plan |
| PUT | `/api/plans/{id}/last-chapter` | `{"type":"TEAM"}` | Plan |
| GET | `/api/plans/{id}/employees` | – | Mitarbeiterliste |
| POST | `/api/plans/{id}/employees` | `{"position":"Verkauf","salary":4500}` | Plan |
| PUT | `/api/plans/{id}/employees/{eid}` | `{"position":"Verkauf","salary":5000}` | Plan |
| DELETE | `/api/plans/{id}/employees/{eid}` | – | Plan |
| GET | `/api/plans/{id}/costs` | – | Kostenliste |
| POST | `/api/plans/{id}/costs` | `{"name":"Miete","amount":2500}` | Plan |
| PUT | `/api/plans/{id}/costs/{cid}` | `{"name":"Miete","amount":6000}` | Plan |
| DELETE | `/api/plans/{id}/costs/{cid}` | – | Plan |
| PUT | `/api/plans/{id}/revenue` | `{"revenue":10000}` | Plan |
| GET | `/api/plans/{id}/finances` | – | Finanzübersicht |

## Antwortstruktur

```json
{
  "id": 1,
  "name": "Café",
  "industry": "GASTRONOMIE",
  "lastChapter": "FINANCE",
  "completedChapters": 1,
  "chapters": [
    {"type":"BUSINESS_IDEA","title":"Geschäftsidee","help":"...","example":"...","content":"Mobiles Café","completed":true}
  ],
  "employees": [{"id":"<UUID>","position":"Verkauf","salary":4500.00}],
  "costs": [{"id":"<UUID>","name":"Miete","amount":2500.00}],
  "finances": {"revenue":10000.00,"employeeCosts":4500.00,"otherCosts":2500.00,"totalCosts":7000.00,"profit":3000.00}
}
```

Die Kapitel-Liste enthält immer alle fünf Kapitel: BUSINESS_IDEA, MARKET_ANALYSIS, MARKETING, TEAM, FINANCE. IDs für Mitarbeiter/Kosten aus der Antwort übernehmen, niemals selbst raten. Fehlermeldungen: 400 oder 404 mit `{"message":"..."}`. Frontend soll `response.ok` prüfen. Beim Kapitelwechsel zuerst Inhalt speichern, anschließend `last-chapter` setzen; beim Öffnen `lastChapter` auswerten. Summen immer aus `finances` verwenden. Den Monatszeitraum deutlich kennzeichnen. Die DTO-Definitionen befinden sich in `PlanDtos.java`.

## Testablauf für morgen

1. Plan erstellen, fünf leere Kapitel und Branchen prüfen.
2. Text im ersten Kapitel speichern, zum nächsten wechseln, Browser neu öffnen.
3. Umsatz 10000, Personal 4500, sonstige Kosten 2500 eintragen: Gewinn 3000.
4. Kosten auf 6000 und Personal auf 5000 setzen: Verlust 1000.
5. Kosten/Mitarbeiter löschen: Summen aktualisiert.
6. Server stoppen und neu starten. Plan und letzte Seite müssen erhalten bleiben.
7. Negativen Betrag und nicht existierende ID prüfen.

Die lokale Datenbank liegt standardmäßig unter `${user.home}/.startklar/startklar.mv.db` außerhalb des Git-Repositorys. Optional kann `STARTKLAR_DB_PATH` gesetzt werden (Pfad ohne Dateiendung).

Die Testdatenbank im Maven-Test ist absichtlich flüchtig; die Neustart-Persistenz muss separat im lokalen Lauf geprüft werden.
