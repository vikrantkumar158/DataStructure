public class BTreePI
{
	public static class BinaryTree {
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
		private int size=0;
	
		public BinaryTree(int[] pre,int[] in) 
		{
			this.root=this.construct(pre,0,pre.length-1,in,0,in.length-1);
		}

		private Node construct(int[] pre,int psi,int pei,int[] in,int isi,int iei) 
		{
			if(psi>pei) 
			{
				return null;
			}
			Node node=new Node(pre[psi]);
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
			node.left=this.construct(pre,psi+1,psi+clc,in,isi,isi+clc-1);
			node.right = this.construct(pre,psi+clc+1,pei,in,isi+clc+1,iei);
			return node;
		}
		
		public void preOrder() 
		{
			preOrder(this.root);
		}

		private void preOrder(Node node) 
		{
			if(node==null) 
			{
				return;
			}
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void main(String[] args)throws Exception 
	{
		int[] in={ 12, 25, 30, 37, 40, 50, 60, 62, 70, 75, 87 };
		int[] pre={ 50, 25, 12, 37, 30, 40, 75, 62, 60, 70, 87 };
		BinaryTree bt=new BinaryTree(pre, in);
		bt.preOrder();
	}
}