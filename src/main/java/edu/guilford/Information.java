package edu.guilford;

public class Information {

    // attributes
    private String name;
    private String favColor;
    private String favAnimal;

    // constructor with default data
    public Information() {
        name = "John Doe";
        favColor = "Blue";
        favAnimal = "Dog";
    }

    // constructor with parameters
    public Information(String name, String favColor, String favAnimal) {
        this.name = name;
        this.favColor = favColor;
        this.favAnimal = favAnimal;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavColor() {
        return favColor;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
    }

    public String getFavAnimal() {
        return favAnimal;
    }

    public void setFavAnimal(String favAnimal) {
        this.favAnimal = favAnimal;
    }

    // toString method
    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", favColor='" + favColor + '\'' +
                ", favAnimal='" + favAnimal + '\'' +
                '}';
    }
}
