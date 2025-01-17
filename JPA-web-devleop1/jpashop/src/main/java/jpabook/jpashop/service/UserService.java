package jpabook.jpashop.service;

import jpabook.jpashop.dto.user.requestdto.UserCreateRequestDTO;
import jpabook.jpashop.dto.user.requestdto.UserUpdateRequestDTO;
import jpabook.jpashop.dto.user.responsedto.UserResponseDTO;

public interface UserService {

    UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO);
    UserResponseDTO getUserById(Long id);
    UserResponseDTO getUserByUsername(String username);
    UserResponseDTO updateUser(Long id, UserUpdateRequestDTO userUpdateRequestDTO);
    void deleteUser(Long id);

}
