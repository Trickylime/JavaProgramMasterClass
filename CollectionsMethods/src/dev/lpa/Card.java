package dev.lpa;

import java.util.ArrayList;
import java.util.List;

record Card(Suit suit, String face, int rank) {

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public char getImage(){
            return (new char[]{9827, 9830, 9829, 9824})[this.ordinal()];
        }
    }

    public static Card getNumericCard(Suit suit, int cardNumber){

        if (cardNumber > 1 && cardNumber < 11){
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid card number selected");
        return null;
    }

    public static Card getFaceCard(Suit suit, char abbrev) {

        int charIndex = "JQKA".indexOf(abbrev);
        int cardNumber = charIndex + 9;
        if (charIndex > -1){
            return new Card(suit, String.valueOf(abbrev), cardNumber);
        }

        System.out.println("Invalid face abbreviation selected");
        return null;
    }

    public static List<Card> getStandardDeck() {

        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()){
            for (int i = 2; i < 11; i++){
                deck.add(getNumericCard(suit, i));
            }
            for (char c : new char[] {'J', 'Q', 'K', 'A'}){
                deck.add(getFaceCard(suit, c));
            }
        }

        return deck;
    }

    public static void printDeck(List<Card> deck) {
        printDeck(deck, "Current Deck", 4);
    }

    public static void printDeck(List<Card> deck, String description, int rows) {
        System.out.println("-".repeat(25));
        if (description != null) {
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for ( int i = 0 ; i < rows; i++){
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex)
                    .forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return face + suit.getImage() + "(" + rank + ")";
    }
}
