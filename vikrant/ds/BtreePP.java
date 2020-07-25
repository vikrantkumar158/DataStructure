public class BTreePP 
{
    public static class BinaryTree 
    {
        public class Node 
        {
            int data;
            Node left;
            Node right;
            public Node(int data) 
            {
                this.data = data;
                this.left = null;
                this.right = null;
            }
        }

        private Node root;
        private int size;

        public BinaryTree(int[] post,int[] in) 
        {
            this.root=this.construct(post,0,post.length-1,in,0,in.length-1);
        }

        private Node construct(int[] post,int psi,int pei,int[] in,int isi,int iei) 
        {
            if(psi>pei) 
            {
                return null;
            }
            Node node=new Node(post[pei]);
            node.left=null;
            node.right=null;
            this.size++;
            int pos=-1;
            for(int i=isi;i<=iei;i++) 
            {
                if(in[i]==node.data) 
                {
                    pos=i;
                    break;
                }
            }
            int clc=pos-isi;
            node.left=this.construct(post,psi,psi+clc-1,in,isi,isi+clc-1);
            node.right=this.construct(post,psi+clc,pei-1,in,isi+clc+1,iei);
            return node;
        }
        public void postOrder() 
        {
            postOrder(this.root);
        }
        private void postOrder(Node node) 
        {
            if(node==null) 
            {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    public static void main(String[] args) throws Exception {

        int[] in={12,25,30,37,40,50,60,62,70,75,87};
        int[] post={12,30,40,37,25,60,70,62,87,75,50};
        BinaryTree bt = new BinaryTree(post, in );
        bt.postOrder();
    }

}