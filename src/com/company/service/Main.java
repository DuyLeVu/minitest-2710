
package com.company.service;

import com.company.model.Student;
import com.company.service.impl.PersonManagerImpl;
import com.company.service.impl.StudentManagerImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> listStudent = new ArrayList<>();
        StudentManagerImpl studentManager = new StudentManagerImpl(listStudent);
        while (true) {
            displayMenuStudent();
            int choiceStudent = -1;
            while (choiceStudent < 0 || choiceStudent > 8) {
                try {
                    System.out.println("Nhập lựa chọn:");
                    choiceStudent = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Mời bạn nhập lựa chọn từ 1 đến 6");
                } finally {
                    sc.nextLine();
                }
            }
            switch (choiceStudent) {
                case 1:
                    studentManager.add(getStudent());
                    break;
                case 2:
                    System.out.print("Nhập Id cần xóa : ");
                    int idNeedToDelete = sc.nextInt();
                    sc.nextLine();
                    studentManager.delete(idNeedToDelete);
                    break;
                case 3:
                    studentManager.print();
                    break;
                case 4:
                    int idNeedToFind;
                    System.out.print("Nhập id học viên cần tìm : ");
                    idNeedToFind = sc.nextInt();
                    studentManager.findPersonById(idNeedToFind);
                    break;
                case 5:
                    System.out.print("Nhập Id học viên cần sửa thông tin: ");
                    int idNeedToUpdate = sc.nextInt();
                    sc.nextLine();
                    studentManager.update(idNeedToUpdate, getStudent());
                    break;
                case 6:
                    studentManager.maxAverageScore();
                    break;
                case 7:
                    FileStudent.writeToFile("fileStudent.csv", studentManager.getListStudent());
                    break;
                case 8:
                    studentManager.setListStudent(FileStudent.readFromFile("fileStudent.csv"));
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public static void displayMenuStudent() {
        System.out.println("==================Menu===============");
        System.out.println("1. Thêm học viên");
        System.out.println("2. Xoá học viên");
        System.out.println("3. Hiển thị danh sách học viên");
        System.out.println("4. Tìm kiếm học theo Id");
        System.out.println("5. Sửa học viên theo Id");
        System.out.println("6. Hiển thị học viên có điểm trung bình lớn nhất");
        System.out.println("7. Ghi file danh sách học sinh");
        System.out.println("8. Đọc file danh sách học sinh");
        System.out.println("0. Thoát");
    }

    public static Student getStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên học viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi học viên: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập điểm môn toán của học viên:");
        double mathScore = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập điểm môn hóa của học viên:");
        double chemistryScore = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập điểm môn lý của học viên:");
        double physicalScore = sc.nextDouble();
        sc.nextLine();
        Student student = new Student(name, age, mathScore, chemistryScore, physicalScore);
        return student;
    }
}
