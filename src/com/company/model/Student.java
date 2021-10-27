package com.company.model;

public class Student extends Person {
    private double mathScore;
    private double chemistryScore;
    private double physicalScore;

    public Student(String name, int age, double mathScore, double chemistryScore, double physicalScore) {
        super(name, age);
        this.mathScore = mathScore;
        this.chemistryScore = chemistryScore;
        this.physicalScore = physicalScore;
    }

    public Student(double mathScore, double chemistryScore, double physicalScore) {
        this.mathScore = mathScore;
        this.chemistryScore = chemistryScore;
        this.physicalScore = physicalScore;
    }

    public Student() {
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(double chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    public double getPhysicalScore() {
        return physicalScore;
    }

    @Override
    public int calAverageScore() {
        return 0;
    }

    public void setPhysicalScore(double physicalScore) {
        this.physicalScore = physicalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + getId() +
                ", Name=" + getName() +
                ", Age=" + getAge() +
                ", mathScore=" + mathScore +
                ", chemistryScore=" + chemistryScore +
                ", physicalScore=" + physicalScore +
                '}';
    }
}
