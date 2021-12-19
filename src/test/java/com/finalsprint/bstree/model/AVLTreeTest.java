package com.finalsprint.bstree.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AVLTreeTest {
    @Test
    void testFind() {
        assertNull((new AVLTree()).find(1));
    }

    @Test
    void testFind2() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        assertNull(avlTree.find(1));
    }

    @Test
    void testFind3() {
        // TODO: This test is incomplete.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by find(int)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.find(1);
    }

    @Test
    void testFind4() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        assertNull(avlTree.find(-1));
    }

    @Test
    void testInsert() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        assertEquals(0, avlTree.height());
        assertEquals(1, avlTree.getRoot().key);
    }

    @Test
    void testInsert2() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.insert(1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertNull(root.left);
        AVLTree.Node node = root.right;
        assertEquals(1, node.key);
        assertEquals(0, node.height);
    }

    @Test
    void testInsert3() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        assertThrows(RuntimeException.class, () -> avlTree.insert(1));
    }

    @Test
    void testInsert4() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(-1);
        avlTree.insert(0);
        avlTree.insert(1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertEquals(0, root.key);
        AVLTree.Node node = root.left;
        assertNull(node.left);
        assertEquals(0, node.height);
        AVLTree.Node node1 = root.right;
        assertNull(node1.left);
        assertEquals(1, node1.key);
        assertNull(node.right);
    }

    @Test
    void testInsert5() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.insert(-1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertNull(root.right);
        AVLTree.Node node = root.left;
        assertNull(node.left);
        assertEquals(-1, node.key);
    }

    @Test
    void testInsert6() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.insert(1);
        assertThrows(RuntimeException.class, () -> avlTree.insert(1));
    }

    @Test
    void testInsert7() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(-1);
        avlTree.insert(2);
        avlTree.insert(1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertEquals(1, root.key);
        AVLTree.Node node = root.left;
        assertNull(node.left);
        assertEquals(0, node.height);
        AVLTree.Node node1 = root.right;
        assertNull(node1.left);
        assertEquals(2, node1.key);
        assertEquals(0, node1.height);
        assertNull(node.right);
    }

    @Test
    void testInsert8() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(0);
        avlTree.insert(-1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertEquals(0, root.key);
        AVLTree.Node node = root.left;
        assertNull(node.left);
        assertEquals(-1, node.key);
        AVLTree.Node node1 = root.right;
        assertNull(node1.left);
        assertEquals(1, node1.key);
        assertEquals(0, node1.height);
    }

    @Test
    void testInsert9() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(-1);
        avlTree.insert(1);
        avlTree.insert(0);
        assertThrows(RuntimeException.class, () -> avlTree.insert(-1));
    }

    @Test
    void testInsert10() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(-2);
        avlTree.insert(-1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertEquals(-1, root.key);
        AVLTree.Node node = root.left;
        assertNull(node.left);
        assertEquals(0, node.height);
        AVLTree.Node node1 = root.right;
        assertNull(node1.left);
        assertEquals(1, node1.key);
        assertEquals(0, node1.height);
        assertNull(node.right);
    }

    @Test
    void testDelete() {
        AVLTree avlTree = new AVLTree();
        avlTree.delete(1);
        assertNull(avlTree.getRoot());
    }

    @Test
    void testDelete2() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.delete(1);
        assertEquals(0, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertNull(root.right);
        assertNull(root.left);
    }

    @Test
    void testDelete3() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.delete(1);
        assertNull(avlTree.getRoot());
    }

    @Test
    void testDelete4() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(0);
        avlTree.delete(1);
        assertEquals(0, avlTree.height());
        assertNull(avlTree.getRoot().right);
    }

    @Test
    void testDelete5() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(-1);
        avlTree.insert(0);
        avlTree.delete(1);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertNull(root.left);
        AVLTree.Node node = root.right;
        assertEquals(0, node.key);
        assertEquals(0, node.height);
        assertNull(node.right);
    }

    @Test
    void testDelete6() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.delete(-1);
        assertEquals(0, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertNull(root.right);
        assertNull(root.left);
    }

    @Test
    void testDelete7() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(-1);
        avlTree.insert(0);
        avlTree.delete(0);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertNull(root.right);
        assertEquals(1, root.key);
        assertNull(root.left.left);
    }

    @Test
    void testDelete8() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.insert(1);
        avlTree.insert(-1);
        avlTree.insert(Integer.MIN_VALUE);
        avlTree.delete(0);
        assertEquals(1, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertEquals(-1, root.key);
        AVLTree.Node node = root.right;
        assertNull(node.left);
        assertEquals(1, node.key);
        assertEquals(0, node.height);
        assertNull(node.right);
    }

    @Test
    void testDelete9() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(0);
        avlTree.insert(-2);
        avlTree.insert(-1);
        avlTree.insert(Integer.MIN_VALUE);
        avlTree.delete(0);
        assertEquals(2, avlTree.height());
        AVLTree.Node root = avlTree.getRoot();
        assertEquals(-1, root.key);
        AVLTree.Node node = root.left;
        assertEquals(-2, node.key);
        AVLTree.Node node1 = root.right;
        assertNull(node1.right);
        assertEquals(0, node1.height);
        assertEquals(1, node1.key);
        assertNull(node.right);
        assertEquals(1, node.height);
        assertNull(node1.left);
    }

    @Test
    void testHeight() {
        assertEquals(-1, (new AVLTree()).height());
    }

    @Test
    void testHeight2() {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        assertEquals(0, avlTree.height());
    }

    @Test
    void testGetBalance() {
        AVLTree avlTree = new AVLTree();
        assertEquals(0, avlTree.getBalance((new AVLTree()).new Node(1)));
    }

    @Test
    void testGetBalance2() {
        assertEquals(0, (new AVLTree()).getBalance(null));
    }

    @Test
    void testConstructor() {
        assertNull((new AVLTree()).getRoot());
    }

    @Test
    void testNodeConstructor() {
        AVLTree avlTree = new AVLTree();
        AVLTree.Node actualNode = avlTree.new Node(1);

        assertEquals(0, actualNode.height);
        assertNull(actualNode.right);
        assertNull(actualNode.left);
        assertEquals(1, actualNode.key);
        assertNull(avlTree.getRoot());
        assertEquals(-1, avlTree.height());
    }
}

