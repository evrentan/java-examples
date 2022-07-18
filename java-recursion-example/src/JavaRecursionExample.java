import java.util.Scanner;

public class JavaRecursionExample {
  public static void main(String[] args) {
    System.out.println("Please enter the number of elements in your binary tree");
    Scanner scanner = new Scanner(System.in);

    int numberOfElements = scanner.nextInt();
    System.out.println("Please enter your numbers");

    Node root = null;

    for (int i = 0; i < numberOfElements; i++)
      root = insertElement(root, scanner.nextInt());

    order(root);
  }

  /**
   * Method to insert an element to the root Node
   *
   * @param root root node of the binary search tree that is going to be updated
   * @param data data to be inserted in the binary search tree
   * @return updated root
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static Node insertElement(Node root, Integer data) {
    if (root == null)
      return new Node(data);
    else {
      Node current;
      if (data <= root.data) {
        current = insertElement(root.left, data);
        root.left = current;
      } else {
        current = insertElement(root.right, data);
        root.right = current;
      }
      return root;
    }
  }

  /**
   * Method to find the height of the binary search tree from root
   *
   * @param root root node of the binary search tree
   * @return integer that is the height of the tree
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static int findHeight(Node root) {
    if (root == null)
      return 0;
    else {
      int leftHeight = findHeight(root.left);
      int rightHeight = findHeight(root.right);
      if (leftHeight > rightHeight)
        return leftHeight + 1;
      else
        return rightHeight + 1;
    }
  }

  /**
   * Method to print the current level of binary search tree with level info of the tree to be printed
   *
   * @param current current node of the binary search tree
   * @param level   level info to be printed
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static void printCurrentLevel(Node current, int level) {
    if (current == null)
      return;
    if (level == 1)
      System.out.print(String.format("%d ", current.data));
    else if (level > 1) {
      printCurrentLevel(current.left, level - 1);
      printCurrentLevel(current.right, level - 1);
    }
  }

  /**
   * Method to order levels of binary search tree
   *
   * @param root root node of the binary search tree
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   */
  public static void order(Node root) {
    int height = findHeight(root);

    for (int i = 1; i <= height; i++)
      printCurrentLevel(root, i);
  }
}
