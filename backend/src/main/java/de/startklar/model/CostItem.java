package de.startklar.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/** Fachliches Datenmodell: CostItem. */
@Embeddable
public class CostItem {
    @Column(name = "item_id", nullable = false)
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false, length = 200)
    private String name;
    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amount = BigDecimal.ZERO;

    /** Erstellt ein leeres Objekt für die Datenbank. */
    protected CostItem() {}
    /**
 * Erstellt einen Eintrag.
 * @param name Bezeichnung
 * @param amount Monatsbetrag
 */
    public CostItem(String name, BigDecimal amount) { this.name = name; this.amount = amount; }
    /**
 * Liefert id.
 * @return id
 */
    public String getId() { return id; }
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
 * Liefert amount.
 * @return amount
 */
    public BigDecimal getAmount() { return amount; }
    /**
 * Setzt amount.
 * @param amount neuer Wert
 */
    public void setAmount(BigDecimal amount) { this.amount = amount; }
}
