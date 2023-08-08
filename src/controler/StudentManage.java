package controler;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManage {
    private Student student;
    private final Scanner scanner;
    private final List<Student> students = new ArrayList<>();
    private final String Path = "C:\\Users\\bong\\Desktop\\baiThiThucHanh\\baiThi\\src\\file\\data.csv";
    int choice;

    public StudentManage(Student student, Scanner scanner) {
        this.student = student;
        this.scanner = scanner;
    }

    public void add() {
        System.out.println("Nhập mã sinh viên : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập điểm trung bình: ");
        double avg = Double.parseDouble(scanner.nextLine());
        student = new Student(id, name, age, gender, address, avg);
        students.add(student);
    }

    public void display() {
        if (checkEmpty()) {
            System.out.println("Danh sách sinh viên: ");
            for (Student student : students) {
                System.out.println(student);
            }
        } else {
            System.err.println("Danh sách sinh viên trống!");
        }
    }

    public void update() {
        if (checkEmpty()) {
            System.out.println("Nhập mã sinh viên muốn sửa: ");
            int check = Integer.parseInt(scanner.nextLine());
            if (checkId(check)) {
                System.out.println("Nhập mã sinh viên mới:  ");
                int id = Integer.parseInt(scanner.nextLine());
                if (!toString(id).equals("")) {
                    student.setId(id);
                }
                System.out.println("Cập nhật tên mới: ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    student.setName(name);
                }
                System.out.println("Cập nhật tuổi mới: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (toString(age).equals("")) {
                    student.setAge(age);
                }
                System.out.println("Cập nhật giới tính mới: ");
                String gender = scanner.nextLine();
                if (!gender.isEmpty()) {
                    student.setGender(gender);
                }
                System.out.println("Cập nhật địa chỉ mới: ");
                String address = scanner.nextLine();
                if (!address.isEmpty()) {
                    student.setAddress(address);
                }
                System.out.println("Cập nhật điểm trung bình: ");
                double avg = Double.parseDouble(scanner.nextLine());
                if (toString((int) avg) != "") {
                    student.setAvg(avg);
                }
                System.out.println("Cập nhật thành công!");
            } else {
                System.err.println("Mã sinh viên không có trong danh sách!");
            }
        } else {
            System.err.println("Danh sách sinh viên trống!");
        }

    }

    public void delete() {
        if (checkEmpty()) {
            System.out.println("Nhập mã sinh viên muốn xóa: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (checkId(choice)) {
                for (int i = 0; i < students.size(); i++) {
                    if (students.get(i).getId() == choice) {
                        students.remove(i);
                        System.out.println("Xoá thành công sinh viên mã số: " + choice);
                    }
                }
            }
        } else {
            System.err.println("Danh sách sinh viên trống!");
        }
    }
    public void menuSort(){
        if (checkEmpty()) {
            do {
                System.out.println("---- Sắp xếp  sinh viên theo điểm trung bình ----\n" +
                        "Chọn chức năng theo số (để tiếp tục)\n" +
                        "1. Sắp xếp điểm trung bình tăng dần\n" +
                        "2. Sắp xếp điểm trung bình giảm dần\n" +
                        "3. Thoát.\n" +
                        "Chọn chức năng: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            sortAvgUp();
                            break;
                        case 2:sortAvgDown();
                            break;
                    }
                } catch (Exception o) {
                    System.err.println("Vui lòng nhập đúng số");
                }
            } while (choice != 3);
        } else {
            System.err.println("Danh sách sinh viên trống!");
        }
    }
    public void sortAvgUp(){
        for (int i = 0; i < students.size()-1; i++) {
            for (int j = students.size()-1; j > i ; j++) {
                if (students.get(j).getAvg() < students.get(j-1).getAvg()){
                    double temp = students.get(j).getAvg();
                    students.get(j).setAvg(students.get(j-1).getAvg());
                    students.get(j-1).setAvg(temp);
                }
            }
        }
        System.out.println("Danh sách sau khi sắp xếp: ");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    public void sortAvgDown(){

    }
    public void readFile(){
        File file = new File(Path);
//        try {
//            FileInputStream fi = new FileInputStream(file);
//            ObjectInputStream oj = new ObjectInputStream(fi);
//            students = (List<students>)oj.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }

    private Object toString(int id) {
        return id;
    }

    public boolean checkId(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkEmpty() {
        return !students.isEmpty();
    }
}
