package de.startklar.service;

import de.startklar.dto.PlanDtos.*;
import de.startklar.exception.*;
import de.startklar.model.*;
import de.startklar.repository.BusinessPlanRepository;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Verwaltet die Daten eines Businessplans und bildet sie auf API-Antworten ab. */
@Service
@Transactional
public class BusinessPlanService {
    private final BusinessPlanRepository repository;
    private final FinanceService finance;
    /**
 * Erstellt den Service.
 * @param repository Datenzugriff
 * @param finance Finanzberechnung
 */
    public BusinessPlanService(BusinessPlanRepository repository, FinanceService finance) {
        this.repository = repository;
        this.finance = finance;
    }
    private BusinessPlan find(Long id) {
        return repository.findById(id).orElseThrow(() -> new PlanNotFoundException("Der Businessplan wurde nicht gefunden."));
    }
    private String required(String value, String label) {
        if (value == null || value.isBlank() || value.strip().length() > 200)
            throw new InvalidInputException(label + " muss zwischen 1 und 200 Zeichen enthalten.");
        return value.strip();
    }
    private BigDecimal money(BigDecimal value) {
        if (value == null || value.signum() < 0 || value.compareTo(new BigDecimal("9999999999999999.99")) > 0)
            throw new InvalidInputException("Bitte einen gültigen, nicht negativen Geldbetrag eingeben.");
        try { return value.setScale(2, RoundingMode.UNNECESSARY); }
        catch (ArithmeticException e) { throw new InvalidInputException("Geldbeträge dürfen höchstens zwei Nachkommastellen haben."); }
    }
    private ChapterResponse chapter(Chapter c) {
        String[] info = switch (c.getType()) {
            case BUSINESS_IDEA -> new String[]{"Geschäftsidee", "Beschreibe dein Angebot und welches Problem du löst.", "Ein mobiles Café versorgt Pendler mit Frühstück."};
            case MARKET_ANALYSIS -> new String[]{"Markt- und Wettbewerbsanalyse", "Beschreibe Zielgruppe, Nachfrage und Konkurrenz.", "Berufstätige im Ort; zwei Cafés in der Umgebung."};
            case MARKETING -> new String[]{"Marketing", "Wie erfahren Kunden von deinem Angebot?", "Flyer, soziale Medien und Empfehlungen."};
            case TEAM -> new String[]{"Team und Organisation", "Wer übernimmt welche Aufgaben?", "Eine Person übernimmt Verkauf, eine die Buchhaltung."};
            case FINANCE -> new String[]{"Finanzplan", "Beschreibe deine Annahmen und erfasse monatliche Umsätze und Kosten.", "10.000 € Umsatz, 7.000 € Kosten, 3.000 € Gewinn."};
        };
        return new ChapterResponse(c.getType(), info[0], info[1], info[2], c.getContent(), c.getCompleted());
    }
    private PlanResponse response(BusinessPlan p) {
        return new PlanResponse(p.getId(), p.getName(), p.getIndustry(), p.getLastChapter(),
            p.getChapters().stream().filter(Chapter::getCompleted).count(),
            p.getChapters().stream().map(this::chapter).toList(),
            p.getEmployees().stream().map(e -> new EmployeeResponse(e.getId(), e.getPosition(), e.getSalary())).toList(),
            p.getCosts().stream().map(c -> new CostResponse(c.getId(), c.getName(), c.getAmount())).toList(), finance.calculate(p));
    }
    /**
 * Legt einen Plan mit fünf Kapiteln an.
 * @param request Eingaben
 * @return neuer Plan
 */
    public PlanResponse create(PlanRequest request) {
        if (request.industry() == null) throw new InvalidInputException("Bitte eine Branche auswählen.");
        return response(repository.save(new BusinessPlan(required(request.name(), "Der Planname"), request.industry())));
    }
    /**
 * Liefert alle Pläne.
 * @return Pläne
 */
    @Transactional(readOnly = true)
    public List<PlanResponse> list() { return repository.findAll(Sort.by("id")).stream().map(this::response).toList(); }
    /**
 * Liefert einen Plan.
 * @param id Plan-ID
 * @return Plan
 */
    @Transactional(readOnly = true)
    public PlanResponse get(Long id) { return response(find(id)); }
    /**
 * Speichert ein Kapitel.
 * @param id Plan-ID
 * @param type Kapitel
 * @param request Daten
 * @return Plan
 */
    public PlanResponse saveChapter(Long id, ChapterType type, ChapterRequest request) {
        if (request.content() == null || request.content().length() > 20000)
            throw new InvalidInputException("Der Kapiteltext darf höchstens 20.000 Zeichen enthalten.");
        BusinessPlan p = find(id);
        Chapter c = p.getChapters().stream().filter(x -> x.getType() == type).findFirst().orElseThrow(() -> new PlanNotFoundException("Kapitel nicht gefunden."));
        c.setContent(request.content()); c.setCompleted(request.completed()); p.setLastChapter(type);
        return response(p);
    }
    /**
 * Merkt sich das aktuell geöffnete Kapitel.
 * @param id Plan-ID
 * @param request Kapitel
 * @return Plan
 */
    public PlanResponse saveLastChapter(Long id, LastChapterRequest request) {
        if (request.type() == null) throw new InvalidInputException("Bitte ein Kapitel auswählen.");
        BusinessPlan p = find(id); p.setLastChapter(request.type()); return response(p);
    }
    /**
 * Fügt einen Mitarbeiter hinzu.
 * @param id Plan-ID
 * @param r Daten
 * @return Plan mit Summen
 */
    public PlanResponse addEmployee(Long id, EmployeeRequest r) {
        BusinessPlan p = find(id); p.getEmployees().add(new Employee(required(r.position(), "Die Funktion"), money(r.salary()))); return response(p);
    }
    private Employee employee(BusinessPlan p, String eid) {
        return p.getEmployees().stream().filter(e -> e.getId().equals(eid)).findFirst().orElseThrow(() -> new PlanNotFoundException("Mitarbeiter nicht gefunden."));
    }
    /**
 * Ändert einen Mitarbeiter.
 * @param id Plan-ID
 * @param eid Mitarbeiter-ID
 * @param r Daten
 * @return Plan
 */
    public PlanResponse updateEmployee(Long id, String eid, EmployeeRequest r) {
        BusinessPlan p = find(id); Employee e = employee(p, eid); e.setPosition(required(r.position(), "Die Funktion")); e.setSalary(money(r.salary())); return response(p);
    }
    /**
 * Entfernt einen Mitarbeiter.
 * @param id Plan-ID
 * @param eid Mitarbeiter-ID
 * @return Plan
 */
    public PlanResponse deleteEmployee(Long id, String eid) {
        BusinessPlan p = find(id); p.getEmployees().remove(employee(p, eid)); return response(p);
    }
    /**
 * Fügt eine Kostenposition hinzu.
 * @param id Plan-ID
 * @param r Daten
 * @return Plan
 */
    public PlanResponse addCost(Long id, CostRequest r) {
        BusinessPlan p = find(id); p.getCosts().add(new CostItem(required(r.name(), "Die Bezeichnung"), money(r.amount()))); return response(p);
    }
    private CostItem cost(BusinessPlan p, String cid) {
        return p.getCosts().stream().filter(c -> c.getId().equals(cid)).findFirst().orElseThrow(() -> new PlanNotFoundException("Kostenposition nicht gefunden."));
    }
    /**
 * Ändert eine Kostenposition.
 * @param id Plan-ID
 * @param cid Kosten-ID
 * @param r Daten
 * @return Plan
 */
    public PlanResponse updateCost(Long id, String cid, CostRequest r) {
        BusinessPlan p = find(id); CostItem c = cost(p, cid); c.setName(required(r.name(), "Die Bezeichnung")); c.setAmount(money(r.amount())); return response(p);
    }
    /**
 * Entfernt eine Kostenposition.
 * @param id Plan-ID
 * @param cid Kosten-ID
 * @return Plan
 */
    public PlanResponse deleteCost(Long id, String cid) {
        BusinessPlan p = find(id); p.getCosts().remove(cost(p, cid)); return response(p);
    }
    /**
 * Speichert den Monatsumsatz.
 * @param id Plan-ID
 * @param r Umsatz
 * @return Plan
 */
    public PlanResponse saveRevenue(Long id, RevenueRequest r) {
        BusinessPlan p = find(id); p.setRevenue(money(r.revenue())); return response(p);
    }
    /**
 * Liefert die fünf verfügbaren Branchen.
 * @return Auswahloptionen
 */
    public List<IndustryResponse> industries() {
        return List.of(new IndustryResponse(Industry.GASTRONOMIE, "Gastronomie"), new IndustryResponse(Industry.HANDWERK, "Handwerk"),
            new IndustryResponse(Industry.DIENSTLEISTUNG, "Dienstleistung"), new IndustryResponse(Industry.FREIBERUF, "Freiberuf"), new IndustryResponse(Industry.ONLINE_HANDEL, "Online-Handel"));
    }
}
