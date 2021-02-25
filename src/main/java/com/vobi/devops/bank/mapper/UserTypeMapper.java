package com.vobi.devops.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.vobi.devops.bank.domain.UserType;
import com.vobi.devops.bank.dto.UserTypeDTO;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org/ MapStruct is a
 *         code generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface UserTypeMapper {
	public UserTypeDTO userTypeToUserTypeDTO(UserType userType);

	public UserType userTypeDTOToUserType(UserTypeDTO userTypeDTO);

	public List<UserTypeDTO> listUserTypeToListUserTypeDTO(List<UserType> userTypes);

	public List<UserType> listUserTypeDTOToListUserType(List<UserTypeDTO> userTypeDTOs);
}
