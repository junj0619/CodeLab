import java.util.*;

public class StableMarriageProblem {

    public static void main(String[] args) {
        int[][] males = new int[][] {{2, 3, 1, 4}, {1,2,3,4}, {2,1,3,4}, {1,4,2,3}};
        int[][] females = new int[][] {{1,2,3,4}, {4,3,2,1}, {2,3,4,1}, {4,1,2,3}};
        List<String> matching = getPairs(males, females);

        for (String m : matching) {
            System.out.println(m);
        }
    }

    public static List<String> getPairs(int[][] males, int[][] females) {
        List<String> pairs = new ArrayList<>();

        int len = males.length;
        Map<Integer, List<Integer>> malesPreferences = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> femalesPreferences = new HashMap<>();
        Queue<Integer> processQueue = new ArrayDeque<>();

        int[] femaleMatch = new int[len + 1];
        Arrays.fill(femaleMatch, -1);

        //Build Male Preferences base on input. Key: male, Value: a list of preferences
        for (int m = 0; m < males.length; m++) {
            List<Integer> preferences = malesPreferences.get(m);
            if (preferences == null) preferences = new LinkedList<>();
            for (int malePre : males[m]) {
                preferences.add(malePre);
            }
            malesPreferences.put(m + 1, preferences);
            processQueue.offer(m + 1);
        }

        //Build Female Preferences base on input. Key: Female, Value: {Male, Preference}
        for (int f = 0; f < females.length; f++) {
            Map<Integer, Integer> preferenceMap = femalesPreferences.get(f);
            if (preferenceMap == null) preferenceMap = new HashMap<>();
            for (int index = 0; index < females.length; index++) {
                preferenceMap.put(females[f][index] + 1, females.length - index);
            }
            femalesPreferences.put(f + 1, preferenceMap);
        }


        while (!processQueue.isEmpty()) {
            int curMale = processQueue.poll();
            int preFemale = malesPreferences.get(curMale).remove(0);

            if (femaleMatch[preFemale] == -1) {
                femaleMatch[preFemale] = curMale;
            } else {
                int curMalePre = femalesPreferences.get(preFemale).get(curMale);
                int prevMalePre = femalesPreferences.get(preFemale).get(femaleMatch[preFemale]);

                if (curMalePre > prevMalePre) {
                    femaleMatch[preFemale] = curMale;
                    malesPreferences.get(curMale).add(0, preFemale);
                    processQueue.offer(prevMalePre);
                }
            }
        }

       for (int f = 1; f < len + 1; f++) {
           pairs.add(f + " -> " + femaleMatch[f]);
       }

        return pairs;
    }
}
