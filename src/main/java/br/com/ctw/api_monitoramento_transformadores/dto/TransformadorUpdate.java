package br.com.ctw.api_monitoramento_transformadores.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

/**
 * Essa classe define o que vai ser atualizado no transformador
 * @param limitTempOleo
 * @param limitTempEnrol
 */

public record TransformadorUpdate (
        @Schema(description = "Limite de temperatura do óleo")
        BigDecimal limitTempOleo,

        @Schema(description = "Limite de temperatura do enrolamento")
        BigDecimal limitTempEnrol
){
}
