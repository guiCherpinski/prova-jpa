package br.com.ctw.api_monitoramento_transformadores.controller;

import br.com.ctw.api_monitoramento_transformadores.dto.*;
import br.com.ctw.api_monitoramento_transformadores.service.TransformadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * Essa é a controller da entity transformador, ela serve para redirecionar de acordo com os métodos HTTP
 */

@RestController
@RequestMapping("/api/v1/transformadores")
public class TransformadorController {

    private final TransformadorService service;

    public TransformadorController(TransformadorService service){
        this.service = service;
    }

    /**
     * Esse método serve para cadastrar um transformador
     * @param request
     * @return TransformadorTotalResponse
     */

    @Tag(
            name = "Cadastrar Transformador",
            description = "Cadastra um transformador e persiste ele no banco"
    )
    @Operation(
            summary = "Cadastrar Transformador",
            description = "Cadastra um transformador e persiste ele no banco"
    )
    @ApiResponses(value ={
            @ApiResponse(
                    responseCode = "201",
                    description = "Cadastrado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro"
            )
    })
    @PostMapping()
    public ResponseEntity<TransformadorTotalResponse> cadastrarTransformador(@RequestBody TransformadorRequest request){
        return ResponseEntity.ok(service.inserirTransformador(request));
    }


    /**
     * Esse método lista todos os transformadores cadastrados no banco de dados
     * @return List<TransformadorResponse>
     */

    @Tag(
            name = "Listar Transformadores",
            description = "Esse método lista todos os transformadores"
    )
    @Operation(
            summary = "Listar Transformadores",
            description = "Esse método lista todos os transformadores do banco de dados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200"
            )
    })
    @GetMapping()
    public ResponseEntity<List<TransformadorResponse>> listarTransformadores (){
        return ResponseEntity.ok(service.listarTransformadores());
    }

    /**
     * Esse método lista o transformador de acordo com seu número de série
     * @param numeroSerie
     * @return TransformadorDetalhadoResponse
     */

    @Tag(
            name = "Buscar Transformador",
            description = "Esse método busca o transformador pelo seu número"
    )
    @Operation(
            summary = "Buscar transformador pelo número",
            description = "Esse método busca o transformador pelo seu número de série"
    )
    @ApiResponses(value ={
            @ApiResponse(
                    responseCode = "200",
                    description = "Ok"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Não encontrado"
            )
    })
    @GetMapping("/{numeroSerie}")
    public ResponseEntity<TransformadorDetalhadoResponse> buscarTransformadorNumeroSerie(@PathVariable String numeroSerie){
        return ResponseEntity.ok(service.buscarTransformadorNumeroSerie(numeroSerie));
    }

    /**
     * Esse método atualiza os dados de temperatura de um transformador
     * @param numeroSerie
     * @param update
     * @return TransformdorResponse
     */
    @Tag(
            name = "Atualizar limites de temperatura",
            description = "Esse método atualiza os limites de temperatura do transformador"
    )
    @Operation(
            summary = "Atualiza os limites de temperatura",
            description = "Esse método serve para atualizar os limites de temperatura do transformador"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ok"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Erro"
            )
    })
    @PutMapping("/{numeroSerie}")
    public ResponseEntity<TransformadorResponse> atualizarLimitesTemperatura(@PathVariable String numeroSerie, @RequestBody @Valid TransformadorUpdate update){
        return ResponseEntity.ok(service.atualizarTemperaturas(numeroSerie,update));
    }

    /**
     * Esse método apaga um transformador pelo seu número de série
     * @param numeroSerie
     * @return Void
     */
    @Tag(
            name = "Deletar Transformador",
            description = "Esse método deleta um transformador"
    )
    @Operation(
            summary = "Deletar transformador",
            description = "Esse método deleta um transformador"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Deletado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro"
            )
    })
    @DeleteMapping("/{numeroSerie}")
    public ResponseEntity<Void> deletarTransformador (@PathVariable String numeroSerie){
        service.deletarTransformador(numeroSerie);
        return ResponseEntity.noContent().build();
    }
}