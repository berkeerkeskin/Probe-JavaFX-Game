package sample;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {
    static InformationScreen Infoscreen1;
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{


        //Background Space Music :
        Media media = new Media(getClass().getResource("./spaceMusic.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        //setting stage and reading text for first level\
        setStage(primaryStage);
        File file = new File("./src/sample/level1.txt");
        ReadingInput ri = new ReadingInput(file);
        //starting screen.
        MainScreen play = new MainScreen();
        play.getPlayButton().setOnAction(e->{

            //creating and adding to the mainPane.
            ri.createTiles();
            Scene level1 = new Scene(ri.mainPane,800 ,600);
            //setting scene for the first level.
            stage.setScene(level1);
            //handling mouseEvents for movable objects.
            ri.specializeTiles();
            //side screen for information.
            Infoscreen1 = new InformationScreen();
            ri.mainPane.getChildren().add(Infoscreen1.getPane());

        });
        Scene scene = new Scene(play.getPane(), 500, 500);
        stage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

}
