```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Markdown
@Datetime: 16-06-21 13:34
```

Attention!!
Merge Step:
i <=> i + 1 for i in range(m - 1).
交叉开来相加。不是二者相加。
In buy and sell stocks III, we can add up i <=> i for i in range(m) because we are finding the maximum range in 2 part of the array.