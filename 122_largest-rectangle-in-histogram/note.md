```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Markdown
@Datetime: 16-06-25 07:36
```

Method 1:
For each bar, assume it is the height of the rectangle, find the most long width avaliable. Use 2 pointers in each iteration to check left and right side.
Time: Worst Case: O(n ^ 2). Space: O(1).

Method2:
Use Stack to remember upper trend index. find part of array that has acending trend. Then for each of them we can calculate area directly.