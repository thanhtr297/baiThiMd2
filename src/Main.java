import controler.StudentManage;
import model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        StudentManage studentManage = new StudentManage(student,scanner);
        int choice = -1;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----\n" +
                    "Chọn chức năng theo số (để tiếp tục)\n" +
                    "1. Xem danh sách sinh viên \n" +
                    "2. Thêm mới\n" +
                    "3. Cập nhật\n" +
                    "4. Xóa\n" +
                    "5. Sắp xếp\n" +
                    "6. Đọc từ file\n" +
                    "7. Ghi vào file.\n" +
                    "8. Thoát\n" +
                    "Chọn chức năng: ");
            try{
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1: studentManage.display();
                        break;
                    case 2:studentManage.add();
                        break;
                    case 3:studentManage.update();
                        break;
                    case 4:studentManage.delete();
                        break;
                    case 5:studentManage.menuSort();
                        break;
                    case 6:studentManage.readFile();
                        break;
                    case 7:
                        break;
                }
            } catch (Exception o){
                System.err.println("Vui lòng nhập đúng số!");
            }
        }while (choice != 8);

    }
}
