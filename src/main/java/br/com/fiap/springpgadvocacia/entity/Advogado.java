package br.com.fiap.springpgadvocacia.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_ADVOGADO")
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ADVOGADO")
    @SequenceGenerator(
            name = "SQ_ADVOGADO",
            sequenceName = "SQ_ADVOGADO",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "ID_ADVOGADO")
    private long Id;

    @Column(name = "NM_ADVOGADO")
    private String nome;

    private String numeroOAB;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "ESTADO",
            referencedColumnName = "ID_ESTADO"
            , foreignKey = @ForeignKey(name = "FK_ADVOGADO_ESTADO")
    )
    private Estado estado;
}
