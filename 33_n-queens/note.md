```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Markdown
@Datetime: 16-07-01 12:25
```

1.DFS search. Depth is # of rows and breath is # of columns.
2. How to check the validation: row - col (left-top to right-bottom)and row + col(right-top to left-bottom)should be equal if points are located in diagnoal.
3. When reached the maximum depth, draw the result.
4. Whenever we want to add another queen, we should check if it confirms rules with all the previous queens.