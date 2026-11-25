package de.startklar.service;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
/** Prüft drei bekannte Referenzrechnungen. */
class FinanceServiceTest {
    private final FinanceService service = new FinanceService();
    @Test void positiveProfit() { assertThat(service.calculateProfit(new BigDecimal("10000"), new BigDecimal("7000"))).isEqualTo(new BigDecimal("3000.00")); }
    @Test void negativeProfit() { assertThat(service.calculateProfit(new BigDecimal("5000"), new BigDecimal("8000"))).isEqualTo(new BigDecimal("-3000.00")); }
    @Test void preciseCents() { assertThat(service.calculateProfit(new BigDecimal("10.30"), new BigDecimal("0.20"))).isEqualTo(new BigDecimal("10.10")); }
}
