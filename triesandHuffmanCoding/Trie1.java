//Problem statement
//Implement the function Search for the Trie class.
//
//For a Trie, write the function for searching a word. Return true if the word is found successfully, otherwise return false.
//
//Note : main function is given for your reference which we are using internally to test the code.

package triesandHuffmanCoding;

class TrieNode1 {
	char data;
	boolean isTerminating;
	TrieNode1 children[];
	int childCount;

	public TrieNode1(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode1[26];
		childCount = 0;
	}
}

public class Trie1 {
	private TrieNode1 root;
	public int count;

	public Trie1() {
		root = new TrieNode1('\0');
	}

	public boolean search(String word) {
		return search(root, word);
	}

	private boolean search(TrieNode1 root, String word) {
		if (word.length() == 0) {
			return root.isTerminating;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode1 child = root.children[childIndex];
		if (child == null) {
			return false;
		}
		return search(child, word.substring(1));
	}

	private void add(TrieNode1 root, String word) {
		if (word.length() == 0) {
			root.isTerminating = true;
			return;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode1 child = root.children[childIndex];
		if (child == null) {
			child = new TrieNode1(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word) {
		add(root, word);
	}
}