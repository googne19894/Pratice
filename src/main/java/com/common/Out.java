package com.common;

import com.common.Tree.GUITreePrinter;
import com.striver.DSAExperience.T12Tree.common.Node;
import com.striver.DSAExperience.T12Tree.common.TreeNode;
import com.striver.DSAExperience.T3LinkedList.ListNode;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Out {

    public static void print(Object obj) {
        if (obj == null) {
            System.out.println("null");
            return;
        }

        String instance = obj.toString();
        if (instance.contains("[[")) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                print(Array.get(obj, i));
            }
        } else if (instance.contains("[")) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                System.out.print(Array.get(obj, i) + " ");
            }
            System.out.println();
        } else if (obj instanceof TreeNode || obj instanceof Node)
            System.out.println(((TreeNode) obj).val);
        else
            System.out.println(obj);
    }

    public static void print(List a) {
        if (a == null)
            System.out.println("null");

        Iterator itr = a.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("-------------");
    }

    public static void print(String msg, List a) {
        System.out.print(msg + ": ");
        print(a);
    }

    public static void print(ListNode node) {
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    //Tree Printing
    public static void printNode(Object root) {
//        if (root == null) {
//            System.out.println("null");
//            return;
//        }
//
//        if (root instanceof TreeNode) {
//            TreePrinter<TreeNode> obj = new TreePrinter<TreeNode>();
//            obj.printRoot((TreeNode) root);
//        } else if (root instanceof Node) {
//            TreePrinter<Node> obj = new TreePrinter<Node>();
//            obj.printRoot((Node) root);
//        } else if (root instanceof BinaryTreeNode) {
//            TreePrinter<BinaryTreeNode> obj = new TreePrinter<BinaryTreeNode>();
//            obj.printRoot((BinaryTreeNode) root);
//        }
    }

    public static void print(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

//        if (root instanceof TreeNode) {
//            TreePrinter<TreeNode> obj = new TreePrinter<TreeNode>(new TreeNode());
//            obj.print();
//        }
    }
    //level wise print full binary tree
    public static void printTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode ref = q.poll();
                if (ref != null) {
                    q.offer(ref.left);
                    q.offer(ref.right);
                    System.out.print(ref.val + " ");
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }

    public static void printTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                Node ref = q.poll();
                if (ref.left != null) q.offer(ref.left);
                if (ref.right != null) q.offer(ref.right);
                System.out.print(ref.data + " ");
            }
            System.out.println();
        }
    }

    public static void guiTree(TreeNode root) {
        GUITreePrinter.printNode(root);
    }

    public static void printWithIndex(Object obj) {
        String instance = obj.toString();
        if (instance.contains("[[")) {
            for (int i = 0; i < Array.getLength(obj); i++) {
                printHelper(i, Array.get(obj, i), false);
            }
        } else if (instance.contains("[")) {
            printHelper(-1, obj, false);
            System.out.println();
        }
    }

    public static void printWithIndex(Object obj, boolean ignoreZero) {
        String instance = obj.toString();
        if (instance.contains("[[")) {
            for (int i = 0; i < Array.getLength(obj); i++)
                printHelper(i, Array.get(obj, i), ignoreZero);
        } else if (instance.contains("["))
            printHelper(-1, obj, ignoreZero);
    }

    public static void printHelper(int i, Object obj, boolean ignoreZero) {
        for (int j = 0; j < Array.getLength(obj); j++) {
            String ele = Array.get(obj, j).toString();
            if (i >= 0) {
                if (ignoreZero) {
                    if (ele != "0")
                        System.out.print("(" + i + "," + j + ")=" + ele + " ");
                } else
                    System.out.print("(" + i + "," + j + ")=" + ele + " ");
            } else {
                if (ignoreZero && ele != "0")
                    System.out.print("(" + j + ")=" + ele + " ");
                else if (!ignoreZero)
                    System.out.print("(" + i + "," + j + ")=" + ele + " ");
            }
        }
        System.out.println();
    }


//    private static GlobalPrinter<Integer> defaultPrinter;
//
//    static {
//        defaultPrinter = new GlobalPrinter<Integer>();
//    }
//
//    public static void print(int[] arr) {
//        defaultPrinter.print(toIntegerArray(arr));
//    }
//
//    public static void print(int[][] arr) {
//        defaultPrinter.print(to2DIntegerArray(arr));
//    }
//
//    public static void printWithIndex(int[][] arr, boolean ignoreZero) {
//        defaultPrinter.printWithIndex(to2DIntegerArray(arr), ignoreZero);
//    }
//
//    public static void printWithIndex(int[][] arr) {
//        defaultPrinter.printWithIndex(to2DIntegerArray(arr));
//    }


//    public static void print(List<List<Object>> a) {
//        Iterator itr = a.iterator();
//
//        while (itr.hasNext()) {
//            System.out.print(itr.next() + " ");
//        }
//    }


//    private static Integer[][] to2DIntegerArray(int[][] arr) {
//        Integer[][] a = new Integer[arr.length][arr[0].length];
//        for (int i = 0; i < arr.length; i++) {
//            a[i] = toIntegerArray(arr[i]);
//        }
//        return a;
//    }
//
//    private static Integer[] toIntegerArray(int[] arr) {
//        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
//    }


//    public static void print(int[] a) {
//        System.out.println("-------------------------");
//
//        for (int i = 0; i < a.length; ++i) {
//            System.out.print(i + " ");
//        }
//
//        System.out.println();
//        int[] var5 = a;
//        int var2 = a.length;
//
//        for (int var3 = 0; var3 < var2; ++var3) {
//            int aa = var5[var3];
//            System.out.print(aa + " ");
//        }
//
//        System.out.println();
//    }

//    public static void print(List<List<Integer>> lists) {
//        Iterator var1 = lists.iterator();
//
//        while(var1.hasNext()) {
//            List<Integer> list = (List)var1.next();
//            printList(list);
//            System.out.println("------------");
//        }
//
//    }

//    public static void print(List<Integer> list) {
//        Iterator var1 = list.iterator();
//
//        while(var1.hasNext()) {
//            int l = (Integer)var1.next();
//            System.out.print(l + ", ");
//        }
//
//    }


}
