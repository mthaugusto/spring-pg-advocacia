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
@Table(name = "TB_ESTADO")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADO")
    @SequenceGenerator(sequenceName = "SQ_ESTADO", name = "SQ_ESTADO", allocationSize = 1, initialValue = 1)
    @Column(name = "ID_ESTADO")
    private int id;

    @Column(name = "NM_ESTADO")
    private String nome;

    @Column(name = "SG_ESTADO")
    private String sigla;
}
