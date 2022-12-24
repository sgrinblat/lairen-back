package lairentcg.lairen.entidades;

//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "expansion")
public class Expansion {

    @Id
    @Column(name = "id_expansion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExpansion;

    @Column(name = "nombre_expansion")
    private String nombreExpansion;

    @Column(name = "fecha_lanzamiento")
    private Date fechaLanzamiento;

    public Expansion() {
    }

    public Expansion(Long idExpansion, String nombreExpansion, Date fechaLanzamiento) {
        this.idExpansion = idExpansion;
        this.nombreExpansion = nombreExpansion;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    //    @JsonCreator
//    public Expansion(@JsonProperty("idExpansion") long idExpansion, @JsonProperty("nombreExpansion") String nombreExpansion, @JsonProperty("fechaLanzamiento") Date fechaLanzamiento) {
//        this.idExpansion = idExpansion;
//        this.nombreExpansion = nombreExpansion;
//        this.fechaLanzamiento = fechaLanzamiento;
//    }

}
