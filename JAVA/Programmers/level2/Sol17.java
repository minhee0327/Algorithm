package programmers.level2;

//스킬트리

public class Sol17 {
    public static void main(String[] args) {
        System.out.println(new Solution17().solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}

class Solution17 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int idx;

        for (String st : skill_trees) {
            boolean flag = true;
            idx = 0;

            for (int i = 0; i < st.length(); i++) {
                char c = st.charAt(i);
                if (!skill.contains(String.valueOf(c))) continue;
                if (idx >= skill.length()) break;
                if (skill.charAt(idx) == c) {
                    idx++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}