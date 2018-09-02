package telran.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;


public class Tree<E> implements Set<E> {
	
	Comparator<E> comp;
	NodeTree<E> root;
	int size = 0;
	private int spacePerLevel = 4;
	
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		Integer[] arr = {100, 80, 40, 30, 20, 50, 82, 90, 85, 95};
		createTree(tree, arr);
		tree.balanceTree();
		tree.printRotated();
	}
	
	private static void createTree(Tree<Integer> tree, Integer[] array) {
		for(Integer number: array) {
			tree.add(number);
		}
	}
	
	public Tree() {
		this.comp = (Comparator<E>)Comparator.naturalOrder();
	}
	
	public Tree(Comparator<E> comp) {
		this.comp = comp;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return findNode(o) != null;
	}

	@Override
	public Iterator<E> iterator() {
		return new TreeIterator<E>(this);
	}

	@Override
	public Object[] toArray() {
		if(size == 0) return null;
		Object[] res = new Object[size];
		int ind = 0;
		for(E v: this) {
			res[ind++] = v;
		}
		return res;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return null;
	}

	@Override
	public boolean add(E e) {
		//TODO add auto-start balancing if length diff more than 20%
		if(contains(e)) 
			return false;
		NodeTree<E> parent = null;
		NodeTree<E> newNode = new NodeTree<>(e);
		if(this.root == null) {
			this.root = newNode;
		} else {
			parent = getParent(e);
			if(comp.compare(e, parent.obj)<0)
				parent.left = newNode;
			else
				parent.right = newNode;
		}
		newNode.parrent = parent;
		size++;
		int height = this.height();
		int optHeight = (int) (Math.log(size) / Math.log(2)) + 1;
		if (optHeight * 1.2 < height)
			this.balanceTree();
		return true;
	}

	private NodeTree<E> getParent(E e) {
		NodeTree<E> parent = root;
		NodeTree<E> current = root;
		while(current != null) {
			parent = current;
			current = comp.compare(e, current.obj)<0 ?
					current.left: current.right;
		}
		return parent;
	}

	@Override
	public boolean remove(Object o) {
		boolean res = false;
		NodeTree<E> node = findNode(o);
		if(node != null) {
			if(node.left != null && node.right != null) {
				removeJunction(node);
			} else {
				removeSimpleNode(node);
			}
			res = true;
		}
		return res;
	}
	
	private void removeJunction(NodeTree<E> node) {
		NodeTree<E> substitute = getSubstitute(node.right);
		node.obj = substitute.obj;
		removeSimpleNode(substitute);
	}
	
	private NodeTree<E> getSubstitute(NodeTree<E> node){
		while (node.left != null) 
			node = node.left;
		return node;
	}
	
	private void removeSimpleNode(NodeTree<E> node) {
		NodeTree<E> parrent = node.parrent;
		NodeTree<E> child = node.left == null ? node.right : node.left;
		if (parrent != null) {
			if(parrent.left == node) parrent.left = child;
			if(parrent.right == node) parrent.right = child;
			if(child != null) child.parrent = parrent;
		} else {
			this.root = child;
			if(child != null) child.parrent = null;
		}
		this.size--;
	}
	
	private NodeTree<E> findNode(Object o){
		NodeTree<E> current = root;
		while(current != null && !o.equals(current.obj)) {
			current = comp.compare((E) o, current.obj)<0 ? 
				current.left : current.right;
		}
		return current;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		NodeTree<E> cur;
		for(Object curCollObj: c) {
			cur = findNode(curCollObj);
			if(cur == null) return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean res = false;
		for(E curCollObj: c) {
			add(curCollObj);
			res = true;
		}
		return res;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		if(c.containsAll(this)) {
			return false;
		}
		removeIf(x->!c.contains(x));
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		if(c.containsAll(this)) {
			return false;
		}
		removeIf(x->c.contains(x));
		return true;
	}
	
	@Override
	public void clear() {
		removeIf(x -> true);
		/*for(E obj: this) {
			remove(obj);
		}*/
		this.size = 0;
		this.root = null;
	}
	
	public int getSizeRecursion() {
		return getSizeRecursion(root);
	}
	
	private int getSizeRecursion(NodeTree<E> root) {
		int res = 0;
		if(root != null) {
			res = getSizeRecursion(root.left) + getSizeRecursion(root.right) + 1;
		}
		return res;
	}
	
	private void printRotated() {
		printRotated(root, 0);
	}

	private void printRotated(NodeTree<E> root, int level) {
		if(root != null) {
			printRotated(root.right, level+1);
			printRoot(root, level);
			printRotated(root.left, level+1);
		}
	}

	private void printRoot(NodeTree<E> root, int level) {
		printShift(level);
		System.out.println(root.obj);
	}

	private void printShift(int level) {
		for(int i = 0; i < level * spacePerLevel ; i++) {
			System.out.print(" ");
		}
	}

	public Integer width() {
		return width(root);
	}

	private Integer width(NodeTree<E> node) {
		if(node == null) return 0;
		if(node.left == null && node.right == null) return 1;
		return width(node.left) + width(node.right);
	}

	public Integer height() {
		return height(root, 0);
	}

	private Integer height(NodeTree<E> node, int i) {
		if(node == null) return i;
		i++;
		return Math.max(height(node.right, i), height(node.left, i));
	}
	
	public void balanceTree() {
		E[] arr = (E[]) this.toArray();
		balancing(root, arr);
	}

	private void balancing(NodeTree<E> node, E[] arr) {
		int index = arr.length / 2;
		node.obj = arr[index];
		if(arr.length > 2) {
			E[] arrRight = Arrays.copyOfRange(arr, index + 1, arr.length);
			NodeTree<E> rightNode = new NodeTree<E>(null);
			node.right = rightNode;
			rightNode.parrent = node;
			balancing(rightNode, arrRight);			
		}
		if(arr.length > 1) {
			E[] arrLeft = Arrays.copyOfRange(arr, 0, index);
			NodeTree<E> leftNode = new NodeTree<E>(null);
			node.left = leftNode;
			leftNode.parrent = node;
			balancing(leftNode, arrLeft);			
		}
	}
	

}
