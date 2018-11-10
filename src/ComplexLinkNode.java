public class ComplexLinkNode {
    private Integer index;
    private ComplexLinkNode next;
    private ComplexLinkNode random;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public ComplexLinkNode getNext() {
        return next;
    }

    public void setNext(ComplexLinkNode next) {
        this.next = next;
    }

    public ComplexLinkNode getRandom() {
        return random;
    }

    public void setRandom(ComplexLinkNode random) {
        this.random = random;
    }

    public ComplexLinkNode(Integer index) {
        this.index = index;
    }



    public static ComplexLinkNode clone(ComplexLinkNode head) {
        // 先复制简单链式节点
        cloneNextNodes(head);

        //在复制随机节点
        cloneRandomNodes(head);

        // 返回分隔的链表头
        return divideLink(head);

    }

    public static void cloneNextNodes(ComplexLinkNode head) {
        while (head != null) {
            ComplexLinkNode tmp = new ComplexLinkNode(head.getIndex());
            tmp.setNext(head.getNext());
            head.setNext(tmp);
            head = tmp.getNext();
        }
    }

    public static void cloneRandomNodes(ComplexLinkNode head) {
        // 如链表不为空
        while (head != null) {
            if (head.getRandom() != null) {
                head.getNext().setRandom(head.getRandom().getNext());
            }
            head = head.getNext().getNext();
        }
    }

    public static ComplexLinkNode divideLink(ComplexLinkNode head) {
        if (head == null) {
            return null;
        }
        ComplexLinkNode newHead = head.getNext();
        ComplexLinkNode tmpNode = newHead;
        head.setNext(newHead.getNext());
        head = head.getNext();
        while (head != null) {
            tmpNode.setNext(head.getNext());
            tmpNode = tmpNode.getNext();
            head.setNext(tmpNode.getNext());
            head = tmpNode.getNext();
        }
        return newHead;
    }

    public static void printComplexLink(ComplexLinkNode head, StringBuffer buffer) {
        buffer.append(head.getIndex());
        buffer.append("(");
        buffer.append(head.getRandom().getIndex());
        buffer.append(")");
        if (null != head.getNext()) {
            buffer.append("->");
            printComplexLink(head.getNext(), buffer);
        }else {
            System.out.println(buffer);
        }

    }

    public static void main(String[] args) {
        // 1(3)->2(1)->3(5)->4(3)-5(1)
        ComplexLinkNode one = new ComplexLinkNode(1);
        ComplexLinkNode two = new ComplexLinkNode(2);
        ComplexLinkNode three = new ComplexLinkNode(3);
        ComplexLinkNode four = new ComplexLinkNode(4);
        ComplexLinkNode five = new ComplexLinkNode(5);

        one.setNext(two);
        one.setRandom(three);

        two.setNext(three);
        two.setRandom(one);

        three.setNext(four);
        three.setRandom(five);

        four.setNext(five);
        four.setRandom(three);

        five.setRandom(one);
        System.out.println("原链表:");
        printComplexLink(one, new StringBuffer());

        ComplexLinkNode copyOne = clone(one);
        System.out.println("复制后原:");
        printComplexLink(one, new StringBuffer());

        System.out.println("复制后新:");
        printComplexLink(copyOne, new StringBuffer());



    }
}
