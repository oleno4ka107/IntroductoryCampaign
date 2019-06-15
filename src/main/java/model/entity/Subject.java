package model.entity;

import java.util.List;

public class Subject {
    private Integer id;
    private String name;
    private List<Rating> ratings;
    private List<Specialty> specialties;

    public Subject() {
    }

    public Subject(String name, List<Rating> ratings, List<Specialty> specialties) {
        this.name = name;
        this.ratings = ratings;
        this.specialties = specialties;
    }

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (ratings != null ? !ratings.equals(subject.ratings) : subject.ratings != null) return false;
        return specialties != null ? specialties.equals(subject.specialties) : subject.specialties == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
        result = 31 * result + (specialties != null ? specialties.hashCode() : 0);
        return result;
    }
}
