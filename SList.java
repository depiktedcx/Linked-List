class SList{
    private SNode curr;
    private SNode head;
    //Constructor
    public SList(){
	//Set head to null
	head = null;
    }
    //Add to head of list a new node with a copy of 's' and return void
    //String s, any string to be added as a part of the list
    public void add(String s){
	//Set curr key to given String
	curr = new SNode(s);
	//Set curr next as head
	curr.next = head;
	//Set head as curr SNode
	head = curr;
	return;
    }
    //Return boolean true if list contains 's' else false
    //String s, the string value to be checked against other nodes in the list
    public boolean has(String s){
	curr = head;
	//While SNode is not null check if given String matches any SNode keys
	while(curr != null){
	    if(curr.key.equals(s)){
		return true;
	    }
	    //Move onto next SNode
	    curr = curr.next;
	}
	//If here, no match was found, return false
	return false;
    }
    //Find the first node which matches 's' and remove without affecting order
    //String s, the string value to be removed as a node from the list
    public void remove(String s){
	//Check if values exist
	if(!(isEmpty())){
	    //Check if the given String exists
	    if(has(s)){
		//Check if the head is the given String
		if(head.key.equals(s)){
		    //Set head to head.next so head is no longer referred to and return
		    head = head.next;
		    return;
		}
		//Set curr to head.next
		curr = head.next;
		//Create a SNode to hold previous SNode
		SNode prev = head;
		//While curr is a defined SNode
		while(curr != null){
		    //If curr has the given String as key
		    if(curr.key.equals(s)){
			//Set the prev SNode.next to curr.next
			prev.next = curr.next;
			return;
		    }
		    //Set for next SNode check
		    prev = curr;
		    curr = curr.next;
		}
	    }
	}
	//If here, then no matches were found, and return unchanged
	return;
    }
    //Return length of the list as an int
    public int length(){
	//Define count
	int count = 0;
	//Set to head
	curr = head;
	//If current SNode is not null increase count and continue
	while(curr != null){
	    count++;
	    curr = curr.next;
	}
	//Return amount of SNodes counted
	return count;
    }
    //Return boolean true if list is empty
    public boolean isEmpty(){
	//Check if the head is null
	if(head == null){
	    //Return true if head is null
	    return true;
	}
	//If head isn't null, then return false
	return false;
    }
    //Print all data in the list onto screen
    public void dump(){
	curr = head;
	//Print the current SNode and set current to next SNode
	while(curr != null){
	    System.out.println(curr.key);
	    curr = curr.next;
	}
    }
    class SNode{
        String key;
        SNode next;
	public SNode(String s){
	    key = s;
	}
    }
}
