package vikrant.ds;
public class BinarySearchTree<E extends Comparable<E>> 
{   
    private static class Node<E>
    { 
        private E data; 
        private Node<E> left,right; 
        public Node(E item) 
        { 
            data=item; 
            left=right=null; 
        }
        public void setLeft(Node<E> n)
        {
            left=n;
        }
        public void setRight(Node<E> n)
        {
            right=n;
        }
        public Node<E> getLeft()
        {
            return left;
        }
        public Node<E> getRight()
        {
            return right;
        }
        public E getData()
        {
            return data;
        }
    }
    private Node<E> root=null; 
    private int size=0;

    public BinarySearchTree() 
    {  

    } 

    public void insert(E data) 
    { 
        root=insertRec(root,data); 
    } 
      
    public Node<E> insertRec(Node<E> root,E data) 
    { 
        if(root==null) 
        { 
            Node<E> n=new Node(data);
            root=n;
            ++size;  
        }
        else if(root.getData().compareTo(data)>0)
        {
            root.setLeft(insertRec(root.getLeft(),data));
        }
        else
        {
            root.setRight(insertRec(root.getRight(),data));   
        } 
        return root;
    }
    private void preOrderPrint(Node<E> root)
    {
        if(root!=null)
        {
            System.out.println(root.getData());
            inOrderPrint(root.getLeft());
            inOrderPrint(root.getRight());
        }
    }
    public void preOrder()
    {
        preOrderPrint(root);
    }
    private void inOrderPrint(Node<E> root)
    {
        if(root!=null)
        {
            inOrderPrint(root.getLeft());
            System.out.println(root.getData());
            inOrderPrint(root.getRight());
        }
    }
    public void inOrder()
    {
        inOrderPrint(root);
    }
    private void postOrderPrint(Node<E> root)
    {
        if(root!=null)
        {
            System.out.println(root.getData());
            inOrderPrint(root.getLeft());
            inOrderPrint(root.getRight());
        }
    }
    public void postOrder()
    {
        postOrderPrint(root);
    }
    public void iterativePreOrder()
    {

    }
    public void iterativeInOrder()
    {

    }
    public void iterativePostOrder()
    {
        
    }
    private int getHeight(Node<E> root)
    {
        if(root==null)
            return  0;
        else
        {
            int x=0,y=0;
            x=getHeight(root.getLeft())+1;
            y=getHeight(root.getRight())+1;
            if(x>y)
                return x;
            else
                return y;
        }
    }
    public int height()
    {
        return getHeight(root);
    }
    public void delete()
    {
        size=0;
        root=null;
    }
    private void loadLevelOrder(Node<E> root)
    {
        Queue<Node<E>> q=new LinkedQueue();
        q.enqueue(root);
        while(!q.isEmpty())
        {
            Node<E> node=q.dequeue();
            System.out.println(node.getData());
            if(node.getLeft()!=null)
                q.enqueue(node.getLeft());
            if(node.getRight()!=null)
                q.enqueue(node.getRight());
        }
    }
    public void levelOrder()
    {
        if(root!=null)
        {
            loadLevelOrder(root);
        }
    }
    private void loadReverseLevelOrder(Node<E> root)
    {
        Stack<Node<E>> s=new LinkedStack();
        Queue<Node<E>> q=new LinkedQueue();
        q.enqueue(root);
        while(!q.isEmpty())
        {
            Node<E> node=q.first();
            q.dequeue();
            s.push(node);
            if(node.getRight()!=null)
                q.enqueue(node.getRight());
            if(node.getLeft()!=null)
                q.enqueue(node.getLeft());
        }
        while(!s.isEmpty())
        {
            System.out.println(s.pop().getData());
        }
    }
    public void reverseLevelOrder()
    {
        if(root!=null)
        {
            loadReverseLevelOrder(root);
        }
    }
    private void loadLevelOrderSpiral(Node<E> root)
    {
        int flag=1;
        Stack<Node<E>> s1=new LinkedStack();
        Stack<Node<E>> s2=new LinkedStack();
        s1.push(root);
        while(true)
        {
            Node<E> node=s1.pop();
            System.out.println(node.getData());
            if(flag==1)
            {
                if(node.getRight()!=null)
                    s2.push(node.getRight());
                if(node.getLeft()!=null)
                    s2.push(node.getLeft());
            }
            else if(flag==0)
            {
                if(node.getLeft()!=null)
                    s2.push(node.getLeft());
                if(node.getRight()!=null)
                    s2.push(node.getRight());   
            }
            if(s1.isEmpty()&&s2.isEmpty())
                break;
            else if(s1.isEmpty())
            {
                s1=s2;
                s2=new LinkedStack();
                if(flag==1)
                    flag=0;
                else
                    flag=1;
            }
        }
    } 
    public void levelOrderSpiral()
    {
        if(root!=null)
        {
            loadLevelOrderSpiral(root);
        }
    }
    public void mirrorize(Node<E> root)
    {
        if(root!=null)
        {
            Node<E> n1=root.getLeft(),n2=root.getRight();
            root.setLeft(n2);
            root.setRight(n1);
            mirrorize(n1);
            mirrorize(n2);
        }
    }
    public void mirror()
    {
        if(root!=null)
        {
            mirrorize(root);
        }
    }
    private void left(Node<E> root)
    {
        if(root!=null)
        {
            left(root.getLeft());
            System.out.println(root.getData());
        }
    }
    private void right(Node<E> root)
    {
        if(root!=null)
        {
            System.out.println(root.getData());
            right(root.getRight());
        }
    }
    public void topView()
    {
        if(root!=null)
        {
            left(root.getLeft());
            System.out.println(root.getData());
            right(root.getRight());
        }
    }
    private int bottom(Node<E> root)
    {
        if(root==null)
            return  0;
        else
        {
            int x=0,y=0;
            x=bottom(root.getLeft())+1;
            y=bottom(root.getRight())+1;
            if(x<=1&&y<=1)
                System.out.println(root.getData());
            if(x>y)
                return x;
            else
                return y;
        }
    }
    public void bottomView()
    {
        if(root!=null)
        {
            bottom(root);
        }
    }
    private boolean checkValidity(Node<E> root)
    {
        if(root!=null)
        {
            Node<E> n1=root.getLeft(),n2=root.getRight();
            if(n1!=null&&n1.getData().compareTo(root.getData())>0)
                return false&&checkValidity(root.getLeft())&&checkValidity(root.getRight());
            else if(n2!=null&&n2.getData().compareTo(root.getData())<=0)
                return false&&checkValidity(root.getLeft())&&checkValidity(root.getRight());
            else
                return true&&checkValidity(root.getLeft())&&checkValidity(root.getRight());
        }
        else
            return true;
    }
    public boolean isValidBST()
    {
        if(root!=null)
        {
            return checkValidity(root);
        }
        return true;
    }
}