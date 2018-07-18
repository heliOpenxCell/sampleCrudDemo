package com.heli.sampledemo.SampleDemo.service;


import com.heli.sampledemo.SampleDemo.dto.UserDTO;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IUserService {

    public List<UserDTO> getAllUsers();

    public UserDTO       getUserByUsername(String username);

    public void          createUser(UserDTO user) throws NoSuchAlgorithmException;

    public void          updateUser(UserDTO user);

    public UserDTO       deleteUser(String username);

    public boolean       authenticate(String username, String password);

}
