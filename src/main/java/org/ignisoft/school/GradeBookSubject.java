package org.ignisoft.school;

import java.util.ArrayList;
import java.util.List;

class GradeBookSubject {

    private final SubjectName name;

    private final List<Integer> grades = new ArrayList<>();

    GradeBookSubject(SubjectName name) {
        this.name = name;
    }

    public void add(int grade) {
        grades.add(grade);
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public double avg() {
        return Calculator.calculateAvg(grades);
    }
}
