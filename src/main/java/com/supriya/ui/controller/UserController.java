package com.supriya.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supriya.ui.model.request.UserDetailsRequestModel;
import com.supriya.ui.model.response.UserRest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users") // https://localhost:8080/users
public class UserController {

	@GetMapping
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
		return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE 
			} )
	public ResponseEntity<UserRest> getUser(@PathVariable("userId") String userId) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail("supriyaroy@gmail.com");
		returnValue.setFirstName("Supriya");
		returnValue.setLastName("Roy");

		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);

	}

	@PostMapping(consumes = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE 
			} ,produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			} )
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());

		return new ResponseEntity<UserRest>(returnValue,HttpStatus.OK);	
		}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}

}
