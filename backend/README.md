# StartKlar – Backend

Java 21 · Spring Boot 4.1 · Maven

Das Backend stellt die Schnittstelle `/api/...` bereit und liefert gleichzeitig das
Frontend aus dem Ordner `../frontend` aus. Es reicht also, nur das Backend zu starten.

## Voraussetzungen

- **JDK 21** installiert. Prüfen im Terminal: `java -version` → muss `21` anzeigen.
  Download z. B. [Eclipse Temurin 21](https://adoptium.net/temurin/releases/?version=21).
- Maven muss **nicht** installiert sein. Das Skript `mvnw` (Maven Wrapper) lädt
  beim ersten Start automatisch die richtige Version herunter.

## Starten

Im Terminal in den Ordner `backend` wechseln:

```bash
cd backend
```

| | Windows (PowerShell / CMD) | macOS / Linux |
| --- | --- | --- |
| Starten | `.\mvnw.cmd spring-boot:run` | `./mvnw spring-boot:run` |
| Tests ausführen | `.\mvnw.cmd test` | `./mvnw test` |
| Bauen (JAR) | `.\mvnw.cmd clean package` | `./mvnw clean package` |

Der erste Start dauert etwas länger (Downloads). Danach:

- **http://localhost:8080** → Startseite (Frontend)
- **http://localhost:8080/api/status** → `{"status":"ok","application":"StartKlar"}`

Beenden mit **Strg + C** im Terminal.

### In Eclipse

1. **File → Import… → Maven → Existing Maven Projects** → Ordner `backend` wählen → **Finish**.
2. `src/main/java/de/startklar/StartKlarApplication.java` öffnen.
3. Rechtsklick → **Run As → Java Application**.

## Ordnerstruktur

```
backend/
├── pom.xml                         Maven: Java-Version und Bibliotheken
├── mvnw, mvnw.cmd, .mvn/           Maven Wrapper
└── src/
    ├── main/
    │   ├── java/de/startklar/
    │   │   ├── StartKlarApplication.java   Startklasse (main-Methode)
    │   │   ├── controller/   Endpunkte /api/... für das Frontend
    │   │   ├── service/      Geschäftslogik und Berechnungen
    │   │   ├── repository/   Daten speichern und laden
    │   │   ├── model/        fachliche Objekte (BusinessPlan, Chapter …)
    │   │   ├── dto/          Daten, die als JSON hin- und hergehen
    │   │   ├── config/       Spring-Konfiguration
    │   │   └── exception/    eigene Ausnahmen, Fehlermeldungen
    │   └── resources/
    │       └── application.properties   Einstellungen (Port, Frontend-Ordner …)
    └── test/java/de/startklar/          Tests, gleiche Paketstruktur wie main
```

In jedem Paket liegt eine `package-info.java`. Dort steht, was in das Paket gehört,
wie Klassen heißen sollen und welche Regeln gelten. **Vor dem ersten Arbeiten in einem
Paket bitte lesen.**

## So läuft eine Anfrage

```
Browser / Frontend
      │  GET /api/plans
      ▼
Controller   nimmt die Anfrage an, gibt DTO als JSON zurück
      │
      ▼
Service      Logik und Berechnungen
      │
      ▼
Repository   Daten speichern und laden
```

Keine Schicht wird übersprungen: Der Controller ruft nie direkt das Repository auf.

## Neuen Endpunkt hinzufügen

Vorlage ist `controller/StatusController.java` mit `dto/StatusResponse.java`.

1. **Model** in `model/` anlegen (falls nötig), z. B. `BusinessPlan`.
2. **Repository** in `repository/`, z. B. `BusinessPlanRepository` mit `@Repository`.
3. **Service** in `service/`, z. B. `BusinessPlanService` mit `@Service`.
4. **DTOs** in `dto/`, z. B. `BusinessPlanRequest`, `BusinessPlanResponse`.
5. **Controller** in `controller/`, z. B. `BusinessPlanController` mit `@RestController`
   und `@RequestMapping("/api/plans")`.
6. **Test** in `src/test/java/de/startklar/...` (Vorlage: `StatusControllerTest`).
7. Endpunkt unten in die Tabelle eintragen, damit das Frontend-Team ihn kennt.

## Endpunkte

| Methode | Pfad | Beschreibung | Antwort |
| --- | --- | --- | --- |
| GET | `/api/status` | Prüft, ob das Backend läuft | `{"status":"ok","application":"StartKlar"}` |

## Regeln

- Klassen, Methoden und Variablen auf **Englisch**, Kommentare und JavaDoc auf **Deutsch**.
- Jede öffentliche Klasse und Methode bekommt JavaDoc (NFA-07).
- Geldbeträge mit `BigDecimal`, nicht mit `double` (NFA-16).
- Vor jedem Pull Request: `mvnw test` muss grün sein.
- Code, der mit KI erstellt wurde, muss man selbst erklären können.

## Häufige Probleme

| Problem | Lösung |
| --- | --- |
| `Port 8080 was already in use` | Läuft das Backend schon in einem anderen Fenster? Dort mit Strg + C beenden. |
| `release version 21 not supported` | Es ist ein älteres JDK aktiv. JDK 21 installieren, `JAVA_HOME` darauf setzen. |
| `JAVA_HOME not found` | `JAVA_HOME` auf den JDK-21-Ordner setzen und das Terminal neu öffnen. |
| `./mvnw: Permission denied` (macOS/Linux) | einmal `chmod +x mvnw` ausführen. |
| Startseite zeigt Fehler 404 | Backend im Ordner `backend` oder im Projekt-Hauptordner starten, nicht woanders. |
