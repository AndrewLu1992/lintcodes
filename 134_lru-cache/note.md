```
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/lru-cache
@Language: Markdown
@Datetime: 16-06-27 08:18
```

Implementation:
HashMap + DoubleLinkedList.
HashMap to store the mappings.
LinkedList is to detect the Least Recently Used mapping.
Policy: Whenever we get a mapping successfully, change the position of the node in the linkedlist to the tail. Thus the Least Recently used mapping will be the head node after a few updatings.
In the set method, use get method to detect whether there is a mapping. If nothing, then first we check if the size is within the capacity, if not, delete the head node from hashmap and linkedlist. Finally, we insert the newNode into hashmap and the tail of the doublelinkedlist.