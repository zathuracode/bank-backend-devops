package com.vobi.devops.bank.entitycontroller;

import com.vobi.devops.bank.domain.*;
import com.vobi.devops.bank.dto.UserTypeDTO;
import com.vobi.devops.bank.entityservice.UserTypeService;
import com.vobi.devops.bank.mapper.UserTypeMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
*
*/
@RestController
@RequestMapping("/api/v1/userType")
@CrossOrigin(origins = "*")
@Slf4j
public class UserTypeRestController {
    @Autowired
    private UserTypeService userTypeService;
    @Autowired
    private UserTypeMapper userTypeMapper;

    @GetMapping(value = "/{ustyId}")
    public ResponseEntity<?> findById(@PathVariable("ustyId")
    Integer ustyId) throws Exception {
        log.debug("Request to findById() UserType");

        UserType userType = (userTypeService.findById(ustyId).isPresent() == true)
            ? userTypeService.findById(ustyId).get() : null;

        return ResponseEntity.ok()
                             .body(userTypeMapper.userTypeToUserTypeDTO(
                userType));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() throws Exception {
        log.debug("Request to findAll() UserType");

        return ResponseEntity.ok()
                             .body(userTypeMapper.listUserTypeToListUserTypeDTO(
                userTypeService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid
    @RequestBody
    UserTypeDTO userTypeDTO) throws Exception {
        log.debug("Request to save UserType: {}", userTypeDTO);

        UserType userType = userTypeMapper.userTypeDTOToUserType(userTypeDTO);
        userType = userTypeService.save(userType);

        return ResponseEntity.ok()
                             .body(userTypeMapper.userTypeToUserTypeDTO(
                userType));
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid
    @RequestBody
    UserTypeDTO userTypeDTO) throws Exception {
        log.debug("Request to update UserType: {}", userTypeDTO);

        UserType userType = userTypeMapper.userTypeDTOToUserType(userTypeDTO);
        userType = userTypeService.update(userType);

        return ResponseEntity.ok()
                             .body(userTypeMapper.userTypeToUserTypeDTO(
                userType));
    }

    @DeleteMapping(value = "/{ustyId}")
    public ResponseEntity<?> delete(@PathVariable("ustyId")
    Integer ustyId) throws Exception {
        log.debug("Request to delete UserType");

        userTypeService.deleteById(ustyId);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/count")
    public ResponseEntity<?> count() {
        return ResponseEntity.ok().body(userTypeService.count());
    }
}
