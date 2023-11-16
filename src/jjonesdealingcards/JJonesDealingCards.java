/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jjonesdealingcards;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Jacob Jones
 * Date - 12/14/2019
 * This program will give the player five cards, and each time the player presses the button,
 * The program shows them a new set of cards
 */
public class JJonesDealingCards extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        // Create a CardPlayer.
        CardPlayer player = new CardPlayer();

        // Create a deck of cards.
        Deck deck = new Deck();

        // The Deck constructor shuffles the cards,
        // but let's shuffle them again...
        deck.shuffle();

        // Deal five cards to the player.
        for (int count = 1; count <= 5; count++)
           player.addCard(deck.deal());

        // Let's see the player's cards.
        ArrayList<Card> hand = player.showCards();
        
        // Sets up the layout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        
        // Sets up the scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Card Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // Sets up the header
        Label header = new Label("Card Game");
        header.setFont(new Font(30));
        header.setPadding(new Insets(30));
        
        // The cards from the player's hand
        Label card1 = new Label(hand.get(0).toString());
        Label card2 = new Label(hand.get(1).toString());
        Label card3 = new Label(hand.get(2).toString());
        Label card4 = new Label(hand.get(3).toString());
        Label card5 = new Label(hand.get(4).toString());
        
        // The column of cards
        VBox cardCol = new VBox(card1, card2, card3, card4, card5);
        cardCol.setAlignment(Pos.CENTER);
        
        // Shuffles the cards and displays the new hand
        Button shuffleBtn = new Button();
        shuffleBtn.setText("Shuffle");
        shuffleBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // The Deck constructor shuffles the cards,
                // but let's shuffle them again...
                
                // Returns the player's cards back to the deck
                for(Card c: hand){
                    deck.add(c);
                }
                
                // Clears the player's hand
                hand.clear();
                player.clear();
                
                // Shuffles the deck
                deck.shuffle();

                // Deal five cards to the player.
                for (int count = 1; count <= 5; count++)
                   player.addCard(deck.deal());

                // Let's see the player's cards.
                ArrayList<Card> hand = player.showCards();
                
                // Sets the card labels to the new cards
                card1.setText(hand.get(0).toString());
                card2.setText(hand.get(1).toString());
                card3.setText(hand.get(2).toString());
                card4.setText(hand.get(3).toString());
                card5.setText(hand.get(4).toString());
            }
        });
        
        // Holds all of the information for the game
        VBox infoCol = new VBox(header, cardCol, shuffleBtn);
        infoCol.setAlignment(Pos.CENTER);
        infoCol.setSpacing(10);
        
        // Adds infoCol to the layout
        layout.add(infoCol, 0, 0);
    }
    
}
