package hocoop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class QuanLyDanhBa {
    public static void main(String[]args){
          System.out.println("Thư mục làm việc hiện tại: " + System.getProperty("user.dir"));

        try {
            FileWriter writer = new FileWriter("QUANLYDANHBA.txt");
            writer.write("An,0901234567\n");
            writer.write("Binh,0912345678\n");
            writer.write("Cuong,0923456789\n");
            writer.write("Dung,0934567890\n");
            writer.close();
            System.out.println("Ghi danh ba thanh cong!");
        } catch (IOException e) {
            System.out.println("Khong the ghi file"+e.getMessage());
        }
        try {
            File file = new File("QUANLYDANHBA.txt");
            Scanner reader = new Scanner(file);
            int soLuong = 0;
            while(reader.hasNextLine()){
                String dong = reader.nextLine();
               String phanTach[] = dong.split(",");
               String ten = phanTach[0];    
               String sdt = phanTach[1]; 
               System.out.println("Tên: " + ten + " - SĐT: " + sdt);
               soLuong++; 
            }
            System.out.println("Tổng số liên hệ: " + soLuong);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("KHONG THE GHI FILE");
        }
    }
        }

}
