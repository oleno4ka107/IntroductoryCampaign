package model.entity;

import java.util.List;

public class Specialty {
    private Integer id;
    private String title;
    private List<Student> students;
    private List<Subject> subjects;

    public Specialty() {
    }

    public Specialty(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Specialty(String title, List<Student> students, List<Subject> subjects) {
        this.title = title;
        this.students = students;
        this.subjects = subjects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialty specialty = (Specialty) o;

        if (title != null ? !title.equals(specialty.title) : specialty.title != null) return false;
        if (students != null ? !students.equals(specialty.students) : specialty.students != null) return false;
        return subjects != null ? subjects.equals(specialty.subjects) : specialty.subjects == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
    }
}
