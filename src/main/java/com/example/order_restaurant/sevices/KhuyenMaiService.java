package com.example.order_restaurant.sevices;

import com.example.order_restaurant.entities.KhuyenMai;
import com.example.order_restaurant.repositories.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiService {
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    //Lấy tất cả các khuyến mại
    public List<KhuyenMai> getAll(){
        return khuyenMaiRepository.findAll();
    }

    //Lấy khuyến mại theo ID
    public Optional<KhuyenMai> getKhuyenMaiByID(int id){
        return khuyenMaiRepository.findById(id);
    }

    //Tạo mới khuyến mại
    public KhuyenMai createKhuyenMai(KhuyenMai khuyenMai){
        return khuyenMaiRepository.save(khuyenMai);
    }

    // Cập nhật khuyến mại
    public KhuyenMai updateKhuyenMai(int id, KhuyenMai khuyenMai) {
        khuyenMai.setId(id);
        return khuyenMaiRepository.save(khuyenMai);
    }

    // Xóa khuyến mại theo ID
    public void deleteKhuyenMai(int id) {
        khuyenMaiRepository.deleteById(id);
    }
}
