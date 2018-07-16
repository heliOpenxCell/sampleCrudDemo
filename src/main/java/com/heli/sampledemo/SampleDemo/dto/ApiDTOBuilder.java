package com.heli.sampledemo.SampleDemo.dto;


import com.heli.sampledemo.SampleDemo.entity.User;

public class ApiDTOBuilder {

    public static UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getUserName(), user.getEncrytedPassword(), user.getGender(),user.getEmail(), user.getFirstName(), user.getLastName(), user.getBirthDate());
    }

    public static User userDTOToUser(UserDTO user) {
        return new User(user.getUsername(), user.getFirstName(),user.getLastName(), user.getGender(), user.getEmail(),user.getPassword(), user.getBirthDate());
    }

}
