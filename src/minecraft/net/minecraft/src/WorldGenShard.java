package net.minecraft.src;

import java.util.Random;


/* =============BUGS=============
 * 
 * Les panneaux ce générent contre le mauvais mur
 * 
 */


public class WorldGenShard extends WorldGenerator 
{
	public WorldGenShard()
	{
	}

	public boolean generate(World world, Random random, int i, int j, int k) 
	{
		/*
		 * ==================SON D'EXPLOSION=================== 
		 */
		
		//world.playSoundEffect((double) i, (double) j, (double) k, "random.explode", 10.0F, 0.6F);
		
		
		int longueurReel = 5;
		int hauteurReel = 5;
		int largeurReel = 5;
		
		/*
		 * ==================GENERATION CUBE=================== 
		 */
		for(int longueur = i; longueur < i + longueurReel; longueur++)//axe x
		{
			for(int hauteur = j; hauteur < j + hauteurReel; hauteur++)//axe y
			{
				for(int largeur = k; largeur < k + largeurReel; largeur++)//axe z
				{ 
					world.setBlock(longueur, hauteur, largeur, mod_Aelyth.AelythDirt.blockID);   	
				}
			}
		}
		
		/*
		 * ==================VIDAGE CUBE=================== 
		 */
		
		for(int longVide = i + 1; longVide < i + longueurReel - 1; longVide++)
		{
			for(int hautVide = j + 1; hautVide < j + hauteurReel - 1; hautVide++)
			{
				for(int largVide = k + 1; largVide < k + largeurReel - 1; largVide++)
				{
					world.setBlockWithNotify(longVide, hautVide, largVide, 0);
				}
			}
		}
		
		/*
		 * ==================PLACEMENT COFFRE + UN DIAMAND=================== 
		 */
		
	    world.setBlock(i + 1, j + 1, k + 2, Block.chest.blockID); 
	    TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i + 1, j + 1, k + 2);
	    ItemStack item = new ItemStack(Item.diamond, 1);
        tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), item);
		
        /*
		 * ==================SPAWN DU FEU=================== 
		 */
		
        for(int largFeu = i; largFeu < i + 20; largFeu++)
        {
        	for(int hautFeu = j; hautFeu < j + 20; hautFeu++)
        	{
        		for(int longFeu = k; longFeu < k + 20; longFeu++)
        		{
        			if(random.nextInt(50) == 0)
        			{
        				int ID = world.getBlockId(largFeu, hautFeu, longFeu);
        				if((ID == 0 || ID == Block.leaves.blockID) && world.getBlockId(largFeu, hautFeu - 1, longFeu) != 0)
        				{
        					world.setBlockWithNotify(largFeu, hautFeu, longFeu, Block.fire.blockID);
        				}
        			}
        		}
        	}
        }
        
        // i = axe x
        // j = axe y
        // k = axe z
        
        /*
		 * ==================FEU INTERIEUR + PORTE=================== 
		 */
        
        world.setBlockWithNotify(i + 1, j, k + 1, Block.netherrack.blockID);
        world.setBlockWithNotify(i + 2, j, k + 1, Block.netherrack.blockID);
        world.setBlockWithNotify(i + 3, j, k + 1, Block.netherrack.blockID);
        world.setBlockWithNotify(i + 1, j, k + 3, Block.netherrack.blockID);
        world.setBlockWithNotify(i + 2, j, k + 3, Block.netherrack.blockID);
        world.setBlockWithNotify(i + 3, j, k + 3, Block.netherrack.blockID);
        
        world.setBlockWithNotify(i + 1, j + 1, k + 1, Block.fire.blockID);
        world.setBlockWithNotify(i + 2, j + 1, k + 1, Block.fire.blockID);
        world.setBlockWithNotify(i + 3, j + 1, k + 1, Block.fire.blockID);
        world.setBlockWithNotify(i + 1, j + 1, k + 3, Block.fire.blockID);
        world.setBlockWithNotify(i + 2, j + 1, k + 3, Block.fire.blockID);
        world.setBlockWithNotify(i + 3, j + 1, k + 3, Block.fire.blockID);
        
        world.setBlockWithNotify(i + 4, j + 1, k + 2, 0);
        world.setBlockWithNotify(i + 4, j + 2, k + 2, 0);
        
        
        /*
		 * ==================FACONNAGE SHARD=================== 
		 */
        
        
        world.setBlockWithNotify(i + 4, j + 3, k + 4, 0);
        world.setBlockWithNotify(i + 4, j + 4, k + 4, 0);
        world.setBlockWithNotify(i + 4, j + 3, k, 0);
        world.setBlockWithNotify(i + 4, j + 4, k, 0);
        world.setBlockWithNotify(i + 4, j + 4, k + 1, 0);
        world.setBlockWithNotify(i + 4, j + 4, k + 3, 0);
        
        world.setBlockWithNotify(i + 3, j + 3, k + 4, 0);
        world.setBlockWithNotify(i + 3, j + 4, k + 4, 0);
        world.setBlockWithNotify(i + 3, j + 3, k, 0);
        world.setBlockWithNotify(i + 3, j + 4, k, 0);
        world.setBlockWithNotify(i + 3, j + 4, k + 1, 0);
        world.setBlockWithNotify(i + 3, j + 4, k + 3, 0);
        
        world.setBlockWithNotify(i + 2, j + 3, k + 4, 0);
        world.setBlockWithNotify(i + 2, j + 4, k + 4, 0);
        world.setBlockWithNotify(i + 2, j + 3, k, 0);
        world.setBlockWithNotify(i + 2, j + 4, k, 0);
        world.setBlockWithNotify(i + 2, j + 4, k + 1, 0);
        world.setBlockWithNotify(i + 2, j + 4, k + 3, 0);
        
        world.setBlockWithNotify(i + 1, j + 3, k + 4, 0);
        world.setBlockWithNotify(i + 1, j + 4, k + 4, 0);
        world.setBlockWithNotify(i + 1, j + 3, k, 0);
        world.setBlockWithNotify(i + 1, j + 4, k, 0);
        world.setBlockWithNotify(i + 1, j + 4, k + 1, 0);
        world.setBlockWithNotify(i + 1, j + 4, k + 3, 0);
        
        world.setBlockWithNotify(i, j + 3, k + 4, 0);
        world.setBlockWithNotify(i, j + 4, k + 4, 0);
        world.setBlockWithNotify(i, j + 3, k, 0);
        world.setBlockWithNotify(i, j + 4, k, 0);
        world.setBlockWithNotify(i, j + 4, k + 1, 0);
        world.setBlockWithNotify(i, j + 4, k + 3, 0);
        
        world.setBlockWithNotify(i + 3, j + 3, k + 1, mod_Aelyth.AelythDirt.blockID);
        world.setBlockWithNotify(i + 3, j + 3, k + 3, mod_Aelyth.AelythDirt.blockID);
        
        world.setBlockWithNotify(i + 2, j + 3, k + 1, mod_Aelyth.AelythDirt.blockID);
        world.setBlockWithNotify(i + 2, j + 3, k + 3, mod_Aelyth.AelythDirt.blockID);
        
        world.setBlockWithNotify(i + 1, j + 3, k + 1, mod_Aelyth.AelythDirt.blockID);
        world.setBlockWithNotify(i + 1, j + 3, k + 3, mod_Aelyth.AelythDirt.blockID);

        world.setBlockWithNotify(i, j + 3, k + 1, mod_Aelyth.AelythDirt.blockID);
        world.setBlockWithNotify(i, j + 3, k + 3, mod_Aelyth.AelythDirt.blockID);
        
        world.setBlockWithNotify(i, j, k, 0);
        world.setBlockWithNotify(i, j, k + 4, 0);

        world.setBlockWithNotify(i + 1, j, k, 0);
        world.setBlockWithNotify(i + 1, j, k + 4, 0);
        
        world.setBlockWithNotify(i + 2, j, k, 0);
        world.setBlockWithNotify(i + 2, j, k + 4, 0);
        
        world.setBlockWithNotify(i + 3, j, k, 0);
        world.setBlockWithNotify(i + 3, j, k + 4, 0);
        
        world.setBlockWithNotify(i + 4, j, k, 0);
        world.setBlockWithNotify(i + 4, j, k + 4, 0);
        
        
//        world.setBlock(i + 1, j + 3, k + 2, Block.signWall.blockID); 
//	    TileEntitySign tileentitysign = (TileEntitySign)world.getBlockTileEntity(i + 1, j + 3, k + 2);
//	    
//        world.setBlock(i + 1, j + 2, k + 2, Block.signWall.blockID); 
//	    TileEntitySign tileentitysign2 = (TileEntitySign)world.getBlockTileEntity(i + 1, j + 2, k + 2);
//	    
//        tileentitysign.signText = new String[] {"Bravo jeune", "pomme, tu viens", "de découvrir", "l'objet qui"};
//        tileentitysign.signText = new String[] {"va te", "permettre", "d'acceder à", "l'Aelyth !"};
        
        
		return true;
	}
}
