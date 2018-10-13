package problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Why Did you create this class? what does it do?
 */
public class TopVotedCandidate {
    int[] persons;
    int[] times;
    int[] candidates;
    Map<Integer, Integer> votes;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.votes = new HashMap<>();
        this.candidates = new int[persons.length + 1];

        preProcess();
    }

    public int q(int t) {
        Integer r = votes.get(t);
        return r != null ? r : votes.get(times[Arrays.binarySearch(times, t) * -1 - 2]);
    }

    void preProcess() {
        int maxVote = 0;
        int maxPerson = -1;
        for (int i = 0; i < times.length; i++) {
            int votedTime = times[i];
            int votedPerson = persons[i];
            candidates[votedPerson]++;
            if (candidates[votedPerson] >= maxVote) {
                maxPerson = votedPerson;
                maxVote = candidates[votedPerson];
            }
            votes.put(votedTime, maxPerson);
        }
    }
}
