package org.blockchain;

public class Launcher {

    public static void main(String[] args) {
        System.out.println("Creating blockchain...\n");
        Blockchain blockchain = new Blockchain();

        System.out.println("Mining block 1...");
        blockchain.addBlock(new Block(1, System.currentTimeMillis(), "Alice -> Bob: 10 BTC", ""));

        System.out.println("\nMining block 2...");
        blockchain.addBlock(new Block(2, System.currentTimeMillis(), "Bob -> Carlos: 5 BTC", ""));

        System.out.println("\nMining block 3...");
        blockchain.addBlock(new Block(3, System.currentTimeMillis(), "Carlos -> Diana: 3 BTC", ""));

        blockchain.print();

        System.out.println("Is chain valid? " + blockchain.isChainValid());

        System.out.println("\n=== ATTEMPTED MANIPULATION ===");
        System.out.println("Attempting to modify block 1...");
        blockchain.getBlock(1).setData("Alice -> Bob: 100 BTC (FRAUDE)");
        System.out.println("Is the chain still valid? " + blockchain.isChainValid());
    }


}
