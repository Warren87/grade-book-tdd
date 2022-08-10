package org.ignisoft.school;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static org.ignisoft.school.Calculator.calculateAvg;

public class GradeBook {

    private final String studentName;

    private final Map<SubjectName, GradeBookSubject> gradesPerSubject = new EnumMap<>(SubjectName.class);

    public GradeBook(String studentName) {
        this.studentName = studentName;
    }

    public String getOwner() {
        return studentName;
    }

    public void addSubject(SubjectName subjectName) {
        gradesPerSubject.put(subjectName, new GradeBookSubject(subjectName));
    }

    public Set<SubjectName> getSubjects() {
        return gradesPerSubject.keySet();
    }

    public void addGradeTo(SubjectName subjectName, int grade) {
        gradesPerSubject.get(subjectName).add(grade);
    }

    public List<Integer> getGrades(SubjectName subjectName) {
        return gradesPerSubject.get(subjectName).getGrades();
    }

    public double averageGradeFor(SubjectName subjectName) {
        return gradesPerSubject.get(subjectName).avg();
    }

    public double averageGradeForAllSubjects() {
        var allAvgPerSubject = gradesPerSubject.values()
                .stream()
                .map(GradeBookSubject::avg)
                .collect(toList());

        return calculateAvg(allAvgPerSubject);
    }

}
