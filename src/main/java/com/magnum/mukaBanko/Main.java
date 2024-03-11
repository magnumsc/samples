package com.magnum.mukaBanko;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        var mainPane = new StackPane();
        mainPane.setAlignment(Pos.BASELINE_CENTER);
        var loginPane = new FlowPane(Orientation.VERTICAL);
        mainPane.getChildren().add(loginPane);
        loginPane.setPrefWidth(500d);
        loginPane.setAlignment(Pos.BASELINE_CENTER);

        var trixieSize = 150;
        var image = new Image(getClass().getResource("/mukaBanko/TrixieFighter.png").toExternalForm());
        var imageViewLeft = new ImageView(image);
        imageViewLeft.setPreserveRatio(true);
        imageViewLeft.setFitHeight(trixieSize);
        imageViewLeft.setScaleX(-1d);
        var imageViewRight = new ImageView(image);
        imageViewRight.setPreserveRatio(true);
        imageViewRight.setFitHeight(trixieSize);
        var title = new Label("MukaBanko");
        title.setFont(new Font("Verdana", 24));
        var titlePane = new FlowPane(Orientation.HORIZONTAL);
        titlePane.getChildren().addAll(imageViewLeft, title, imageViewRight);
        titlePane.setAlignment(Pos.BASELINE_CENTER);
        var loginForm = new GridPane();
        loginForm.setAlignment(Pos.BASELINE_CENTER);
        var usernameLabel = new Label("Conta: ");
        usernameLabel.setPrefWidth(100d);
        usernameLabel.setAlignment(Pos.BASELINE_RIGHT);
        var passwordLabel = new Label("Senha: ");
        passwordLabel.setPrefWidth(100d);
        passwordLabel.setAlignment(Pos.BASELINE_RIGHT);
        var usernameField = new TextField();
        var passwordField = new TextField();
        loginForm.addRow(0, usernameLabel, usernameField);
        loginForm.addRow(1, passwordLabel, passwordField);
        loginPane.getChildren().addAll(titlePane, loginForm);

        Scene scene = new Scene(mainPane, 500, 220);
        stage.setScene(scene);

        loginForm.setGridLinesVisible(true);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
