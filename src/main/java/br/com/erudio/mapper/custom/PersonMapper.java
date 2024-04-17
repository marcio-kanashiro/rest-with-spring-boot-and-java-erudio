package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.models.Person;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVOV2(Person person) {
        PersonVOV2 vo = new PersonVOV2();

        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());

        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertVOV2toEntity(PersonVOV2 vo) {
        Person entity = new Person();

        entity.setId(vo.getId());
        entity.setFirstName(vo.getFirstName());
        entity.setLastName(vo.getLastName());
        entity.setAddress(vo.getAddress());
        entity.setGender(vo.getGender());

        return entity;
    }
}
