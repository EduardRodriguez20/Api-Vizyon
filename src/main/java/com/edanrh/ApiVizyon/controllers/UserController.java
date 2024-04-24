package com.edanrh.ApiVizyon.controllers;

import com.edanrh.ApiVizyon.dto.UserDTO;
import com.edanrh.ApiVizyon.exceptions.BussinesRuleException;
import com.edanrh.ApiVizyon.exceptions.ContentNullException;
import com.edanrh.ApiVizyon.exceptions.DuplicateCreationException;
import com.edanrh.ApiVizyon.exceptions.NotFoundException;
import com.edanrh.ApiVizyon.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO userDTO) throws DuplicateCreationException, BussinesRuleException {
        Map<String,Object> response=new HashMap<>();
        try{
            UserDTO user = userService.save(userDTO);
            response.put("message","Register successfully");
            response.put("user", user);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (DataAccessException e){
            response.put("message","Error inserting to database");
            response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@RequestParam String email) throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        try{
            UserDTO user = userService.findByEmail(email);
            response.put("user", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (DataAccessException e){
            response.put("message","Error searching to database");
            response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() throws ContentNullException {
        Map<String,Object> response=new HashMap<>();
        List<UserDTO> users = userService.findAll();
        response.put("users", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{email}")
    public ResponseEntity<?> edit(@Valid @RequestBody UserDTO userDTO, @RequestParam String email) throws NotFoundException, BussinesRuleException {
        Map<String,Object> response=new HashMap<>();
        try{
            userService.edit(email,userDTO);
            response.put("message","Edit successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (DataAccessException e){
            response.put("message","Error editing to database");
            response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteByEmail(@RequestParam String email) throws NotFoundException {
        Map<String,Object> response=new HashMap<>();
        try{
            userService.deleteByEmail(email);
            response.put("message","Delete successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (DataAccessException e){
            response.put("message","Error deleting to database");
            response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}