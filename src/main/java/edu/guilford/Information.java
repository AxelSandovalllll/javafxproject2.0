package edu.guilford;

public class Information {

    // attributes
    private String name;
    private String email;
    private String gNumber;

    // constructor with default data
    public Information() {
        name = "John Doe";
        email = "JDoe@gmail.com";
        gNumber = "G-Number";
    }

    // constructor with parameters
    public Information(String name, String email, String gNumber) {
        this.name = name;
        this.email = email;
        this.gNumber = gNumber;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getgNumber() {
        return gNumber;
    }

    public void setgNumber(String gNumber) {
        this.gNumber = gNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gNumber='" + gNumber + '\'' +
                '}';
    }
}
