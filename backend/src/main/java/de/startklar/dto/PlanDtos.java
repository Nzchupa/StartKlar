package de.startklar.dto;
import de.startklar.model.Industry;
import de.startklar.model.ChapterType;
import java.math.BigDecimal;
import java.util.List;
/** JSON-Daten der MVP-Schnittstelle; keine Geschäftslogik. */
public final class PlanDtos {
    private PlanDtos() {}
    /** Anfrage zum Anlegen eines Plans. */
    public record PlanRequest(String name, Industry industry) {}
    /** Anfrage zum Speichern eines Kapitels. */
    public record ChapterRequest(String content, boolean completed) {}
    /** Anfrage zum Speichern der zuletzt geöffneten Seite. */
    public record LastChapterRequest(ChapterType type) {}
    /** Anfrage zum Anlegen oder Ändern eines Mitarbeiters. */
    public record EmployeeRequest(String position, BigDecimal salary) {}
    /** Anfrage zum Anlegen oder Ändern einer Kostenposition. */
    public record CostRequest(String name, BigDecimal amount) {}
    /** Anfrage zum Speichern des monatlichen Umsatzes. */
    public record RevenueRequest(BigDecimal revenue) {}
    /** Kapitel mit Hilfetext und Beispiel. */
    public record ChapterResponse(ChapterType type, String title, String help, String example, String content, boolean completed) {}
    /** Mitarbeiterdaten. */
    public record EmployeeResponse(String id, String position, BigDecimal salary) {}
    /** Kostenposition. */
    public record CostResponse(String id, String name, BigDecimal amount) {}
    /** Monatliche Finanzübersicht. */
    public record FinanceResponse(BigDecimal revenue, BigDecimal employeeCosts, BigDecimal otherCosts, BigDecimal totalCosts, BigDecimal profit) {}
    /** Vollständiger Businessplan samt Finanzübersicht. */
    public record PlanResponse(Long id, String name, Industry industry, ChapterType lastChapter, long completedChapters,
                               List<ChapterResponse> chapters, List<EmployeeResponse> employees, List<CostResponse> costs, FinanceResponse finances) {}
    /** Auswahloption für eine Branche. */
    public record IndustryResponse(Industry value, String label) {}
    /** Verständliche Fehlermeldung. */
    public record ErrorResponse(String message) {}
}
