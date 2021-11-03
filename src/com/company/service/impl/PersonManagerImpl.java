package com.company.service.impl;

import com.company.model.Person;
import com.company.service.GeneralManagerService;

import java.util.ArrayList;
import java.util.List;

public class PersonManagerImpl implements GeneralManagerService<Person> {
    private List<Person> listPerson;

    public PersonManagerImpl(List<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public PersonManagerImpl() {
    }

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(List<Person> listPerson) {
        this.listPerson = listPerson;
    }

    @Override
    public void add(Person person) {
        listPerson.add(person);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listPerson.size(); i++) {
            if (listPerson.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    @Override
    public void update(int id, Person person) {
        int index = findIndexById(id);
        if (index == -1) System.out.println("Id không có trong danh sách");
        else {
            listPerson.get(index).setName(person.getName());
            listPerson.get(index).setAge(person.getAge());
        }
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        if (index == -1) System.out.println("Id cần xóa không có trong danh sách");
        else
            listPerson.remove(index);
    }

    @Override
    public void print() {
        printFullLine();
        System.out.printf("|%-12s|%-12s|%-12s|%-20s|%-20s|%-20s","Id","Name","Age","Math Score","Chemistry Score","Physical Score");
        System.out.println();
        printFullLine();
        for (int i=0; i<listPerson.size(); i++){
            System.out.println(listPerson.get(i));
        }
        System.out.println();
    }

    @Override
    public void findPersonById(int id) {
        int index = findIndexById(id);
        if (index != -1)
            System.out.println(listPerson.get(index));
        else {
            System.out.println("Id không có trong danh sách");
        }
    }

    @Override
    public void sort() {
    }

    public void maxAverageScore() {
    }

    public static void printLine(int space) {
        for (int i = 0; i <= space; i++) {
            if (i == space) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
    }
    public static void printFullLine() {
        System.out.print("+");
        printLine(12);
        printLine(12);
        printLine(12);
        printLine(20);
        printLine(20);
        printLine(20);
        System.out.println();
    }
}
