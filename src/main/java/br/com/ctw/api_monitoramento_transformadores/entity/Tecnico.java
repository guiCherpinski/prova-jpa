package br.com.ctw.api_monitoramento_transformadores.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_tecnico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "cpf",
            nullable = false,
            unique = true,
            length = 11
    )
    private String cpf;

    @Column(
            name = "nome",
            nullable = false,
            length = 100
    )
    private String nome;

    @Column(
            name = "especialidade",
            nullable = false,
            length = 100
    )
    private String especialidade;

    @Column(
            name = "email",
            nullable = false,
            length = 50
    )
    private String email;

    @ManyToMany(mappedBy = "tecnicos")
    private Set<Transformador> transformadores = new HashSet<>();
}


