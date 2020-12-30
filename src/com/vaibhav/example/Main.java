package com.vaibhav.example;


 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public static int maxPathSum(TreeNode root) {

         if(root == null){
             return 0;
         }

         int value = Integer.MIN_VALUE;
         int [] result = {value};

         maxPathSumHelper(root, result);

         return result[0];


     }

     public static int maxPathSumHelper(TreeNode root, int []result){

         if(root == null){
             return 0;
         }

         int left = maxPathSumHelper(root.left, result);
         int right = maxPathSumHelper(root.right, result);

         int ms = Math.max(Math.max(left, right)+root.val, root.val);  //straight path
         int m21 = Math.max(ms, left+right+root.val); // max of sum of subtree and straight path
         result[0] = Math.max(m21, result[0]); //max of previous result and max of sum of subtree and //straight path

         return ms;
     }
 }


public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(TreeNode.maxPathSum(root));
    }
}
