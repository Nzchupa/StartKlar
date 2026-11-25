package de.startklar.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/** Fachliches Datenmodell: BusinessPlan. */
@Entity
@Table(name = "business_plans")
public class BusinessPlan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String name;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Industry industry;
    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal revenue = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private ChapterType lastChapter = ChapterType.BUSINESS_IDEA;
    @ElementCollection @CollectionTable(name = "plan_chapters", joinColumns = @JoinColumn(name = "plan_id")) @OrderColumn(name = "chapter_order")
    private List<Chapter> chapters = new ArrayList<>();
    @ElementCollection @CollectionTable(name = "plan_employees", joinColumns = @JoinColumn(name = "plan_id")) @OrderColumn(name = "employee_order")
    private List<Employee> employees = new ArrayList<>();
    @ElementCollection @CollectionTable(name = "plan_costs", joinColumns = @JoinColumn(name = "plan_id")) @OrderColumn(name = "cost_order")
    private List<CostItem> costs = new ArrayList<>();

    /** Erstellt ein leeres Objekt für die Datenbank. */
    protected BusinessPlan() {}
    /**
 * Erstellt einen neuen Plan.
 * @param name Planname
 * @param industry Branche
 */
    public BusinessPlan(String name, Industry industry) {
        this.name = name;
        this.industry = industry;
        for (ChapterType type : ChapterType.values()) chapters.add(new Chapter(type));
    }
    /**
 * Liefert id.
 * @return id
 */
    public Long getId() { return id; }
    /**
 * Liefert name.
 * @return name
 */
    public String getName() { return name; }
    /**
 * Setzt name.
 * @param name neuer Wert
 */
    public void setName(String name) { this.name = name; }
    /**
 * Liefert industry.
 * @return industry
 */
    public Industry getIndustry() { return industry; }
    /**
 * Setzt industry.
 * @param industry neuer Wert
 */
    public void setIndustry(Industry industry) { this.industry = industry; }
    /**
 * Liefert revenue.
 * @return revenue
 */
    public BigDecimal getRevenue() { return revenue; }
    /**
 * Setzt revenue.
 * @param revenue neuer Wert
 */
    public void setRevenue(BigDecimal revenue) { this.revenue = revenue; }
    /**
 * Liefert lastChapter.
 * @return lastChapter
 */
    public ChapterType getLastChapter() { return lastChapter; }
    /**
 * Setzt lastChapter.
 * @param lastChapter neuer Wert
 */
    public void setLastChapter(ChapterType lastChapter) { this.lastChapter = lastChapter; }
    /**
 * Liefert chapters.
 * @return chapters
 */
    public List<Chapter> getChapters() { return chapters; }
    /**
 * Setzt chapters.
 * @param chapters neuer Wert
 */
    public void setChapters(List<Chapter> chapters) { this.chapters = chapters; }
    /**
 * Liefert employees.
 * @return employees
 */
    public List<Employee> getEmployees() { return employees; }
    /**
 * Setzt employees.
 * @param employees neuer Wert
 */
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
    /**
 * Liefert costs.
 * @return costs
 */
    public List<CostItem> getCosts() { return costs; }
    /**
 * Setzt costs.
 * @param costs neuer Wert
 */
    public void setCosts(List<CostItem> costs) { this.costs = costs; }
}
