package src;

import java.awt.Color;
import java.awt.Graphics;

public class ANT {
	private int xpos;
	private int ypos;
	Direction direction;
	private int xLimit;
	private int yLimit;
	private Color antColor;

	public ANT(int xPosition, int yPosition, Direction dir, int maxX, int maxY, Color color) {
		antColor = color;
		xpos = xPosition;
		ypos = yPosition;
		xLimit = maxX;
		yLimit = maxY;
		direction = dir;
	}

	public int getXPos() {
		return xpos;
	}

	public int getYPos() {
		return ypos;
	}

	public void setPosition(int xPosition, int yPosition) {
		xpos = xPosition;
		ypos = yPosition;
	}

	public void render(Graphics pANE_ONE_CHANNEL2, double xOffset, double yOffset, int zOOMLevel) {
		pANE_ONE_CHANNEL2.setColor(antColor);
		pANE_ONE_CHANNEL2.drawRect(xpos * zOOMLevel + ((int) xOffset), ypos * zOOMLevel + ((int) yOffset), zOOMLevel,
				zOOMLevel);
	}

	public void moveForward() {
		if (direction.equals(direction.NORTH)) {
			if (xpos == 0) {
				xpos = xLimit - 1;
			} else {
				xpos--;
			}
		}

		/*
		 * else if (direction.equals(direction.NORTHEAST)) { if (xpos == (xLimit - 1)) {
		 * if (ypos == 0) { xpos = 0; ypos = (yLimit - 1); } else if (ypos == (yLimit -
		 * 1)) { xpos = 0; ypos--; } else { xpos = 0; ypos--; } } else if (xpos == 0) {
		 * if (ypos == 0) { xpos++; ypos = (yLimit - 1); } else if (ypos == (yLimit -
		 * 1)) { xpos++; ypos--; } else { xpos++; ypos--; } }else{ if (ypos == 0) {
		 * xpos++; ypos = (yLimit - 1); } else if (ypos == (yLimit - 1)) { xpos++;
		 * ypos--; } else { xpos++; ypos--; } } } else if
		 * (direction.equals(direction.NORTHWEST)) { if (xpos == (xLimit - 1)) { if
		 * (ypos == 0) { xpos--; ypos = (yLimit - 1); } else if (ypos == (yLimit - 1)) {
		 * xpos--; ypos--; } else { xpos--; ypos--; } } else if (xpos == 0) { if (ypos
		 * == 0) { xpos = (xLimit - 1); ypos = (yLimit - 1); } else if (ypos == (yLimit
		 * - 1)) { xpos=(xLimit - 1); ypos--; } else { xpos=(xLimit - 1); ypos--; }
		 * }else{ if (ypos == 0) { xpos--; ypos = (yLimit - 1); } else if (ypos ==
		 * (yLimit - 1)) { xpos--; ypos--; } else { xpos--; ypos--; } } }
		 * 
		 */

		else if (direction.equals(direction.SOUTH)) {
			if (xpos == (xLimit - 1)) {
				xpos = 0;
			} else {
				xpos++;
			}
		}

		/*
		 * else if (direction.equals(direction.SOUTHEAST)) { if (xpos == (xLimit - 1)) {
		 * if (ypos == 0) { xpos=0; ypos++; } else if (ypos == (yLimit - 1)) { xpos=0;
		 * ypos=0; } else { xpos=0; ypos++; } } else if (xpos == 0) { if (ypos == 0) {
		 * xpos++; ypos++; } else if (ypos == (yLimit - 1)) { xpos++; ypos=0; } else {
		 * xpos++; ypos++; } }else{ if (ypos == 0) { xpos++; ypos++; } else if (ypos ==
		 * (yLimit - 1)) { xpos++; ypos=0; } else { xpos++; ypos++; } } } else if
		 * (direction.equals(direction.SOUTHWEST)) { if (xpos == (xLimit - 1)) { if
		 * (ypos == 0) { xpos--; ypos++; } else if (ypos == (yLimit - 1)) { xpos--;
		 * ypos=0; } else { xpos--; ypos++; } } else if (xpos == 0) { if (ypos == 0) {
		 * xpos=(xLimit-1); ypos++; } else if (ypos == (yLimit - 1)) { xpos=(xLimit-1);
		 * ypos=0; } else { xpos=(xLimit-1); ypos++; } }else{ if (ypos == 0) { xpos--;
		 * ypos++; } else if (ypos == (yLimit - 1)) { xpos--; ypos=0; } else { xpos--;
		 * ypos++; } } }
		 */

		else if (direction.equals(direction.EAST)) {
			if (ypos == 0) {
				ypos = yLimit - 1;
			} else {
				ypos--;
			}
		} else if (direction.equals(direction.WEST)) {
			if (ypos == yLimit - 1) {
				ypos = 0;
			} else {
				ypos++;
			}
		}

	}

	public void changeTile(tile[][] tiles) {

		if (!tiles[xpos][ypos].getTileColor().equals(Color.RED)) {
			tiles[xpos][ypos].setTileColor(Color.RED);
			turnLeft();
		} else if (tiles[xpos][ypos].getTileColor().equals(Color.RED)) {
			Color tileColor = Color.BLACK;
			tiles[xpos][ypos].setTileColor(tileColor);

			turnRight();
		}

	}

	/*
	 * private void turnLeft() { if (direction.equals(Direction.NORTH)) { direction
	 * = Direction.NORTHWEST; } else if (direction.equals(Direction.NORTHEAST)) {
	 * direction = Direction.NORTH; } else if
	 * (direction.equals(Direction.NORTHWEST)) { direction = Direction.WEST; } else
	 * if (direction.equals(Direction.EAST)) { direction = Direction.NORTHEAST; }
	 * else if (direction.equals(Direction.SOUTH)) { direction =
	 * Direction.SOUTHEAST; } else if (direction.equals(Direction.SOUTHEAST)) {
	 * direction = Direction.EAST; } else if (direction.equals(Direction.SOUTHWEST))
	 * { direction = Direction.SOUTH; } else if (direction.equals(Direction.WEST)) {
	 * direction = Direction.SOUTHWEST; } }
	 * 
	 * private void turnRight() { if (direction.equals(Direction.NORTH)) { direction
	 * = Direction.NORTHEAST; } else if (direction.equals(Direction.NORTHEAST)) {
	 * direction = Direction.EAST; } else if (direction.equals(Direction.NORTHWEST))
	 * { direction = Direction.NORTH; } else if (direction.equals(Direction.EAST)) {
	 * direction = Direction.SOUTHEAST; } else if
	 * (direction.equals(Direction.SOUTH)) { direction = Direction.SOUTHWEST; } else
	 * if (direction.equals(Direction.SOUTHEAST)) { direction = Direction.SOUTH; }
	 * else if (direction.equals(Direction.SOUTHWEST)) { direction = Direction.WEST;
	 * } else if (direction.equals(Direction.WEST)) { direction =
	 * Direction.NORTHWEST; } }
	 */

	private void turnLeft() {
		if (direction.equals(Direction.NORTH)) {
			direction = Direction.EAST;
		} else if (direction.equals(Direction.EAST)) {
			direction = Direction.SOUTH;
		} else if (direction.equals(Direction.SOUTH)) {
			direction = Direction.WEST;
		} else if (direction.equals(Direction.WEST)) {
			direction = Direction.NORTH;
		}
	}

	private void turnRight() {
		if (direction.equals(Direction.NORTH)) {
			direction = Direction.WEST;
		} else if (direction.equals(Direction.WEST)) {
			direction = Direction.SOUTH;
		} else if (direction.equals(Direction.SOUTH)) {
			direction = Direction.EAST;
		} else if (direction.equals(Direction.EAST)) {
			direction = Direction.NORTH;
		}
	}

}
