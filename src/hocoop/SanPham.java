package hocoop;

public class SanPham {
    String tenSP;
    double gia;
    int soLuong;

    SanPham(String t, double g, int l) {
        tenSP = t;
        gia = g;
        soLuong = l;
    }

    void hienThi() {
        System.out.println("San pham: " + tenSP + ", gia: " + gia + ", so luong: " + soLuong);
    }

    double tinhTongTien() {
        return gia * soLuong;
    }
}