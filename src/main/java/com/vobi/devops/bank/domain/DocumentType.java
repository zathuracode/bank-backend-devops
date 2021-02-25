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
@Table ( name="document_type", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="doty_id", unique=true, nullable=false)
		@NotNull
		private Integer dotyId;
		
	
	    
						@NotNull
						@NotEmpty
			@Size(max=1)
							@Column(name="enable"  , nullable=false  )
		private String enable;	
    					@NotNull
						@NotEmpty
			@Size(max=255)
							@Column(name="name"  , nullable=false  )
		private String name;	
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="documentType")
		private List<Customer> customers = new ArrayList<>();	
        
}	