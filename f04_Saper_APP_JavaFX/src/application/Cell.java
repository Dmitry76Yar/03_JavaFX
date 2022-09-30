package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Cell extends Button{
	public int x;
	public int y;
	public boolean isOpened;
	public boolean isMarked;
	public Cell(int x, int y) {
		super();
		isOpened = false;
		isMarked = false;
		BorderStroke brs = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(0.5), null);
		this.setBorder(new Border(brs));
		this.setMaxWidth(Main.sizeCell);
		this.setMaxHeight(Main.sizeCell);
		Engine.changeImgInCell(-1, this);
		this.setPadding(new Insets(0,0,0,0));
		this.x = x;
		this.y = y;
	}
	
}
