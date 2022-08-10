import org.ignisoft.school.GradeBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ignisoft.school.SubjectName.BIOLOGY;
import static org.ignisoft.school.SubjectName.MATH;

class TeacherGradeBookTest {

    private GradeBook gradeBook;

    @BeforeEach
    void setUp() {
        gradeBook = new GradeBook("Tomek Przybylski");
    }


    @Test
    void addingSubjectToGradeBook() {
        gradeBook.addSubject(MATH);

        var subjects = gradeBook.getSubjects();
        assertThat(subjects).containsOnlyOnce(MATH);
    }

    @Test
    void addingDuplicatedSubjectToGradeBook() {
        gradeBook.addSubject(MATH);
        gradeBook.addSubject(MATH);

        var subjects = gradeBook.getSubjects();
        assertThat(subjects).containsOnlyOnce(MATH);
    }

    @Test
    void addGradeToSubject() {
        gradeBook.addSubject(MATH);
        gradeBook.addGradeTo(MATH, 3);

        var grades = gradeBook.getGrades(MATH);
        assertThat(grades).containsOnlyOnce(3);
    }

    @Test
    void addGradesToDifferentSubjects() {
        gradeBook.addSubject(MATH);
        gradeBook.addGradeTo(MATH, 5);

        gradeBook.addSubject(BIOLOGY);
        gradeBook.addGradeTo(BIOLOGY, 3);

        var mathGrades = gradeBook.getGrades(MATH);
        assertThat(mathGrades).containsOnlyOnce(5);

        var biologyGrades = gradeBook.getGrades(BIOLOGY);
        assertThat(biologyGrades).containsOnlyOnce(3);
    }
    
    @Test
    void averageGradeForSubject(){
        gradeBook.addSubject(MATH);
        gradeBook.addGradeTo(MATH, 5);
        gradeBook.addGradeTo(MATH, 5);
        gradeBook.addGradeTo(MATH, 5);
        
        
        double avgGrade = gradeBook.averageGradeFor(MATH);
        assertThat(avgGrade).isEqualTo(5);
        
    }

    @Test
    void averageGradeForAllSubject(){
        gradeBook.addSubject(MATH);
        gradeBook.addGradeTo(MATH, 6);

        gradeBook.addSubject(BIOLOGY);
        gradeBook.addGradeTo(BIOLOGY, 4);

        double avgGrade = gradeBook.averageGradeForAllSubjects();
        assertThat(avgGrade).isEqualTo(5);

    }
}
