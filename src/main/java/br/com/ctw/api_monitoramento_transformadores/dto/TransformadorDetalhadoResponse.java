package br.com.ctw.api_monitoramento_transformadores.dto;

import br.com.ctw.api_monitoramento_transformadores.entity.AlertaTermico;
import br.com.ctw.api_monitoramento_transformadores.entity.LeituraTermica;
import br.com.ctw.api_monitoramento_transformadores.entity.Tecnico;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.*;

import java.math.BigDecimal;

/**
 * Essa classe define o que vai ser devolvido para visualização
 * @param id
 * @param numeroSerie
 * @param modelo
 * @param subestacao
 * @param potenciaKva
 * @param limitTempOleo
 * @param limitTempEnrol
 * @param leituraTermica
 * @param tecnicos
 */

public record TransformadorDetalhadoResponse(
        @Schema(description = "Identificador único do transformador", example = "1")
        Long id,

        @Schema(description = "Número de série do transformador", example = "TRF-2026-1001")
        String numeroSerie,

        @Schema(description = "Modelo do transformador", example = "Transformador trifásico bom")
        String modelo,

        @Schema(description = "Subestação do transformador", example = "Subestação Lateral")
        String subestacao,

        @Schema(description = "Potencia em Kwa do transformador", example = "1500")
        BigDecimal potenciaKva,

        @Schema(description = "Limite de temperatura do óleo", example = "102")
        BigDecimal limitTempOleo,

        @Schema(description = "Limite de temperatura do enrolamento", example = "104")
        BigDecimal limitTempEnrol,

        @Schema(description = "Lista de leituras do transformador")
        Set<LeituraTermica> leituraTermica,

        @Schema(description = "Lista de técnicos do transformador")
        Set<Tecnico> tecnicos
) {
}
