package com.vobi.devops.bank.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vobi.devops.bank.domain.Users;
import com.vobi.devops.bank.dto.UsersDTO;

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
public interface UsersMapper {
	@Mapping(source = "userType.ustyId", target = "ustyId_UserType")
	public UsersDTO usersToUsersDTO(Users users);

	@Mapping(source = "ustyId_UserType", target = "userType.ustyId")
	public Users usersDTOToUsers(UsersDTO usersDTO);

	public List<UsersDTO> listUsersToListUsersDTO(List<Users> userss);

	public List<Users> listUsersDTOToListUsers(List<UsersDTO> usersDTOs);
}
