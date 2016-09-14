```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/web-logger
@Language: Markdown
@Datetime: 16-09-07 03:01
```

So if you absolutely know that the list is an implementation of ArrayList and will never ever change then it doesn't really matter; but:

this is bad programming practice anyway to tie yourself down to a specific implementation.
If things change a few years down the line with code restructuring, testing will show that "it works" but things are running less efficiently than before
Even in the best case, size() == 0 is still not faster than isEmpty(), so there's no compelling reason to ever use the former.
isEmpty is a clearer definition of what it is you actually care about and are testing, and so makes your code a bit more easily understandable.