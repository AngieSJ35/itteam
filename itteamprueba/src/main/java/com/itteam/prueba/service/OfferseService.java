package com.itteam.prueba.service;

import com.itteam.prueba.entity.Offerse;
import com.itteam.prueba.repository.OfferseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferseService {

	@Autowired
    OfferseRepository offerseRepository;

    public List<Offerse> list(){
        return offerseRepository.findAll();
    }

    public Optional<Offerse> getOne(int id){
        return offerseRepository.findById(id);
    }

    public Optional<Offerse> getByName(String name){
        return offerseRepository.findByName(name);
    }

    public void  save(Offerse offerse){
        offerseRepository.save(offerse);
    }

    public void delete(int offerse_id){
        offerseRepository.deleteById(offerse_id);
    }

    public boolean existsById(int offerse_id){
        return offerseRepository.existsById(offerse_id);
    }

    public boolean existsByName(String name){
        return offerseRepository.existsByName(name);
    }
}
