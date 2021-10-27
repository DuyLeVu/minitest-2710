
package com.company.service;

import com.company.model.Student;
import com.company.service.impl.PersonManagerImpl;
import com.company.service.impl.StudentManagerImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {Scanner sc = new Scanner(System.in);
       StudentManagerImpl personManager = new StudentManagerImpl();
       personManager.add(new Student("1",1,1,1,1));
        personManager.add(new Student("2",2,2,2,2));
        personManager.add(new Student("3",3,0,0,0));
        while (true) {
            displayMenuStudent();
            System.out.println("Nhập lựa chọn:");
            int choiceStudent = sc.nextInt();
            switch (choiceStudent) {
                case 1:
                    personManager.add(getStudent());
                    break;
                case 2:
                    System.out.print("Nhập Id cần xóa : ");
                    int idNeedToDelete = sc.nextInt();
                    sc.nextLine();
                    personManager.delete(idNeedToDelete);
                    break;
                case 3:
                   personManager.print();
                    break;
                case 4:
                    int idNeedToFind;
                    System.out.print("Nhập id học viên cần tìm : ");
                    idNeedToFind = sc.nextInt();
                    personManager.findPersonById(idNeedToFind);
                    break;
                case 5:
                    System.out.print("Nhập Id học viên cần sửa thông tin: ");
                    int idNeedToUpdate = sc.nextInt();
                    sc.nextLine();
                    personManager.update(idNeedToUpdate, getStudent());
                    break;
                case 6:
                    personManager.maxAverageScore();
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
