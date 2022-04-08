package Clients;

import java.util.Objects;

public class Clients {
    private Integer id;
    private String name;
    private Sectors sector;
    private String location;
    private long numOfConsultants;

    public Clients(Integer id, String name, Sectors sector, String location, long numOfConsultants) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.location = location;
        this.numOfConsultants = numOfConsultants;
    }

    public Clients(Integer id, String name, Sectors sector, String location) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.location = location;
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

    public Sectors getSector() {
        return sector;
    }

    public void setSector(Sectors sector) {
        this.sector = sector;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getNumOfConsultants() {
        return numOfConsultants;
    }

    public void setNumOfConsultants(Integer numOfConsultants) {
        this.numOfConsultants = numOfConsultants;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sector=" + sector +
                ", location='" + location + '\'' +
                ", numOfConsultants=" + numOfConsultants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(id, clients.id) &&
                Objects.equals(name, clients.name) &&
                sector == clients.sector &&
                Objects.equals(location, clients.location) &&
                Objects.equals(numOfConsultants, clients.numOfConsultants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sector, location, numOfConsultants);
    }
}