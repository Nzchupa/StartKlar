package de.startklar.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/** Fachliches Datenmodell: Chapter. */
@Embeddable
public class Chapter {
    @Enumerated(EnumType.STRING) @Column(name = "chapter_type", nullable = false)
    private ChapterType type;
    @Column(length = 20000, nullable = false)
    private String content = "";
    private boolean completed = false;

    /** Erstellt ein leeres Objekt für die Datenbank. */
    protected Chapter() {}
    /**
 * Erstellt ein leeres Kapitel.
 * @param type Kapiteltyp
 */
    public Chapter(ChapterType type) { this.type = type; }
    /**
 * Liefert type.
 * @return type
 */
    public ChapterType getType() { return type; }
    /**
 * Setzt type.
 * @param type neuer Wert
 */
    public void setType(ChapterType type) { this.type = type; }
    /**
 * Liefert content.
 * @return content
 */
    public String getContent() { return content; }
    /**
 * Setzt content.
 * @param content neuer Wert
 */
    public void setContent(String content) { this.content = content; }
    /**
 * Liefert completed.
 * @return completed
 */
    public boolean getCompleted() { return completed; }
    /**
 * Setzt completed.
 * @param completed neuer Wert
 */
    public void setCompleted(boolean completed) { this.completed = completed; }
}
