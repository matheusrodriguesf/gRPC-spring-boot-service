package br.com.arcelino.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arcelino.dto.PersonResponseDto;
import br.com.arcelino.dto.PersonValueFormDto;
import br.com.arcelino.repository.PersonRepository;
import br.com.arcelino.util.PersonMapper;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // @Autowired
    // private PersonMapper personMapper;

    @Transactional
    public PersonResponseDto create(PersonValueFormDto valuesForm) {
        return null;
        // var person = personMapper.toEntity(valuesForm);
        // person = personRepository.save(person);
        // return personMapper.toDto(person);
    }

    public void delete(Long id) {
        // personRepository.deleteById(id);
    }

    public PersonResponseDto findById(Long id) {
        return null;
        // var person = personRepository.findById(id);
        // if (!person.isPresent()) {
        //     throw new RuntimeException("Person not found");
        // }
        // return personMapper.toDto(person.get());
    }

    public List<PersonResponseDto> all() {
        return null;
    }
}
