package problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Why Did you create this class? what does it do?
 */
public class TopVotedCandidate {
    public static void main(String[] args) {
        TopVotedCandidate candidate = new TopVotedCandidate(new int[] {
                0, 1, 1, 0, 0, 1, 0
        }, new int[] {
                0, 5, 10, 15, 20, 25, 30
        });
        System.out.println(candidate.q(3));
        System.out.println(candidate.q(12));
        System.out.println(candidate.q(25));
        System.out.println(candidate.q(15));
        System.out.println(candidate.q(24));
        System.out.println(candidate.q(8));

    }

    int[] persons;
    int[] times;
    int[] cans;
    Map<Integer, Integer> votes;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.votes = new HashMap<>();
        this.cans = new int[persons.length + 1];
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
            cans[votedPerson]++;
            if (cans[votedPerson] >= maxVote) {
                maxPerson = votedPerson;
                maxVote = cans[votedPerson];
            }
            votes.put(votedTime, maxPerson);
        }
    }
}
