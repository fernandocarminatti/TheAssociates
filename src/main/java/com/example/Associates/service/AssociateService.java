package com.example.Associates.service;

import com.example.Associates.dtos.AssociateDto;
import com.example.Associates.model.Associate;
import com.example.Associates.repository.AssociateRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssociateService {

    public AssociateRepository associateRepository;
    public Associate associate;
    public AssociateDto associateDto;

    public AssociateService(AssociateRepository associateRepository, Associate associate, AssociateDto associateDto) {
        this.associateRepository = associateRepository;
        this.associate = associate;
        this.associateDto = associateDto;
    }

    public boolean createAssociate(AssociateDto associateDto) {
        boolean foundAssociate = associateRepository.existsByIndividualRegistry(associateDto.individualRegistry());
        if(foundAssociate) {
            return false;
        }

        Associate associate = new Associate.AssociateBuilder()
                .withFullName(associateDto.fullName())
                .withIndividualRegistry(associateDto.individualRegistry())
                .withAffiliationDad(associateDto.affiliation_dad())
                .withAffiliationMom(associateDto.affiliation_mom())
                .withDateOfBirth(LocalDate.parse(associateDto.dateOfBirth()))
                .withMaritalStatus(associateDto.maritalStatus())
                .withProfession(associateDto.profession())
                .withAddress(associateDto.address())
                .build();
        associateRepository.save(associate);
        return true;
    }

    public List<Associate> findAll() {
        return associateRepository.findAll();
    }

    public Optional<Associate> findById(UUID associateId) {
        return associateRepository.findById(associateId);
    }

    public Optional<Associate> findByFullName(String fullName) {
        return associateRepository.findByFullName(fullName);
    }

    public Optional<Associate> findByIndividualRegistry(String individualRegistry) {
        return associateRepository.findByIndividualRegistry(individualRegistry);
    }

}
