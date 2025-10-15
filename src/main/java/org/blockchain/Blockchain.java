package org.blockchain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Este proyecto <b>NO simula el funcionamiento completo de una blockchain real</b>, sino que es una <b>implementacion educativa
 * simplificada</b> que captura solo algunos conceptos fundamentales.
 */

public class Blockchain {

    private final ArrayList<Block> chain;
    private final int difficulty;

    public Blockchain() {
        this.chain = new ArrayList<>();
        this.difficulty = 2; // Numero de ceros requeridos al comienzo del hash
        chain.add(createGenesisBlock());
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        // Comienza desde el bloque 1 (salta el genesis)
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Verifica si el hash actual es correcto
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Invalid hash in block " + i);
                return false;
            }

            // Verifica si el bloque actual se vincula correctamente con el bloque anterior
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Broken chain in block " + i);
                return false;
            }
        }

        return true;
    }

    public void print() {
        System.out.println("\n=== Blockchain ===");
        for (int i = 0; i < chain.size(); i++) {
            Block block = chain.get(i);
            System.out.println("\nBlock #" + i + ":");
            System.out.println("Timestamp: " + new Date(block.getTimestamp()));
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash().substring(0, Math.min(20, block.getPreviousHash().length())) + "...");
            System.out.println("Hash: " + block.getHash().substring(0, 20) + "...");
            System.out.println("Nonce: " + block.getNonce());
        }
    }

    public Block getBlock(int index) {
        return chain.get(index);
    }

    private Block createGenesisBlock() {
        return new Block(0, System.currentTimeMillis(), "Genesis Block", "0");
    }

}
