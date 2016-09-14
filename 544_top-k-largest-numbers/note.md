```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Markdown
@Datetime: 16-06-28 15:13
```

result[i] = nums[nums.length - 1 - i];
i++;
Arrays does not have reverse method.
Collections has reverse method for data structures implementing list interface.
heap.toArray() return Object[].
heap.toArray(T[] a) does not work.
Method 2 Heap:
Use Heap to store the top k largest numbers up so far and throw minimum one in each time. O(nlogk). Better than O(nlogn).