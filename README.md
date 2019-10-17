# Software Engineering assignment

Student Name: David Hooban  
Student ID: 17328486  

Implemented in Java, and tests were implemented with the JUnit test framework  

Binary Search Tree Implementation found in:  
BSTLowestCommonAncestor.java  

Directed Acyclic Graph Implementation found in:  
DAGLowestCommonAncestor.java  

## Note

The DAG solution for this problem was implemented on the 'dag' branch, but was ultimately merged to master as per instructions.  
The BST solution for this problem was strictly developed on master.  


## Note regarding merge history  

When working on this project, the initial BST implementation was done on the master branch, containing just the BSTLowestCommonAncestor and LowestCommonAncestorTest classes,
as can be seen in the commit history. Then, I branched to 'dag' and completed work on the DAGLowestCommonAncestor implementation, and modified LowestCommonAncestorTest to 
include tests for both BST and DAG implementations of the LCA algorithm. As per the instructions on the website, I merged the two, but because it was a fast forward merge as 
I learned later, it is difficult to see the merge history, so I've included the below image from 'git reflog' which shows that the merge did happen.

![Image of merge history](https://github.com/davidh234/Software-Engineering/blob/master/merge%20history.PNG)


Biography found at:  
https://github.com/davidh234/sweng-biography