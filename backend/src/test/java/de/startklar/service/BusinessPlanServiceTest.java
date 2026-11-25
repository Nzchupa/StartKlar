package de.startklar.service;
import de.startklar.dto.PlanDtos.*;
import de.startklar.model.*;
import de.startklar.exception.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
/** Prüft Datenhaltung und Geschäftslogik mit einer separaten Testdatenbank. */
@SpringBootTest
class BusinessPlanServiceTest {
    @Autowired BusinessPlanService service;
    @Test void createAndResume() {
        var p = service.create(new PlanRequest("Café", Industry.GASTRONOMIE));
        assertThat(p.chapters()).hasSize(5);
        assertThat(p.chapters()).allMatch(c -> c.content().isEmpty());
        service.saveChapter(p.id(), ChapterType.MARKETING, new ChapterRequest("Flyer", true));
        service.saveLastChapter(p.id(), new LastChapterRequest(ChapterType.TEAM));
        var loaded = service.get(p.id());
        assertThat(loaded.lastChapter()).isEqualTo(ChapterType.TEAM);
        assertThat(loaded.completedChapters()).isEqualTo(1);
        assertThat(loaded.chapters().get(2).content()).isEqualTo("Flyer");
    }
    @Test void financeAndCrud() {
        var p = service.create(new PlanRequest("Test", Industry.HANDWERK));
        var id = p.id();
        service.saveRevenue(id, new RevenueRequest(new BigDecimal("10000")));
        var e = service.addEmployee(id, new EmployeeRequest("Verkauf", new BigDecimal("4500"))).employees().get(0).id();
        var c = service.addCost(id, new CostRequest("Miete", new BigDecimal("2500"))).costs().get(0).id();
        assertThat(service.get(id).finances().profit()).isEqualByComparingTo("3000.00");
        service.updateEmployee(id, e, new EmployeeRequest("Verkauf", new BigDecimal("5000")));
        service.updateCost(id, c, new CostRequest("Miete", new BigDecimal("6000")));
        assertThat(service.get(id).finances().profit()).isEqualByComparingTo("-1000.00");
        service.deleteEmployee(id, e); service.deleteCost(id, c);
        assertThat(service.get(id).finances().totalCosts()).isEqualByComparingTo("0.00");
    }
    @Test void rejectsInvalidInputAndMissingPlan() {
        assertThatThrownBy(() -> service.create(new PlanRequest(" ", Industry.HANDWERK))).isInstanceOf(InvalidInputException.class);
        assertThatThrownBy(() -> service.get(-1L)).isInstanceOf(PlanNotFoundException.class);
        var p = service.create(new PlanRequest("Test", Industry.HANDWERK));
        assertThatThrownBy(() -> service.saveRevenue(p.id(), new RevenueRequest(new BigDecimal("-1")))).isInstanceOf(InvalidInputException.class);
    }
}
