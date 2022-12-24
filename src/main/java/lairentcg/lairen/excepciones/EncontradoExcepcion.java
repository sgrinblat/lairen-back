package lairentcg.lairen.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EncontradoExcepcion extends RuntimeException {

    private String codigo;
    private HttpStatus status;

    public EncontradoExcepcion(String message, String codigo, HttpStatus status) {
        super(message);
        this.codigo = codigo;
        this.status = status;
    }
}
