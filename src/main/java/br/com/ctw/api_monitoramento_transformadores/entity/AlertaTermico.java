package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_alerta_termico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlertaTermico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transf_id", nullable = false)
    private Transformador transformador;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leitura_id", nullable = false)
    private LeituraTermica leituraTermica;

    @Column(
            name = "data_alerta",
            nullable = false
    )
    private LocalDateTime dataAlerta;

    @Column(
            name = "tipo",
            nullable = false,
            length = 30
    )
    private String tipo;

    @Column(
            name = "descricao",
            nullable = false,
            length = 255
    )
    private String descricao;
}
