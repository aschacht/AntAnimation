package src;


public enum Direction {
NORTH,NORTHEAST,NORTHWEST,EAST,SOUTH,SOUTHEAST,SOUTHWEST,WEST;

public static Direction random() {
	
	int random = (int)(Math.random()*7);
	
	if(random ==0){
		return NORTH;
	}else if(random == 1){
		return EAST;
	}else if(random == 2){
		return SOUTH;
	}
//	else if(random == 3){
//		return NORTHEAST;
//	}else if(random == 4){
//		return NORTHWEST;
//	}else if(random == 5){
//		return SOUTHEAST;
//	}else if(random == 6){
//		return SOUTHWEST;
//	}
	else{
		return WEST;
	}
	
}
}
