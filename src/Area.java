public class Area {
    private String areaName;
    protected Course notes;
    private int score;

    // Constructor for Area class
    public Area(String areaName) {
        this.areaName = areaName;
    }

    // Getters and Setter for variables
    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    // Taking note from lecturer function
    public void takeNote(Area area, Course content, int score) {
        if (area.getAreaName() != "Stationary") {
            System.out.println("You are in wrong area to give notes.");
        } else {
            notes = content;
            this.score = score;
        }
    }

    // Giving notes to students function
    public int sellNote(Area cMekan, Course cCourse) {
        if (cMekan.getAreaName() != "Stationary") {
            System.out.println("You are in wrong area to buy notes.");
            return 0;
        } else if (notes == null) {
            System.out.println("There is no notes for this course");
            return 0;
        } else {
            System.out.println("You bought notes for this course. Don't study hard, study smart.");
            return score;
        }

    }

}
