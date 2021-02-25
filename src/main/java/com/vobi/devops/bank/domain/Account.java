package com.vobi.devops.bank.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/
@Entity
@Table ( name="account", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="acco_id", unique=true, nullable=false)
		@NotNull
		private String accoId;
		
	
			@ManyToOne(fetch=FetchType.LAZY)
   		@JoinColumn(name="cust_id"  	 )
		@NotNull
		private Customer customer;	
        
						@NotNull
							@Column(name="balance"  , nullable=false  )
		private Double balance;	
    					@NotNull
						@NotEmpty
			@Size(max=1)
							@Column(name="enable"  , nullable=false  )
		private String enable;	
    					@NotNull
						@NotEmpty
			@Size(max=255)
							@Column(name="password"  , nullable=false  )
		private String password;	
    					@NotNull
							@Column(name="version"  , nullable=false  )
		private Long version;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="account")
		private List<RegisteredAccount> registeredAccounts = new ArrayList<>();	
    	@OneToMany(fetch=FetchType.LAZY, mappedBy="account")
		private List<Transaction> transactions = new ArrayList<>();	
        
}	