package hocoop;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyLopHoc{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> danhSach = new ArrayList<>(); // mỗi phần tử dạng "Ten - Diem"
        int luaChon;

        do {
            System.out.println("\n===== QUAN LY LOP HOC =====");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim sinh vien theo ten");
            System.out.println("4. Tinh diem trung binh ca lop");
            System.out.println("5. Sinh vien co diem cao nhat");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            luaChon = -1;
            try {
                luaChon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen!");
                continue;
            }

            switch (luaChon) {
                case 1: nhapDanhSach(sc, danhSach); break;
                case 2: hienThi(danhSach); break;
                case 3: timTheoTen(sc, danhSach); break;
                case 4: tinhDiemTrungBinh(danhSach); break;
                case 5: timDiemCaoNhat(danhSach); break;
                case 0: System.out.println("Tam biet!"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (luaChon != 0);
        sc.close();
    }

    // 1. Nhap danh sach: dung try-catch de bat loi nhap diem sai
    static void nhapDanhSach(Scanner sc, ArrayList<String> ds) {
        System.out.print("Nhap so luong sinh vien can them: ");
        int n;
        try {
            n = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("So luong khong hop le!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap ten sinh vien thu " + (i + 1) + ": ");
            String ten = sc.nextLine().trim();

            double diem = -1;
            boolean hopLe = false;
            while (!hopLe) {
                System.out.print("Nhap diem (thang 10) cua " + ten + ": ");
                try {
                    diem = Double.parseDouble(sc.nextLine().trim());
                    if (diem < 0 || diem > 10) {
                        System.out.println("Diem phai nam trong khoang 0 - 10, nhap lai!");
                    } else {
                        hopLe = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Diem khong hop le (khong phai la so), nhap lai!");
                }
            }
            ds.add(ten + " - " + diem);
        }
        System.out.println("Da them " + n + " sinh vien vao danh sach.");
    }

    // 2. Hien thi toan bo danh sach
    static void hienThi(ArrayList<String> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        System.out.println("--- DANH SACH SINH VIEN ---");
        for (int i = 0; i < ds.size(); i++) {
            System.out.println((i + 1) + ". " + ds.get(i));
        }
    }

    // 3. Tim theo ten (dung split() de tach ten ra khoi chuoi)
    static void timTheoTen(Scanner sc, ArrayList<String> ds) {
        System.out.print("Nhap ten can tim: ");
        String ten = sc.nextLine().trim().toLowerCase();
        boolean thay = false;
        for (String sv : ds) {
            String[] parts = sv.split(" - ");
            if (parts[0].toLowerCase().contains(ten)) {
                System.out.println("Tim thay: " + sv);
                thay = true;
            }
        }
        if (!thay) System.out.println("Khong tim thay sinh vien nao co ten chua \"" + ten + "\"");
    }

    // 4. Tinh diem trung binh ca lop
    static void tinhDiemTrungBinh(ArrayList<String> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong, khong the tinh trung binh!");
            return;
        }
        double tong = 0;
        int demHopLe = 0;
        for (String sv : ds) {
            try {
                String[] parts = sv.split(" - ");
                double diem = Double.parseDouble(parts[1]);
                tong += diem;
                demHopLe++;
            } catch (Exception e) {
                System.out.println("Bo qua dong du lieu loi: " + sv);
            }
        }
        if (demHopLe > 0) {
            System.out.printf("Diem trung binh ca lop: %.2f%n", tong / demHopLe);
        }
    }

    // 5. Tim sinh vien co diem cao nhat (dung vong lap tim max)
    static void timDiemCaoNhat(ArrayList<String> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }
        double max = -1;
        ArrayList<String> ketQua = new ArrayList<>();
        for (String sv : ds) {
            try {
                String[] parts = sv.split(" - ");
                double diem = Double.parseDouble(parts[1]);
                if (diem > max) {
                    max = diem;
                    ketQua.clear();
                    ketQua.add(sv);
                } else if (diem == max) {
                    ketQua.add(sv);
                }
            } catch (Exception e) {
                // bo qua dong du lieu bi loi
            }
        }
        System.out.println("Sinh vien co diem cao nhat (" + max + "):");
        for (String sv : ketQua) System.out.println(" - " + sv);
    }
}