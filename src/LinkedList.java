/*public class LinkedList {
    Node head;

    class Node{
        employee employee;  //data in node is object of type employee
        Node next;

        //constructor
        Node(employee employee){
            this.employee = employee;
        }
    }

    //add function adds a new node to the linked list and uses an object of type employee to fill data
    public void add(employee employee){

        Node new_node = new Node(employee);
        new_node.next = null;

        if(head == null) {
            head = new_node;
        }
        else{
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
    }

    //search runs through the list and searches for a match
    public boolean search(int id, int salary){
        Node temp = head;
        boolean found = false;
        while(temp.next != null){
            employee current = temp.employee;
            if(current.getId() == id && current.getSalary() == salary){
                found = true;
                break;
            }
            temp = temp.next;
        }
        if(found){
            System.out.println("Employee found!\n");
            temp.employee.print();
            return true;
        }
        else {System.out.println("Employee not found\n"); return false;}

    }

    //delete search for target and if it exists resets links from node before it to node after it
    //effectively deleting it
    public void delete(employee employee){
        if(!search(employee.getId(), employee.getSalary())) {
            System.out.println("Non-existent employee cannot be deleted\n");
            return;
        }
        else {
            Node temp = head;
            employee current = temp.next.employee;
            boolean found = false;
            while(temp.next.next != null){
                if(current.getId() == employee.getId() && current.getSalary() == employee.getSalary()){
                    temp.next = temp.next.next;
                    System.out.println("employee deleted\n");
                    break;
                }
                temp = temp.next;
            }

        }
    }

}
*/