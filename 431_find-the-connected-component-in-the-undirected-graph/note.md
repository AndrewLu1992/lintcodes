```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph
@Language: Markdown
@Datetime: 16-07-04 15:24
```

Learn how to use Iterator.
When you want to iterate through a collection while removing elements of the collection. Use itr.hasNext() and itr.next(). itr.remove will only remove the element return by itr.next(). It should be paired with the itr.next() method otherwise will through IlligealStatementException(It does not know which to delete).