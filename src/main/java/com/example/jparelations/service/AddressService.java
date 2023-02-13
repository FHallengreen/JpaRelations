package com.example.jparelations.service;

import com.example.jparelations.entity.Address;
import com.example.jparelations.repository.AddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepo AddressRepo;

    @Transactional
    public void printFullAddressInfo(int id, boolean includeCitizens) {
        Address address_1 = AddressRepo.findById(id).get();
        System.out.println(address_1.getStreet());
        if (includeCitizens) {
            System.out.println("Citizens: " + address_1.getCitizens().size());
        }
    }
}
