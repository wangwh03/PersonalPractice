package com.weihua.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PanlidromePair {

    public static void main(String[] args) {
        PanlidromePair test = new PanlidromePair();
        String[] words = {"lba", "lb", "l"};
        System.out.print(test.palindromePairs(words));
    }
    public boolean palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return false;
        }

        TrieNode trieHead = new TrieNode(' ', null);
        for (String word : words) {
            if (currentTrieContainsPalindromPairWithWord(reverseString(word), trieHead)) {
                return true;
            } else {
                addWord(word, trieHead);
            }
        }

        return false;
    }

    private boolean currentTrieContainsPalindromPairWithWord(String reversedWord, TrieNode trieHead) {
        TrieNode currentHead = trieHead;
        int currentIndex = 0;
        while (currentIndex < reversedWord.length() && currentHead != null) {
            TrieNode nodeWithSameValue = findChildrenNodeWithSameValue(reversedWord.charAt(currentIndex), currentHead);
            if (nodeWithSameValue != null) {
                currentIndex++;
                currentHead = nodeWithSameValue;
            } else {
                return false;
            }
        }

        if (currentIndex >= reversedWord.length()) {
            return containsPanlindromStartingFromHeadChildren(currentHead);
        } else if (currentHead == null) {
            return isPanlindrom(reversedWord, currentIndex, reversedWord.length() - 1);
        } else{
            return true;
        }
    }

    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }


    private boolean containsPanlindromStartingFromHeadChildren(TrieNode currentHead) {
        if (currentHead.getChildren().isEmpty()) {
            return true;
        }
        // Get all strings from head
        List<String> allStrings = getAllWordsFromHeadChildren(currentHead);
        // check if is panlindrom
        for (String path : allStrings) {
            if (isPanlindrom(path)) {
                return true;
            }
        }

        return false;
    }

    private List<String> getAllWordsFromHeadChildren(TrieNode currentHead) {
        List<String> result = new ArrayList<>();
        for (TrieNode child : currentHead.getChildren()) {
            List<String> childPaths = getAllWordsFromHead(child);
            result.addAll(childPaths);
        }
        return result;
    }

    private List<String> getAllWordsFromHead(TrieNode currentHead) {
        List<String> result = new ArrayList<>();
        if (currentHead == null || currentHead.getChildren().isEmpty()) {
            result.add(String.valueOf(currentHead.getValue()));
            return result;
        }

        if (currentHead.isWord) {
            result.add(String.valueOf(currentHead.value));
        }
        for (TrieNode child : currentHead.getChildren()) {
            List<String> previousResults = getAllWordsFromHead(child);
            for (String previousResult : previousResults) {
                result.add(currentHead.getValue() + previousResult);
            }
        }
        return result;
    }


    private boolean isPanlindrom(String word) {
        return isPanlindrom(word, 0, word.length()-1);
    }

    private boolean isPanlindrom(String word, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (word.charAt(startIndex) != word.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }

    private void addWord(String word, TrieNode trieHead) {
        TrieNode currentNode = trieHead;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TrieNode nodeWithSameValue = findChildrenNodeWithSameValue(currentChar, currentNode);
            if (nodeWithSameValue != null) {
                currentNode = nodeWithSameValue;
            } else {
                insertCurrentChar(word, i, currentNode);
                return;
            }
        }
        currentNode.isWord = true;
    }

    private TrieNode findChildrenNodeWithSameValue(char currentChar, TrieNode currentNode) {
        for (TrieNode child : currentNode.getChildren()) {
            if (child.value == currentChar) {
                return child;
            }
        }
        return null;
    }

    private void insertCurrentChar(String word, int startIndex, TrieNode currentNode) {
        TrieNode previousNode = new TrieNode(word.charAt(startIndex), null);
        TrieNode head = previousNode;
        for (int i = startIndex + 1; i < word.length(); i++) {
            TrieNode node = new TrieNode(word.charAt(i), null);
            previousNode.getChildren().add(node);
            previousNode = node;
        }
        previousNode.isWord = true;
        currentNode.getChildren().add(head);
    }

    public static class TrieNode {
        private char value;
        private List<TrieNode> children = new ArrayList<>();
        private boolean isWord;

        public TrieNode(char value, List<TrieNode> children) {
            this.value = value;
            if (children == null) {
                children = new ArrayList<>();
            }
            this.children = children;
        }

        public char getValue() {
            return value;
        }

        public void setValue(char value) {
            this.value = value;
        }

        public List<TrieNode> getChildren() {
            return children;
        }

        public void setChildren(List<TrieNode> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "value=" + value +
                    ", children=" + children +
                    '}';
        }
    }
}