package EvilTester.POJOs;

import java.util.List;

public class MyResponse {
    private List<ChallengesItems> challenges;

    public void setChallenges(List<ChallengesItems> challenges) {
        this.challenges = challenges;
    }

    public List<ChallengesItems> getChallenges() {
        return challenges;
    }

    @Override
    public String toString() {
        return
                "MyResponse{" +
                        "challenges = '" + challenges + '\'' +
                        "}";
    }
}