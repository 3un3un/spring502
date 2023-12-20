package controllers;

import commons.CommonException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")
public class CommonController {

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model, HttpServletResponse response){ // 다양한 예외처리 가능하도록 Exception으로 변경

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
        if(e instanceof CommonException) {
            CommonException commonException = (CommonException)  e;
            status = commonException.getStatus();

        }

        response.setStatus(status.value());

        e.printStackTrace(); // 개발자가 알도록

        model.addAttribute("message", e.getMessage()); // 사용자가 알도록

        return "error/common";

    }


}
