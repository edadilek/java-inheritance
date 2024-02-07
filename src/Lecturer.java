
public class Lecturer {

    private String lNameSurname;
    private int lIdNumber;
    private int header = 0;
    private Student[] studentsMentored = new Student[10];
    private int mentoredCounter = 0;
    protected int numberOfCourse = 0;

    // Constructor
    public Lecturer(String lNameSurname, int lIdNumber) {
        this.lNameSurname = lNameSurname;
        this.lIdNumber = lIdNumber;

    }

    // Getters and Setters
    public String getLNameSurname() {
        return lNameSurname;
    }

    public void setLNameSurname(String lNameSurname) {
        this.lNameSurname = lNameSurname;
    }

    public int getLIdNumber() {
        return this.lIdNumber;
    }

    public void setLIdNumber(int lIdNumber) {
        this.lIdNumber = lIdNumber;
    }

    // Appointing header for course
    public void appointHeader() {
        System.out.println(lNameSurname + " assigned as a header\n");
        header = 1;
    }

    // Taking header authority back from lecturer
    public void dischargeHeader() {
        header = 0;
        System.out.println(lNameSurname + "named lecturer's authority taken back");
    }

    // Grading student's course grades function
    public void toGrade(Student student, Course course, int grade) {
        // Checks if this lecturer is appointed lecturer for this course or not
        if (lNameSurname == course.getLecturer()) {
            for (int i = 1; i <= student.getstCoCounter(); i++) {
                if (student.takenCourses[i - 1].getCourseName() == course.getCourseName()) {
                    student.courseGrade[i - 1] = grade;
                }
            }
        } else {
            System.out.println("This lecturer doesn't have permission to grade for this course");
        }

    }

    // Adding new student to lecturer to consultation
    public void addConsultation(Student newStudent) {
        int checking = mentoredCheck(newStudent);
        // Checks situations if you can add this new student or not
        switch (checking) {
            // This student already getting counseling from one of teacher
            case -2:
                System.out.println(
                        newStudent.getNameSurname() + " is already getting counseling from " + getLNameSurname());
                break;
            // This teacher has reached maximum counseling student
            case -1:
                System.out.println("A lecturer can mentor a maximum of ten students");
                break;
            // Adding student to this lecturer
            case 1:
                studentsMentored[mentoredCounter] = newStudent;
                newStudent.counselingLecturer = getLNameSurname();
                mentoredCounter++;
                break;
        }
    }

    // Checking stutions for adding consultation
    public int mentoredCheck(Student newStudent) {

        if (mentoredCounter < 10) {
            for (int i = 1; i <= mentoredCounter; i++) {
                if (studentsMentored[i - 1] == newStudent) {
                    return -2;
                }
            }
        } else if (mentoredCounter > 10) {
            return -1;
        }
        return 1;
    }

    // Giving notes to stationary for students function
    public void giveNotes(Area bMekan, Course bDers, int score) {
        if (lNameSurname != bDers.getLecturer()) {
            System.out.println("This lecrutrer doesn't have permission and notes to give");
        } else {
            bMekan.takeNote(bMekan, bDers, score);
        }

    }

    // Showing mentored students function
    public void showMentoredStudents() {
        for (int i = 1; i <= mentoredCounter; i++) {
            System.out.println(i + ". student to get counseling from " + getLNameSurname() + " : " + studentsMentored[i - 1].getNameSurname());
        }
    }

    // Giving graduate certificate function
    public void graduateCertificate(Student student) {
        String graduateLevel = student.getGraduateLevel();
        // Checking header station
        if (header != 1) {
            System.out.println("This lecturer is not header, he can not give graduate certificate");
        } else {
            // Possibilities of student's graduate level, number of courses that he taked
            // and his gpa
            switch (graduateLevel) {
                case "Undergraduate":
                    if (student.getstCoCounter() >= 40) {
                        if (student.calculateGPA() >= 2.0) {
                            System.out.println("This student can take graduate certificate");
                            break;
                        } else {
                            System.out.println("This student's GPA must be at least 2.0");
                            break;
                        }
                    } else {
                        System.out.println("This student must take at least 40 courses.");
                        break;
                    }

                case "Master":
                    if (student.getstCoCounter() >= 7) {
                        if (student.calculateGPA() >= 2.5) {
                            System.out.println("This student can take graduate certificate");
                            break;
                        } else {
                            System.out.println("This student's GPA must be at least 2.5");
                            break;
                        }
                    } else {
                        System.out.println("This student must take at least 7 courses.");
                        break;
                    }
                case "Doctorate":
                    if (student.getstCoCounter() >= 8) {
                        if (student.calculateGPA() >= 3.0) {
                            System.out.println("This student can take graduate certificate");
                            break;
                        } else {
                            System.out.println("This student's GPA must be at least 3.0");
                            break;
                        }
                    } else {
                        System.out.println("This student must take at least 8 courses.");
                        break;
                    }

            }
        }
    }

}
