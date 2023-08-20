import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class test {
	
    public static void main(String args[]) throws IOException
    {
    	Stack<Node> stack = new Stack<>();
    	stack.add(new Node(1,2));
    	System.out.println(stack);
    	Node n = stack.peek();
    	n.a = 10;
    	System.out.println(stack);
    }
    static class Node{
    	int a;
    	int b;
		public Node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + "]";
		}
    	
    }
}

	