package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;

public class Simulation extends Thread {

	private static final int FIVE = 5;
	private static final int ONETHOUSAND = 5;

	private static tile[][] tilesDisplay;
	private static tile[][] blankDisplay;
	private static Point currentLocation;
	private static Point initialLocation;
	private static int xLimit = 1024;
	private static int yLimit = 800;

	private static int ZOOMLevel = 1;
	static Tiles theTiles = null;
	private static int count;
	private static JFrame frameWATCHINGNOW;
	private static Graphics pANE_ONE_CHANNEL;
	private int height;
	private boolean fbf;
	private static boolean pickup;

	public Simulation(boolean fbf, Point initialLoc, int count, JFrame frameWATCHINGNOW, Graphics PANE_ONE_CHANNEL,
			int height, int xLim, int yLim, Tiles tiles) {
		this.fbf = fbf;
		this.count = count;
		this.frameWATCHINGNOW = frameWATCHINGNOW;
		pANE_ONE_CHANNEL = PANE_ONE_CHANNEL;
		this.height = height;
		this.xLimit = xLim;
		this.yLimit = yLim;
		theTiles = tiles;

		theTiles.start();

		initialLocation = initialLoc;
		currentLocation = initialLoc;
		blankDisplay = new tile[xLimit][yLimit];
		clearDisplay();
	}

	public void run() {
		System.out.println("run the simulation");
		if (fbf)
			runSimulation(false, frameWATCHINGNOW, pANE_ONE_CHANNEL);
		else {
			runSimulation(true, frameWATCHINGNOW, pANE_ONE_CHANNEL);
		}
		System.out.println("simulation over");
	}

	public static int runSimulation(boolean framebyFrame, JFrame frameWATCHINGNOW2, Graphics pANE_ONE_CHANNEL2) {

		if (!framebyFrame) {
			while (count < 900000000) {
				//if (pickup) {
					pANE_ONE_CHANNEL2.fillRect(0, 0, xLimit, yLimit);
					tile[][] toDisplay = theTiles.getToDisplay();
					if (toDisplay != null) {
						tilesDisplay = toDisplay;

					} else {
						tilesDisplay = blankDisplay;

					}

					double xOffset = currentLocation.getX() - initialLocation.getX();
					double yOffset = currentLocation.getY() - initialLocation.getY();

					calculate_offset_and_print_tiles_in_grid_fassion(xOffset, yOffset, pANE_ONE_CHANNEL2);
					print_ants(xOffset, yOffset, pANE_ONE_CHANNEL2);

					 frameWATCHINGNOW2.pack();
					 frameWATCHINGNOW2.repaint();
					theTiles.fillQueue();

					count++;
			//	}
			}
		} else {
			// System.err.println("true");

			// theTiles.fillQueue();
			pANE_ONE_CHANNEL2.fillRect(0, 0, xLimit, yLimit);
			tile[][] toDisplay = theTiles.getToDisplay();
			if (toDisplay != null) {
				tilesDisplay = toDisplay;

			} else {
				tilesDisplay = blankDisplay;

			}

			double xOffset = currentLocation.getX() - initialLocation.getX();
			double yOffset = currentLocation.getY() - initialLocation.getY();

			calculate_offset_and_print_tiles_in_grid_fassion(xOffset, yOffset, pANE_ONE_CHANNEL2);
			print_ants(xOffset, yOffset, pANE_ONE_CHANNEL2);

//				frameWATCHINGNOW2.pack();
//				frameWATCHINGNOW2.repaint();
			theTiles.fillQueue();

			count++;

		}
		// System.out.println("simulation over");
		return count;

	}

	
	public static boolean isQueuefull() {
		return theTiles.isAtMaxSizeOrAbove();
	}
	
	
	
	
	private static void clear_screen(Graphics2D PANE_ONE_CHANNEL, int height) {
		for (int j = 0; j < height; j++) {
			Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
					(int) (Math.random() * 255));

			if (color != Color.RED) {
				PANE_ONE_CHANNEL.setColor(color);
			} else {
				PANE_ONE_CHANNEL.setColor(Color.BLACK);
			}
			PANE_ONE_CHANNEL.drawRect(0, j, 1024, 1);
		}

	}

	private static void calculate_offset_and_print_tiles_in_grid_fassion(double xOffset, double yOffset,
			Graphics pANE_ONE_CHANNEL2) {

		print_tiles_in_grid_fassion(xOffset, yOffset, pANE_ONE_CHANNEL2);
	}

	private static void print_tiles_in_grid_fassion(double xOffset, double yOffset, Graphics pANE_ONE_CHANNEL2) {

		for (int i = 0; i < xLimit; i++) {

			for (int j = 0; j < yLimit; j++) {

				tilesDisplay[i][j].render(pANE_ONE_CHANNEL2, xOffset, yOffset, xLimit, yLimit, ZOOMLevel);

			}
		}

	}

	private static void print_ants(double xOffset, double yOffset, Graphics pANE_ONE_CHANNEL2) {
		for (ANT ant : theTiles.getAnts()) {
			ant.render(pANE_ONE_CHANNEL2, xOffset, yOffset, ZOOMLevel);
		}

	}

	public void setCurrentLocation(Point locationOnScreen) {
		currentLocation = locationOnScreen;

	}

	public void setZOOMLevel(int zoomLevel) {
		ZOOMLevel = zoomLevel;

	}

	public void setGraphics(Graphics graphics) {
		pANE_ONE_CHANNEL = graphics;
	}

	public static void clearDisplay() {

		for (int i = 0; i < xLimit; i++) {
			for (int j = 0; j < yLimit; j++) {
				blankDisplay[i][j] = new tile(i, j, Color.WHITE);
			}
		}

	}


	public  boolean isPickup() {
		return pickup;
	}

	public  void setPickup(boolean pickup) {
		this.pickup = pickup;
	}

}
