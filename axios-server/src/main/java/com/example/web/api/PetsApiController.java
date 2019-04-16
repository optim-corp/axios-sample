package com.example.web.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Pet;

@CrossOrigin
@Controller
@RequestMapping("${openapi.swaggerPetstore.base-path:/v1}")
public class PetsApiController implements PetsApi {

	@Override
	public ResponseEntity<Void> createPets() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Pet>> listPets(@Valid Integer limit) {
		return new ResponseEntity<>(
				new ArrayList<>(
						Arrays.asList(new Pet().id(1L).name("name1").tag(String.valueOf(System.currentTimeMillis())),
								new Pet().id(2L).name("name2").tag(String.valueOf(System.currentTimeMillis())),
								new Pet().id(3L).name("name3").tag(String.valueOf(System.currentTimeMillis())))),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Pet>> showPetById(String petId) {
		return new ResponseEntity<>(new ArrayList<>(Arrays.asList(new Pet().id(Long.valueOf(petId)).name("name" + petId)
				.tag(String.valueOf(System.currentTimeMillis())))), HttpStatus.OK);
	}

}
