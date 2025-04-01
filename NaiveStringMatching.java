public class NaiveStringMatching {

    // Function to perform Naive String Matching
    public static void naiveStringMatch(String text, String pattern) {
        int m = pattern.length(); // Length of the pattern
        int n = text.length();    // Length of the text
        
        // Loop to go through the text
        for (int i = 0; i <= n - m; i++) {
            int j;
            
            // Check for pattern match
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break; // If there's a mismatch, break the loop
                }
            }
            
            // If the entire pattern matched, print the index
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        naiveStringMatch(text, pattern);
    }
}
