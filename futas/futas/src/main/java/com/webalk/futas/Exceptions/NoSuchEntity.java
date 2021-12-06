package com.webalk.futas.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not founded entity")
public class NoSuchEntity extends RuntimeException{
}
