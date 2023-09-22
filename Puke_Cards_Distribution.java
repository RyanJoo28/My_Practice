package Puke_Cards_Distribution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puke_Cards_Distribution {
    public static void main(String[] args) {
        display();
    }

    public static void display() {
        // Create a list of 52 playing cards
        List<String> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] colors = {"Black", "Red"};
        String joker = "Joker";

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }
        }

        for (String color : colors) {
            deck.add(color + " " + joker);
        }

        // Shuffle the deck to randomize the order of cards
        Collections.shuffle(deck);

        // Number of players
        int numPlayers = 3;

        // get 3 trump cards
        List<String> trumpCards = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            String str = deck.remove(0);
            trumpCards.add(str);
        }

        // Calculate the number of cards each player should receive
        int cardsPerPlayer = deck.size() / numPlayers;

        // Distribute the cards to players
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Player " + (i + 1) + " receives:");
            for (int j = 0; j < cardsPerPlayer; j++) {
                String card = deck.remove(0); // Remove the top card from the shuffled deck
                System.out.println(card);
            }
            System.out.println();
        }

        System.out.println("Trump Cards:");
        trumpCards.forEach(System.out::println);
    }
}
