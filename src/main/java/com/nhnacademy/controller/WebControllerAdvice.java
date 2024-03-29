package com.nhnacademy.controller;

import com.nhnacademy.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(ValidationFailedException.class)
    public String handleValidationFailedException(Exception ex, Model model) {
        log.error("", ex);
        model.addAttribute("exception", ex);
        return "view/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        log.error("", ex);

        model.addAttribute("exception", ex);
        return "view/error";
    }
}
