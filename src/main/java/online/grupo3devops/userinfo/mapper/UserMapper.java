package online.grupo3devops.userinfo.mapper;

import online.grupo3devops.userinfo.dto.UserDTO;
import online.grupo3devops.userinfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapUserDTOToUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
