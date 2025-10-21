package org.blockchain;

/**
 * Este proyecto <b>NO simula el funcionamiento completo de una blockchain real</b>, sino que es una <b>implementacion educativa
 * simplificada</b> que captura solo algunos conceptos fundamentales.
 * <p>
 * TODO Ver codigo fuente de Bitcoin en C
 */

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

        // Verifica si la blockchain es valida
        System.out.println("Is chain valid? " + blockchain.isBlockchainValid());

        // Genera un intento de manipulacion en la blockchain para luego verificar si la blockchain es valida, que obviamente no es asi
        System.out.println("\n=== ATTEMPTED MANIPULATION ===");
        System.out.println("Attempting to modify block 1...");
        blockchain.getBlock(1).setData("Alice -> Bob: 100 BTC (FRAUDE)");
        System.out.println("Is the chain still valid? " + blockchain.isBlockchainValid());
    }


}
