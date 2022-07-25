package com.example.attornatus.repository;

import com.example.attornatus.model.Adress;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static com.example.attornatus.util.AdressCreator.createToBeSavedAdress;

@DataJpaTest
@DisplayName("Tests for Adress Repository")
class AdressRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Test
    @DisplayName("Save persists creates adress")
    void saveAdress() {
        Adress adressToBesaved = createToBeSavedAdress();
        Adress adressSaved = this.adressRepository.save(adressToBesaved);

        Assertions.assertThat(adressSaved).isNotNull();
        Assertions.assertThat(adressSaved.getId()).isNotNull();
        Assertions.assertThat(adressSaved.getAdress()).isEqualTo(adressSaved.getAdress());
    }

    @Test
    @DisplayName("Update persists adress")
    void updateAdress() {
        Adress adressToBesaved = createToBeSavedAdress();
        Adress adressSaved = this.adressRepository.save(adressToBesaved);
        adressSaved.setAdress("José João Correa");
        Adress adressUpdate = this.adressRepository.save(adressSaved);

        Assertions.assertThat(adressUpdate).isNotNull();
        Assertions.assertThat(adressUpdate.getId()).isNotNull();
        Assertions.assertThat(adressUpdate.getAdress()).isEqualTo(adressSaved.getAdress());
    }

    @Test
    @DisplayName("Delete updates adress")
    void deleteAdress() {
        Adress adressToBesaved = createToBeSavedAdress();
        Adress adressSaved = this.adressRepository.save(adressToBesaved);
        this.adressRepository.delete(adressSaved);
        Optional<Adress> adressOptional = this.adressRepository.findById(adressSaved.getId());

        Assertions.assertThat(adressOptional.isEmpty());
    }

    @Test
    @DisplayName("Find by id return list of adress")
    void findByIdAdress() {
        Adress adressToBesaved = createToBeSavedAdress();
        Adress adressSaved = this.adressRepository.save(adressToBesaved);
        Optional<Adress> AdressOptional = this.adressRepository.findById(adressSaved.getId());

        Assertions.assertThat(AdressOptional.isEmpty());
    }


}