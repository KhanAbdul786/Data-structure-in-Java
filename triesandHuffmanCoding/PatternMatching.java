//Problem statement
//Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= n <= 10^5
//Time Limit: 1 sec
//Sample Input 1 :
//4
//abc def ghi cba
//de
//Sample Output 1 :
//true
//Sample Input 2 :
//4
//abc def ghi hg
//hi
//Sample Output 2 :
//true
//Sample Input 3 :
//4
//abc def ghi hg
//hif
//Sample Output 3 :
//false

package triesandHuffmanCoding;

/*
Time complexity: O(N * M)
Space complexity: O(N * M)
where N is the number of words in the Trie and M is the average word length
*/
import java.util.ArrayList;

class TrieNode3 {
	char data;
	boolean isTerminating;
	TrieNode3 children[];
	int childCount;

	public TrieNode3(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode3[26];
		childCount = 0;
	}
}

public class PatternMatching {
	private TrieNode3 root;
	public int count;

	public PatternMatching() {
		root = new TrieNode3('\0');
	}

	public boolean search(String word) {
		return search(root, word);
	}

	private boolean search(TrieNode3 root, String word) {
		if (word.length() == 0) {
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode3 child = root.children[childIndex];
		if (child == null) {
			return false;
		}
		return search(child, word.substring(1));
	}

	private void add(TrieNode3 root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode3 child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode3(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);
	}

	public boolean patternMatching(ArrayList<String> vect, String pattern) {
		for (int i = 0; i < vect.size(); i++) {
			String word = vect.get(i);
			for (int j = 0; j < word.length(); j++) {
				add(word.substring(j));
			}
		}
		return search(pattern);
	}
}
