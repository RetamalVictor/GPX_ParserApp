package softwaredesign;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainMenu extends Application {

    Scene menuScene;
    Scene resultsScene;
    File selectedFile;
    Button fileSelect;
    Button showResults;

    GPXinfo gpxInfo;

    public void initializeMenu(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GPX Manager");

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-image: url('https://www.kindpng.com/picc/m/0-5952_color-sport-background-hd-png-download.png'); -fx-background-repeat: no-repeat; -fx-background-size: 860 412; -fx-background-position: center center;");
        vBox.setAlignment(Pos.CENTER);

        initializeFileButton(primaryStage);

        BorderPane resultLayout = new BorderPane();
        resultsScene = new Scene(resultLayout, 1000, 600);
        initializeResultButton(primaryStage);

        BorderPane menuLayout = new BorderPane();
        vBox.getChildren().addAll(fileSelect, showResults);
        menuLayout.setCenter(vBox);

        menuScene = new Scene(menuLayout, 860, 412);
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    public void initializeResultButton(Stage primaryStage){
        showResults = new Button("Show Results!");
        showResults.setFont(Font.font("Courier new", FontWeight.EXTRA_BOLD, 12));
        showResults.setPrefSize(150,30);
        showResults.setStyle("-fx-background-color: #00ff00; -fx-border-color: #000000; -fx-border-width: 3px");
        showResults.setOnAction(e ->
                switchToResultScene(primaryStage)
        );
    }

    public void switchToResultScene(Stage primaryStage){
        initializeGPXinfo();

        BorderPane resultLayout = new BorderPane();

        StringBuilder elev = new StringBuilder("");
        for(Double i : gpxInfo.getElevation()){
            elev.append(i + "\n");
        }
        resultLayout.setCenter(new Text(elev.toString()));

        StringBuilder lat = new StringBuilder("");
        for(Double i : gpxInfo.getLatitude()){
            lat.append(i + "\n");
        }
        resultLayout.setLeft(new Text(lat.toString()));

        StringBuilder lon = new StringBuilder("");
        for(Double i : gpxInfo.getLongutide()){
            lon.append(i + "\n");
        }
        resultLayout.setRight(new Text(lon.toString()));

        resultsScene = new Scene(resultLayout, 1000, 600);
        primaryStage.setScene(resultsScene);
        primaryStage.show();
    }

    public void initializeGPXinfo(){
        gpxInfo = new GPXinfo(selectedFile);
    }

    public void initializeFileButton(Stage primaryStage){
        fileSelect = new Button("Upload File");
        fileSelect.setPrefSize(200,50);
        fileSelect.setFont(Font.font("Courier new", FontWeight.EXTRA_BOLD, 16));
        fileSelect.setStyle("-fx-background-color: #00ff00; -fx-border-color: #000000; -fx-border-width: 3px");

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("GPX File Selector");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("GPX file", "*.gpx")
        );

        fileSelect.setOnAction(e -> selectedFile = fileChooser.showOpenDialog(primaryStage));
    }
}
