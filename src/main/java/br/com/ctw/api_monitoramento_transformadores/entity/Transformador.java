package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_transformadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transformador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "numero_serie",
            nullable = false,
            unique = true,
            length = 50
    )
    private String numeroSerie;

    @Column(
            name = "modelo",
            nullable = false,
            length = 100
    )
    private String modelo;

    @Column(
            name = "subestacao",
            nullable = false,
            length = 100
    )
    private String subestacao;

    @Column(
            name = "potencia_kva",
            nullable = false
    )
    private BigDecimal potenciaKva;

    @Column(
            name = "limit_temp_oleo",
            nullable = false
    )
    private BigDecimal limitTemOleo;

    @Column(
            name = "limit_temp_enrol",
            nullable = false
    )
    private BigDecimal limitTempEnrol;

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlertaTermico> alertaTermico = new HashSet<>();

    @OneToMany(mappedBy = "transformador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LeituraTermica> leituraTermica = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "transformador_tecnico",
            joinColumns = @JoinColumn(name = "transformador_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnico_id")
    )
    private Set<Tecnico> tecnicos = new HashSet<>();
}
