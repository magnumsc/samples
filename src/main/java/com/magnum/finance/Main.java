package com.magnum.finance;

import com.magnum.finance.config.PostgreSQLConfig;
import com.magnum.finance.exceptions.DatabaseUnreachableException;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.sql.Connection;
import java.util.logging.Level;

@Log
public class Main extends Application {
    public static Connection connection;
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
    public static void main(String[] args) throws Exception {
        try {
            log.info("Starting the application");
            log.info("Creating a database connection");
            connection = PostgreSQLConfig.createConnection();
            log.info("Database connection create successfully");

            launch();
        } catch (DatabaseUnreachableException e) {
            log.severe("Could not connect to the database");
            throw e;
        } catch (Exception e) {
            log.log(Level.SEVERE,"An unexpected error occurred {}", e.getMessage());
            throw e;
        }
    }
}
