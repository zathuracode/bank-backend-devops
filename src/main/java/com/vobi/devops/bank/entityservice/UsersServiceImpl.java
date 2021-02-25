package  com.vobi.devops.bank.entityservice;


import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.vobi.devops.bank.exception.*;
import com.vobi.devops.bank.repository.*;
import com.vobi.devops.bank.utility.Utilities;

import com.vobi.devops.bank.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import lombok.extern.slf4j.Slf4j;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
@Slf4j
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Users users)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<Users>> constraintViolations =validator.validate(users);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return usersRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Users> findAll(){
		log.debug("finding all Users instances");
       	return usersRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public Users save(Users entity) throws Exception {
		log.debug("saving Users instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Users");
		}
		
		validate(entity);	
	
		if(usersRepository.existsById(entity.getUserEmail())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return usersRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(Users entity) throws Exception {
            	log.debug("deleting Users instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Users");
	    		}
    	
                                if(entity.getUserEmail()==null){
                    throw new ZMessManager().new EmptyFieldException("userEmail");
                    }
                        
            if(usersRepository.existsById(entity.getUserEmail())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getUserEmail()).ifPresent(entidad->{	            	
	                													List<Transaction> transactions = entidad.getTransactions();
							                    if(Utilities.validationsList(transactions)==true){
                       	 	throw new ZMessManager().new DeletingException("transactions");
                        }
	                	            });
                       

           
            
            usersRepository.deleteById(entity.getUserEmail());
            log.debug("delete Users successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(String id) throws Exception {            
            	log.debug("deleting Users instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("userEmail");
            	}
            	if(usersRepository.existsById(id)){
           			delete(usersRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public Users update(Users entity) throws Exception {

				log.debug("updating Users instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Users");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(usersRepository.existsById(entity.getUserEmail())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return usersRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Users> findById(String userEmail) {            
            	log.debug("getting Users instance");
            	return usersRepository.findById(userEmail);
            }
			
}
