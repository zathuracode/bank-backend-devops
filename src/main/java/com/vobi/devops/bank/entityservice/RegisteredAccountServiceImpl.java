package com.vobi.devops.bank.entityservice;

import com.vobi.devops.bank.domain.*;
import com.vobi.devops.bank.exception.*;
import com.vobi.devops.bank.repository.*;
import com.vobi.devops.bank.utility.Utilities;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
@Slf4j
public class RegisteredAccountServiceImpl implements RegisteredAccountService {
    @Autowired
    private RegisteredAccountRepository registeredAccountRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(RegisteredAccount registeredAccount)
        throws ConstraintViolationException {
        Set<ConstraintViolation<RegisteredAccount>> constraintViolations = validator.validate(registeredAccount);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return registeredAccountRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegisteredAccount> findAll() {
        log.debug("finding all RegisteredAccount instances");

        return registeredAccountRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public RegisteredAccount save(RegisteredAccount entity)
        throws Exception {
        log.debug("saving RegisteredAccount instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "RegisteredAccount");
        }

        validate(entity);

        if (registeredAccountRepository.existsById(entity.getReacId())) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return registeredAccountRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(RegisteredAccount entity) throws Exception {
        log.debug("deleting RegisteredAccount instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "RegisteredAccount");
        }

        if (entity.getReacId() == null) {
            throw new ZMessManager().new EmptyFieldException("reacId");
        }

        if (registeredAccountRepository.existsById(entity.getReacId()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        registeredAccountRepository.deleteById(entity.getReacId());
        log.debug("delete RegisteredAccount successful");
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Integer id) throws Exception {
        log.debug("deleting RegisteredAccount instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("reacId");
        }

        if (registeredAccountRepository.existsById(id)) {
            delete(registeredAccountRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public RegisteredAccount update(RegisteredAccount entity)
        throws Exception {
        log.debug("updating RegisteredAccount instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "RegisteredAccount");
        }

        validate(entity);

        if (registeredAccountRepository.existsById(entity.getReacId()) == false) {
            throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }

        return registeredAccountRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RegisteredAccount> findById(Integer reacId) {
        log.debug("getting RegisteredAccount instance");

        return registeredAccountRepository.findById(reacId);
    }
}