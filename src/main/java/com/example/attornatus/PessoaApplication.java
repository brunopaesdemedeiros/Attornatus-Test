package com.example.attornatus;

import com.example.attornatus.repository.AdressRepository;
import com.example.attornatus.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PessoaApplication {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(PessoaApplication.class, args);
        PersonRepository personRepository =
                configurableApplicationContext.getBean(PersonRepository.class);
        AdressRepository adressRepository =
                configurableApplicationContext.getBean(AdressRepository.class);

       /* Adress address1 = new Address();
        address1.setAdress("Rua Doraci de Medeiros Paes");
        address1.setZipCode("88745-000");
        address1.setCity("Capivari de Baixo");
        address1.setMainAdress(true);
        address1.setNumber(88);

        Address address2 = new Address();
        address2.setAdress("Av.Felipe Schmidt");
        address2.setZipCode("88750-000");
        address2.setCity("Braço do Norte");
        address2.setMainAdress(false);
        address2.setNumber(1949);
        List<Address>enderecos1 = Arrays.asList(address1, address2);

        Address address3 = new Address();
        address3.setAdress("Rua Osvaldo Cabral");
        address3.setZipCode("88790-000");
        address3.setCity("Laguna");
        address3.setMainAdress(true);
        address3.setNumber(113);
        List<Address>enderecos2 = Arrays.asList(address3);

        Person person1 = new Person();
        person1.setName("bruno Paes de Medeiros");
        person1.setBirthDate(LocalDate.of(1989,12,18));
        person1.setAddress(enderecos1);
        personRepository.save(person1);

        Person person2 = new Person();
        person2.setName("Felipe da Silveira");
        person2.setBirthDate(LocalDate.of(1995,10,9));
        person2.setAddress(enderecos2);
        personRepository.save(person2);*/

    }




}
