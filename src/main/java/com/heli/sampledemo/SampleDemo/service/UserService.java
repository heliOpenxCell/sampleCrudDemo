package com.heli.sampledemo.SampleDemo.service;

import com.heli.sampledemo.SampleDemo.dto.ApiDTOBuilder;
import com.heli.sampledemo.SampleDemo.dto.UserDTO;
import com.heli.sampledemo.SampleDemo.entity.User;
import com.heli.sampledemo.SampleDemo.repository.UserRepository;
import com.heli.sampledemo.SampleDemo.security.SHAAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

//The class provides services only. Calls DAO class's methods and provides necessary services like creating,deleting,updating and fetching data.
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDTO> getAllUsers() {

        List<User> entities =new ArrayList<>();
        userRepository.findAll().forEach(entities::add);

        List<UserDTO> users = new ArrayList<UserDTO>();//Will never use directly User Object, will be using Tranferable objects

        Iterator<User> iterator = entities.iterator();

       while(iterator.hasNext()) {
            User user = iterator.next();
            users.add(ApiDTOBuilder.userToUserDTO(user));//We are building UserDTO object.
        }
        return users;
    }
    //The purpose of the class is to provide a type-level solution for representing optional values instead of using null references.
    @Override
    public UserDTO getUserByUsername(String username) {
        if(userRepository.findById(username).isPresent()){
            User user = userRepository.findById(username).get();
            return ApiDTOBuilder.userToUserDTO(user);
        }

        return null;
    }

    @Override
    public void createUser(UserDTO user) throws NoSuchAlgorithmException {
        //Encrypting password
        String passwordToEncrypt = user.getPassword();
        user.setPassword(SHAAlgorithm.getSHA256(passwordToEncrypt));
        userRepository.save(ApiDTOBuilder.userDTOToUser(user));
    }

    @Override
    public void updateUser(UserDTO user) {
        userRepository.save(ApiDTOBuilder.userDTOToUser(user));
    }

    @Override
    public UserDTO deleteUser(String username) {
        if(userRepository.findById(username).isPresent()){
            User user = userRepository.findById(username).get();
            userRepository.delete(user);
            return ApiDTOBuilder.userToUserDTO(user);
        }
        return null;
    }

    @Override
    public boolean authenticate(String username, String password) {

        User user = userRepository.findById(username).get();

        if(user != null){
            String encryptedPass = user.getEncrytedPassword();
            System.out.println("Service fetched: "+encryptedPass);
            try {
                String encryptEnteredPassword = SHAAlgorithm.getSHA256(password);
                System.out.println("User entered encrypted: "+encryptEnteredPassword);
                if(encryptEnteredPassword.equals(encryptedPass)){
                    return true;
                }else
                    return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Username doesn't exist! Please register yourself first! :)");
        }

        return false;
    }


}
