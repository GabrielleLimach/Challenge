package com.compasso.challengeapi.model.enuns;

public enum ExceptionResponse {


    PUT(404, "Erro ao atualizar o produto"),

    POST(404,"Erro ao inserir um novo produto"),

    DELETE(404,"Erro ao deletar o produto"),

    GET(404, "Erro ao pesquisar produto");

    private Integer    status_code;
    private String     message;

    ExceptionResponse(Integer status_code, String message){
        this.status_code    = status_code;
    }

}
