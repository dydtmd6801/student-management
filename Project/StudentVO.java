package Project;

public class StudentVO {
    private int student_id;
    private String name;
    private String subject;
    private int score;

    public StudentVO(int student_id, String name, String subject, int score) {
        this.student_id = student_id;
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "student_id=" + student_id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}
