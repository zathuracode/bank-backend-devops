package com.vobi.devops.bank.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
*
*/
@Entity
@Table(name = "registered_account", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredAccount implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "reac_id", unique = true, nullable = false)
    @NotNull
    private Integer reacId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acco_id")
    @NotNull
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cust_id")
    @NotNull
    private Customer customer;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    @Column(name = "enable", nullable = false)
    private String enable;
}
