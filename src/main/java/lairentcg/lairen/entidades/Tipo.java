package lairentcg.lairen.entidades;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tipo")
public class Tipo {

    @Id
    @Column(name = "id_tipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;

    @Column(name = "nombre_tipo")
    private String nombreTipo;

    public Tipo() {
    }

    public Tipo(Long idTipo, String nombreTipo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
    }
}
