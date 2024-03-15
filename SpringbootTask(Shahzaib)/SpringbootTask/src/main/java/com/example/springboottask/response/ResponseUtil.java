package com.example.springboottask.response;


import com.example.springboottask.dto.StatusDTO;
import com.example.springboottask.dto.StatusEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseUtil {

    public static ResponseEntity<Object> returnResponse(RuntimeException exception) {
        StatusDTO statusDto = new StatusDTO();
        statusDto.setCode(StatusEnum.FAILURE);
        statusDto.setMessage(exception.getMessage().replace("com.example.springboottask.entity.Courses","Course"));
        //exception.printStackTrace();
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    public static ResponseEntity<Object> returnResponse(Exception exception) {
        StatusDTO statusDto = new StatusDTO();
        statusDto.setCode(StatusEnum.FAILURE);
        statusDto.setMessage(exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    public static ResponseEntity<Object> returnResponseWithCustomMessage(Integer code, String message, Object data) {
        StatusDTO statusDto = new StatusDTO();
        statusDto.setCode(StatusEnum.SUCCESS);
        statusDto.setMessage(message);
        statusDto.setData(data);

        return new ResponseEntity<>(statusDto, HttpStatus.valueOf(code));
    }

    public static ResponseEntity<Object> returnResponse(Object object) {
        StatusDTO statusDto = new StatusDTO();
        statusDto.setCode(StatusEnum.SUCCESS);
        statusDto.setMessage(StatusEnum.SUCCESS.getReasonPhrase());
        statusDto.setData(object);
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

    public static ResponseEntity<Object> returnResponse(StatusDTO statusDto) {
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }

}

