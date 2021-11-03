package com.company.service.impl;

import com.company.model.Person;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManagerImpl extends PersonManagerImpl {
    private List<Student> listStudent;


    public StudentManagerImpl(List<Student> listStudent) {
        super();
        this.listStudent = listStudent;
    }

    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public List<Student> getListStudent() {
        return listStudent;
    }

    public void maxAverageScore() {
        double max = listStudent.get(0).calAverageScore();
        int indexOf = 0;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).calAverageScore() > max) {
                max = listStudent.get(i).calAverageScore();
                indexOf = i;
            }
        }
        System.out.println("Học viên có điểm lớn nhất: " + listStudent.get(indexOf));
    }

    @Override
    public void print() {
        printFullLine();
        System.out.printf("|%-12s|%-12s|%-12s|%-20s|%-20s|%-20s","Id","Name","Age","Math Score","Chemistry Score","Physical Score");
        System.out.println();
        printFullLine();
        for (int i=0; i<listStudent.size(); i++){
            System.out.println(listStudent.get(i));
        }
        System.out.println();
//        listStudent.sort(Comparator.comparingDouble(Person::calAverageScore));
//        super.print();
    }

    //    @Override
//    public void sort() {
//        listStudent.sort(Comparator.comparingInt(Person::calAverageScore));
//    }
}
