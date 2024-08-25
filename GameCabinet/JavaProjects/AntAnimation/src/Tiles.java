package src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class Tiles extends Thread {

	private static tile[][] tiles;
	private static ArrayList<tile[][]> queue;
	
	boolean calculateQueue = true;
	int queueMaxSize = 64;
	private static int xLimit = 500;
	private static int yLimit = 500;
	private int simcount = 0;
	static Color initialTialColor = Color.DARK_GRAY;
	static ArrayList<ANT> ant_s_;
	public Tiles(int xLim, int yLim,Color initialCol,ArrayList<ANT> antz) {
		xLimit = xLim;
		yLimit = yLim;
		this.initialTialColor = initialCol;
		this.ant_s_ = antz;
		
		tiles = new tile[xLimit][yLimit];
		

		
		
		queue = new ArrayList<>();
		
	}

	public void run() {
		
		for (int i = 0; i < xLimit; i++) {
			for (int j = 0; j < yLimit; j++) {
				tiles[i][j]  = new tile(i, j, initialTialColor);
			}
		} 
		
		
		System.out.println("filling queue");
		while (queue.size() < queueMaxSize)
			fillQueue();

	}

	public boolean isAtMaxSizeOrAbove() {
		return queue.size() >= queueMaxSize;
	}

	public void fillQueue() {
		if (queue.size() < queueMaxSize) {
			tile[][] tiles2 = tiles;
			queue.add(tiles2);
			updateTiles();
		//	System.out.println("+QSize " + queue.size());
		}

	}



	private static void updateTiles() {
		run_all_ant_s_in_the_universe_exactly_one_unit_of_movement(ant_s_);
//		run_all_ant_s_in_the_universe_exactly_N_unit_of_movement(ant_s_);
		run_one_ant_to_the_max(ant_s_);

		for (int i = 0; i < xLimit; i++) {
			tile[] tile1 = tiles[i];			

			Color d = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
			for (int j = 0; j < yLimit; j++) {
				tile tile = tile1[j];
				if (tile.getTileColor() != Color.RED && tile.getTileColor() != Color.BLUE
						&& tile.getTileColor() != Color.MAGENTA
						&& tile.getTileColor() != Color.ORANGE & tile.getTileColor() != Color.BLACK) {
					tile.setTileColor(initialTialColor);
				} else if (tile.getTileColor() != Color.RED && tile.getTileColor() != Color.BLUE
						&& tile.getTileColor() != initialTialColor
						&& tile.getTileColor() != Color.ORANGE & tile.getTileColor() != Color.BLACK) {
					tile.setTileColor(initialTialColor);
				}else if(tile.getTileColor() == Color.BLACK) {
					
					tile.setTileColor(Color.ORANGE);
				}else if(tile.getTileColor() == Color.ORANGE) {
					tile.setTileColor(Color.BLACK);
					
				}else if (tile.getTileColor() == Color.DARK_GRAY) {
					if(d==Color.RED)
						tile.setTileColor(initialTialColor);
					
					tile.setTileColor(d);
					
				} 
			}

		}
	}

	private static void run_one_ant_to_the_max(ArrayList<ANT> ant_s_2) {
		for (ANT ant : ant_s_2) {
			for (int i = 1; i < (int) (Math.random() * 1024 + 2048); i++) {
				ant.changeTile(tiles);
				ant.moveForward();

			}
		}

	}
	

	private static void run_all_ant_s_in_the_universe_exactly_one_unit_of_movement(ArrayList<ANT> ants) {
		for (ANT ant : ants) {
			ant.changeTile(tiles);
			ant.moveForward();
		}

	}

	private static void run_all_ant_s_in_the_universe_exactly_N_unit_of_movement(ArrayList<ANT> ants) {
		for (ANT ant : ants) {
			for (int i = 0; i < (int) (Math.random() * 64); i++) {

				ant.changeTile(tiles);
				ant.moveForward();
			}
		}

	}

	public static tile[][] getTiles() {
		return tiles;
	}

	public static void setTiles(tile[][] tiles) {
		Tiles.tiles = tiles;
	}

	public tile[][] getToDisplay() {

		if (queue.size() > 0) {
			tile[][] remove = queue.remove(0);
			//System.out.println("-QSize " + queue.size());
			return remove;
		} else
			return null;
	}

	public ArrayList<ANT> getAnts() {
		return ant_s_;
	}

	public int getSimcount() {
		return simcount;
	}
	

	public void setSimcount(int simcount) {
		this.simcount = simcount;
	}

	public boolean isFull() {
		
		return queue.size()==queueMaxSize;
	}

}
