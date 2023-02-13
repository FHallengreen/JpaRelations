package com.example.jparelations.config;

import com.example.jparelations.entity.Address;
import com.example.jparelations.entity.Citizen;
import com.example.jparelations.entity.Town;
import com.example.jparelations.repository.AddressRepo;
import com.example.jparelations.repository.CitizenRepo;
import com.example.jparelations.repository.TownRepo;
import com.example.jparelations.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DeveloperData implements ApplicationRunner {

    private AddressRepo addressRepo;
    private TownRepo townRepo;
    private CitizenRepo citizenRepo;
    private AddressService addressService;

    public DeveloperData(AddressRepo addressRepo, TownRepo townRepo, CitizenRepo citizenRepo, AddressService addressService) {
        this.addressRepo = addressRepo;
        this.townRepo = townRepo;
        this.citizenRepo = citizenRepo;
        this.addressService = addressService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Address a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
        Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk","123");
        Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", "234");

        Town town1 = new Town("Lyngby");
        townRepo.save(town1);

        a1.addCitizen(citizen1);
        a1.addCitizen(citizen2);

        citizen1.setTown(town1);
        citizen2.setTown(town1);

        addressRepo.save(a1);//Save the address

/*        System.out.println("------- Select statements starts here ------------");
        Address address_1 = addressRepo.findById(a1.getId()).get();
        System.out.println(address_1.getStreet());
        System.out.println("Press Enter to continue");
        System.in.read();  //This will block so you have time to read the DEBUG statements
        System.out.println("Citizens: "+ address_1.getCitizens().size());*/

        addressService.printFullAddressInfo(a1.getId(), true);

        System.out.println(citizenRepo.findByTownId(1).size());
        System.out.println(citizenRepo.findByTownName("Lyngby").size());
    }
}
