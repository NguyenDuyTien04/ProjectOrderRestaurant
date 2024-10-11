package com.example.order_restaurant.controller.admin;

import com.example.order_restaurant.entities.KhuyenMai;
import com.example.order_restaurant.entities.LoaiKhuyenMai;
import com.example.order_restaurant.sevices.KhuyenMaiService;
import com.example.order_restaurant.sevices.LoaiKhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/admin/khuyen-mai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService khuyenMaiService;

    @Autowired
    private LoaiKhuyenMaiService loaiKhuyenMaiService;

    @GetMapping("/list")
    public String list(Model model) {
        List<KhuyenMai> lstKhuyenMai = khuyenMaiService.getAll();
        model.addAttribute("items", lstKhuyenMai);
        return "admin/khuyen_mai/_table";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        KhuyenMai khuyenMai = new KhuyenMai();
        model.addAttribute("khuyenMai", khuyenMai);

        List<LoaiKhuyenMai> loaiKhuyenMais = loaiKhuyenMaiService.getAll();
        model.addAttribute("loaiKhuyenMais", loaiKhuyenMais);

        return "admin/khuyen_mai/_form";
    }


    @PostMapping("/create")
    public String createKhuyenMai(@ModelAttribute("khuyenMai") KhuyenMai khuyenMai) {
        LocalDate now = LocalDate.now(); // Lấy ngày hiện tại
        khuyenMai.setNgayTao(now);
        khuyenMai.setNgaySua(now);

        khuyenMaiService.createKhuyenMai(khuyenMai);
        return "redirect:/admin/khuyen-mai/create?success=true";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        KhuyenMai khuyenMai = khuyenMaiService.getKhuyenMaiByID(id).orElseThrow(() -> new IllegalArgumentException("Invalid Khuyen Mai ID:" + id));
        model.addAttribute("khuyenMai", khuyenMai);

        List<LoaiKhuyenMai> loaiKhuyenMais = loaiKhuyenMaiService.getAll();
        model.addAttribute("loaiKhuyenMais", loaiKhuyenMais);

        return "admin/khuyen_mai/_form";
    }

    @PostMapping("/edit/{id}")
    public String updateKhuyenMai(@PathVariable("id") int id, @ModelAttribute("khuyenMai") KhuyenMai khuyenMai) {
        khuyenMai.setId(id);
        khuyenMai.setNgaySua(LocalDate.now());
        khuyenMaiService.updateKhuyenMai(id, khuyenMai);
        return "redirect:/admin/khuyen-mai/list?updateSuccess=true";
    }

    @GetMapping("/delete/{id}")
    public String deleteKhuyenMai(@PathVariable("id") int id) {
        khuyenMaiService.deleteKhuyenMai(id);
        return "redirect:/admin/khuyen-mai/list?deleteSuccess=true";
    }
}
