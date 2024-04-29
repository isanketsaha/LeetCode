package StudyPlan.LinkedList;

public class BrowserHistory {

    public static void main(String[] args) {
        BrowserHistory h = new BrowserHistory("leetcode.com");
        h.visit("google.com");
        h.visit("facebook.com");
        h.visit("youtube.com");
        System.out.print(h.back(1));
        System.out.print(h.back(1));
        System.out.print(h.forward(1));
    }
    private Node head = null;
    public BrowserHistory(String homepage) {
        head = new Node(homepage, head, head);
    }


    public void visit(String url) {

        Node node = new Node(url, head, null);
        head.prev = node;
        head = node;
    }

    public String back(int steps) {
        while(steps!= 0 ){
            head = head.next;
            --steps;
        }
        return head.val;
    }

    public String forward(int steps) {
        while(steps!=0 ){
            head = head.prev;
            --steps;
        }
        return  head.val;
    }
}

    class Node {
        String val;
        Node next;
        Node prev;

        Node(String val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

