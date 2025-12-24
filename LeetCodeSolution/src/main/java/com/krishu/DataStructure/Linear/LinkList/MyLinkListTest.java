package com.krishu.DataStructure.Linear.LinkList;

public class MyLinkListTest {
    public static void main(String[] args) {
        test1();
    }
    static void test1() {
        MyLinkList<Integer> linkList = new MyLinkList<>();
        for (int i = 1; i <= 20; i++) {
            linkList.insertAtBegining(i);
        }
        System.out.println(linkList.toString());
        linkList.insertAtEnd(0);
        System.out.println(linkList.toString());
        linkList.insertAtIndex(2, 22);
        System.out.println(linkList.toString());
        linkList.removeAtIndex(2);
        System.out.println(linkList.toString());
        linkList.insertAtIndex(0, 21);
        System.out.println(linkList.toString());
        linkList.removeFromBegining();
        System.out.println(linkList.toString());
        linkList.removeFromEnd();
        System.out.println(linkList.toString());

        System.out.println("21 contain: " + linkList.contain(21));
        System.out.println("3 contain: " + linkList.contain(3));



    }
}
