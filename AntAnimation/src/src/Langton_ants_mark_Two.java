package src;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Panel;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Langton_ants_mark_Two {

	private static final int _60 = 60;
	private static final int _72 = 72;
	private static final int animationTime = 48;
	private static final int _800 = 800;
	private static final int _1024 = 1024;
	final static String FILE_TO_LOAD_JPG = "DUCK_COP_THE_GAME.jpg";
	private static JFrame frameThatisthedemoyouareWATCHINGNOW;
	private static JPanel pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here;
	private static JTabbedPane tabbedPaneThi_i_i_i_ight;
	private static String Experiment_1_NAME;
	private static Panel infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario;
	private static BufferedImage img;
	private static String currentWorkspaceDirectory = "C:\\Users\\BitBot01\\workspace\\Board\\";
	private static String nicePictureToShowWhenNotLogging = currentWorkspaceDirectory + "resources\\data\\IMAGES\\"
			+ FILE_TO_LOAD_JPG;
	private static Graphics2D PANE_ONE_CHANNEL;
	private static JLabel imageForSeed;
	private static JTextArea txtrWidth;
	private static JTextArea txtrHeight;
	private static JTextArea txtrTotalNumberOfPixels;
	private static JTextArea txtrFile;
	private static ArrayList<JTextArea> factsaboutanexperimentthatisrunning = new ArrayList<JTextArea>();
	private static int height;
	private static int width;
	private static int total_number_of_pixel_s_;

	private static String FileONEthefiletoprocess;
	private static String filePathForFileONE;
	private static String FileONE_with_constructed_path;
	private static PrintWriter NSA_olive_ve_Let_tray_er_s_Edition;

	private static final int ONETHOUSAND = 1;
	private static final int FIVE = 5;
	private static final double THREE = 3.0000001;
	private static final int TWENTYFIVE = 25;
	private static final int FOURTEEN = 14;
	private static final int THIRTEEN = 13;
	private static final int ONE = 1;
	private static final int TWENTYFOUR = 24;
	private static final int TWENTYTHREE = 23;
	private static final double ONEHUNDREDTWENTYEIGHT = 128;
	private static final int TWO = 2;
	private static final int TWOHUNDREDFIFTYFIVE = 255;
	private static final int ZERO = 0;
	private static final int TWOTHOUSAND = 2000;
	private static final int THREETHOUSAND = 3000;
	private static final int FOURTHOUSAND = 4000;
	private static final int FIVETHOUSAND = 5000;
	private static final int SIXTHOUSAND = 6000;
	private static final int SEVENTHOUSAND = 7000;
	private static final int EIGHTTHOUSAND = 8000;
	private static final int NINETHOUSAND = 9000;
	private static final int TENTHOUSAND = 10000;
	private static final int FIVEHUNDRED = 50;
	private static int COUNT = 0;
	private static int max = FIVE;
	private static ArrayList<vector> pixels;

	private static int ONETHOUSANDTWENTYFOUR = 1024;
	private static int mouseWheelNotches;
	private static double mousePreciseRotation;
	static Simulation simOne = null;
	private static int zoomLevel = 0;
	private static ArrayList<BufferedImage> images = new ArrayList<>();
	private static int xLimit = 0 ;
	private static int yLimit = 0 ;
	private static Tiles tiles;
	static Color initialTialColor = Color.DARK_GRAY;
	static ArrayList<ANT> ant_s_;
	
	
	static MouseMotionListener mouseListen = new MouseMotionListener() {

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			simOne.setCurrentLocation(e.getLocationOnScreen());

		}
	};

	public static void main(String[] args) {
		loadImages();
		set_up_display_stuff();
		ant_s_ = new ArrayList<>();
		tiles = new Tiles(xLimit,yLimit,initialTialColor,ant_s_);
		generateBoard();
		generateAnts();
		
		simOne = new Simulation(true,MouseInfo.getPointerInfo().getLocation(),0, frameThatisthedemoyouareWATCHINGNOW, PANE_ONE_CHANNEL, width,xLimit,yLimit, tiles);
		simOne.setPickup(true);
		
		simOne.start();

	}
	
	
	public static void generateBoard() {

		
		tile[][] tilez = tiles.getTiles();
		
		for (int i = 0; i < xLimit; i++) {
			for (int j = 0; j < yLimit; j++) {
				Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
						(int) (Math.random() * 255));
				if (color != Color.RED)
					tilez[i][j] = new tile(i, j, color);
				else
					tilez[i][j] = new tile(i, j, initialTialColor);

			}
		}
	}

	public static void generateAnts() {
		for (int i = 0; i < 10// 50000
		; i++) {
			ant_s_.add(new ANT((int) (Math.random() * (xLimit - 1)), (int) (Math.random() * (yLimit - 1)),
					Direction.random(), xLimit, yLimit, new Color(255, 255, 0)));
		}

	}
	
	
	

	private static void loadImages() {
		for (int i = 0; i < 73; i++) {

			BufferedImage img = null;


			try {
				img = ImageIO.read(new File(
						"/home/wes/Wisper Tech 1.0/THEORY/GAMES/AntAnimation/LANGTON_ANTs_II/resources/data/IMAGES/"
								+ COUNT + ".jpg"));
				if (img != null)
					COUNT++;
			} catch (IOException e) {
			}
			try {
				if (img == null) {
					img = ImageIO.read(new File(
							"/home/wes/Wisper Tech 1.0/THEORY/GAMES/AntAnimation/LANGTON_ANTs_II/resources/data/IMAGES/"
									+ COUNT + ".bmp"));
					COUNT++;
				}
			} catch (IOException e) {
			}
			try {
				if (img == null) {
					img = ImageIO.read(new File(
							"/home/wes/Wisper Tech 1.0/THEORY/GAMES/AntAnimation/LANGTON_ANTs_II/resources/data/IMAGES/"
									+ COUNT + ".png"));
					COUNT++;
				}
			} catch (IOException e) {
			}


			images.add(img);

		}
		
		
		xLimit = findMaxX();
		yLimit = findMaxY();		
	}

	private static void set_up_display_stuff() {
		frameThatisthedemoyouareWATCHINGNOW = new JFrame("LANGTON_ANT[S][s][S]");

		frameThatisthedemoyouareWATCHINGNOW.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				if (zoomLevel + e.getWheelRotation() >= 1) {
					zoomLevel += e.getWheelRotation();
					simOne.setZOOMLevel(zoomLevel);
				}

				System.out.println("zoom Level " + zoomLevel);

			}
		});

		pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here = new JPanel();

		pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here.addMouseMotionListener(mouseListen);

		tabbedPaneThi_i_i_i_ight = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneThi_i_i_i_ight.addTab(Experiment_1_NAME, null,
				pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here, null);

		frameThatisthedemoyouareWATCHINGNOW.add(tabbedPaneThi_i_i_i_ight);
		frameThatisthedemoyouareWATCHINGNOW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameThatisthedemoyouareWATCHINGNOW.setLayout(new GridBagLayout());
		pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here
				.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

//		pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here
//				.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario = new Panel();

//		infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario
//				.setLayout(new FlowLayout(FlowLayout.TRAILING, 100, 100));

//		pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here
//				.add(infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario);

		img = new BufferedImage(xLimit, yLimit, BufferedImage.TYPE_INT_RGB);
		// try {

		// img = ImageIO.read(new File(nicePictureToShowWhenNotLogging));
		getHeightAndWidthOfImage(img);
		calculate_total_number_of_pixels_SLASH_nodes___();

		PANE_ONE_CHANNEL = img.createGraphics();
		// } catch (IOException e) {
		// System.out.println(nicePictureToShowWhenNotLogging);
		// e.printStackTrace();
		// }
		{
			ZERO_regester_a_fact_or_statistic_about___();

			ONE_add_regestered_facts_added_to_info_panel();

			TWO_write_statistics_to_a_text_box_single_line();
		}
		;

		ImageIcon image = new ImageIcon(img);

		imageForSeed = new JLabel(image);
		imageForSeed.setHorizontalAlignment(SwingConstants.TRAILING);

		pane1ThiS_here_stallion_can_get_yo_fo_here_to_to_to_to_to_here.add(imageForSeed);

		System.out.println("flash pixels red green blue random for 3");

		fill_in_list_of_pixels_before_you_make_any_changes_to_the_screen();

		flash_pixels_red_green_blue_random_for(3);

		System.out.println("Oh what a Nice Picture: " + nicePictureToShowWhenNotLogging);

	}

	private static void ZERO_regester_a_fact_or_statistic_about___() {
		txtrWidth = new JTextArea();
		txtrHeight = new JTextArea();
		txtrTotalNumberOfPixels = new JTextArea();
		txtrFile = new JTextArea();
	}

	private static void ONE_add_regestered_facts_added_to_info_panel() {
		factsaboutanexperimentthatisrunning.add(txtrHeight);
		factsaboutanexperimentthatisrunning.add(txtrWidth);
		factsaboutanexperimentthatisrunning.add(txtrTotalNumberOfPixels);
		factsaboutanexperimentthatisrunning.add(txtrFile);

		infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario
				.add(txtrHeight);
		infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario.add(txtrWidth);
		infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario
				.add(txtrTotalNumberOfPixels);
		infogroupThiSis____ohhhhohhhhhohhhhhThisIsTHeInfoGroupPanelThatDisplaysStatsAboutRunningScenario.add(txtrFile);

	}

	private static void TWO_write_statistics_to_a_text_box_single_line() {

		txtrHeight.setText("height: " + height);
		txtrWidth.setText("width: " + width);
		txtrTotalNumberOfPixels.setText("total pixel count: " + total_number_of_pixel_s_);
		txtrFile.setText("file: " + FILE_TO_LOAD_JPG);

		System.out.println("height: " + height);
		System.out.println("width: " + width);
		System.out.println("total pixel count: " + total_number_of_pixel_s_);
		System.out.println("file: " + FILE_TO_LOAD_JPG);
	}

	private static void getHeightAndWidthOfImage(BufferedImage img) {
		height = img.getHeight();
		width = img.getWidth();
	}

	private static void calculate_total_number_of_pixels_SLASH_nodes___() {
		total_number_of_pixel_s_ = height * width;
	}

	private static void flash_pixels_red_green_blue_random_for(int some_amount_of_t) {



		frameThatisthedemoyouareWATCHINGNOW.setVisible(true);

		
		
		
		
		
		
		COUNT = 0;
		int framecount=0;
		double time =0;
		try {
			for (int random = 0; random < animationTime; random++) {
				

				long start = System.currentTimeMillis();
				Thread.sleep((int)(15));
				long fin = System.currentTimeMillis();
			
				long l = fin-start;
				time+=l;
				start = System.currentTimeMillis();
				PANE_ONE_CHANNEL.drawImage(images.get(COUNT), 0, 0, null);
				COUNT++;
				 fin = System.currentTimeMillis();
				 long m = fin-start;
				 time+=m;
				 start = System.currentTimeMillis();

				 
				if (COUNT >= _72) {
					COUNT=0;
				}
				

				frameThatisthedemoyouareWATCHINGNOW.pack();
				frameThatisthedemoyouareWATCHINGNOW.repaint();
				if(random<5) {
				System.out.println("random: "+random);
					Thread.sleep(4000);
				}else
					Thread.sleep(42);
				fin = System.currentTimeMillis();
				long m2 = fin-start;
				time+=m2;
				framecount++;
				
				if(framecount == _60) {
					System.out.println("60 frames every "+(double)(time/1000)+" seconds");
					framecount=0;
					time=0;
				}
				
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("HEY");

		// dot_dot_dot();

	}

	private static int findMaxX() {
int witdthMax = 0;
		for (BufferedImage bufferedImage : images) {
			int width2 = bufferedImage.getWidth();
			if(witdthMax<width2)
				witdthMax=width2;
		}
		
		return witdthMax;
		
	}
	private static int findMaxY() {
		int heightMax = 0;
		for (BufferedImage bufferedImage : images) {
			int height2 = bufferedImage.getHeight();
			if(heightMax<height2)
				heightMax=height2;
		}
		
		return heightMax;
		
	}

	private static void am_i_winking_blinking_or_noding(Color red, Color white) {

		I_SHALL_NOW_FLASH_THIS_MIXEL_PIXEL_RED_WHITE_or_WHITE_RED(red, white);
	}

	private static void now_can_you_see_the_change_in_the_pattern_(Color thesecondcolorichosetoshow, Color white) {
		FIRSTTHISPIXELSHALLBEEEEEEEEEEEEEEEEEEEEEEEEEEEE(thesecondcolorichosetoshow);

	}

	private static void ok_cool_can_you_now_see_the_blue_dog_(Color blue, Color white) {
		FIRSTTHISPIXELSHALLBEEEEEEEEEEEEEE(blue);

	}

	private static void ok_now_RANDOM_Red_Green_Blue() {
		System.out.println("now a random Red ");

		Color randomRed = new Color(((int) (Math.random() * TWOHUNDREDFIFTYFIVE)), ZERO, ZERO);

		FIRSTTHISPIXELSHALLBEEEEEEEEEEEEEE(randomRed);

	}

	private static void FIRSTTHISPIXELSHALLBEEEEEEEEEEEEEE(Color blue) {

//		for (int j = 0; j < height; j++) {
//			PANE_ONE_CHANNEL.setColor(blue);
//			PANE_ONE_CHANNEL.drawRect(0, j, ONETHOUSANDTWENTYFOUR, 1);
//		}

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					"/home/wes/Wisper Tech 1.0/THEORY/GAMES/AntAnimation/LANGTON_ANTs_II/resources/data/IMAGES/" + COUNT
							+ ".jpg"));
			COUNT++;
		} catch (IOException e) {
		}

		if (COUNT >= _72)
			COUNT = 0;

		PANE_ONE_CHANNEL.drawImage(img, 0, 0, null);

		frameThatisthedemoyouareWATCHINGNOW.pack();
		frameThatisthedemoyouareWATCHINGNOW.repaint();

	}

	private static void okletsalltakeTHREEandcallitthislightingschemeisreallycommingtogetherguysiloveitFIVEMIPPIPPIS() {
		try {
			Thread.sleep((int) FIVEHUNDRED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static void I_SHALL_NOW_FLASH_THIS_MIXEL_PIXEL_RED_WHITE_or_WHITE_RED(Color red, Color white) {
		FIRSTTHISPIXELSHALLBEEEEEEEEEEEEEEEEEEEEEEEEEEEE(red);
	}

	private static void FIRSTTHISPIXELSHALLBEEEEEEEEEEEEEEEEEEEEEEEEEEEE(Color theColorIAmShowingFIRST) {

//		for (int j = 0; j < height; j++) {
//			PANE_ONE_CHANNEL.setColor(theColorIAmShowingFIRST);
//			PANE_ONE_CHANNEL.drawRect(0, j, ONETHOUSANDTWENTYFOUR, ONE);
//		}

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					"/home/wes/Wisper Tech 1.0/THEORY/GAMES/AntAnimation/LANGTON_ANTs_II/resources/data/IMAGES/" + COUNT
							+ ".jpg"));
			COUNT++;
		} catch (IOException e) {
		}

		if (COUNT >= _72)
			COUNT = 0;

		PANE_ONE_CHANNEL.drawImage(img, 0, 0, null);

		frameThatisthedemoyouareWATCHINGNOW.pack();
		frameThatisthedemoyouareWATCHINGNOW.repaint();

	}

	private static void andtheprinceaskedtheprincesstosleepforasecondwearealmostthereFIVEMIPPIPPIS() {
		try {
			int sleep_for_some_amount = (int) FIVEHUNDRED;
			System.out.println("Red is all set so im going to Sleeping for: " + sleep_for_some_amount + " s");
			Thread.sleep(sleep_for_some_amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void THISPIXELSHALLBEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE(
			Color white) {

//		for (int j = 0; j < height; j++) {
//			PANE_ONE_CHANNEL.setColor(white);
//			PANE_ONE_CHANNEL.drawRect(0, j, ONETHOUSANDTWENTYFOUR, ONE);
//			
//			
//		}

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					"/home/wes/Wisper Tech 1.0/THEORY/GAMES/AntAnimation/LANGTON_ANTs_II/resources/data/IMAGES/" + COUNT
							+ ".jpg"));
			COUNT++;
		} catch (IOException e) {
		}

		if (COUNT >= 7)
			COUNT = 0;

		PANE_ONE_CHANNEL.drawImage(img, 0, 0, null);

		frameThatisthedemoyouareWATCHINGNOW.pack();
		frameThatisthedemoyouareWATCHINGNOW.repaint();

	}

	private static void please_be_patient_this_section_is_still_under_construction_delay_s_are_to_be_expected_SOMENUMBEROFMIPPIPPIPPIS(
			int i) {
		try {
			// System.out.println("Set the second color so now im going to Sleep
			// for [" + i * ONETHOUSAND + "] ");
			Thread.sleep(FIVEHUNDRED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private static String print_i_please(int i) {
		hey_max_what_is_your_job();
		well_then_please();
		System.out.println("I i captian;");
		for (i = i; i < max; i++) {
			System.out.print("i");
		}
		System.out.println(";naitpac i I");
		return "i";
	}

	private static void well_then_please() {
		System.out.println("Please print i to the " + hey_max_what_is_your_name_again() + " dude/tude/food thank s");

	}

	public static void hey_max_what_is_your_job() {
		System.out.println("it is printer to the max and no more, after " + max
				+ " i am done, this whole \"joke\" has gone way to far . . .");
	}

	private static String hey_max_what_is_your_name_again() {
		System.out.println(
				"it is max i have only ben gone " + THREE + " second s you couldent have frogotten that much . . . ");
		return "max";
	}

	private static void could_you_do_me_this_favor_and() {
		System.out.println("Please print s to the " + hey_max_what_is_your_name_again() + " dude/tude/food thank s");

	}

	private static String print_s_please(int s) {
		hey_max_what_is_your_job();
		could_you_do_me_this_favor_and();
		System.out.println("S s captian;");
		for (s = s; s < max; s++) {
			System.out.print("s");
		}
		System.out.println(";naitpac s S");
		return "s";
	}

	private static void fill_in_list_of_pixels_before_you_make_any_changes_to_the_screen() {
		pixels = new ArrayList<vector>();

		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				int argb = img.getRGB(i, j);
				pixels.add((j * width) + i, build_a_vector_of_this_pixel_here_take_this_(argb));
				// System.out.println("recently added pixel
				// "+pixels.get((j*height)+i).getxDimension()+","+pixels.get((j*height)+i).getyDimension()+","+pixels.get((j*height)+i).getzDimension());
			}

			// System.out.println("LOADED ROW OF SIZE: "+pixels.get(j).size()+"
			// mixels/pixels/pixelz");
		}

		// System.out.println("TOTAL ROWS LOADED: "+pixels.size()+"
		// pixels/mixels/zlexip");

	}

	public static vector build_a_vector_of_this_pixel_here_take_this_(int plus_one) {
		int alpha = (plus_one >> 24) & 0xff;
		int red = (plus_one >> 16) & 0xff;
		int green = (plus_one >> 8) & 0xff;
		int blue = (plus_one) & 0xff;

		int lottery_for_all_the_BIG_MONNEY = (int) (Math.random() * TWOHUNDREDFIFTYFIVE);
		int lottery_for_all_the_GIB_MONNEY = (int) (Math.random() * TWOHUNDREDFIFTYFIVE);
		int lottery_for_all_the_XXX_MONNEY = (int) (Math.random() * TWOHUNDREDFIFTYFIVE);

		// System.out.println("/alpha/ /red/ /green/ /blue/
		// /lottery_for_all_the_BIG_MONNEY/ "+"/"+alpha+"/ /"+red+"/ /"+green+"/
		// /"+blue+"/ /"+lottery_for_all_the_BIG_MONNEY+"/ ");

		return new vector(red, green, blue, lottery_for_all_the_BIG_MONNEY, lottery_for_all_the_GIB_MONNEY,
				lottery_for_all_the_XXX_MONNEY, alpha);

	}

	private static void load_image_from_saved_pixels() {

		System.out.println("Processing image this may take a bit . . .");

		you_have_arrived();

	}

	private static void you_have_arrived() {

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				vector vector = pixels.get((j * width) + i);
				Color imageColor = new Color(vector.xDimension, vector.yDimension, vector.zDimension);
				PANE_ONE_CHANNEL.setColor(imageColor);
				PANE_ONE_CHANNEL.drawRect(i, j, 1, 1);
			}
		}
		frameThatisthedemoyouareWATCHINGNOW.pack();
		frameThatisthedemoyouareWATCHINGNOW.setVisible(true);
		frameThatisthedemoyouareWATCHINGNOW.repaint();
	}

}
