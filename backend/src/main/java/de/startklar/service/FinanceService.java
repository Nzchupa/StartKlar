package de.startklar.service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import de.startklar.model.BusinessPlan;
import de.startklar.dto.PlanDtos.FinanceResponse;
import org.springframework.stereotype.Service;
/** Berechnet monatliche Kosten und Gewinn oder Verlust mit exakten Dezimalzahlen. */
@Service
public class FinanceService {
    /**
 * Berechnet Gewinn.
 * @param revenue Umsatz
 * @param costs Gesamtkosten
 * @return Gewinn oder Verlust
 */
    public BigDecimal calculateProfit(BigDecimal revenue, BigDecimal costs) {
        return revenue.subtract(costs).setScale(2, RoundingMode.HALF_UP);
    }
    /**
 * Berechnet alle Summen eines Plans.
 * @param plan Plan
 * @return Finanzübersicht
 */
    public FinanceResponse calculate(BusinessPlan plan) {
        BigDecimal zero = BigDecimal.ZERO.setScale(2);
        BigDecimal staff = plan.getEmployees().stream().map(e -> e.getSalary()).reduce(zero, BigDecimal::add);
        BigDecimal other = plan.getCosts().stream().map(c -> c.getAmount()).reduce(zero, BigDecimal::add);
        BigDecimal total = staff.add(other);
        BigDecimal revenue = plan.getRevenue().setScale(2, RoundingMode.HALF_UP);
        return new FinanceResponse(revenue, staff, other, total, calculateProfit(revenue, total));
    }
}
