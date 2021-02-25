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
public class DocumentTypeServiceImpl implements DocumentTypeService{

	@Autowired
	private DocumentTypeRepository documentTypeRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(DocumentType documentType)throws ConstraintViolationException{		
		
		Set<ConstraintViolation<DocumentType>> constraintViolations =validator.validate(documentType);
		 if (!constraintViolations.isEmpty()) {			
			throw new ConstraintViolationException(constraintViolations);
		}
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return documentTypeRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<DocumentType> findAll(){
		log.debug("finding all DocumentType instances");
       	return documentTypeRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)			
    public DocumentType save(DocumentType entity) throws Exception {
		log.debug("saving DocumentType instance");
	   
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("DocumentType");
		}
		
		validate(entity);	
	
		if(documentTypeRepository.existsById(entity.getDotyId())){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return documentTypeRepository.save(entity);
	   
    }
			
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void delete(DocumentType entity) throws Exception {
            	log.debug("deleting DocumentType instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("DocumentType");
	    		}
    	
                                if(entity.getDotyId()==null){
                    throw new ZMessManager().new EmptyFieldException("dotyId");
                    }
                        
            if(documentTypeRepository.existsById(entity.getDotyId())==false){
           		throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        	} 
            
            	            findById(entity.getDotyId()).ifPresent(entidad->{	            	
	                													List<Customer> customers = entidad.getCustomers();
							                    if(Utilities.validationsList(customers)==true){
                       	 	throw new ZMessManager().new DeletingException("customers");
                        }
	                	            });
                       

           
            
            documentTypeRepository.deleteById(entity.getDotyId());
            log.debug("delete DocumentType successful");
            
           
            	
            }
            
            @Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public void deleteById(Integer id) throws Exception {            
            	log.debug("deleting DocumentType instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("dotyId");
            	}
            	if(documentTypeRepository.existsById(id)){
           			delete(documentTypeRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
            public DocumentType update(DocumentType entity) throws Exception {

				log.debug("updating DocumentType instance");
				
	           
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("DocumentType");
		    		}
		    		
	            validate(entity);
	            
	            
	            if(documentTypeRepository.existsById(entity.getDotyId())==false){
           			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        		}	            
	
	            return documentTypeRepository.save(entity);
	        
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<DocumentType> findById(Integer dotyId) {            
            	log.debug("getting DocumentType instance");
            	return documentTypeRepository.findById(dotyId);
            }
			
}
