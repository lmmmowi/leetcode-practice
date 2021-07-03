// 1206. 设计跳表[https://leetcode-cn.com/problems/design-skiplist/]
package main

import (
	"math/rand"
	"time"
)

func main() {
	var ok bool

	skiplist := Constructor()

	skiplist.Add(0)
	skiplist.Add(5)
	skiplist.Add(2)
	skiplist.Add(1)
	skiplist.Add(0)
	ok = skiplist.Search(2)
	println(ok)
	ok = skiplist.Search(4)
	println(ok)
	ok = skiplist.Search(1)
	println(ok)
	ok = skiplist.Search(3)
	println(ok)
	ok = skiplist.Erase(2)
	println(ok)
	ok = skiplist.Search(2)
	println(ok)
	//ok = skiplist.Erase(2)
	//println(ok)
}

const (
	maxLevel           = 32
	randomLevelPercent = 75
)

type Skiplist struct {
	head   *Node
	level  int
	random *rand.Rand
}

type Node struct {
	val      int
	level    int
	forwards []*Node
}

func Constructor() Skiplist {
	head := &Node{-1, maxLevel, make([]*Node, maxLevel)}
	random := rand.New(rand.NewSource(time.Now().UnixNano()))
	return Skiplist{head, 0, random}
}

func (this *Skiplist) Search(target int) bool {
	node := this.head
	for i := this.level - 1; i >= 0; i-- {
		for ; node.forwards[i] != nil && node.forwards[i].val < target; {
			node = node.forwards[i]
		}
	}

	return node.forwards[0] != nil && node.forwards[0].val == target
}

func (this *Skiplist) Add(num int) {
	level := this.randomLevel()

	updates := make([]*Node, level)
	for i := range updates {
		node := this.head
		for ; node.forwards[i] != nil && node.forwards[i].val < num; {
			node = node.forwards[i]
		}
		updates[i] = node
	}

	node := &Node{num, level, make([]*Node, level)}
	for i := 0; i < level; i++ {
		node.forwards[i] = updates[i].forwards[i]
		updates[i].forwards[i] = node
	}

	if level > this.level {
		this.level = level
	}
}

func (this *Skiplist) Erase(num int) bool {
	updates := make([]*Node, this.level)
	node := this.head
	for i := this.level - 1; i >= 0; i-- {
		for ; node.forwards[i] != nil && node.forwards[i].val < num; {
			node = node.forwards[i]
		}
		updates[i] = node
	}

	toRemove := node.forwards[0]
	if toRemove == nil || toRemove.val != num {
		return false
	}

	for i := range updates {
		if updates[i].forwards[i] == toRemove {
			updates[i].forwards[i] = toRemove.forwards[i]
		}
	}
	return true
}

func (this *Skiplist) randomLevel() int {
	level := 1
	for ; level < maxLevel; level++ {
		r := this.random.Int31n(100)
		if r < randomLevelPercent {
			return level
		}
	}
	return level
}
