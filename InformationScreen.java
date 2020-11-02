package sample;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/*this screen holds levelNumber and NumberOfMoves. It also shows them on the screen.
 Player can see the level which he is playing at that time. */
public class InformationScreen extends CutScenes{

        private Text levelNum;
        private Text numOfMoves;
        private static int levels = 1;
        public InformationScreen() {
            super.getPane().setPrefSize(200, 600);
            super.getPane().setStyle("-fx-background-color: #4412c8;");
            super.getPane().setTranslateX(600);
            super.setPlayButton(null);
            numOfMoves = new Text("Moves " + 0);
            numOfMoves.setFont(new Font("Bauhaus 93", 30));
            levelNum = new Text("LEVEL " + getLevels());
            levelNum.setFont(new Font("Bauhaus 93", 40));

            super.getPane().getChildren().addAll(levelNum,numOfMoves);
            levelNum.setX(50);
            levelNum.setY(200);

            numOfMoves.setX(50);
            numOfMoves.setY(350);
        }

        public void setNumberOfMoves(int numberOfMoves1){
            getNumOfMoves().setText("Moves " + numberOfMoves1);
        }
        public int getLevels() {
            return levels;
        }

        public Text getLevelNum() {
            return levelNum;
        }
        public void setLevelNum() {
            levels++;
            this.levelNum.setText(levelNum.getText().substring(0, levelNum.getText().length() - 1) + levels);
        }
        public Text getNumOfMoves() {
            return numOfMoves;
        }

}
