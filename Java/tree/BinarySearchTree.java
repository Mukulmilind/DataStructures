/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Binary Search Tree is efficient data structure. 
 * Speacial Features:
 * - Every node can have max of two child nodes
 * - Every node to the left is less than the root node and every node to the right is greater.
 * - Depth of the tree is the maximum number of edges in the leaf node.
 * - Smallest value in the tree is obtained by traversing to the leftmost leaf node.
 * - Largest value in the tree is obtained by traversing to the rightmost leaf node
 */

class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    // Constructor
    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        // Duplicates are not allowed
        if (value == data){
            return;
        }
        // If the value is less than root/parent node, check recursively and insert in left subtree
        if(value < data) {
            if(leftChild == null) {
                leftChild = new TreeNode(value);
            } else {
                leftChild.insert(value);
            }
        // If the value is greater than root/parent node, check recursively and insert in right subtree
        } else {
            if(rightChild == null) {
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    // In-order traversal
    public void traverseInOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        System.out.println("Data: " + data);

        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    // Pre-order traversal
    public void traversePreOrder() {
        System.out.println("Data: " + data);

        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    // Post-order traversal
    public void traversePostOrder() {
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }
        
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }

        System.out.println("Data: " + data);
    }

    // Search for a value
    public TreeNode get(int value) {
        if (value == data) {
            return this;
        }
        if (value < data) {
            if (leftChild != null) {
                return leftChild.get(value);
            } 
        } else {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
    }


    // Find the minimum value
    public int min() {
        if (leftChild == null) {
            return data;
        } else {
            return leftChild.min();
        }
    }

    // Find the maximum value
    public int max() {
        if (rightChild == null) {
            return data;
        } else {
            return rightChild.max();
        }
    }

    // Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
}

class Tree {
    private TreeNode root;
    public void insert(int value) {
        // If there is nothing in the BST make the value as the root
        if(root == null) {
            root = new TreeNode(value);
        // Otherwise insert the value in the right position
        } else {
            root.insert(value) ;
        }
    }

    // In-order traversal
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder(); 
        }
    }

    // Pre-order traversal
    public void traversePreOrder() {
        if (root != null) {
            root.traversePreOrder(); 
        }
    }

    // Post -order traversal
    public void traversePostOrder() {
        if (root != null) {
            root.traversePostOrder(); 
        }
    }

    // Search for an element in BST
    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value); 
        }
        return null;
    }

    // Delete a node in BST
    public void delete(int value) {
         root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
         if (subTreeRoot == null) {
            return subTreeRoot; // bascially returning null as tree is empty.
         }
         if (value < subTreeRoot.getData()) {
             subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
         } else if (value > subTreeRoot.getData()) {
             subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
         } else {
            // Case 0 and 1 - Node to delete has 0 or 1 child node.
             if (subTreeRoot.getLeftChild() == null) {
                 return subTreeRoot.getRightChild(); //if this is a leaf then return null else return replacement
             } else if (subTreeRoot.getRightChild() == null) {
                 return subTreeRoot.getLeftChild(); // same as above for right Child
             }

             // Case 3 - The node to delete has two children
             // Replace the value of subTreeRoot node with the smallest value in right sub-tree
             subTreeRoot.setData(subTreeRoot.getRightChild().min());

             // Delete the node that has the smallest value in the right sub-tree
             subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
         }

         return subTreeRoot;
    }

    // Find the minimum value if the BST
    public int min() {
        if (root != null) {
            return root.min();
        }
        return Integer.MIN_VALUE;
    }

    // Find the maximum value in the BST
    public int max() {
        if (root != null) {
            return root.max();
        }
        return Integer.MIN_VALUE;
    }

}

public class BinarySearchTree {
    public static void main(String [] args) {
        Tree intTree = new Tree();
        
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.traverseInOrder();
        System.out.println("");

        // System.out.println(intTree.get(27).getData());
        // System.out.println(intTree.get(15).getData());
        // System.out.println(intTree.get(88));
        // System.out.println();

        // System.out.println("The minimum element in the BST is : " + intTree.min());
        // System.out.println("The maximum element in the BST is : " + intTree.max());

        intTree.delete(15);
        intTree.traverseInOrder();
        System.out.println("");
    }
}