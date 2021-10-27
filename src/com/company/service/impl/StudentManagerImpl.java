package com.company.service.impl;

import com.company.model.Person;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManagerImpl extends PersonManagerImpl {
    private ArrayList<Person> listStudent;

    public StudentManagerImpl() {
        listStudent = getListPerson();
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
        listStudent.sort(Comparator.comparingDouble(Person::calAverageScore));
        super.print();
    }

    //    @Override
//    public void sort() {
//        listStudent.sort(Comparator.comparingInt(Person::calAverageScore));
//    }
}
