package lairentcg.lairen.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carta")
public class Carta {

    @Id
    @Column(name = "id_carta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarta;

    @Column(name = "nombre_carta")
    private String nombreCarta;

    @Column(name = "coste_carta")
    private Long costeCarta;

    @Column(name = "url_imagen")
    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "expansion_id_expansion")
    private Expansion expansion;

    @ManyToOne
    @JoinColumn(name = "tipo_id_tipo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "rareza_id_rareza")
    private Rareza rareza;
}
