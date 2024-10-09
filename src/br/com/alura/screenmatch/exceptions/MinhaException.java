package br.com.alura.screenmatch.exceptions;

public class MinhaException extends RuntimeException {
    private String mensagem;
    public MinhaException(String mensagem) {
        this.mensagem = mensagem;
    }
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
