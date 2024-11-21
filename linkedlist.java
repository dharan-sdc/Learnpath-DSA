package begL.pcNov;

import java.util.Scanner;

class Node{  //default create to every node's next is null
    int data;
    Node next;//hold addr through obj

    Node(int data) {
        this.data=data;
        this.next=null;
    }

}
class SinglyLL{
    Node head=null;// head address = null

    void inBegin(int data) {
        Node newNode = new Node(data);  //create a node (obj=addr);
        if(head==null) {
            newNode.next = head; // newNode.next->head addr(obj);
            head = newNode; // head addr-> newNode addr(obj);
            return;
        }else{
            newNode.next=head;
            head=newNode;
            return;
        }
    }

    void inEnd(int data) {
        Node newNode = new Node(data); // create a node
        if (head == null) {
            head = newNode;
            return; // return to called method place (main method)
        }
        Node curr=head; //create a temp traversal node
        while (curr.next != null) {
            curr=curr.next;
        }
        curr.next=newNode;
        return;
    }
/*
    void inPosition(int pos, int data) {
        if (head == null) {
            System.out.println("Out of LL");
            return;
        }
        Node curr=head;
        while (curr.next != null) {
            if (curr.data == pos) {
                Node newNode = new Node(data);
                newNode.next=curr.next;
                curr.next=newNode;
                System.out.println(" Node Inserted " + data + " is after position of "+pos);
                return;
            }
            curr=curr.next;
        }
        System.out.println("Invalid Position "+pos);
        return;
    }
*/

    void inBefPos(int pos, int data) {
        if (head == null) {
            System.out.println("\nEmpty LinkedList");
            return;
        }
        if (head.data == pos) {
            inBegin(data);
            return;
        }
        Node curr=head;
        while (curr.next != null && curr.next.data != pos) { //67!=27 is true & 27!=27 is false
            curr=curr.next;
        }
         if (curr.next.data == pos) {
            Node newNode = new Node(data);
            newNode.next=curr.next;
            curr.next=newNode;
            return;
        }
        System.out.println("\nValue Doesn't found in LinkedList");
        return;
    }

    void inAfter(int pos, int data) {
        if (head == null) {
            System.out.println("\nEmpty LinkedList");
            return;
        }
        Node curr=head;
        while (curr.next != null && curr.data != pos) { //67!=27 is true & 27!=27 is false
            curr=curr.next;
        }

        if (curr.data == pos) {
            Node newNode = new Node(data);
            newNode.next=curr.next;
            curr.next=newNode;
            System.out.println("\nNode Inserted " + data + " is after position of "+pos);
            return;
        }
        System.out.println("\nValue Doesn't found in LinkedList");
        return;
    }

    void del(int key) {
        if(head==null) {
            System.out.println("\n\nEmpty LinkedList");
            return;
        }
        if(head.data==key) {
            head=head.next;

            return;
        }
        Node curr=head;
        while(curr.next!=null && curr.next.data!=key) {
            curr=curr.next;
        }
        if(curr.next!=null && curr.next.data==key) {
            curr.next=curr.next.next;
            return;
        }
        System.out.println("\nValue Doesn't found in LinkedList");
        return;

    }
    void search(int value) {
        if(head==null) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node curr=head;
        int pos=0;
        while(curr.next!=null && curr.data!=value) {
            curr=curr.next;
            pos++;
        }
        if(curr.data==value) {
            System.out.println("\n"+value+" at Position of "+pos);
            return;
        }
        System.out.println("Value Doesn't Found in LinkedList");
        return;
    }
    void sorting() {
        if(head==null) {
            System.out.println("Empty LinkedList");
            return;
        }
        for (Node curr = head; curr != null; curr = curr.next) {
            Node minNode = curr;
            for (Node temp = curr.next; temp != null; temp = temp.next) {
                if (temp.data < minNode.data) {
                    minNode = temp;
                }
            }
            if (minNode != curr) {
                int tempData = curr.data;
                curr.data = minNode.data;
                minNode.data = tempData;
            }
        }

    }
    void printLL() {
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node curr=head;
        System.out.println("\nDisplay to LL :");
        System.out.print("head --> ");
        if (curr.next == null) {
            System.out.print(curr.data);
            System.out.print(" --> null");
            return;
        }
        while(curr!= null) {
            System.out.print(curr.data+" --> ");
            curr=curr.next;
            if (curr.next == null) {
                System.out.print(curr.data);
                break;
            }
        }
        System.out.print(" --> null");
        return;
    }
}

public class linkedlist {
    public static void main(String[] args) {
        SinglyLL s = new SinglyLL();
        System.out.println("--SinglyLinkedList--");
        boolean choice = true;
        while (choice) {
            System.out.println("\nSLL Menus:\n1.insert at Begin\n2.insert at end\n3.insert node before a value\n4.insert node after a value\n5.delete\n6.search a value\n7.sorting a LL\n8.Print a Ll\n9.Exit");
            System.out.print("Enter a choice : ");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter a value at Begin : ");
                    int data = sc.nextInt();
                    s.inBegin(data);
                    System.out.println("\nNode Insert");
                    break;
                case 2:
                    System.out.print("Enter a value at Begin : ");
                    int ld = sc.nextInt();
                    s.inEnd(ld);
                    System.out.println("\nNode Insert");
                    break;
                case 3:
                    System.out.print("Enter a insert value : ");
                    int bi = sc.nextInt();
                    System.out.print("Enter a before value of insert : ");
                    int pos = sc.nextInt();
                    s.inBefPos(pos, bi);
                    System.out.println("\nNode Inserted before at position "+pos);
                    break;
                case 4:
                    System.out.print("Enter a insert value : ");
                    int ai = sc.nextInt();
                    System.out.print("Enter a before value of insert : ");
                    int posi = sc.nextInt();
                    s.inAfter(posi, ai);
                    break;
                case 5:
                    System.out.print("Enter a value : ");
                    int del = sc.nextInt();
                    s.del(del);
                    System.out.println("\nNode Deleted");
                    break;
                case 6:
                    System.out.print("Enter a value : ");
                    int sr = sc.nextInt();
                    s.search(sr);
                    break;
                case 7:
                    s.sorting();
                    System.out.println("\nSorting Completed");
                    s.printLL();
                    System.out.println();
                    break;
                case 8:
                    s.printLL();
                    System.out.println();
                    break;
                case 9:
                    System.out.println("\nExiting..");
                    choice=false;
                    break;
                default:
                    System.out.println("\nInvalid Option");
                    break;
            }
        }
    }
}
