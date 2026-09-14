package br.com.ctw.api_monitoramento_transformadores.exception;

public class TransformadorNotFound extends RuntimeException {
    public TransformadorNotFound(String message) {
        super(message);
    }
}
