package de.startklar.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/** Fachliches Datenmodell: Employee. */
@Embeddable
public class Employee {
    @Column(name = "item_id", nullable = false)
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false, length = 200)
    private String position;
    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal salary = BigDecimal.ZERO;

    /** Erstellt ein leeres Objekt für die Datenbank. */
    protected Employee() {}
    /**
 * Erstellt einen Eintrag.
 * @param position Bezeichnung
 * @param salary Monatsbetrag
 */
    public Employee(String position, BigDecimal salary) { this.position = position; this.salary = salary; }
    /**
 * Liefert id.
 * @return id
 */
    public String getId() { return id; }
    /**
 * Liefert position.
 * @return position
 */
    public String getPosition() { return position; }
    /**
 * Setzt position.
 * @param position neuer Wert
 */
    public void setPosition(String position) { this.position = position; }
    /**
 * Liefert salary.
 * @return salary
 */
    public BigDecimal getSalary() { return salary; }
    /**
 * Setzt salary.
 * @param salary neuer Wert
 */
    public void setSalary(BigDecimal salary) { this.salary = salary; }
}
