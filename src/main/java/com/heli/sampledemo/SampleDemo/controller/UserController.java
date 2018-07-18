package com.heli.sampledemo.SampleDemo.controller;

import com.heli.sampledemo.SampleDemo.dto.UserDTO;
import com.heli.sampledemo.SampleDemo.security.SHAAlgorithm;
import com.heli.sampledemo.SampleDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(name = "",value="/readall", method=RequestMethod.GET, produces="application/json" )
    public ResponseEntity<List<UserDTO>> readAll() {
        List<UserDTO> user = service.getAllUsers();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(name ="/fetchuser", value="{username}", method=RequestMethod.GET, produces="application/json" )
    public ResponseEntity<UserDTO> read(@PathVariable String username) {
        UserDTO user = service.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(name="", value="/createuser", method=RequestMethod.POST, produces="application/json" )
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        try {
            service.createUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.print(e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(name ="", value="/updateuser", method=RequestMethod.PUT, produces="application/json" )
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user) {
        try {
            service.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.print(e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="{username}", method=RequestMethod.DELETE, produces="application/json" )
    public ResponseEntity<UserDTO> delete(@PathVariable String username) {
        try {
            service.deleteUser(username);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.print(e.getStackTrace());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/welcome/{username}/{password}/", method = RequestMethod.GET, produces="application/json" )
    public boolean authenticate(@PathVariable("username") String username,
                                @PathVariable("password") String password) {
        boolean status = service.authenticate(username, password);
        return status;

    }
}