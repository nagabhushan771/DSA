package dsa.Trees;

public class BinarySearchTree{
	  TreeNode root;

	  public BinarySearchTree(){
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
	  
	  public TreeNode insertRec(int val, TreeNode curRoot) {
		  if(curRoot == null)
			  return new TreeNode(val);
		  
		  if(val > curRoot.val)
			  curRoot.right = insertRec(val, curRoot.right);
		  else if(val < curRoot.val)
			  curRoot.left = insertRec(val, curRoot.left);
		  return curRoot;
	  }
	  
	  public TreeNode deleteRec(int val, TreeNode curRoot) {
		  if(curRoot == null)
			  return null;
		  
		  if(val > curRoot.val)
			  curRoot.right = deleteRec(val, curRoot.right);
		  else if(val < curRoot.val)
			  curRoot.left = deleteRec(val, curRoot.left);
		  else {
			  if(curRoot.left == null)
				  return curRoot.right;
			  else if(curRoot.left == null)
				  return curRoot.left;
			  else {
				  curRoot.val = minVal(curRoot.right);
				  curRoot.right = deleteRec(curRoot.val, curRoot.right);
//				  return curRoot;
			  }
			  
		  }
		  return curRoot;
	  }
	  
	  private int minVal(TreeNode node) {
		while(node.left != null)
			node = node.left;
		return node.val;
	}

	  //deleteNode method is not yet completed
	public void deleteNode(TreeNode root, int val) {
		TreeNode temp = root;
		TreeNode prev = null;
		while(temp.val != val && temp != null) {
			prev = temp;
			temp = val>temp.val ? temp.right : temp.left;
		}
		if(temp == null)
			return;
		
		if(temp.left == null && temp.right == null) {
			if(prev.left == temp)
				prev.left = null;
			else
				prev.right = null;
		} else if(temp.left == null || temp.right == null){
			 if(prev.left == temp)
				 prev.left = temp.left != null ? temp.left : temp.right;
			 else
				 prev.right = temp.left != null ? temp.left : temp.right;
		} else {
			TreeNode t = temp.right;
			TreeNode p = temp;
			while(t != null) {
				p = t;
				t = t.left;
			}
			temp.val = t.val;
			deleteNode(temp.right, temp.val);
		}
		return;
		  
	  }
	}
