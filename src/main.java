import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import objects.*;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    Label label = new Label("Hello, World!");
        Scene scene = new Scene(label, 300, 200);
        
        primaryStage.setTitle("JavaFX Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
       
        
    
    }
    public static void main(String[] args) {
        launch(args);
        XMLGenerator xmlGenerator = new XMLGenerator(STYLESHEET_MODENA, STYLESHEET_CASPIAN);
        xmlGenerator.generateXML();
        
        }
    
}
