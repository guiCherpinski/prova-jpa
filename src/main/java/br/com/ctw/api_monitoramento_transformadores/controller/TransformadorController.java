package br.com.ctw.api_monitoramento_transformadores.controller;

import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorRequest;
import br.com.ctw.api_monitoramento_transformadores.dto.TransformadorResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/api/v1/transformadores")
public class TransformadorController {

    @PostMapping()
    public ResponseEntity<TransformadorResponse> cadastrarTransformador(@RequestBody TransformadorRequest request){

    }

    @GetMapping()
    public ResponseEntity<List<TransformadorResponse>> listarTransformadores (){

    }

    @GetMapping("/{numeroSerie}")
    public ResponseEntity<TransformadorResponse> buscarTransformadorNumeroSerie(@PathVariable String numeroSerie){

    }

    @PutMapping("/{numeroSerie}")
    public ResponseEntity<TransformadorResponse> atualizarLimitesTemperatura(@PathVariable String numeroSerie, @RequestBody @Valid BigDecimal limite){

    }

    @DeleteMapping("/{numeroSerie}")
    public void deletarTransformador (@PathVariable String numeroSerie){

    }
}
