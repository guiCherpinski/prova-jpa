package br.com.ctw.api_monitoramento_transformadores.dto;

import br.com.ctw.api_monitoramento_transformadores.entity.AlertaTermico;
import br.com.ctw.api_monitoramento_transformadores.entity.LeituraTermica;
import br.com.ctw.api_monitoramento_transformadores.entity.Tecnico;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Essa classe define o que vai ser devolvido para visualização
 * @param id
 * @param numeroSerie
 * @param modelo
 * @param subestacao
 * @param potenciaKva
 * @param limitTempOleo
 * @param limitTempEnrol
 * @param alertaTermico
 * @param leituraTermica
 * @param tecnicos
 */

public record TransformadorTotalResponse(
        @Schema(description = "Identificador único do transformador")
        Long id,

        @Schema(description = "Número de série do transformador")
        String numeroSerie,

        @Schema(description = "Modelo do transformador")
        String modelo,

        @Schema(description = "Subestação do transformador")
        String subestacao,

        @Schema(description = "Potencia em Kwa do transformador")
        BigDecimal potenciaKva,

        @Schema(description = "Limite de temperatura do óleo")
        BigDecimal limitTempOleo,

        @Schema(description = "Limite de temperatura do enrolamento")
        BigDecimal limitTempEnrol,

        @Schema(description = "Lista de alertas")
        Set<AlertaTermico> alertaTermico,

        @Schema(description = "Lista de leituras")
        Set<LeituraTermica> leituraTermica,

        @Schema(description = "Lista de técnicos")
        Set<Tecnico> tecnicos
) {
}
