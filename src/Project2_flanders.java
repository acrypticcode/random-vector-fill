/*
This program creates a vector called "wallet" and fills the wallet with a number of random objects, and then prints the
contents of the wallet to the user
 */

import java.util.Vector;
import java.util.Collections;

public class Project2_flanders {
    //First, we create enums and a class to represent the different types of objects that can be stored in the wallet
    //(credit cards, photos, miscellaneous cards, paper currency, coins, and playing cards)
    public enum CreditCard {Visa, MasterCard, AmericanExpress, Lowes, BJs, HomeDepot, DinersClub, Debit}

    public enum Photos {Spouse, Dog, Cat, Pet, Children, Friend, Parents, Grandparents}

    public enum MiscCards {DriverLicense, MilitaryID, SSNCard, BloodDonor, Insurance, Library, RecordOfConviction, BarnesAndNoble, Borders}

    public enum PaperCurrency {
        One (1), Five(5), Ten (10), Twenty (20), Fifty (50), Hundred (100);
        private final int value;
        PaperCurrency (int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Coins {

        Penny (0.01), Nickel (0.05), Dime (0.10), Quarter (0.25),
        HalfDollar(0.50);

        private final double value;
        Coins(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    //Suit and rank enums are only used within the playing card class: they can not be placed in the wallet on their own
    public enum Suit {Spades, Hearts, Clubs, Diamonds}

    public enum Rank {Two, Three, Four, Five, Six, Seven, Eight,
        Nine, Ten, Jack, Queen, King, Ace}

    public static class PlayingCard {
        private final Suit suit;
        private final Rank rank;

        public static PlayingCard[] values(){
            int i = 0;
            PlayingCard[] value_list = new PlayingCard[52];
            for (Rank r: Rank.values()){
                for (Suit s: Suit.values()){
                    value_list[i] = new PlayingCard(r,s);
                    i++;
                }
            }
            return value_list;
        }
        public PlayingCard(Rank r, Suit s){
            rank = r;
            suit = s;
        }

        @Override
        public String toString(){
            return rank + " of " + suit;
        }
    }

    //Next, we create methods that can print each type of object in the wallet
    public static void printCreditCards (Vector<Object> w){
        System.out.println("\nCredit Cards:");
        for (Object item: w){
            if (item instanceof CreditCard){
                System.out.println(item);
            }
        }
    }

    public static void printPhotos (Vector<Object> w){
        System.out.println("\nPhotos:");
        for (Object item: w){
            if (item instanceof Photos){
                System.out.println(item);
            }
        }
    }

    public static void printMiscCards (Vector<Object> w){
        System.out.println("\nMiscellaneous Cards:");
        for (Object item: w){
            if (item instanceof MiscCards){
                System.out.println(item);
            }
        }
    }

    public static void printCurrency (Vector<Object> w){
        int currency_value = 0;
        System.out.println("\nPaper Currency:");
        for (Object item: w){
            if (item instanceof PaperCurrency){
                System.out.println(item);
                currency_value += ((PaperCurrency) item).getValue();
            }
        }
        System.out.println("Currency value: " + currency_value + " dollars");
    }

    public static void printCoins (Vector<Object> w){
        double coin_value = 0;
        System.out.println("\nCoins:");
        for (Object item: w){
            if (item instanceof Coins){
                System.out.println(item);
                coin_value += ((Coins) item).getValue();
            }
        }
        System.out.printf("Coin value: %.2f dollars%n",coin_value);
    }

    public static void printPlayingCards (Vector<Object> w){
        System.out.println("\nPlaying Cards:");
        for (Object item: w){
            if (item instanceof PlayingCard){
                System.out.println(item);
            }
        }
    }

    //Our main method
    public static void main(String args[]) {
        //variables defined here
        int number_of_credit_cards, number_of_photos, number_of_misc_cards, amount_of_currency, number_of_coins, number_of_cards, i;
        CreditCard credit_card_types[], new_credit_card;
        Photos photo_types[], new_photo;
        MiscCards misc_cards_types[], new_misc_card;
        PaperCurrency currency_types[], new_currency;
        Coins coin_types[], new_coin;
        PlayingCard playing_card_types[], new_playing_card;
        Vector<Object> wallet = new Vector<>();

        //We create arrays containing all possible values of the class and enums that represent our wallet's contents
        credit_card_types = CreditCard.values();
        photo_types = Photos.values();
        misc_cards_types = MiscCards.values();
        currency_types = PaperCurrency.values();
        coin_types = Coins.values();
        playing_card_types = PlayingCard.values();

        //We randomly determine the number of each type of object in the wallet
        number_of_credit_cards = (int) (Math.random() * 4) + 2;
        number_of_photos = (int) (Math.random() * 11);
        number_of_misc_cards = (int) (Math.random() * 4) + 3;
        amount_of_currency = (int) (Math.random() * 21);
        number_of_coins = (int) (Math.random() * 33) + 5;
        number_of_cards = 2;

        //We add each type of object to the wallet
        for (i = 0; i < number_of_credit_cards; i++) {
            new_credit_card = credit_card_types[(int) (Math.random() * credit_card_types.length)];
            wallet.add(new_credit_card);
        }

        for (i = 0; i < number_of_photos; i++) {
            new_photo = photo_types[(int) (Math.random() * photo_types.length)];
            wallet.add(new_photo);
        }

        for (i = 0; i < number_of_misc_cards; i++) {
            new_misc_card = misc_cards_types[(int) (Math.random() * misc_cards_types.length)];
            wallet.add(new_misc_card);
        }

        for (i = 0; i < amount_of_currency; i++) {
            new_currency = currency_types[(int) (Math.random() * currency_types.length)];
            wallet.add(new_currency);
        }

        for (i = 0; i < number_of_coins; i++){
            new_coin = coin_types[(int)(Math.random()*coin_types.length)];
            wallet.add(new_coin);
        }

        for (i = 0; i < number_of_cards; i++){
            new_playing_card = playing_card_types[(int)(Math.random()*playing_card_types.length)];
            wallet.add(new_playing_card);
        }

        //We print the contents of the wallet to the user
        System.out.println("Contents of wallet:");
        System.out.println(wallet);

        //We randomize the order in which the items appear in the wallet
        Collections.shuffle(wallet);

        //We print the reordered wallet to the user
        System.out.println("\nContents of wallet after shuffle:");
        System.out.println(wallet);

        //We print all instances of each type of object in the wallet to the user
        printCreditCards(wallet);
        printPhotos(wallet);
        printMiscCards(wallet);
        printCurrency(wallet);
        printCoins(wallet);
        printPlayingCards(wallet);
    }
}