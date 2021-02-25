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
@Table ( name="user_type", schema="public" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType implements java.io.Serializable {

	private static final long serialVersionUID = 1L;


			@Id
	    @Column(name="usty_id", unique=true, nullable=false)
		@NotNull
		private Integer ustyId;
		
	
	    
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
        
		@OneToMany(fetch=FetchType.LAZY, mappedBy="userType")
		private List<Users> userses = new ArrayList<>();	
        
}	