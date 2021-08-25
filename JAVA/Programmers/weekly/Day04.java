package programmers.monthly;

import java.util.*;

public class Day04 {

}

class Solution4{
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        Map<String, Integer> companyScoreMap = new HashMap<>();

        for(String t: table){
            String[] tables = t.split(" ");

            String company = tables[0];
            int tableSize = tables.length;
            int languagePreference = languages.length;
            int sum = 0;

            Map<String, Integer> scoreMap = new HashMap<>();
            for(int i = 1; i < tableSize; i++){
                scoreMap.put(tables[i], tableSize -i);
            }

            for(int i = 0; i < languagePreference; i++){
                sum += scoreMap.getOrDefault(languages[i], 0) * preference[i];
            }

            companyScoreMap.put(company, sum);
        }
        List<Integer> scoreValues = new ArrayList<>(companyScoreMap.values());
        scoreValues.sort(Comparator.reverseOrder());
        int maxValue = scoreValues.get(0);

        List<String> candidates = new ArrayList<>();
        for(Map.Entry<String , Integer> entry: companyScoreMap.entrySet()){
            if(entry.getValue() == maxValue){
                candidates.add(entry.getKey());
            }
        }
        Collections.sort(candidates);
        System.out.println(candidates);

        return candidates.get(0);
    }
}