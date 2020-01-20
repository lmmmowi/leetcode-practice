// 208.实现 Trie (前缀树)[https://leetcode-cn.com/problems/implement-trie-prefix-tree/]
package main

import "fmt"

func main() {
	t := Constructor()
	fmt.Println(t.Search("apple"))
	t.Insert("apple")
	fmt.Println(t.Search("apple"))
	fmt.Println(t.Search("app"))
	fmt.Println(t.StartsWith("app"))
	t.Insert("app")
	fmt.Println(t.Search("app"))
}

type Trie struct {
	nodes  [26]*Trie
	isWord bool
}

/** Initialize your data structure here. */
func Constructor() Trie {
	return Trie{}
}

/** Inserts a word into the trie. */
func (this *Trie) Insert(word string) {
	current := this

	for i := 0; i < len(word); i++ {
		c := int(word[i] - 'a')
		if current.nodes[c] == nil {
			trie := Constructor()
			current.nodes[c] = &trie
		}
		current = current.nodes[c]
	}

	current.isWord = true
}

/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	current := this

	for i := 0; i < len(word); i++ {
		c := int(word[i] - 'a')
		if current.nodes[c] == nil {
			return false
		} else {
			current = current.nodes[c]
		}
	}
	return current.isWord
}

/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	current := this

	for i := 0; i < len(prefix); i++ {
		c := int(prefix[i] - 'a')
		if current.nodes[c] == nil {
			return false
		} else {
			current = current.nodes[c]
		}
	}
	return true
}
