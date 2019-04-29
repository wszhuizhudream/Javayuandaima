package com.wschase.springmvc.control;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author:WSChase
 * Created:2019/4/27
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Parameter Invalid")
public class RequestParamInvalidException extends RuntimeException {
}
