import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import objects.*;

import java.io.*;

public class Main extends Application {
    private  XMLGenerator xmlFile;

    @Override
    public void start(Stage primaryStage) {
        // Créer le menu


        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open...");
        MenuItem saveItem = new MenuItem("Save XML");
        fileMenu.getItems().addAll(openItem, saveItem);
        menuBar.getMenus().add(fileMenu);


        // Zone centrale
        Label label = new Label("Enter something:");
        TextField textField = new TextField();
        Button submitButton = new Button("Submit");

        // Design moderne
        textField.setPromptText("Type here...");
        textField.setStyle("-fx-font-size: 14px; -fx-padding: 8px;");
        submitButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8px 16px; -fx-border-radius: 5px;");

        // Action du bouton Submit
        submitButton.setOnAction(event -> {
            String inputText = textField.getText();
            label.setText("You entered: " + inputText);

            // Créer un objet XMLGenerator
           //XMLGenerator xmlGenerator = new XMLGenerator (STYLESHEET_MODENA, STYLESHEET_CASPIAN);
           //xmlGenerator.generateXML();
           xmlFile = new XMLGenerator (STYLESHEET_MODENA, STYLESHEET_CASPIAN);
           System.out.println("XML object created: " + xmlFile.toString());

           




        });

        // Gestion des fichiers
        openItem.setOnAction(event -> openFile(primaryStage, textField));
        saveItem.setOnAction(event -> saveXML(primaryStage));

        // Contenu principal
        VBox centerBox = new VBox(10, label, textField, submitButton);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setStyle("-fx-padding: 20px; -fx-background-color: #F4F4F4;");

        // Layout principal avec menu en haut
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(centerBox);

        // Scene et affichage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("XML Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openFile(Stage stage, TextField textField) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textField.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Méthode pour enregistrer le fichier XML avec FileChooser
    private void saveXML(Stage stage) {
        if (xmlFile == null) {
            System.out.println("No XML data to save.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save XML File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));

        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(xmlFile.generateXML());
                System.out.println("XML saved: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
