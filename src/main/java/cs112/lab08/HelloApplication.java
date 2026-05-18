package cs112.lab08;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Random;

public class HelloApplication extends Application {

    //CONSTANTS

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage){
        //CREATE COMPONENTS
        Label titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        titleLabel.setFont(new Font(20));
        Label messageLabel = new Label("Click the button below to randomly draw a card.");
        Button drawCardButton = new Button("Draw Random Card");
        LoteriaCard startingCard = new LoteriaCard();
        ImageView cardImageView = new ImageView(startingCard.getImage());

        //SETUP SIZE OF CARD
        cardImageView.setFitWidth(300);
        cardImageView.setPreserveRatio(true);

        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Pick a random number between 0 and the length of our LOTERIA_CARDS array
                Random rand = new Random();
                int randomIndex = rand.nextInt(LOTERIA_CARDS.length);

                LoteriaCard randomCard = LOTERIA_CARDS[randomIndex];

                // Update the GUI components with the new card image & name
                cardImageView.setImage(randomCard.getImage());
                messageLabel.setText(randomCard.getCardName());
            }
        });

        //VBOX CONFIGURATION
        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton);

        //SETUP SCENE AND SHOW
        Scene scene = new Scene(vbox, 350, 500); // Strict size constraint from prompt
        stage.setTitle("EChALE STEM Loteria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}