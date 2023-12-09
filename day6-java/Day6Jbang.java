///usr/bin/env jbang "$0" "$@" ; exit $?
//SOURCES Input.java

//DEPS com.google.guava:guava:32.1.3-jre

import java.util.*;

public class Day6Jbang {

    public static long getDistance(long pressesTime, long raceDuration) {
        return pressesTime * (raceDuration - pressesTime);
    }

    public static List<Integer> getPressTimes(int distance, int raceDuration) {
        var result = new ArrayList<Integer>();
        // -pt^2 + rd pt - d = 0
        int a = -1;
        int b = raceDuration;
        int c = -distance;
        int delta = b * b - 4 * a * c;
        if (delta == 0) {
            double x0 = (double) -b / (double) (2 * a);
            if (x0 - (int) x0 == 0) {
                result.add((int) x0);
            }
        } else {
            double x1 = (double) (-b - Math.sqrt(delta)) / (double) (2 * a);
            if (x1 - (int) x1 == 0 && x1 > 0) {
                result.add((int) x1);
            }
            double x2 = (double) (-b + Math.sqrt(delta)) / (double) (2 * a);
            if (x2 - (int) x2 == 0 && x2 > 0) {
                result.add((int) x2);
            }
        }
        return result;
    }

    static List<Integer> conevertLineToNumbers(String line) {
        var numbrString = line.split(": ")[1].trim();
        return Arrays.stream(
                numbrString.split("\s+")).map(
                        (s) -> Integer.valueOf(s))
                .toList();
    }

    static long conevertLineToNumber(String line) {
        var numbersString = line.split(": ")[1].trim();
        var numberString = numbersString.replaceAll(" ", "");
        return Long.valueOf(numberString);
    }

    public static void main(String... args) {
        var inputString = Input.PUZZLE_INPUT;
        var lines = inputString.split("\n");
        var linesAsNumbers = Arrays.stream(lines).map((line) -> conevertLineToNumbers(line)).toList();
        var durations = linesAsNumbers.get(0);
        var recordDistances = linesAsNumbers.get(1);

        // step 1
        int recordCount = 1;
        for (int i = 0; i < durations.size(); i++) {
            int duration = durations.get(i);
            int record = recordDistances.get(i);
            // get the next possible record time
            // int nextRecord = record + 1;
            // List<Integer> pressTimes;
            // do {
            // nextRecord = record + 1;
            // pressTimes = getPressTimes(nextRecord, duration);
            // } while (pressTimes.size() == 0);
            // get the minimum time
            // var nextPressTime = pressTimes.stream().mapToInt(v -> v).min().orElseThrow();
            var nextPressTime = 1;
            int raceRecordCount = 0;
            do {
                nextPressTime += 1;
                if (getDistance(nextPressTime, duration) > record) {
                    raceRecordCount += 1;
                }
            } while (nextPressTime < duration);
            recordCount *= raceRecordCount;
        }
        System.out.println("result 1: " + recordCount);

        // step 2
        var bigDuration = conevertLineToNumber(lines[0]);
        var bigDistanceToBeat = conevertLineToNumber(lines[1]);
        var nextPressTime = 1;
        int bigRecordCount = 0;
        System.out.println("Part 2. bigDuration: " + bigDuration);
        System.out.println("Part 2. bigDistanceToBeat: " + bigDistanceToBeat);
        do {
            nextPressTime += 1;
            if (getDistance(nextPressTime, bigDuration) > bigDistanceToBeat) {
                bigRecordCount += 1;
            }
            // System.out.println("next press time: " + nextPressTime);
        } while (nextPressTime < bigDuration);
        System.out.println("result 2: " + bigRecordCount);
    }
}
