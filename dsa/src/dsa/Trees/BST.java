package dsa.Trees;

public class BST{
	  TreeNode root;

	  public BST(){
	    root = null;
	  }

	  public void insert(int val){
	    TreeNode newNode = new TreeNode(val);
	    if(root == null){
	      root = newNode;
	      return;
	    }
	    TreeNode temp;
	    TreeNode parent = root;
	    if(root.val < newNode.val)
	      temp = root.right;
	    else
	      temp = root.left;
	    while(temp!=null){
	      parent = temp;
	      if(newNode.val > temp.val)
	        temp = temp.right;
	      else
	        temp = temp.left;
	    }
	    if(newNode.val > parent.val)
	      parent.right = newNode;
	    else
	      parent.left = newNode;

	    return;
	  }
	}
