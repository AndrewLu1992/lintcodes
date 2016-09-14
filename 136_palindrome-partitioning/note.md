```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Markdown
@Datetime: 16-07-02 05:17
```

Search on different partition method.
1. List<List<String>> = result new ArrayList<List<String>>(); result.add(new ArrayList<String>());
2. Iterate through the end index. End must each time pos = i.