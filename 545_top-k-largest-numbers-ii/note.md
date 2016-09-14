```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Markdown
@Datetime: 16-08-02 01:53
```

1. Use iterator to traverse the heap without modifying actual elements.
2. it.next() returns an object, needed to be casted to Integer.
3. We do not need to store all added numbers, only k largest numbers.