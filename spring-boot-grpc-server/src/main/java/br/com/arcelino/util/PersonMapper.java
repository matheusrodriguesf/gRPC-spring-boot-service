package br.com.arcelino.util;

import org.mapstruct.Mapper;
import br.com.arcelino.dto.PersonResponseDto;
import br.com.arcelino.dto.PersonValueFormDto;
import br.com.arcelino.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonResponseDto toDto(Person person);

    Person toEntity(PersonValueFormDto personValueFormDto);
}