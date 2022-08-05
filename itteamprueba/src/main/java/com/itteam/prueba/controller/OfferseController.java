package com.itteam.prueba.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itteam.prueba.dto.Message;
import com.itteam.prueba.dto.OfferseDto;
import com.itteam.prueba.entity.Offerse;
import com.itteam.prueba.service.OfferseService;

@RestController
@RequestMapping("/offerse")
@CrossOrigin(origins = "http://localhost:4200")
public class OfferseController {
    @Autowired
    OfferseService offerseService;

    @GetMapping("/list")
    public ResponseEntity<List<Offerse>> list(){
        List<Offerse> list = offerseService.list();
        return new ResponseEntity<List<Offerse>>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{offerse_id}")
    public ResponseEntity<Offerse> getById(@PathVariable("offerse_id") int offerse_id){
        if(!offerseService.existsById(offerse_id))
            return new ResponseEntity(new Message("Not exist" ), HttpStatus.NOT_FOUND);
        Offerse offerse = offerseService.getOne(offerse_id).get();
        return new ResponseEntity(offerse, HttpStatus.OK);
    }

	@GetMapping("/detailname/{name}")
    public ResponseEntity<Offerse> getByName(@PathVariable("name") String name){
        if(!offerseService.existsByName(name))
            return new ResponseEntity(new Message("Not exist"), HttpStatus.NOT_FOUND);
        Offerse offerse = offerseService.getByName(name).get();
        return new ResponseEntity(offerse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OfferseDto offerseDto){
        if(StringUtils.isBlank(offerseDto.getName()))
            return new ResponseEntity(new Message("The name is mandatory"), HttpStatus.BAD_REQUEST);
        if(offerseDto.getPrice_value() == null || offerseDto.getPrice_value()<0 )
            return new ResponseEntity(new Message("The price must be over 0"), HttpStatus.BAD_REQUEST);
        if(offerseService.existsByName(offerseDto.getName()))
            return new ResponseEntity(new Message("The name already exists"), HttpStatus.BAD_REQUEST);
        Offerse offerse = new Offerse(offerseDto.getPrice_value(), offerseDto.getDescription(), offerseDto.getName());
        offerseService.save(offerse);
        return new ResponseEntity(new Message("Offerse succesfully create "), HttpStatus.OK);
    }

    @PutMapping("/update/{offerse_id}")
    public ResponseEntity<?> update(@PathVariable("offerse_id")int offerse_id, @RequestBody OfferseDto offerseDto){
        if(!offerseService.existsById(offerse_id))
            return new ResponseEntity(new Message("Not exist"), HttpStatus.NOT_FOUND);
        if(offerseService.existsByName(offerseDto.getName()) && offerseService.getByName(offerseDto.getName()).get().getOfferse_id() != offerse_id)
        	return new ResponseEntity(new Message("The name already exist"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(offerseDto.getName()))
            return new ResponseEntity(new Message("The name is mandatory"), HttpStatus.BAD_REQUEST);
        if(offerseDto.getPrice_value() == null || offerseDto.getPrice_value()<0 )
            return new ResponseEntity(new Message("Th price must be over 0"), HttpStatus.BAD_REQUEST);

        Offerse offerse = offerseService.getOne(offerse_id).get();
        offerse.setName(offerseDto.getName());
        offerse.setPrice_value(offerseDto.getPrice_value());
        offerseService.save(offerse);
        return new ResponseEntity(new Message("Offers successfully update"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{offerse_id}")
    public ResponseEntity<?> delete(@PathVariable("offerse_id")int offerse_id){
        if(!offerseService.existsById(offerse_id))
            return new ResponseEntity(new Message("Not exist"), HttpStatus.NOT_FOUND);
        offerseService.delete(offerse_id);
        return new ResponseEntity(new Message("Offerse successfully deleted"), HttpStatus.OK);
    }


	
	
}
