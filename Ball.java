//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
package sample;

import java.io.File;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Ball  {
	private Circle ball = new Circle(75,75,26); //create a circle for animation
	private int lastX = 0;//store the ball's last x coordinates 
	private int lastY = 0;//store the ball's last y coordinates
	private boolean vertical = true;//if last tile is vertical,variable is true vice versa.
	private PathTransition path = new PathTransition(); //Creating a pathTransition which is ball's path.
	public Ball() {
		ball.setCenterX(75);
		ball.setCenterY(75);
		Image img = new Image(new File("./src/sample/UFO.jpg").toURI().toString());
		ball.setFill(new ImagePattern(img));
	}
	public void ballMove() {
		Path pathT = new Path();//Creating path 

		MoveTo moveTo = new MoveTo(75.0f,75.0f);//set start coordinates.
		pathT.getElements().add(moveTo);
		//To control all tiles and draw a path their properties. 
		for(int i = 0 ; i < 16 ; i++) {
			if(ReadingInput.tiles.get(i).getNameOfType().equals("Starter") ) {
				if(ReadingInput.tiles.get(i).getPipeType().equals("Vertical")) {
					LineTo line1 = new LineTo();
					line1.setX(75);
					line1.setY(150-(int)ball.getRadius());
					lastX = 75 ;
					lastY = 150-(int)ball.getRadius();
					pathT.getElements().add(line1);
				}else {
					LineTo line1 = new LineTo();
					line1.setX( 150-(int)ball.getRadius());
					line1.setY(75);
					lastX = 150-(int)ball.getRadius() ;
					lastY = 75;
					pathT.getElements().add(line1);
					vertical = false;
				}

			}else if(ReadingInput.tiles.get(i).getNameOfType().equals("Pipe") || ReadingInput.tiles.get(i).getNameOfType().equals("PipeStatic")) {
				if(ReadingInput.tiles.get(i).getPipeType().equals("Vertical")&& vertical) {
					LineTo line1 = new LineTo(lastX,lastY+150);
					lastY = lastY + 150 ;
					pathT.getElements().add(line1);//Adding new path to path
				}else if (ReadingInput.tiles.get(i).getPipeType().equals("Horizontal") && (!vertical)){
					LineTo line1 = new LineTo(lastX+150,lastY);
					lastX = lastX + 150 ;
					pathT.getElements().add(line1);//Adding new path to path
				}
				//To Control arc tiles and to use different class, which is ArcTo, for path. 
				else if(ReadingInput.tiles.get(i).getPipeType().equals("00")) {
					if(vertical) {
						ArcTo arc1 = new ArcTo();
						arc1.setRadiusX(70-ball.getRadius());
						arc1.setRadiusY(70-ball.getRadius());
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(false);
						arc1.setX(lastX+75+ball.getRadius());
						arc1.setY(lastY-75-ball.getRadius());
						lastX += (75+ball.getRadius());
						lastY -= (75+ball.getRadius());
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = false; //To change the path direction
					}else {
						ArcTo arc1 = new ArcTo();
						arc1.setRadiusX(70-ball.getRadius());
						arc1.setRadiusY(70-ball.getRadius());
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(false);
						arc1.setX(lastX+75+ball.getRadius());
						arc1.setY(lastY-75-ball.getRadius());
						lastX += (75+ball.getRadius());
						lastY -= (75+ball.getRadius());
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = true;//To change the path direction
					}
				}else if(ReadingInput.tiles.get(i).getPipeType().equals("01")) {
					if(vertical) {
						ArcTo arc1 = new ArcTo();
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(false);
						arc1.setX(lastX + 75 -ball.getRadius());
						arc1.setY(lastY + 75 + ball.getRadius());
						lastX += 75-ball.getRadius();
						lastY += 75+ball.getRadius();
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = false;//To change the path direction according to condition
					}
					else {
						ArcTo arc1 = new ArcTo();
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(false);
						arc1.setX(lastX - 75 +ball.getRadius());
						arc1.setY(lastY - 75 - ball.getRadius());
						lastX -= 75-ball.getRadius();
						lastY -= 75+ball.getRadius();
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = true;//To change the path direction according to condition
					}
				}else if(ReadingInput.tiles.get(i).getPipeType().equals("10")) {
					if(!vertical) {
						ArcTo arc1 = new ArcTo();
						arc1.setRadiusX(70-ball.getRadius());
						arc1.setRadiusY(70-ball.getRadius());
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(true);
						arc1.setX(lastX + 75 +ball.getRadius());
						arc1.setY(lastY + 75 - ball.getRadius());
						lastX += 75+ball.getRadius();
						lastY += 75-ball.getRadius();
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = true;//To change the path direction according to condition
					}
					else {
						ArcTo arc1 = new ArcTo();
						arc1.setRadiusX(70-ball.getRadius());
						arc1.setRadiusY(70-ball.getRadius());
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(true);
						arc1.setX(lastX - 75 -ball.getRadius());
						arc1.setY(lastY - 75 + ball.getRadius());
						lastX -= 75 + ball.getRadius();
						lastY -= 75-ball.getRadius();
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = false;//To change the path direction according to condition
					}
				}else if(ReadingInput.tiles.get(i).getPipeType().equals("11")) {
					if(!vertical) {
						ArcTo arc1 = new ArcTo();
						arc1.setRadiusX(70-ball.getRadius());
						arc1.setRadiusY(70-ball.getRadius());
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(true);
						arc1.setX(lastX - 75 - ball.getRadius() );
						arc1.setY(lastY + 75 + ball.getRadius());
						lastX -= (75 + ball.getRadius());
						lastY += 75 + ball.getRadius();
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = true;//To change the path direction according to condition
					}
					else {
						ArcTo arc1 = new ArcTo();
						arc1.setRadiusX(70-ball.getRadius());
						arc1.setRadiusY(70-ball.getRadius());
						arc1.setLargeArcFlag(true);
						arc1.setSweepFlag(true);
						arc1.setX(lastX + 75 + ball.getRadius());
						arc1.setY(lastY - 75 -ball.getRadius());
						lastX += 75 + ball.getRadius();
						lastY -= (75+ball.getRadius());
						pathT.getElements().add(arc1);//Adding new path to path
						vertical = false;//To change the path direction according to condition
					}
				}
			}else if(ReadingInput.tiles.get(i).getNameOfType().equals("End")) {
				if(ReadingInput.tiles.get(i).getPipeType().equals("Vertical") && vertical) {
					LineTo line1 = new LineTo(lastX , lastY + 79 + ball.getRadius());
					pathT.getElements().add(line1);//Adding new path to path
				}else if(ReadingInput.tiles.get(i).getPipeType().equals("Horizontal") && (!vertical)) {
					LineTo line1 = new LineTo(lastX + 79 + ball.getRadius(), lastY );
					pathT.getElements().add(line1);//Adding new path to path
				}
			}
		}

		path.setPath(pathT); //adding path to pathTransition
		path.setNode(ball);
		path.setDuration(Duration.seconds(5));
		path.play();
	}

	public Circle getBall() {
		return ball;
	}
	public void setBall(Circle ball) {
		this.ball = ball;
	}
	public PathTransition getPath() {
		return path;
	}
}