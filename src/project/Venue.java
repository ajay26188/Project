
package project;


public class Venue {
    private String name;
    private String location;
    
    public Venue(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation(String location) {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}

