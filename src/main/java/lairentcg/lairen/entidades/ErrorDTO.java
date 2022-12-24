package lairentcg.lairen.entidades;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorDTO {

    private String codigo;
    private String mensaje;

}
