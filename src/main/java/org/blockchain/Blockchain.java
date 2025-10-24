package org.blockchain;

import java.util.ArrayList;
import java.util.Date;

public class Blockchain {

    /** Lista de objetos Block que representa a la blockchain. */
    private final ArrayList<Block> blockchain;
    /** Numeros de ceros requeridos al comienzo del hash, es decir, el nivel de dificultad. */
    private final int difficulty;

    public Blockchain() {
        this.blockchain = new ArrayList<>();
        this.difficulty = 6;
        blockchain.add(createGenesisBlock()); // Agrega el primer bloque a la blockchain, en donde el primer bloque hace referencia al bloque genesis
    }

    /**
     * Obtiene el ultimo bloque de la blockchain.
     *
     * @return el ultimo bloque de la blockchain
     */
    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    /**
     * Agrega un bloque a la blockchain.
     *
     * @param block nuevo bloque
     */
    public void addBlock(Block block) {
        block.setPreviousHash(getLatestBlock().getHash());
        block.mineBlock(difficulty);
        blockchain.add(block);
    }

    /**
     * Comprueba si la blockchain es valida.
     *
     * @return true si la blockchain es valida o false en caso contrario
     */
    public boolean isBlockchainValid() {
        // Comienza a iterar desde el bloque 1 (salta el bloque genesis)
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i); // Obtiene el bloque actual
            Block previousBlock = blockchain.get(i - 1); // Obtiene el bloque anterior

            // Si el hash del bloque actual no es correcto
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Invalid hash in block [" + i + "]");
                return false;
            }

            // Si el hash del bloque actual no se vincula con el hash del bloque anterior
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                System.out.println("Broken blockchain in block [" + i + "]");
                return false;
            }
        }

        return true;
    }

    /**
     * Imprime en consola la blockchain, es decir, cada uno de los bloques mostrando la informacion almacenada en cada uno. Con
     * informacion me refiero al indice del bloque, la fecha de creacion del bloque (timestamp), la transaccion realizada como por
     * ejemplo "Alice -> Bob: 10 BTC" (los datos del bloque), el hash previo, el hash actual y el nonce.
     */
    public void print() {
        System.out.println("\n[Blockchain]");
        for (int i = 0; i < blockchain.size(); i++) {
            Block block = blockchain.get(i);
            System.out.println("\nBlock #" + i + ":");
            System.out.println("Timestamp: " + new Date(block.getTimestamp()));
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println("Nonce: " + block.getNonce());
        }
    }

    /**
     * Obtiene el bloque especificado.
     *
     * @param index indice del bloque
     * @return el bloque especificado
     */
    public Block getBlock(int index) {
        return blockchain.get(index);
    }

    /**
     * Crea el bloque genesis, es decir el primer bloque en la blockchain.
     *
     * @return el bloque genesis
     */
    private Block createGenesisBlock() {
        return new Block(0, System.currentTimeMillis(), "Genesis Block", "0");
    }

}
