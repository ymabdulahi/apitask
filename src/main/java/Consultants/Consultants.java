package Consultants;

import java.util.Objects;

public class Consultants {
    private Integer id;
    private String name;
    private String location;
    private String currentClient;

    public Consultants(Integer id, String name, String location, String relocate, String currentClient) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.currentClient = currentClient;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(String currentClient) {
        this.currentClient = currentClient;
    }

    @Override
    public String toString() {
        return "Consultants{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", currentClient='" + currentClient + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultants that = (Consultants) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(location, that.location) &&
                Objects.equals(currentClient, that.currentClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, currentClient);
    }
}
