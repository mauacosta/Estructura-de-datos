public class LinkedList<T> {
	
	private Node<T> start;
	
	public LinkedList() {
	}
	
	
	public void removeFirst() {
		if(start==null) {
			System.out.println("Nothing to remove");
		}else {
			start=start.getNext();
		}
	}
	
	public void removeLast() {
		if(start==null) {
			System.out.println("Nothing to remove");
		}else {
			if(count()==1) {
				start=null;
			}else {
				
				Node<T> temp= start;
				while(temp.getNext().getNext()!=null) {
					temp=temp.getNext();
				}				
				temp.setNext(null);
				
			}

		}
	}
	public Node<T> getLastNode(){
		if(start==null) {
			System.out.println("Nothing to get");
			return null;
		}else {
			Node<T> temp=start;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			return temp;
		}
	}
	
	public Node<T> getFirstNode(){
		if(start==null) {
			System.out.println("Nothing to get");
			return null;			
		}else {
			return start;
		}
	}
	
	public Node<T> getNodeAtIndex(int index){
		if(index<0||index>count()-1) {
			System.out.println("Index out of bounds");
			return null;
		}else {
			int count=0;
			Node<T> temp=start;
			while(count!=index) {
				count++;
				temp=temp.getNext();
			}
			return temp;
		}
		
	}
	
	public void insertElementAtIndex(int index,T element) {
		if(index<0||index>count()) {
			System.out.println("Index out of bounds");
		}else {
			if(count()==0) {
				addElementAtStart(element);
			}
			int count=0;
			Node<T> temp=start;
			if(index!=0) {
				while(count!=index-1) {
					count++;
					temp=temp.getNext();
				}
				Node<T> newNode= new Node<T>(element);
				newNode.setNext(temp.getNext());
				temp.setNext(newNode);
			}else {
				addElementAtStart(element);
			}
		}
	}
	
	public T getElementAtIndex(int index) {
		return getNodeAtIndex(index).getElement();
	}
	
	public T getLastElement() {
		return getLastNode().getElement();
	}
	
	public T getFirstElement() {
		return getFirstNode().getElement();
	}
	
	public void addElementAtStart(T element) {
		if(start==null) {
			start= new Node<T>(element);
		}else {
			
			Node<T> newNode= new Node<T>(element);
			newNode.setNext(start);
			start= newNode;
		}
	}
	
	public void addElementAtEnd(T element) {
		if(start==null) {
			start= new Node<T>(element);
		}else {
			Node<T> temp= start;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			temp.setNext(new Node<T>(element));
		}
		
	}
	
	public int count() {
		int c=0;
		if(start!=null) {
			Node<T> temp=start;
			while(temp!=null) {
				c++;
				temp=temp.getNext();
			}
		}
		return c;
	}
	
	
	
	public Node<T> getStart() {
		return start;
	}


	public void setStart(Node<T> start) {
		this.start = start;
	}
	
	public String toString() {
		if(start==null) {
			return "Empty list";
		}else {
			Node<T> temp= start;
			String resultado="[";
			while(temp!=null) {
				resultado=resultado+" "+temp.getElement()+",";
				temp=temp.getNext();
			}
			resultado=resultado+"]";
			return resultado;
		}		
	}


	public void print() {
		if(start==null) {
			System.out.println("Empty list");
		}else {
			Node<T> temp= start;
			while(temp!=null) {
				System.out.println(temp.getElement().toString());
				temp=temp.getNext();
			}
		}
	}

}