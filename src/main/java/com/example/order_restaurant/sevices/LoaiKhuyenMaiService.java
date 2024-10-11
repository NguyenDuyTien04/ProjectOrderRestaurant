package com.example.order_restaurant.sevices;

import com.example.order_restaurant.entities.LoaiKhuyenMai;
import com.example.order_restaurant.repositories.LoaiKhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiKhuyenMaiService {
    @Autowired
    private LoaiKhuyenMaiRepository repository;

    public List<LoaiKhuyenMai> getAll(){
        return repository.findAll();
    }
}
