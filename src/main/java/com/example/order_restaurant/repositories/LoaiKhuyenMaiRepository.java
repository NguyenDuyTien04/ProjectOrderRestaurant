package com.example.order_restaurant.repositories;

import com.example.order_restaurant.entities.LoaiKhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhuyenMaiRepository extends JpaRepository<LoaiKhuyenMai, Integer> {
}
