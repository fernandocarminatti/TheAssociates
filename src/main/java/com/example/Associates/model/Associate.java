package com.example.Associates.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "associates")
public class Associate {
    private final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID associateId;

    private String fullName;
    private String individualRegistry;
    private String affiliation_dad;
    private String affiliation_mom;
    private LocalDate dateOfBirth;
    private String maritalStatus;
    private String profession;
    private String address;

    public Associate(){}

    public String getFullName() {
        return fullName;
    }

    public String getIndividualRegistry() {
        return individualRegistry;
    }

    public String getAffiliation(){
        return "Dad: " + affiliation_dad + " | Mom: " + affiliation_mom;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getProfession() {
        return profession;
    }

    public String getAddress() {
        return address;
    }

    public String toString(){
        return "Associate{" +
                "fullName='" + fullName + '\'' +
                ", individualRegistry='" + individualRegistry + '\'' +
                ", affiliation_dad='" + affiliation_dad + '\'' +
                ", affiliation_mom='" + affiliation_mom + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", profession='" + profession + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class AssociateBuilder {
        private final Associate associate;

        public AssociateBuilder() {
            associate = new Associate();
        }

        public AssociateBuilder withFullName(String fullName) {
            associate.fullName = fullName;
            return this;
        }

        public AssociateBuilder withIndividualRegistry(String individualRegistry) {
            associate.individualRegistry = individualRegistry;
            return this;
        }

        public AssociateBuilder withAffiliationDad(String affiliation_dad) {
            associate.affiliation_dad = affiliation_dad;
            return this;
        }

        public AssociateBuilder withAffiliationMom(String affiliation_mom) {
            associate.affiliation_mom = affiliation_mom;
            return this;
        }

        public AssociateBuilder withDateOfBirth(LocalDate dateOfBirth) {
            associate.dateOfBirth = dateOfBirth;
            return this;
        }

        public AssociateBuilder withMaritalStatus(String maritalStatus) {
            associate.maritalStatus = maritalStatus;
            return this;
        }

        public AssociateBuilder withProfession(String profession) {
            associate.profession = profession;
            return this;
        }

        public AssociateBuilder withAddress(String address) {
            associate.address = address;
            return this;
        }

        public Associate build() {
            return associate;
        }
    }

}
