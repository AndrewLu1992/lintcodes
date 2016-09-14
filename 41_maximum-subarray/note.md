```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Markdown
@Datetime: 16-06-20 12:14
```

1. Iterate through the array:
2. Check if the sum(subarray) < 0, if true we trhow the sum.
3. Compare the added one and the single elem.
4. This is essentially a dynamic programming problem. O(N ^ 2) -> O(n). O(1) space.