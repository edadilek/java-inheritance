
public class Community {
    private String communityName;
    private Lecturer communityLecturer;
    private int[] communityMembers = new int[100];
    private int memberCount = 0;

    // Constructor
    Community(String communityName, Lecturer communityLecturer) {
        this.communityName = communityName;
        this.communityLecturer = communityLecturer;
    }

    // Getter-Setters
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityName() {
        return this.communityName;
    }

    public void setCommunityLecturer(Lecturer communityLecturer) {
        this.communityLecturer = communityLecturer;
    }

    public Lecturer getCommunityLecturer() {
        return this.communityLecturer;
    }

    // showing community information
    public void showCommunityInfo() {
        System.out.println("Community name : " + getCommunityName() + "\nCommunity lecturer : " + getCommunityLecturer().getLNameSurname());
    }

    // Adding member to community function
    public void addMember(int studentID) {
        communityMembers[memberCount] = studentID;
        memberCount++;
    }

    // showing community members
    public void showMembers() {
        if (memberCount != 0 && memberCount < 100) {
            for (int i = 0; i < memberCount; i++) {
                System.out.println("ID of " + (i + 1) + ". member in the " + getCommunityName() + " : " + communityMembers[i]);
            }
        }
    }

}