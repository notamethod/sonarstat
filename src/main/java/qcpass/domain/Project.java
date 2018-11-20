package qcpass.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {


    private long nbIssues;
    private String name;

    public Project() {
    }

    public Project(String name, int i) {
        this.name = name;
        this.nbIssues = i;

    }

    public long getNbIssues() {
        return nbIssues;
    }

    public void setNbIssues(long nbIssues) {
        this.nbIssues = nbIssues;
    }

    @Override
    public String toString() {
        return "Project{" +
                "nbIssues='" + nbIssues + '\'' +
                ", name=" + name +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
