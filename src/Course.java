public class Course {
    private int courseCounter = 0;
    private String courseName;
    private String courseCode;
    private int courseCredit;
    private int[] studentsTaking = new int[100];
    protected Lecturer Lecturer;
    private Area CourseArea;
    private boolean project = false;

    // Constructor
    public Course(String courseName, String courseCode, int courseCredit) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public void setCoursePlace() {

    }

    public String getLecturer() {
        if (Lecturer == null) {

            return "There is no lecturer for this course";
        } else {
            return Lecturer.getLNameSurname();
        }
    }

    public void setAreaForCourse(Area CourseAssigning) {
        CourseArea = CourseAssigning;
    }

    public void getArea() {
        if (CourseArea == null) {
            System.out.println("Area didn't assingn for " + courseName);
        } else {
            System.out.println(courseName + " will be taught in " + CourseArea.getAreaName());
        }

    }

    // Adding students to course list function
    public void addStudent(int ID) {
        studentsTaking[courseCounter] = ID;
    }

    // Assigning project for course by lecturer to earn extra score for students
    public void projectAssigned(Lecturer Chosen2, Course Connect2) {
        if (Connect2.project) {
            System.out.println("This lesson already have project!");
        } else {
            if (Connect2.Lecturer == Chosen2) {
                project = true;
                System.out.println("Lecturer assign a new project!");

            } else {
                System.out.println("This lecturer don't have permission to assign project!");
            }
        }
    }

    // Grading projects by lecturer
    public void gradeProject(Lecturer Lecturer2, Course Course2, Student Student2, int grade) {
        if (Course2.Lecturer == Lecturer2) {
            for (int i = 1; i <= Student2.getstCoCounter(); i++) {
                if (Student2.takenCourses[i - 1].getCourseName() == Course2.getCourseName()) {
                    Student2.courseGrade[i - 1] = Student2.courseGrade[i - 1] + grade / 10;
                }
            }

            System.out.println("Lecturer graded the project!");

        } else {
            System.out.println("This lecturer don't have permission to grade the project!");
        }
    }

}