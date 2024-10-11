package com.example.order_restaurant.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "KhuyenMai")
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "MaKhuyenMai")
    private String maKhuyenMai;

    @Column(name = "TenKhuyenMai")
    private String tenKhuyenMai;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "SoHoaDonDaApDung")
    private int soHoaDonDaApDung;

    @Column(name = "HinhThuc")
    private int hinhThuc;

    @Column(name = "MucGiamGia")
    private float mucGiamGia;

    @Column(name = "SoTienMin")
    private float soTienMin;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "createdAt")
    private LocalDate ngayTao;

    @Column(name = "updatedAt")
    private LocalDate ngaySua;

    @Column(name = "createdBy")
    private String nguoiTao;

    @Column(name = "updatedBy")
    private String nguoiSua;

    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "DeletedFlag")
    private int deleteFlag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loaiKhuyenMaiId", referencedColumnName = "id")
    private LoaiKhuyenMai loaiKhuyenMai;
}
