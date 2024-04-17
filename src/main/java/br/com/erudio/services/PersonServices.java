package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all persons!");
        
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating a person!");

        var entity = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    // Versionamento de endpoint
    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating a person with v2!");

        var entity = mapper.convertVOV2toEntity(person);
        var vo = mapper.convertEntityToVOV2(repository.save(entity));

        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating a person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting a person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        repository.delete(entity);
    }

}
