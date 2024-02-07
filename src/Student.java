import java.util.Arrays;

public class Student {

    private int ID;
    private String nameSurname;
    private int year;
    private String graduateLevel;
    protected Course[] takenCourses = new Course[100];
    protected int[] courseGrade = new int[100];
    private int stCoCounter = 0;
    protected Community[] communities = new Community[20];
    private int communityCounter = 0;
    protected String counselingLecturer;
    int totalCredit = 0;
    int totalGrade = 0;

    // Constructor
    public Student(int ID, String nameSurname, int year, String graduateLevel) {
        this.ID = ID;
        this.nameSurname = nameSurname;
        this.year = year;
        this.graduateLevel = graduateLevel;
        Arrays.fill(courseGrade, -1);
    }

    // Getter Functions
    public int getID() {
        return ID;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public int getYear() {
        return year;
    }

    public String getGraduateLevel() {
        return graduateLevel;
    }

    public String getCounselingLecturer() {
        return counselingLecturer;
    }

    public int getstCoCounter() {
        return stCoCounter;
    }
    // End of Getters and Setters

    // Adding new course for student
    public void addCourse(Course newTake) {
        int checking = courseCheck(newTake);

        switch (checking) {
            case -2:
                System.out.println("Student already takes this course");
                break;
            case -1:
                System.out.println("Student already takes this course but doesn't have grade");
                break;
            case 1:
                takenCourses[stCoCounter] = newTake;
                newTake.addStudent(ID);
                courseGrade[stCoCounter] = 0;
                stCoCounter++;
        }
    }

    // Showing student's courses that he takes and its grades
    public void show() {
        for (int i = 1; i <= stCoCounter; i++) {
            if (courseGrade[i - 1] != 0) {
                System.out
                        .println("Course taken by the student: " + takenCourses[i - 1].getCourseName() + "  --> Score: " + courseGrade[i - 1]);
            } else if (courseGrade[i - 1] == 0) {
                System.out.println("Course taken by the student: " + takenCourses[i - 1].getCourseName() + "  --> Score: There is no score. ");
            }
        }
    }

    // Checking about student's previous courses
    public int courseCheck(Course newTake) {

        if (stCoCounter != 0) {
            for (int i = 1; i <= stCoCounter; i++) {
                if (takenCourses[i - 1].getCourseName() == newTake.getCourseName() && courseGrade[i - 1] != 0) {
                    return -2;
                } else if (takenCourses[i - 1].getCourseName() == newTake.getCourseName() && courseGrade[i - 1] == 0) {
                    return -1;
                }
            }
            return 1;
        }
        return 1;
    }

    // Buying notes from stationary for extra grade
    public void buyNotes(Area aMekan, Course aDers) {
        int extrapoint = aMekan.sellNote(aMekan, aDers);
        int cc = findCourseNumber(aDers.getCourseName());
        if (cc != -1) {
            courseGrade[cc] = courseGrade[cc] + extrapoint;
        }

    }

    // Finding number of course that student's course that he take function
    public int findCourseNumber(String courseExtra) {
        for (int i = 1; i <= stCoCounter; i++) {
            if (takenCourses[i - 1].getCourseName() == courseExtra) {
                return i - 1;
            }
        }
        return -1;
    }

    // Calculating student's gpa function
    public float calculateGPA() {
        float GPA = 0;
        for (int i : courseGrade) {
            totalGrade += courseGrade[i] * takenCourses[i].getCourseCredit();
            totalCredit += takenCourses[i].getCourseCredit();
        }
        GPA = totalGrade / totalCredit;
        return GPA;
    }

    // Joining community function
    public void addCommunity(Community newCommunity) {
        int checking = communityChecking(newCommunity);
        switch (checking) {
            case -2:
                System.out.println("You can only join a maximum of 20 communities!");
            case -1:
                System.out.println("Student is already registered.");
                break;
            case 1:
                communities[communityCounter] = newCommunity;
                communityCounter++;
                newCommunity.addMember(getID());
                System.out.println(
                        newCommunity.getCommunityName() + " is added to the communities of " + getNameSurname());
                break;
        }
    }

    // Checking if student can join chosen community function
    public int communityChecking(Community newCommunity) {
        if (communityCounter != 0 && communityCounter < 20) {
            for (int i = 0; i < communityCounter; i++) { // control to not re-register
                if (communities[i] == newCommunity) {
                    return -1; // return -1 if student is already registered
                }
            }
            return 1;
        } else if (communityCounter > 20) {
            return -2; // return -2 if the student reached the max number of communities
        } else {
            return 1; // return 1 if community can be registered
        }
    }

    // String format
    public String toString() {
        return String.format(
                "Student name-surname: %s\nStudent ID:%d\nStudent year:%d\nStudent graduate level:%s\nCounseling lecturer of student:%s", getNameSurname(), getID(), getYear(), getGraduateLevel(), getCounselingLecturer());
    }

}