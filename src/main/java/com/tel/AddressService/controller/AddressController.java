package com.tel.AddressService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tel.AddressService.dto.AddressDTO;
import com.tel.AddressService.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@PostMapping("/get-address/{id}")
	public ResponseEntity<AddressDTO> getAddress(@PathVariable int id){
		
		AddressDTO addressDTO = addressService.getAddress(id);
		return ResponseEntity.status(HttpStatus.OK).body(addressDTO);
	}
	
	@PostMapping("/save-address")
	public String saveAddress(@RequestBody AddressDTO addressDTO) {
		
		addressService.saveAddress(addressDTO);
		return "Address data saved";
	}
}
