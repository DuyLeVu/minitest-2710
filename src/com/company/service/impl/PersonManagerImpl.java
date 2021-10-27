package com.company.service.impl;

import com.company.model.Person;
import com.company.service.GeneralManagerService;

import java.util.ArrayList;

public class PersonManagerImpl implements GeneralManagerService<Person> {
    private ArrayList<Person> listPerson;

    public PersonManagerImpl() {
        this.listPerson = new ArrayList<>();
    }

    public ArrayList<Person> getListPerson() {
        return listPerson;
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
        for (int i=0; i<listPerson.size(); i++){
            System.out.println(listPerson.get(i));
        }
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
}
