package hocoop;

public class TestSanPham {
    public static void main(String[] args) {
        SanPham sp1 = new SanPham("Ao thun", 150000, 10);
        SanPham sp2 = new SanPham("Quan jean", 350000, 5);

        sp1.hienThi();
        sp2.hienThi();

        System.out.println("Tong tien ao thun: " + sp1.tinhTongTien());
        System.out.println("Tong tien quan jean: " + sp2.tinhTongTien());
    }
}