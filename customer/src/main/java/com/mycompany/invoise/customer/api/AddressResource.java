
package com.mycompany.invoise.customer.api;

import com.mycompany.invoise.core.entity.customer.Address;
import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.customer.repository.AddressRepositoryInterface;
import com.mycompany.invoise.customer.repository.CustomerRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/address")
public class AddressResource {
    @Autowired
    private AddressRepositoryInterface addressRepository;


    @GetMapping("/{id}")
    public Address get(@PathVariable("id") Long id) {
        System.out.println("La methode get de address a été invoqué" );
       return   addressRepository.findById(id).orElseThrow(
               ()->new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public AddressRepositoryInterface getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepositoryInterface addressRepository) {
        this.addressRepository = addressRepository;
    }
}
