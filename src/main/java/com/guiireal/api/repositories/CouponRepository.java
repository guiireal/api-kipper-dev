package com.guiireal.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guiireal.api.domain.coupon.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, UUID>{
    
}
