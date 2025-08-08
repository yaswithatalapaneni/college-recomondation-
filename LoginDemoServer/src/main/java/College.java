
public class College {
	private String name;
    private String location;
    private String course;
    private int ranking;

    public College() {}

    public College(String name, String location, String course, int ranking) {
        this.name = name;
        this.location = location;
        this.course = course;
        this.ranking = ranking;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }

}
