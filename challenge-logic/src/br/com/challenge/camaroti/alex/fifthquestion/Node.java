package br.com.challenge.camaroti.alex.fifthquestion;

public class Node {

	private Object element;
	private Node next;
	
	public Node(Object element, Node next) {
		super();
		this.element = element;
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
	
}
