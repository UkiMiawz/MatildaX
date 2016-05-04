1. Using List of WindowSystem. On mouse click, the system will give out x and y value of the mouse click. Then WindowSystem will search for the window with corresponding value of x and y in range.  List is much faster for searching and its also memory save. 

2. 
Adding window -  create a new SimpleWindow instance and add it to the list. A List will automatically add new object to the end of the list. 

Removing window -  get the index of the window, decrease the index value of other windows with bigger index. Then remove the object from the list using the index. When you have the object index, its easy and fast to delete it from a list.

Drawing windows from back to front -  Draw windows from window with the smallest index to the biggest index. 

Finding specific window - search the list for Windows that has the value of given x and y coordinate in range. Then look for which one is on the top. 

Code complexity -  with list, search always has worst case complexity of O(n) 

