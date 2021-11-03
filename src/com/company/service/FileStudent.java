package com.company.service;

import com.company.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStudent {
    public static void writeToFile(String path, List<Student> students) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Id,Name,Age,Math Score,Chemistry Score,Physical Score\n";
        for (Student s : students) {
            str += s.getId() + "," + s.getName() + "," + s.getAge() + "," + s.getMathScore() + "," + s.getChemistryScore() + "," + s.getPhysicalScore() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Student> readFromFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = bufferedReader.readLine();
        while ((content = bufferedReader.readLine()) != null) {
            String[] values = content.split(",");
            students.add(new Student(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5])));
        }
        return students;
    }
}
