package vikrant.ds;
public class BinarySearchTree<E extends Comparable<E>> 
{   
    private static class Node<E>
    { 
        private E data; 
        private Node<E> left,right; 
        public Node()
        {

        }
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
        public void setData(E item)
        {
            data=item;
        }
        public E getData()
        {
            return data;
        }
    }
    private Node<E> root=null; 

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
            preOrderPrint(root.getLeft());
            preOrderPrint(root.getRight());
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
            postOrderPrint(root.getLeft());
            postOrderPrint(root.getRight());
            System.out.println(root.getData());
        }
    }
    public void postOrder()
    {
        postOrderPrint(root);
    }
    public void iterativePreOrder()
    {
        Stack<Node<E>> s=new LinkedStack();
        Node<E> n;
        s.push(root);
        while(!s.isEmpty())
        {
            n=s.pop();
            if(n.getRight()!=null)
                s.push(n.getRight());
            if(n.getLeft()!=null)
                s.push(n.getLeft());
            System.out.println(n.getData());
        }   
    }
    public void iterativeInOrder()
    {
        Stack<Node<E>> s=new LinkedStack();
        Node<E> n=root;
        while(!s.isEmpty()||n!=null)
        {
            while(n!=null)
            {
                s.push(n);
                n=n.getLeft();
            }
            n=s.pop();
            System.out.println(n.getData());
            n=n.getRight();
        }
    }
    public void iterativePostOrder()
    {
        Stack<Node<E>> s1=new LinkedStack(),s2=new LinkedStack();
        Node<E> n;
        s1.push(root);
        while(!s1.isEmpty())
        {
            n=s1.pop();
            s2.push(n);
            if(n.getLeft()!=null)
                s1.push(n.getLeft());
            if(n.getRight()!=null)
                s1.push(n.getRight());
        } 
        while(!s2.isEmpty())
        {
            n=s2.pop();
            System.out.println(n.getData());
        }  
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
    private void setNull(Node<E> r,Node<E> n)
    {
        if(n!=null)
        {
            if(r==root&&root.getData()==n.getData())
            {
                root=null;
            }
            if(r.getLeft()!=null&&r.getLeft().getData()==n.getData())
            {
                r.setLeft(null);
            }
            else if(r.getRight()!=null&&r.getRight().getData()==n.getData())
            {
                r.setRight(null);
            }
            else if(r.getData().compareTo(n.getData())>0)
                setNull(r.getLeft(),n);
            else if(r.getData().compareTo(n.getData())<0)
                setNull(r.getRight(),n);
        }
    }
    private void deleteNode(Node<E> r)
    {
        if(r.getLeft()==null&&r.getRight()==null)
        {
            setNull(root,r);
        }
        if(r.getLeft()==null&&r.getRight()!=null)
        {
            Node<E> n=r;
            r.setData(r.getRight().getData());
            r.setLeft(r.getRight().getLeft());
            r.setRight(r.getRight().getRight());
        }
        else if(root.getLeft()!=null&&root.getRight()==null)
        {
            Node<E> n=r;
            r.setData(r.getLeft().getData());
            r.setRight(r.getLeft().getRight()); 
            r.setLeft(r.getLeft().getLeft()); 
        }
        else
        {
            Node<E> n=r.getLeft(),p=r;
            while(n.getRight()!=null)
            {
                p=n;
                n=n.getRight();
            }
            if(n.getLeft()!=null)
            {
                r.setData(n.getData());
                n.setData(n.getLeft().getData());
                n.setRight(n.getLeft().getRight());
                n.setLeft(n.getLeft().getLeft());
            }
            else
            {
                r.setData(n.getData());
                p.setLeft(null);
            }    
        }
    }
    private Node<E> findNode(Node<E> root,E key)
    {
        if(root!=null)
        {
            if(root.getData().compareTo(key)==0)
                return root;
            else if(root.getData().compareTo(key)>0)
                return findNode(root.getLeft(),key);
            else
                return findNode(root.getRight(),key);
        }
        return null;
    }
    public void delete(E key)
    {
        if(root!=null)
        {
            Node<E> n=findNode(root,key);
            if(n!=null)
            {
                deleteNode(n);
            }
        }
    }
    private boolean checkPallindrome(Node<E> n1,Node<E> n2)
    {

        if(n1==null&&n2==null)
            return true;
        else if(n1!=null&&n2==null)
            return false;
        else if(n1==null&&n2!=null)
            return false;
        else
        {
            if(n1.getData().compareTo(n2.getData())==0)
                return true&&checkPallindrome(n1.getLeft(),n2.getRight())&&checkPallindrome(n2.getLeft(),n1.getRight());
            else
                return false;
        }
    }
    public boolean isPallindrome()
    {
        if(root!=null)
        {
            return checkPallindrome(root.getLeft(),root.getRight());
        }
        return true;
    }
    private Node<E> lowestCommonAncestor(Node<E> n,E x,E y)
    {
        if(n==null)
            return null;
        if(n.getData().compareTo(x)>0&&n.getData().compareTo(y)>0)
            return lowestCommonAncestor(n.getLeft(),x,y);
        if(n.getData().compareTo(x)<0&&n.getData().compareTo(y)<0)
            return lowestCommonAncestor(n.getRight(),x,y);
        return n;
    }
    public E LCA(E x,E y)
    {
        if(root!=null)
        {
            Node<E> n=lowestCommonAncestor(root,x,y);
            if(n!=null)
                return n.getData();
            return null;
        }
        return null;
    }
    private int max(int a,int b)
    {
        if(a>b)
            return a;
        return b;
    }
    private int getDiameter(Node<E> n)
    {
        if(n==null)
            return 0;
        int lh=getHeight(n.getLeft());
        int rh=getHeight(n.getRight());
        int ld=getDiameter(n.getLeft());
        int rd=getDiameter(n.getRight());
        return max(lh+rh+1,max(ld,rd));
    }
    public int diameter() 
    { 
        if(root!=null)
        {
            return getDiameter(root);
        }
        return 0;
    }  
}