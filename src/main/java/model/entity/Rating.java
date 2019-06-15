package model.entity;

public class Rating {

    private Integer id;
    private Integer assessment;
    private Integer subjectId;
    private Integer studentId;


    public Rating() {
    }

    public Rating(Integer assessment, Integer subjectId, Integer studentId) {
        this.assessment = assessment;
        this.subjectId = subjectId;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (assessment != null ? !assessment.equals(rating.assessment) : rating.assessment != null) return false;
        if (subjectId != null ? !subjectId.equals(rating.subjectId) : rating.subjectId != null) return false;
        return studentId != null ? studentId.equals(rating.studentId) : rating.studentId == null;
    }

    @Override
    public int hashCode() {
        int result = assessment != null ? assessment.hashCode() : 0;
        result = 31 * result + (subjectId != null ? subjectId.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", assessment=" + assessment +
                ", subjectId=" + subjectId +
                ", studentId=" + studentId +
                '}';
    }
}
