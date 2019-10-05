package Aula10.ex2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.lang.Comparable;

public class BinarySearchTree<T extends Comparable<? super T>>
 implements Iterable<T> {
// o elemento do tipo T deve ser comparável para efectuar pesquisas
// mas como pode herdar a implementação de compareTo() é mais correcto
// usar <? super T>
	private static class BSTNode<T> {
		T element;
		BSTNode<T> left;
		BSTNode<T> right;
		BSTNode(T theElement) {
			element = theElement;
			left = right = null;
		}
		
		public BSTNode<T> subTreeMin(){
			return subTreeMin(this);
		}
		
		private BSTNode<T> subTreeMin(BSTNode<T> root){
			if(root.left == null)
				return root;
			return subTreeMin(root.left);
		}
		
		
	}
	
	private BSTNode<T> root;
	private int numNodes;

	public BinarySearchTree() {
		root = null;
		numNodes = 0;
	}
	public void insert(T value) {
		if(contains(value)) return;
		root = insert(value, root);
	}
	
	private BSTNode<T> insert(T value,BSTNode<T> root){
		if(root == null) {
			numNodes++;
			return new BSTNode<T>(value);
		}
		
		int n = value.compareTo(root.element);
		
		if(n<0) {
			root.left = insert(value,root.left);
			return root;
		}else {
			root.right = insert(value,root.right);
			return root;
		}
	}
	
	public void remove(T value) {
		if (root == null)
			throw new NullPointerException();
		if(!contains(value))
			throw new NoSuchElementException();
		numNodes--;
		root = remove(value, root);
	}
	
	private BSTNode<T> remove(T value, BSTNode<T> root) {
		int n = value.compareTo(root.element);
		
		if(n<0)
			root.left=remove(value,root);
		else if(n>0)
			root.right=remove(value,root);
		else if(root.left == null)
			root = root.right;
		else if(root.right == null)
			root = root.left;
		else {
			root = root.subTreeMin();
			remove(root.element);
		}
		
		return root;
	}
	public boolean contains(T value) {
		Iterator<T> iter = iterator();
		while (iter.hasNext())
			if(((T)iter.next()).equals(value))
				return true;
		return false;
	}
	
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}
	
	public class BSTIterator<T> implements Iterator<T>{
		
		Stack<BSTNode<T>> pilha;
		
		public BSTIterator(BSTNode<T> root) {
			pilha = new Stack<>();
			while(root!=null) {
				pilha.push(root);
				root = root.left;
			}
		}

		@Override
		public boolean hasNext() {
			return !pilha.isEmpty();
		}

		@Override
		public T next() {
			BSTNode<T> node = pilha.pop();
			T top = node.element;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					pilha.push(node);
					node = node.left;
				}
			}
			return top;
		}
	}
}
		
