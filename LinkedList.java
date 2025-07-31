public class LinkedList{
public static class Node{
    int data;
    Node next;
    
    public Node(int data)
    {
        this.data=data;
        this.next=null;

    }
}
public static Node head;
public static Node tail;
public static int size;

public void addFirst(int data)
{
    Node newnNode=new Node(data);
    size++;
    if(head==null)
    {
    head=tail=newnNode;
    return;
    }
    newnNode.next=head;
    head=newnNode;
}
public void addLast(int data)
{
    Node newNode=new Node(data);
    size++;
    if(head==null)
    {
        head=tail=newNode;
        return;
    }
    tail.next=newNode;
    tail=newNode;
}

public void print()
{
    Node temp=head;
    while(temp!=null)
    {
        System.out.print(temp.data+"->");
        temp=temp.next;
    }
    System.out.println("null");
}

public void add(int index,int data)
{
    if(index==0)
    {
        addFirst(data);
        return;
    }
    Node newNode=new Node(data);
    size++;
    Node temp=head;
    int i=0;
    while(i<index-1)
    {
        temp=temp.next;
        i++;
    }
    //i=idx-1   => temp->prev
    newNode.next=temp.next;
    temp.next=newNode;
}

public int removeFirst()
{
    if(size==0)
    {
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;
    }
    if(size==1)
    {
        int val=head.data;
        head=tail=null;
        size=0;
        return val;
    }
    int val=head.data;
    head=head.next;
    size--;
    return val;
}

public int removeLast()
{
    if(size==0)
    {
        System.out.println("LL is empty");
        return Integer.MIN_VALUE;
    }
    if(size==1)
    {
        int val=head.data;
        head=tail=null;
        size=0;
        return val;
    }
    Node prev=head;
    for(int i=0;i<size-2;i++)
    {
        prev=prev.next;
    }
    int val=prev.next.data; //tail.data....
    prev.next=null;
    tail=prev;
    size--;
    return val;
}

public int Search(int key)
{
    if(head==null)
    {
        System.out.println("LL is empty");
    }
    Node temp=head;
    int i=0;
    while(temp!=null)
    {
        if(temp.data==key){
            return i;
        }
        else{
            temp=temp.next;
            i++;
        }
    }

    return -1;
}

public void reverse()  //O(n)
{
    Node prev=null;
    Node curr=tail=head;
    Node next;

    while(curr!=null)
    {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    head=prev;
}

public void deleteNthfromEnd(int n)
{
    int sz=0;
    Node temp=head;
    while(temp!=null)
    {
        temp=temp.next;
        sz++;
    }
    if(n==sz)
    {
        head=head.next;
        return;
    }
    int i=1;
    int iToFind=sz-n;
    Node prev=head;
    while(i<iToFind)
    {
        prev=prev.next;
        i++;
    }
    prev.next=prev.next.next;
    return;
}

//slow-fast Approach !!!
public Node findMid(Node head)
{
    Node slow=head;
    Node fast=head;

    while(fast!=null && fast.next!=null)
    {
        slow=slow.next; //+1
        fast=fast.next.next; //+2
    }
    return slow; //slow is my midnode..
}

public boolean checkPalindrome()
{
    if(head==null || head.next==null)
    {
        return true;
    }
   // step 1:- find midNode

    Node midNode=findMid(head);  

   // step 2:- reverse 2nd half
    Node prev=null;
    Node curr=midNode;
    Node next;

    while(curr!=null)
    {
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    Node right=prev; //right half ka head
    Node left=head;

   // step 3:- check left half & right half
    while(right!=null)
    {
        if(left.data!=right.data)
        {
            return false;
        }
        left=left.next;
        right=right.next;
    }
    return true;

}

public static boolean detectCycle()
{
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast){
            return true;
        }
    }
    return false;
}

public static void removeCycle()
{
    //detect cycle
    Node slow=head;
    Node fast=head;
    boolean cycle=false;
    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
        {
            cycle=true;
            break;
        }
    }
    if(cycle==false)
    {
        return;
    }

    //find meeting point..
    slow=head;
    Node prev=null;
    while(slow!=fast)
    {
        prev=fast;
        slow=slow.next;
        fast=fast.next;
    }

    //remove cycle 
    prev.next=null;
    
}
private Node getMid(Node head){
    Node slow=head;
    Node fast=head.next;

    if(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow; //mid node

}
private Node merge(Node head1, Node head2)   
{
    Node mergedLL=new Node(-1);
    Node temp=mergedLL;

    while(head1!=null && head2!=null)
    {
        if(head1.data<=head2.data)
        {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        else
        {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
    }
    while(head1!=null)
    {
        temp.next=head1;
        head1=head1.next;
        temp=temp.next;
    }
    while(head2!=null)
    {
        temp.next=head2;
        head2=head2.next;
        temp=temp.next;
    }
    return mergedLL.next;
}
public Node mergeSort(Node head)   //O(nlogn)
{
    if(head==null || head.next ==null)
    {
        return head;
    }
    //find mid
    Node mid=getMid(head);

    //left & right MS
    Node righthead=mid.next;
    mid.next=null;
    Node newLeft=mergeSort(head);
    Node newRight=mergeSort(righthead);

    //merge
    return merge(newLeft, newRight);
}

    public void ZigZag()
    {
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;

        //reveerse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        while(curr!=null)
        {
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        //zig zag merge

        while(left!=null && right!=null)
        {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }
public static void main(String[] args) {
    LinkedList ll =new LinkedList();
   // ll.print();
//     ll.addFirst(2);
//    // ll.print();
//     ll.addFirst(1);
//    // ll.print();
//     ll.addLast(4);
//    // ll.print();
//     ll.addLast(5);
//     ll.add(2, 3);

//     ll.print();
   // System.out.println(ll.size);
    // ll.removeFirst();
    // ll.print();

    // ll.removeLast();
    // ll.print();
   // System.out.println(ll.size);
  //  System.out.println(ll.Search(5));
  //  System.out.println(ll.Search(10  ));
   // ll.reverse();
   // ll.print();
    //  ll.deleteNthfromEnd(3);
    //  ll.print();

//     ll.addLast(1);
//     ll.addLast(2);
//     ll.addLast(1);
//   //  ll.addLast(1);

    // ll.print();
    // System.out.println(ll.checkPalindrome());

    // head=new Node(1);
    // Node temp=new Node(2);
    // head.next=temp;
    // head.next.next=new Node(3);
    // head.next.next.next=temp;

    // System.out.println(detectCycle());
    // removeCycle();
    // System.out.println(detectCycle());
    
    // ll.addFirst(1);
    // ll.addFirst(2);
    // ll.addFirst(3);
    // ll.addFirst(4);
    // ll.addFirst(5);
    
    // ll.print();
    // ll.head=ll.mergeSort(head);
    // ll.print();

    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(3);
    ll.addLast(4);
    ll.addLast(5);
   // 1->2->3->4->5
    ll.print();
    ll.ZigZag();
    ll.print();

}
}
