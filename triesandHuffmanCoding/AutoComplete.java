//Problem statement
//Given n number of words and an incomplete word w. You need to auto-complete that word w.
//
//That means, find and print all the possible words which can be formed using the incomplete word w.
//
//Note : Order of words does not matter.
//
//Detailed explanation ( Input/output format, Notes, Images )
//Constraints:
//0 <= n <= 10^5
//Time Limit: 1 sec
//Sample Input 1 :
//7
//do dont no not note notes den
//no
//Sample Output 1 :
//no
//not
//note
//notes
//Sample Input 2 :
//7
//do dont no not note notes den
//de
//Sample Output 2 :
//den
//Sample Input 3 :
//7
//do dont no not note notes den
//nom

package triesandHuffmanCoding;

/*
Time complexity: O(N * M)
Space complexity: O(N * M)
where N is the number of words in the Trie and M is the average word length
*/
import java.util.ArrayList;

class TrieNode16 {
	char data;
	boolean isTerminating;
	TrieNode16 children[];
	int childCount;

	public TrieNode16(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode16[26];
		childCount = 0;
	}
}

public class AutoComplete {
	private TrieNode16 root;
	public int count;

	public AutoComplete() {
		root = new TrieNode16('\0');
	}

	private void add(TrieNode16 root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode16 child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode16(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);
	}

	public TrieNode16 findRoot(TrieNode16 root, String word) {
		if (word.length() == 0) {
			return root;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode16 child = root.children[childIndex];
		if (child == null) {
			return null;
		}
		return findRoot(child, word.substring(1));
	}

	public void autoComplete(ArrayList<String> input, String word) {
		for (String w : input) {
			add(w);

		}
		TrieNode16 node = findRoot(root, word);
		if (node == null || node.childCount == 0) {
			return;
		}
		String output = "";
		allRootToLeafPaths(node, output, word);
	}

	private void allRootToLeafPaths(TrieNode16 node, String output, String word) {
		if (node.childCount == 0) {
			if (output.length() > 0) {
				System.out.println(word + output);
			}
			return;
		}
		if (node.isTerminating == true) {
			System.out.println(word + output);
		}
		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				String ans = output + node.children[i].data;
				allRootToLeafPaths(node.children[i], ans, word);
			}
		}
	}
}