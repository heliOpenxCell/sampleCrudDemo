package com.heli.sampledemo.SampleDemo.service;


import com.heli.sampledemo.SampleDemo.dto.UserDTO;

import java.util.List;

public interface IUserService {

    public List<UserDTO> getAllUsers();

    public UserDTO       getUserByUsername(String username);

    public void          createUser(UserDTO user);

    public void          updateUser(UserDTO user);

    public UserDTO       deleteUser(String username);

}
