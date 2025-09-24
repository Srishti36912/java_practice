package medium;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sum = 0;
    
    public int getResult() {
      	//implement this
        return sum;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long product = 1;
    private final int MOD = 1000000007;
    
    public int getResult() {
      	//implement this
        return (int) (product % MOD);
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if(node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if(leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int sumNonLeafEvenDepth = 0;
    private int sumGreenLeaves = 0;
    
    public int getResult() {
      	//implement this
        return Math.abs(sumNonLeafEvenDepth - sumGreenLeaves);
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if(node.getDepth() % 2 == 0) {
            sumNonLeafEvenDepth += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if(leaf.getColor() == Color.GREEN) {
            sumGreenLeaves += leaf.getValue();
        }
    }
}

public class visitorPattern {
  
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    String valuesLine = scan.nextLine();
    String colorsLine = scan.nextLine();

    String[] valuesStr = valuesLine.split(" ");
    int[] values = new int[n];

    for (int i = 0; i < n; i++) {
        values[i] = Integer.parseInt(valuesStr[i]);
    }

    String[] colorsStr = colorsLine.split(" ");
    byte[] colors = new byte[n];

    for (int i = 0; i < n; i++) {
        colors[i] = (byte) Integer.parseInt(colorsStr[i]);
    }

    Map<Integer, List<Integer>> adj = new HashMap<>();
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
        adj.put(i, new ArrayList<Integer>());
    }

    while (scan.hasNextInt()) {
        int u = scan.nextInt() - 1;
        int v = scan.nextInt() - 1;
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    scan.close();

    return buildTree(0, 0, values, colors, adj, visited);
}

    public static Tree buildTree(
        int index, int depth, int[] values, byte[] colors, Map<Integer, List<Integer>> adj, boolean[] visited
    ) {
        boolean isLeaf = true;
        visited[index] = true;

        Color color = colors[index] == 0 ? Color.RED : Color.GREEN;
        List<Integer> children = adj.get(index);
        TreeNode treeNode = new TreeNode(values[index], color, depth);

        for (int child : children) {
            if (!visited[child]) {
                isLeaf = false;
                Tree childNode = buildTree(child, depth + 1, values, colors, adj, visited);
                treeNode.addChild(childNode);
            }
        }

        if (isLeaf) {
            return new TreeLeaf(values[index], color, depth);
        } else {
            return treeNode;
        }
}

    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}