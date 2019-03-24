package nl.han.ica.HazardBattle;

import java.util.List;

import nl.han.ica.HazardBattle.Tiles.LoopbandTile;
import nl.han.ica.OOPDProcessingEngineHAN.Collision.CollidedTile;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import processing.core.PVector;

public class Geest extends AbstractObject {

	private HazardBattle world; 
	
	public Geest(HazardBattle world) {
		super(new Sprite("src/main/java/nl/han/ica/HazardBattle/media/ghost.png"));
		this.world = world;
		setxSpeed(2f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mousePressed(int x, int y, int button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
		// TODO Auto-generated method stub
		PVector vector; 
		
        for (CollidedTile ct : collidedTiles) {
            
            if (ct.theTile instanceof LoopbandTile) {
            	this.setX(getX() + 32);
            	setxSpeed(1f);
            }
        }
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(getX() == world.gameBreedte) {
			world.verminderLevens(4);
			world.deleteGameObject(this);		
		} else if(world.haalLevensOp() == 0) {
			world.exit();
		}
	}

}
