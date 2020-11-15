package entregaPercistente;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<Void> handleNofindException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ExceptionHandler(ElementoExistenteException.class)
    public ResponseEntity<Void> ElementoExistenteException() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
    
    @ExceptionHandler(IdIncompativelException.class)
    public ResponseEntity<Void> IdIncompativelException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    
}
