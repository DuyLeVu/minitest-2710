package com.company.service.impl;

import com.company.model.Person;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentManagerImpl extends PersonManagerImpl {
    private ArrayList<Person> listStudent;

    public StudentManagerImpl() {
        listStudent = getListPerson();
    }

    public double calAverageScore() {
        double averageScore = 0;
        for (int i = 0; i < listStudent.size(); i++) {
            averageScore = (listStudent.get(i).getMathScore() + listStudent.get(i).getChemistryScore() + listStudent.get(i).getPhysicalScore()) / 3;
        }
        return averageScore;
    }

    public void maxAverageScore() {
        double max = listStudent.get(0).calAverageScore();
        int indexOf = -1;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).calAverageScore() > max) {
                max = listStudent.get(i).calAverageScore();
                indexOf = i;
            }
        }
        System.out.println("Học viên có điểm lớn nhất: " + listStudent.get(indexOf));
    }

    public void printStudent() {
        listStudent.sort((s1,s2) -> s1.calAverageScore() - s2.calAverageScore());
        for (int i=0; i<listStudent.size(); i++){
            System.out.println(listStudent.get(i));
        }
    }

//    @Override
//    public void sort() {
//        listStudent.sort(Comparator.comparingInt(Person::calAverageScore));
//    }
}
