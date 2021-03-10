package com.assignment.spring.api;

import com.assignment.spring.exception.InvalidApiKeyException;
import com.assignment.spring.exception.InvalidCityException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {


        switch (response.status()){
            case 401:
                return new InvalidApiKeyException();
            case 404:
                return new InvalidCityException();
            default:
                return new Exception(response.reason());
        }
    }

}