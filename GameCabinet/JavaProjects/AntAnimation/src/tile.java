package src;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class tile {
	
	
	private int row;
	private int column;
	private Color tileColor;

	public tile(int r, int c,Color imageColor) {
		this.tileColor = imageColor;
		setRow(r);
		setColumn(c);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public void render(Graphics pANE_ONE_CHANNEL2, double xOffset, double yOffset, int xLimit, int yLimit, int zOOMLevel) {
		
		
		Color tileColor2 = getTileColor();
		if(tileColor2 !=Color.gray) {
		pANE_ONE_CHANNEL2.setColor(tileColor2);
		for(int i = zOOMLevel;i>0;i=i-2){
			int x = row*zOOMLevel+((int)xOffset);
			int y = column*zOOMLevel+((int)yOffset);
			if(x<xLimit && x>=0 && y<yLimit && y>=0)
				pANE_ONE_CHANNEL2.drawRect(x, y, i, i);
		}
		}
		
		
		
	}
	
	
	public void render(Graphics2D pANE_ONE_CHANNEL, int displayWidth, int displayHeight,Color imageColor, double xOffset, double yOffset) {
		pANE_ONE_CHANNEL.setColor(imageColor);
		pANE_ONE_CHANNEL.drawRect(row*50+((int)xOffset), column*50+((int)yOffset), 50, 50);
		
//		pANE_ONE_CHANNEL.setColor(Color.BLUE);
//		pANE_ONE_CHANNEL.drawRect(row*50+20+1, column*50+20+1, 48, 48);
		
		
		
	}
	

	public Color getTileColor() {
		return tileColor;
	}

	public void setTileColor(Color tileColor) {
		this.tileColor = tileColor;
	}


	

	
	

}
