// LeetCode 2114 – Maximum Number of Words Found in Sentences.

package leetCode;

public class MaximumWordsInSentences {

	public static void main(String[] args) {
		String[] sentences = {
	            "alice and bob love leetcode",
	            "i think so too",
	            "this is great thanks very much"
	        };

	        int result = mostWordsFound(sentences);

	        System.out.println("Maximum number of words in a sentence: " + result);
	    }
	
	public static int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String s : sentences) {
            int words = s.split(" ").length;
            max = Math.max(max, words);
        }
        return max;
    }
}
