
public class App {
    public static void main(String[] args) throws Exception {
        // Creating student function
        Student Eda = new Student(01, "Eda Dilek", 2, "Undergraduate");
        Student Dilek = new Student(02, "Dilek Kaya", 2, "Undergraduate");
        Student Sena = new Student(03, "Sena Dilek", 2, "Undergraduate");
        // Creating course functions
        Course math = new Course("Mathemathics I", "MATH101", 6);
        Course eng = new Course("English II", "ENG102", 4);
        Course tur = new Course("Türk Dili I", "TUR201", 3);
        Course oop = new Course("Object Orianted Programming", "CENG205", 5);
        Course data = new Course("Data Structers", "CENG201", 6);
        // Creating lecturer functions
        Lecturer hüseyinTemucin = new Lecturer("Hüseyin Temuçin", 20938174);
        Lecturer oktay = new Lecturer("Oktay Yıldız", 8213445);
        Community gaziComputer = new Community("Gazi Computer Community", oktay);
        // Appointing teacher as header function
        hüseyinTemucin.appointHeader();
        // Creating personel function
        Staff elif = new Staff(112345, "Secretary", 40);
        // Assigning teacher as lecturer one of lesson
        elif.setLecturer(hüseyinTemucin, math);
        // Creating personel function
        Staff Ahmet = new Staff(112345, "Accountant", 40);
        Staff Aslı = new Staff(2341245, "Community Officer", 45);
        // Taking course functions from student class
        Eda.addCourse(math);
        Eda.addCourse(eng);
        // To grade score of one of student's course function from lecturer class
        hüseyinTemucin.toGrade(Eda, math, 45);
        elif.setLecturer(hüseyinTemucin, oop);
        elif.setLecturer(hüseyinTemucin, tur);
        elif.setLecturer(hüseyinTemucin, data);
        Eda.show();
        System.out.println("----------");
        oktay.toGrade(Eda, math, 65);
        System.out.println("----------");
        Ahmet.setLecturer(oktay, eng);
        System.out.println("----------------");
        elif.setLecturer(oktay, eng);
        System.out.println("----------");
        oktay.toGrade(Eda, eng, 70);
        Eda.show();
        System.out.println("----------");
        // Creating class function
        Area classOne = new Area("402");
        // Assigning class for course function
        math.setAreaForCourse(classOne);
        math.getArea();
        System.out.println("----------");
        eng.getArea();
        System.out.println("----------");
        Eda.addCourse(math);
        // Adding students to teacher's consulation
        oktay.addConsultation(Eda);
        oktay.addConsultation(Dilek);
        oktay.addConsultation(Sena);

        // Showing students' personal infos
        System.out.println("----------");
        System.out.println("**Students info**\n");
        System.out.println(Eda.toString());
        System.out.println("----------");
        System.out.println(Dilek.toString());
        System.out.println("----------");
        System.out.println(Sena.toString());
        System.out.println("----------");
        // Showing students that one of the teacher's consultation
        System.out.println("**Mentored students of Lecturer Oktay**\n");
        oktay.showMentoredStudents();
        Aslı.changeCounselingLecturer(hüseyinTemucin, Eda);
        elif.changeCounselingLecturer(hüseyinTemucin, Sena);
        System.out.println("----------");
        // Setting salary for staff
        Aslı.setSalary(5000);
        System.out.println("**Staff info**");
        // Showing staff's personal info
        System.out.println(Aslı.toString());
        System.out.println("----------");

        Aslı.salaryHike(Ahmet);
        System.out.println("----------");
        Ahmet.salaryHike(Aslı);
        System.out.println(Aslı.toString());
        System.out.println("----------");

        System.out.println("**Community info**");
        // Getting info about community
        gaziComputer.showCommunityInfo();

        System.out.println("----------");
        Sena.addCommunity(gaziComputer);
        Dilek.addCommunity(gaziComputer);
        Eda.addCommunity(gaziComputer);
        System.out.println("----------");
        // Showing community members

        gaziComputer.showMembers();
        Eda.show();
        math.projectAssigned(hüseyinTemucin,math);
        math.gradeProject(hüseyinTemucin,math,Eda,70);
        Eda.show();
        classOne.takeNote(classOne,math,90);
        Area classTwo = new Area("Stationary");
        classTwo.takeNote(classTwo,math,90);
        Eda.show();
    }

}