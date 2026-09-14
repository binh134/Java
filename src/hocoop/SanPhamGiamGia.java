/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hocoop;

/**
 *
 * @author Dell 3400
 */
public class SanPhamGiamGia extends SanPham {
    double phanTramGiamGia;
    SanPhamGiamGia(String t,double g,int l,double pt){
        super(t,g,l);   //gọi constructor của SanPham
        phanTramGiamGia =pt ;
    }
    double tinhTongTienSauGiamGia(){
        double tongGoc = tinhTongTien(); //dùng lại method của SanPham
        return tongGoc - (tongGoc * phamTramGiamGia /100);  
    }
}
