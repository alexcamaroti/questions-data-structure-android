package br.com.challenge.camaroti.alex.fifthquestion;

import java.util.LinkedList;

public class EmailThreadUtil {
	
	public static void main(String[] args) throws InterruptedException {

		LinkedList<Node> nodes = new LinkedList<>();
		
		Node msg1 = new Node("Hi, Good Morning!", null);
		Node msg2 = new Node("Hi, What's up?", null);
		Node msg3 = new Node("Hey, What's the craic?", null);
		Node msg4 = new Node("Hi, What's up?", null);
		Node msg5 = new Node("Heya!", null);
		Node msg6 = new Node("Hey, What's the craic?", null);

		msg1.setNext(msg2);
		msg2.setNext(msg3);
		msg3.setNext(msg4);
		msg4.setNext(msg5);
		msg5.setNext(msg6);
		
		nodes.add(msg1);
		nodes.add(msg2);
		nodes.add(msg3);
		nodes.add(msg4);
		nodes.add(msg5);
		nodes.add(msg6);
		
		Node headNode = nodes.getFirst();
		Node oldNode = headNode;
		Node rebuiltNode = headNode;
		Object msg = headNode.getElement();		
		Node validatingNode = headNode;
		
		System.out.println("-------OLD LIST-----------");
		while(oldNode != null) {
			System.out.println(oldNode.getElement());
			oldNode = oldNode.getNext();
		}
		
		while(headNode != null) {
			while (validatingNode != null) {
					if(validatingNode.getNext() != null && msg.equals(validatingNode.getNext().getElement().toString())) {
						if(validatingNode.getNext().getElement().equals(msg)) {
							validatingNode.setNext(validatingNode.getNext().getNext());
							validatingNode = validatingNode.getNext();	
						}
						
					} else {
						validatingNode = validatingNode.getNext();					
					}
				
			}
			if(headNode.getNext() != null) {
				validatingNode = headNode.getNext();
				msg = validatingNode.getElement();
				headNode = headNode.getNext();	
			} else {
				headNode = null;
				
			}

		}
		
		System.out.println("-------NEW LIST-----------");
		while(rebuiltNode != null) {
			System.out.println(rebuiltNode.getElement());
			rebuiltNode = rebuiltNode.getNext();
		}
		
	}

}
