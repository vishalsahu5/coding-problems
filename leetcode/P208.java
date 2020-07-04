class Trie {
  class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isEnd;

    public TrieNode() {
      this.isEnd = false;
      for (int i = 0; i < 26; i++)
        this.children[i] = null;
    }
  }

  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (temp.children[index] == null) {
        temp.children[index] = new TrieNode();
      }
      temp = temp.children[index];
    }
    temp.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      temp = temp.children[word.charAt(i) - 'a'];
      if (temp == null)
        return false;
    }
    return temp.isEnd;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String word) {
    TrieNode temp = root;
    for (int i = 0; i < word.length(); i++) {
      temp = temp.children[word.charAt(i) - 'a'];
      if (temp == null)
        return false;
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */