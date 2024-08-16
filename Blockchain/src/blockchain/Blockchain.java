/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

/**
 *
 * @author Client
 */
import java.util.ArrayList;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<>();
    public static int difficulty = 5; // Adjust for more or less difficulty

    // Check if the blockchain is valid
    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal");
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    // Add a block to the chain
    public static void addBlock(Block newBlock) {
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    // Synchronize blockchain across nodes
    public static void synchronizeBlockchain(ArrayList<Block> otherChain) {
        if (otherChain.size() > blockchain.size() && isChainValid(otherChain)) {
            blockchain = new ArrayList<>(otherChain);
            System.out.println("Blockchain synchronized!");
        } else {
            System.out.println("Received chain is not valid!");
        }
    }

    // Check validity of a provided blockchain
    public static boolean isChainValid(ArrayList<Block> chain) {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                return false;
            }
        }
        return true;
    }
}