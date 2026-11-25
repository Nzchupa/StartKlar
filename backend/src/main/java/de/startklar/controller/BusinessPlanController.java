package de.startklar.controller;
import de.startklar.dto.PlanDtos.*;
import de.startklar.model.ChapterType;
import de.startklar.service.BusinessPlanService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
/** REST-Endpunkte zur Bearbeitung der Businesspläne. */
@RestController
@RequestMapping("/api")
public class BusinessPlanController {
    private final BusinessPlanService service;
    /**
 * Erstellt den Controller.
 * @param service Geschäftslogik
 */
    public BusinessPlanController(BusinessPlanService service) { this.service = service; }
    /**
 * Liefert Branchen.
 * @return Branchenliste
 */
    @GetMapping("/industries") public List<IndustryResponse> industries() { return service.industries(); }
    /**
 * Erstellt einen Plan.
 * @param r Daten
 * @return Plan
 */
    @PostMapping("/plans") @ResponseStatus(HttpStatus.CREATED) public PlanResponse create(@RequestBody PlanRequest r) { return service.create(r); }
    /**
 * Liefert die Übersicht.
 * @return Pläne
 */
    @GetMapping("/plans") public List<PlanResponse> list() { return service.list(); }
    /**
 * Liefert einen Plan.
 * @param id Plan-ID
 * @return Plan
 */
    @GetMapping("/plans/{id}") public PlanResponse get(@PathVariable("id") Long id) { return service.get(id); }
    /**
 * Liefert Kapitel.
 * @param id Plan-ID
 * @return Kapitel
 */
    @GetMapping("/plans/{id}/chapters") public List<ChapterResponse> chapters(@PathVariable("id") Long id) { return service.get(id).chapters(); }
    /**
 * Speichert ein Kapitel.
 * @param id Plan-ID
 * @param type Kapiteltyp
 * @param r Daten
 * @return Plan
 */
    @PutMapping("/plans/{id}/chapters/{type}") public PlanResponse chapter(@PathVariable("id") Long id, @PathVariable("type") ChapterType type, @RequestBody ChapterRequest r) { return service.saveChapter(id, type, r); }
    /**
 * Speichert die zuletzt geöffnete Seite.
 * @param id Plan-ID
 * @param r Daten
 * @return Plan
 */
    @PutMapping("/plans/{id}/last-chapter") public PlanResponse lastChapter(@PathVariable("id") Long id, @RequestBody LastChapterRequest r) { return service.saveLastChapter(id, r); }
    /**
 * Liefert Mitarbeiter.
 * @param id Plan-ID
 * @return Mitarbeiter
 */
    @GetMapping("/plans/{id}/employees") public List<EmployeeResponse> employees(@PathVariable("id") Long id) { return service.get(id).employees(); }
    /**
 * Fügt einen Mitarbeiter hinzu.
 * @param id Plan-ID
 * @param r Daten
 * @return Plan
 */
    @PostMapping("/plans/{id}/employees") @ResponseStatus(HttpStatus.CREATED) public PlanResponse addEmployee(@PathVariable("id") Long id, @RequestBody EmployeeRequest r) { return service.addEmployee(id, r); }
    /**
 * Ändert einen Mitarbeiter.
 * @param id Plan-ID
 * @param eid Mitarbeiter-ID
 * @param r Daten
 * @return Plan
 */
    @PutMapping("/plans/{id}/employees/{eid}") public PlanResponse updateEmployee(@PathVariable("id") Long id, @PathVariable("eid") String eid, @RequestBody EmployeeRequest r) { return service.updateEmployee(id, eid, r); }
    /**
 * Löscht einen Mitarbeiter.
 * @param id Plan-ID
 * @param eid Mitarbeiter-ID
 * @return Plan
 */
    @DeleteMapping("/plans/{id}/employees/{eid}") public PlanResponse deleteEmployee(@PathVariable("id") Long id, @PathVariable("eid") String eid) { return service.deleteEmployee(id, eid); }
    /**
 * Liefert Kostenpositionen.
 * @param id Plan-ID
 * @return Kosten
 */
    @GetMapping("/plans/{id}/costs") public List<CostResponse> costs(@PathVariable("id") Long id) { return service.get(id).costs(); }
    /**
 * Fügt Kosten hinzu.
 * @param id Plan-ID
 * @param r Daten
 * @return Plan
 */
    @PostMapping("/plans/{id}/costs") @ResponseStatus(HttpStatus.CREATED) public PlanResponse addCost(@PathVariable("id") Long id, @RequestBody CostRequest r) { return service.addCost(id, r); }
    /**
 * Ändert Kosten.
 * @param id Plan-ID
 * @param cid Kosten-ID
 * @param r Daten
 * @return Plan
 */
    @PutMapping("/plans/{id}/costs/{cid}") public PlanResponse updateCost(@PathVariable("id") Long id, @PathVariable("cid") String cid, @RequestBody CostRequest r) { return service.updateCost(id, cid, r); }
    /**
 * Löscht Kosten.
 * @param id Plan-ID
 * @param cid Kosten-ID
 * @return Plan
 */
    @DeleteMapping("/plans/{id}/costs/{cid}") public PlanResponse deleteCost(@PathVariable("id") Long id, @PathVariable("cid") String cid) { return service.deleteCost(id, cid); }
    /**
 * Speichert Umsatz.
 * @param id Plan-ID
 * @param r Daten
 * @return Plan
 */
    @PutMapping("/plans/{id}/revenue") public PlanResponse revenue(@PathVariable("id") Long id, @RequestBody RevenueRequest r) { return service.saveRevenue(id, r); }
    /**
 * Liefert Finanzsummen.
 * @param id Plan-ID
 * @return Finanzen
 */
    @GetMapping("/plans/{id}/finances") public FinanceResponse finances(@PathVariable("id") Long id) { return service.get(id).finances(); }
}
