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
public class Main {
    public static void main(String[] args) {
        // Add genesis block
        Blockchain.addBlock(new Block("Genesis Block", "0"));

        // Add more blocks
        Blockchain.addBlock(new Block("Second Block", Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash));
        Blockchain.addBlock(new Block("Third Block", Blockchain.blockchain.get(Blockchain.blockchain.size() - 1).hash));

        System.out.println("\nBlockchain is Valid: " + Blockchain.isChainValid());

        // Print the blockchain
        for (Block block : Blockchain.blockchain) {
            System.out.println("\nBlock:");
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Data: " + block.getData());  // Accessing data using the getter
        }
    }
}