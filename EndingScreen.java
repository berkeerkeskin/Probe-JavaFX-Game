package sample;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
//Ending ...
public class EndingScreen extends CutScenes {
    private Scene endingScene;

    public EndingScreen(){
    super.getPane().setPrefSize(600,600);
    Text endingText = new Text("YOU ARE THE MASTER OF TILES!");
    endingText.setFill(Color.WHITE);

    ImageView iw4 = new ImageView();
    Image img4 = new Image(new File("./src/sample/Ending.jpg").toURI().toString());
    iw4.setImage(img4);
    iw4.setCache(true);
    iw4.setPreserveRatio(true);
    iw4.setSmooth(true);
    super.getPane().getChildren().add(iw4);

    endingText.setFont(new Font("Bauhaus 93", 30));
    super.getPane().getChildren().add(endingText);
    endingText.setX(120);
    endingText.setY(300);
    endingScene = new Scene(super.getPane(),600 ,600);
    }

    public Scene getEndingScene(){
        return this.endingScene;
    }
}
