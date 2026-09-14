package br.com.ctw.api_monitoramento_transformadores.mapper;

import br.com.ctw.api_monitoramento_transformadores.dto.*;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Essa é a mapper da entity Transformador
 */

@Component
public class TransformadorMapper {

    /**
     * Esse método transforma uma requisiçã num objeto
     * @param request
     * @return Transformador
     */
    public Transformador toEntity (TransformadorRequest request){
        return Transformador.builder()
                .numeroSerie(request.numeroSerie())
                .modelo(request.modelo())
                .subestacao(request.subestacao())
                .potenciaKva(request.potenciaKva())
                .limitTemOleo(request.limitTempOleo())
                .limitTempEnrol(request.limitTempEnrol())
                .alertaTermico(request.alertaTermico())
                .leituraTermica(request.leituraTermica())
                .tecnicos(request.tecnicos())
                .build();
    }

    /**
     * Esse método transforma uma entity em uma resposta simples
     * @param transformador
     * @return TransformadorResponse
     */
    public TransformadorResponse toResponse (Transformador transformador){
        return new TransformadorResponse(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimitTemOleo(),
                transformador.getLimitTempEnrol()
        );
    }

    /**
     * Esse método transforma uma lista de transformadores (entitys) em uma resposta simples
     * @param transformadores
     * @return TransformadorResponse
     */
    public List<TransformadorResponse> toResponseList(List<Transformador> transformadores){
        return transformadores.stream().map(this::toResponse).toList();
    }

    /**
     * Esse método transforma uma entity em uma resposta detalhada
     * @param transformador
     * @return TransformadorDetalhadoResponse
     */
    public TransformadorDetalhadoResponse toResponseDetalhado (Transformador transformador){
        return new TransformadorDetalhadoResponse(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimitTemOleo(),
                transformador.getLimitTempEnrol(),
                transformador.getLeituraTermica(),
                transformador.getTecnicos()
        );
    }

    /**
     * Esse método transforma uma entity em uma resposta completa com todos os atributos de transformadores
     * @param transformador
     * @return TransformadorTotalResponse
     */
    public TransformadorTotalResponse toResponseTotal (Transformador transformador) {
        return new TransformadorTotalResponse(
                transformador.getId(),
                transformador.getNumeroSerie(),
                transformador.getModelo(),
                transformador.getSubestacao(),
                transformador.getPotenciaKva(),
                transformador.getLimitTemOleo(),
                transformador.getLimitTempEnrol(),
                transformador.getAlertaTermico(),
                transformador.getLeituraTermica(),
                transformador.getTecnicos()
        );
    }

    /**
     * Esse método atualiza os dados da entity com atributos passados
     * @param update
     * @param entity
     * @return Transformador
     */
    public Transformador toUpdate (TransformadorUpdate update, Transformador entity){
        if (update.limitTempOleo() != null){
            entity.setLimitTemOleo(update.limitTempOleo());
        }

        if (update.limitTempEnrol() != null){
            entity.setLimitTempEnrol(update.limitTempEnrol());
        }

        return entity;
    }
}
