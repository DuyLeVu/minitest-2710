package com.company.service;

public interface GeneralManagerService<T> {
    void add(T t);

    int findIndexById(int id);

    void update(int id, T t);

    void delete(int id);

    void print();

    void findPersonById(int id);

    void sort();
}
