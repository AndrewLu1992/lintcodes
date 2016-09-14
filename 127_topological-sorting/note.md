```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Markdown
@Datetime: 16-07-01 01:47
```

Method1: BFS:
In each new phase, we find the node with 0 in-degree.
Method2 DFS:
!!! We add nodes to result array only if reached to the farthest nodes.

Preprocessing:
Find out graph nodes can not be reached by any other nodes but can reach out to some of them.