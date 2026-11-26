package de.startklar.exception;
import de.startklar.dto.PlanDtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
/** Übersetzt erwartete Fehler in deutsche HTTP-Antworten. */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
 * Meldet eine fehlende Ressource.
 * @param e Fehler
 * @return Antwort
 */
    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(PlanNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
    }
    /**
 * Meldet ungültige Eingaben.
 * @param e Fehler
 * @return Antwort
 */
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> invalid(InvalidInputException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }
    /**
 * Meldet fehlerhaftes JSON oder einen unbekannten Pfadparameter.
 * @return Antwort
 */
    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> invalidFormat() {
        return ResponseEntity.badRequest().body(new ErrorResponse("Die Anfrage enthält ungültige oder fehlende Daten."));
    }
}
