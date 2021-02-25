package com.vobi.devops.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
*
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String address;
    @NotNull
    private Integer custId;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String email;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String enable;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String phone;
    private String token;
    private Integer dotyId_DocumentType;
}
