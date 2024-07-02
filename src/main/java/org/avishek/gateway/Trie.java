package org.avishek.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {
    private Node root;

    Trie() {
        root = new Node(null);
    }

    public void add(List<String> words) {
        Node pointer = root;
        for(int i=0; i < words.size(); i++) {
            String word = words.get(i);
            if(pointer.getNodes().containsKey(word)) {
                pointer = pointer.getNodes().get(word);
            } else {
                Node node = new Node(word);
                pointer.getNodes().put(word, node);
                pointer = node;
            }
            if(i == words.size() - 1) pointer.setEnd(true);
        }
    }

    public boolean check(List<String> words) {
        Node pointer = root;
        for(int i=0; i < words.size(); i++) {
            String word = words.get(i);
            if(!pointer.getNodes().containsKey(word)) return false;
            pointer = pointer.getNodes().get(word);
            if(i == words.size() - 1 && pointer.isEnd()) return true;
        }
        return false;
    }

    public void wildcardManipulation(List<String> words, List<List<String>> results) {
        Node pointer = root;
        for(int i=0; i < words.size(); i++) {
            String word = words.get(i);
            if(word.equals("*")) {
                Map<String, Node> nodes = pointer.getNodes();
                for(String wrd : nodes.keySet()) {
                    List<String> ax = new ArrayList<>();
                    ax.addAll(words.subList(0, i));
                    ax.add(wrd);
                    ax.addAll(words.subList(i+1, words.size()));
                    wildcardManipulation(ax, results);
                }
            } else {
                Map<String, Node> nodes = pointer.getNodes();
                if(!nodes.containsKey(word)) return;
                pointer = nodes.get(word);
                if(i == words.size()-1 && pointer.isEnd()) {
                    results.add(words);
                }
            }
        }
    }

}
