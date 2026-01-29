package com.ponscio.taller.application.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ErrorCustom {
    private Date date;
    private String error;
    private String message;
    private int status;
}
