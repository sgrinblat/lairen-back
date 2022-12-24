package lairentcg.lairen.entidades;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rareza")
public class Rareza {

    @Id
    @Column(name = "id_rareza")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRareza;

    @Column(name = "nombre_rareza")
    private String nombreRareza;

    public Rareza() {
    }

    public Rareza(Long idRareza, String nombreRareza) {
        this.idRareza = idRareza;
        this.nombreRareza = nombreRareza;
    }
}
