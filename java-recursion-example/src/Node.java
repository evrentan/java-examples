/**
 * Node class that has left and right nodes and data
 *
 * @author <a href="https://github.com/evrentan">Evren Tan</a>
 */
public class Node {
  Node left;
  Node right;
  int data;

  Node(int data) {
    this.data = data;
    left = right = null;
  }
}
