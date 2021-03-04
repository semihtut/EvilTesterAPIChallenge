package EvilTester.POJOs;

public class ChallengesItems {
    private String name;
    private String description;
    private boolean status;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "ChallengesItem{" +
                        "name = '" + name + '\'' +
                        ",description = '" + description + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
