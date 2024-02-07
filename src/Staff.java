
public class Staff {
    private int sIdNumber;
    private String taskInfo;
    private int workingHours;
    private int salary;

    // Constructor
    public Staff(int sIdNumber, String taskInfo, int workingHours) {
        this.sIdNumber = sIdNumber;
        this.taskInfo = taskInfo;
        this.workingHours = workingHours;
    }

    // Getters and Setters
    public void setAreaForStaff(Area areaName) {

    }

    public String getTaskInfo() {
        return this.taskInfo;
    }

    public int getWorkingHours() {
        return this.workingHours;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    // Calculating hike function
    public void salaryHike(Staff chosenStaff) {
        // salary raise based on working hours

        if (getTaskInfo() == "Accountant") {
            // Raise rate will be determined according to working hours
            if (chosenStaff.getWorkingHours() > 60) {
                chosenStaff.setSalary(getWorkingHours() * 10 + getSalary());
            } else if (chosenStaff.getWorkingHours() <= 60 && chosenStaff.getWorkingHours() >= 40) {
                chosenStaff.setSalary(chosenStaff.getWorkingHours() * 8 + chosenStaff.getSalary());
            } else {
                chosenStaff.setSalary(chosenStaff.getWorkingHours() * 5 + chosenStaff.getSalary());
            }
        } else {
            // give an error message if the staff is not an accountant
            System.out.println("This staff does not have permission to raise the salary.");
        }
    }

    // if the staff is a secretary s/he can change the counseling lecturer

    public void changeCounselingLecturer(Lecturer chosenLecturer, Student chosenStudent) {
        if (getTaskInfo() == "Secretary") {
            chosenStudent.counselingLecturer = chosenLecturer.getLNameSurname();
        } else {
            System.out.println("This staff does not have permission to change counseling lecturer.");
        }
    }

    // Setting lecturer for course function
    public void setLecturer(Lecturer Chosen, Course Connect) {
        if (getTaskInfo() == "Secretary") {
            // Checks if this lecturer teaches 10 course.
            if (Chosen.numberOfCourse < 10) {
                Connect.Lecturer = Chosen;
                Chosen.numberOfCourse++;
            }
            // If he teaches 10 course, he can teaches no more course
            else {
                System.out.println("This lecturer already teaches 10 course, he can teach no more course. ");
            }
        } else {
            System.out.println("This staff doesn't have permission to assign lecturer for lesson");
        }

    }

    // String format
    public String toString() {
        return String.format("task info:%s\nworking hours:%d\nsalary:%d", getTaskInfo(), getWorkingHours(), getSalary());
    }
}
