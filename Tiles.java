package sample;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Tiles {

	private String nameOfType;
	private String pipeType;
	private Pane pane;
	private int RowCoordinates;
	private int ColumnCoordinates;
	private static int numberOfMoves = 0;
	private static int LevelNumber = 2;
	private ArrayList<Integer> indexesForFinish = new ArrayList<>();
	private static boolean isReadyForNextLevel = false;

	public Tiles(String name, String pipe, Pane pane , int xco ,int yco){
		this.nameOfType = name;
		this.pipeType = pipe;
		this.pane = pane;
		this.RowCoordinates = xco;
		this.ColumnCoordinates = yco;
	}


	//checks if a pane has a freetile near its up, down, left and right.
	public int isPaneMovable(int index, ArrayList<Tiles> tiles) {
		int rowNum = index / 4;
		if (index - 1 >= 0 && (index - 1) / 4 == rowNum) {
			if (tiles.get(index - 1).pipeType.equals("Free")) {
					return index - 1;
			}
		}
		if (index - 4 >= 0) {
			if (tiles.get(index - 4).pipeType.equals("Free")) {
				return index - 4;
			}
		}
		if (index + 1 <= 15 && (index + 1) / 4 == rowNum) {
			if (tiles.get(index + 1).pipeType.equals("Free")) {
				return index + 1;
			}
		}
		if (index + 4 <= 15) {
			if (tiles.get(index + 4).pipeType.equals("Free")) {
				return index + 4;
			}
		}
			return -1;
	}

	//compare's if a freetile is near to the dragged pane.
	public boolean isMovable(int paneIndex, int freeTileIndex){
		int rowNum = paneIndex / 4;
		if (paneIndex - 1 == freeTileIndex && (paneIndex - 1) / 4 == rowNum) {
			return  true;
		}else if (paneIndex - 4 == freeTileIndex) {
			return  true;
		}else if (paneIndex + 1 == freeTileIndex && (paneIndex + 1) / 4 == rowNum) {
			return  true;
		}else if (paneIndex + 4 == freeTileIndex) {
			return  true;
		}
		return false;
	}

	//Simply handles MouseEvent.Details inside.
	public void movePane(){
			//When Dragged :
			getPane().setOnMouseDragged(e -> {
				int indexOfTheFreeTile = isPaneMovable(getRowCoordinates() * 4 + getColumnCoordinates(), ReadingInput.tiles);
				if(indexOfTheFreeTile > 0 && this.getNameOfType().equals("Empty") && !getPipeType().equals("Free") || indexOfTheFreeTile > 0 && getNameOfType().equals("Pipe")) {
					getPane().setTranslateY(e.getSceneY() - 75);
					getPane().setTranslateX(e.getSceneX() - 75);
				}
			});

			//When Released :
			getPane().setOnMouseReleased(e -> {
				int index = 0;
				for(Tiles t : ReadingInput.freetiles){
					if(e.getSceneX() >= t.getPane().getBoundsInParent().getMinX() &&
							e.getSceneX() <= t.getPane().getBoundsInParent().getMaxX() &&
							e.getSceneY() <= t.getPane().getBoundsInParent().getMaxY() &&
							e.getSceneY() >= t.getPane().getBoundsInParent().getMinY()){
						for(int i = 0; i < ReadingInput.tiles.size(); i++){
							if(ReadingInput.tiles.get(i) == t){
								index = i;
							}
						}
					}
				}

				int indexOfPane = (RowCoordinates * 4) + ColumnCoordinates;
				int indexOfTheFreeTile = isPaneMovable(getRowCoordinates() * 4 + getColumnCoordinates(), ReadingInput.tiles);
				if(indexOfTheFreeTile != index && isMovable(indexOfPane, index)){
					indexOfTheFreeTile = index;
				}
				if(indexOfTheFreeTile > 0 && this.getNameOfType().equals("Empty") && !getPipeType().equals("Free") || indexOfTheFreeTile > 0 && getNameOfType().equals("Pipe")) {
					System.out.println(indexOfPane);
					if (e.getSceneX() >= ReadingInput.tiles.get(indexOfTheFreeTile).getPane().getBoundsInParent().getMinX() &&
							e.getSceneX() <= ReadingInput.tiles.get(indexOfTheFreeTile).getPane().getBoundsInParent().getMaxX() &&
							e.getSceneY() <= ReadingInput.tiles.get(indexOfTheFreeTile).getPane().getBoundsInParent().getMaxY() &&
							e.getSceneY() >= ReadingInput.tiles.get(indexOfTheFreeTile).getPane().getBoundsInParent().getMinY()) {

						//changes dragged tile's position.
						getPane().setTranslateX(ReadingInput.tiles.get(indexOfTheFreeTile).getColumnCoordinates() * 150);
						getPane().setTranslateY(ReadingInput.tiles.get(indexOfTheFreeTile).getRowCoordinates() * 150);

						//changes freeTile's position.
						ReadingInput.tiles.get(indexOfTheFreeTile).getPane().setTranslateX(this.getColumnCoordinates() * 150 );
						ReadingInput.tiles.get(indexOfTheFreeTile).getPane().setTranslateY(this.getRowCoordinates() * 150);

						//new X and Y of pane:
						int newXofPane = ReadingInput.tiles.get(indexOfTheFreeTile).getRowCoordinates();
						int newYofPane = ReadingInput.tiles.get(indexOfTheFreeTile).getColumnCoordinates();
						//new X and Y of freePane:
						int newXofFreePane = this.getRowCoordinates();
						int newYofFreePane = this.getColumnCoordinates();


						Tiles tempTile = ReadingInput.tiles.get(indexOfTheFreeTile);
						Tiles tempPaneTile = this;
						//removing freepane and adding pane :
						ReadingInput.tiles.remove(ReadingInput.tiles.get(indexOfTheFreeTile));
						ReadingInput.tiles.add(indexOfTheFreeTile, tempPaneTile);
						//removing pane :
						ReadingInput.tiles.remove(this);
						ReadingInput.tiles.add(indexOfPane , tempTile);
						// adding pane to the new index :
						ReadingInput.tiles.remove(tempPaneTile);
						ReadingInput.tiles.add(indexOfTheFreeTile,this);

						//changing pane's xco and yco :
						ReadingInput.tiles.get(indexOfTheFreeTile).setColumnCoordinates(newYofPane);
						ReadingInput.tiles.get(indexOfTheFreeTile).setRowCoordinates(newXofPane);

						//changing freePane's xco and yco :
						ReadingInput.tiles.get(indexOfPane).setColumnCoordinates(newYofFreePane);
						ReadingInput.tiles.get(indexOfPane).setRowCoordinates(newXofFreePane);
						numberOfMoves++;
						Main.Infoscreen1.setNumberOfMoves(numberOfMoves);

						//islevelfinished
						ReadingLevel.ReadLevel(ReadingLevel.ReadUp(0), ReadingLevel.ReadDown(0), ReadingLevel.ReadLeft(0), ReadingLevel.ReadRight(0),0, "Up", indexesForFinish);
						if(indexesForFinish.get(indexesForFinish.size() - 1) == -1){
							indexesForFinish.removeAll(indexesForFinish);
							System.out.println("Level is finished!!!");

							setIsReadyForNextLevel(true);

							Ball ball = new Ball();
							ball.ballMove();
							ReadingInput.mainPane.getChildren().add(ball.getBall());

							ball.getPath().setOnFinished(e2->{
								ball.getBall().setVisible(false);
								if(Tiles.isIsReadyForNextLevel()) {
									Main.Infoscreen1.setLevelNum();
									try{
										//this is creating new level at the end of the ball animation.
										if(Tiles.getLevelNumber() <= 5){
											File file1 = new File("./src/sample/level" + Tiles.getLevelNumber() +".txt");
											ReadingInput ri1 = new ReadingInput(file1);
											Tiles.setLevelNumber(Tiles.getLevelNumber() + 1);
											ri1.createTiles();
											ri1.mainPane.getChildren().add(Main.Infoscreen1.getPane());

											Scene level = new Scene(ri1.mainPane,800 ,600);
											Main.getStage().setScene(level);
											ri1.specializeTiles();
										}else{
											EndingScreen endingscreen = new EndingScreen();
											Main.getStage().setScene(endingscreen.getEndingScene());
										}
									}catch(Exception ee){
										System.out.println("An ex is catched");
									}
								}
								Tiles.setIsReadyForNextLevel(false);
								Main.Infoscreen1.setNumberOfMoves(0);
							});
							numberOfMoves = 0;

						}
					}else{
						//this case is available only if the tile is released in an unrelated area.
						getPane().setTranslateX(this.getColumnCoordinates() * 150);
						getPane().setTranslateY(this.getRowCoordinates() * 150);
					}
				}
			});

		}
		//Some useful getter and setters.
	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

	public String getNameOfType() {
		return nameOfType;
	}

	public void setNameOfType(String nameOfType) {
		this.nameOfType = nameOfType;
	}

	public String getPipeType() {
		return pipeType;
	}

	public int getRowCoordinates() {
		return RowCoordinates;
	}

	public void setRowCoordinates(int xCoordinates) {
		RowCoordinates = xCoordinates;
	}

	public int getColumnCoordinates() {
		return ColumnCoordinates;
	}

	public void setColumnCoordinates(int yCoordinates) {
		ColumnCoordinates = yCoordinates;
	}

	public static int getNumberOfMoves() {
		return numberOfMoves;
	}

	public static void setNumberOfMoves(int numberOfMoves1) {
		numberOfMoves = numberOfMoves1;
	}

	public static int getLevelNumber() {
		return LevelNumber;
	}

	public static void setLevelNumber(int levelNumber) {
		LevelNumber = levelNumber;
	}

	public static boolean isIsReadyForNextLevel() {
		return isReadyForNextLevel;
	}

	public static void setIsReadyForNextLevel(boolean isReadyForNextLevel) {
		Tiles.isReadyForNextLevel = isReadyForNextLevel;
	}

}
