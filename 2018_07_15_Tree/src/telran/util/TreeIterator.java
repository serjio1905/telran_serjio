package telran.util;

import java.util.Iterator;

public class TreeIterator<E> implements Iterator<E> {

	NodeTree<E> current;
	Tree<E> tree;
	
	public TreeIterator(Tree<E> tree) {
		this.tree = tree;
		this.current = getLastNode(tree.root);
	}

	private NodeTree<E> getLastNode(NodeTree<E> root) {
		NodeTree<E> cur = root;
		while (cur.left != null) 
			cur = cur.left;
		return cur;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public E next() {
		NodeTree<E> res = this.current;
		if(current.right != null) {
			current = getLastNode(current.right);
		} else {
			while(current.parrent != null && current.parrent.right != null && current.parrent.right.obj.equals(current.obj)) {
				current = current.parrent;
			}
			current = current.parrent;
		}
		return res.obj;
	}
	

}
