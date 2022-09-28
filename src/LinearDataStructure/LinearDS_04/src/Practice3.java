package LinearDataStructure.LinearDS_04.src;// Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList() {

    }

    CircularLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
        node.next = node;
        node.prev = node;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }

        return false;
    }

    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (head == null) {
            head = new NodeBi(data, null, null);
            tail = head;
            head.next = head;
            head.prev = head;
            return;
        }

        if (beforeData == null) {
            tail.next = new NodeBi(data, head, tail);
            head.prev = tail.next;
            tail = tail.next;
            return;
        }

        NodeBi cur = head;
        NodeBi prev = cur;
        do {
            if (beforeData == cur.data) {
                if (cur == head) {
                    head = new NodeBi(data, head, tail);
                    tail.next = head;
                    head.prev = head;
                    return;
                }

                prev.next = new NodeBi(data, cur, prev);
                cur.prev = prev.next;
            }

            prev = cur;
            cur = cur.next;
        } while (cur != head);
    }

    //  연결 리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeBi cur = head;
        NodeBi prev = cur;
        while (cur != null) {
            if (data == cur.data) {
                if (cur == head && cur == tail) {
                    this.head = null;
                    this.tail = null;
                    return;
                }

                if (cur == head) {
                    cur.next.prev = head.prev;
                    tail.next = cur.next;
                    head = cur.next;
                    return;
                }

                if (cur == tail) {
                    prev.next = cur.next;
                    tail = prev;
                    head.prev = tail;
                    return;
                }

                prev.next = cur.next;
                cur.next.prev = prev;
                break;
            }

            prev = cur;
            cur = cur.next;
        }
    }

    public void showData() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeBi cur = head;
        while(cur.next != head) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1, null, null));
        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();  // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();  // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
    }
}
