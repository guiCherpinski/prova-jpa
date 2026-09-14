package br.com.ctw.api_monitoramento_transformadores.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * Essa é uma entity que representa uma leitura térmica
 */

@Entity
@Table(name = "tb_leitura_termica")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeituraTermica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transf_id", nullable = false)
    private Transformador transformador;

    @Column(
            name = "temp_oleo",
            nullable = false
    )
    private BigDecimal tempOleo;

    @Column(
            name = "temp_enrolamento",
            nullable = false
    )
    private BigDecimal tempEnrolamento;

    @Column(
            name = "data_hora",
            nullable = false
    )
    private LocalDateTime dataHora;

    @JsonBackReference
    @OneToOne(mappedBy = "leituraTermica", cascade = CascadeType.ALL)
    private AlertaTermico alertaTermico;
}
