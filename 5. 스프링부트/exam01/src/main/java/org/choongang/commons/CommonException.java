package org.choongang.commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private HttpStatus status;

    public CommonException(String message){
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 500 고정
    }

    public CommonException(String message, HttpStatus status) { // 파라메터로 직접 설정 가능
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }

}
