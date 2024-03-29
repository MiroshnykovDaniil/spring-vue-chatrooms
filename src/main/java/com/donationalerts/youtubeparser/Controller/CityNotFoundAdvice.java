package com.donationalerts.youtubeparser.Controller;

import com.donationalerts.youtubeparser.exception.CityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CityNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CityNotFoundException ex) {
        return ex.getMessage();
    }
}
