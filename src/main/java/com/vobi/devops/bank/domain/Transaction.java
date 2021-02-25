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
@Table(name = "transaction", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "tran_id", unique = true, nullable = false)
    @NotNull
    private Integer tranId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acco_id")
    @NotNull
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trty_id")
    @NotNull
    private TransactionType transactionType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    @NotNull
    private Users users;
    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;
    @NotNull
    @Column(name = "date", nullable = false)
    private Date date;
}
