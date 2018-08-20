package telran.util;

public class NodeTree<E> {
	
	E obj;
	NodeTree<E> parrent;
	NodeTree<E> left;
	NodeTree<E> right;
	
	public NodeTree(E obj){
		this.obj = obj;
	}
	
}
