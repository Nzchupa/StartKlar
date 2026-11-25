package de.startklar.repository;
import de.startklar.model.BusinessPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/** Speichert und lädt Businesspläne über Spring Data JPA. */
@Repository
public interface BusinessPlanRepository extends JpaRepository<BusinessPlan, Long> {}
