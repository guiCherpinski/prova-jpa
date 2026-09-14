package br.com.ctw.api_monitoramento_transformadores.service;

import br.com.ctw.api_monitoramento_transformadores.dto.*;
import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import br.com.ctw.api_monitoramento_transformadores.exception.TransformadorNotFound;
import br.com.ctw.api_monitoramento_transformadores.mapper.TransformadorMapper;
import br.com.ctw.api_monitoramento_transformadores.repository.TransformadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Essa é a service da entity transformador, onde acontece toda a regra de negócio
 */

@Service
public class TransformadorService {

    private final TransformadorRepository repository;
    private final TransformadorMapper mapper;

    public TransformadorService(TransformadorRepository repository, TransformadorMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Esse método é responsável por pegar os dados da request, tratá-los e retorná-los ao cliente
     * @param request
     * @return TransformadorTotalResponse
     */
    @Transactional
    public TransformadorTotalResponse inserirTransformador(TransformadorRequest request){
        Transformador entity = mapper.toEntity(request);
        repository.save(entity);
        TransformadorTotalResponse response = mapper.toResponseTotal(entity);
        return response;
    }

    /**
     * Esse método é responsável por listar todos os transformadores persistidos no banco de dados
     * @return List<TransformadorResponse>
     */
    @Transactional
    public List<TransformadorResponse> listarTransformadores(){
        List<Transformador> entitys = repository.findAll();
        List<TransformadorResponse> responses = mapper.toResponseList(entitys);
        return responses;
    }

    /**
     * Esse método é responsável por buscar um transformador pelo seu número de série e retorná-lo
     * @param numeroSerie
     * @return TransformadorDetalhadoResponse
     */
    @Transactional
    public TransformadorDetalhadoResponse buscarTransformadorNumeroSerie(String numeroSerie){
        Transformador entity = repository.findByNumeroSerie(numeroSerie).orElseThrow(() -> new TransformadorNotFound("erro - transformador não encontrado"));
        return mapper.toResponseDetalhado(entity);
    }

    /**
     * Esse método é responsável por atualizar as duas temperaturas de um transformador, buscado pelo seu id
     * @param numeroSerie
     * @param update
     * @return TransformadorResponse
     */
    @Transactional
    public TransformadorResponse atualizarTemperaturas(String numeroSerie, TransformadorUpdate update){
        Transformador entity = repository.findByNumeroSerie(numeroSerie).orElseThrow(() -> new TransformadorNotFound("erro - transformador não encontrado"));
        Transformador newEntity = mapper.toUpdate(update,entity);
        repository.save(newEntity);
        return mapper.toResponse(newEntity);
    }

    /**
     * Esse método é responsável por deletar um transformador atráves do seu número de série
     * @param numeroSerie
     */
    @Transactional
    public void deletarTransformador(String numeroSerie){
        if (numeroSerie.isBlank()){
            throw new RuntimeException("erro - número de série não pode ser núlo");
        }

        Transformador entity = repository.findByNumeroSerie(numeroSerie).orElseThrow(() -> new TransformadorNotFound("erro - transformador não encontrado"));
        repository.delete(entity);
    }
}
