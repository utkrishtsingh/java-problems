public class FindLongestConsecutiveString {
    public static void main(String... args) {

    }

    private static findCharStreak(String s, int n) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> charStreaks = new HashMap<>();
        StringBuilder currentStreak = new StringBuilder();

        currentStreak.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if ( char[i] !=currentStreak.charAt(0)){
                copyCharStreakToMap(currentStreak, charStreaks);
                currentStreak = new StringBuilder();
            }
            currentStreak.append(chars[i]);
        }
        copyCharStreakToMap(currentStreak, charStreaks);
    }

    private static void copyCharStreakToMap(StringBuilder currentStreak, Map<Character, Object> charStreaks) {
        if ((charStreaks.get(currentStreak.charAt(0)) != null && charStreaks.get(currentStreak.charAt(0)) < currentStreak.length())
                || (charStreaks.get(currentStreak.charAt(0)) == null)) {
            charStreaks.put(currentStreak.charAt(0), currentStreak.length());
        }
    }

    private static String getResult(Map<Character, Integer> charStreaks) {
        int maxValue = Collections.max(charStreaks.values());
        String maxKeys = charStreaks.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= maxValue)
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining(""));

        return (new StringBuilder()).append(maxValue).append(" ").append(maxKeys).toString();
    }
}
