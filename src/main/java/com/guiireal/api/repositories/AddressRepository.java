package com.guiireal.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiireal.api.domain.address.Address;

public interface AddressRepository extends JpaRepository<Address, UUID>{
    
}
