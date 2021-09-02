/**
 * Tan Ming Li, Natalie
 * A0220822U
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bestrelayteam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Runner> runners = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double startTime = Double.parseDouble(input[1]);
            double subsequentTime = Double.parseDouble(input[2]);
            Runner runner = new Runner(name, startTime, subsequentTime);
            runners.add(runner);
        }

        Collections.sort(runners);
        double bestTime = 80.0; // max time is 20
        ArrayList<Runner> bestTeam = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Runner> currTeam = new ArrayList<>();
            Runner first = runners.get(i);
            currTeam.add(first);
            double currTime = first.startTime;
            for (int j = 0; j < n; j++) {
                if (currTeam.size() == 4)
                    break;
                Runner curr = runners.get(j);
                if (first != curr) {
                    currTeam.add(curr);
                    currTime += curr.subsequentTime;
                }
            }
            if (currTime < bestTime) {
                bestTime = currTime;
                bestTeam = currTeam;
            }
        }

        System.out.printf("%.2f%n", bestTime);
        for (int i = 0; i < 4; i++)
            System.out.println(bestTeam.get(i).name);
    }
}

class Runner implements Comparable<Runner> {
    String name;
    double startTime;
    double subsequentTime;

    public Runner(String n, double start, double subs) {
        this.name = n;
        this.startTime = start;
        this.subsequentTime = subs;
    }

    @Override
    public int compareTo(Runner r) {
        return Double.compare(this.subsequentTime, r.subsequentTime);
    }
}
