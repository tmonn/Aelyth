package net.minecraft.src;

import java.util.Random;


/* =============BUGS=============
 * 
 * Bugs des emplacements où le Shard se génére (en l'air ou incrusté dans le sol)
 * 
 * Apparemment quelques bugs pour les blocs aléatoires sur le shard
 * 
 * spawn de l'herbe à revoir
 * 
 */


public class WorldGenShard extends WorldGenerator 
{	
	public WorldGenShard()
	{
	}

	public boolean generate(World world, Random random, int i, int j, int k) 
	{	
		
		if(!canGenerate(world, random, i, j, k))
			return false;
		
		int dirt = mod_Aelyth.AelythDirt.blockID;
		int stone = mod_Aelyth.AelythStone.blockID;
		int cobble = mod_Aelyth.AelythCobble.blockID;
		int grass = mod_Aelyth.AelythGrass.blockID;
		
		/*
		 * ==================SON D'EXPLOSION=================== 
		 */
		
		//world.playSoundEffect((double) i, (double) j, (double) k, "random.explode", 10.0F, 0.6F);
		
		
		/*
		 * ==================GENERATION SHARD=================== 
		 */
		
		for(int larg = i; larg < i + 7; larg++)
		{
			for(int lon = k; lon < k + 8; lon++)
			{
				world.setBlockWithNotify(larg, j, lon, dirt);
			}
		}
		
		for(int k1 = k + 2; k1 < k + 5; k1++)
			for(int i1 = i + 1; i1 < i + 6; i1++)
				world.setBlockWithNotify(i1, j + 1, k1, stone);
		
		
		world.setBlockWithNotify(i + 2, j + 1, k + 5, stone);
		world.setBlockWithNotify(i + 3, j + 1, k + 5, stone);		
		world.setBlockWithNotify(i + 4, j + 1, k + 5, stone);
		world.setBlockWithNotify(i + 3, j + 1, k + 6, stone);
		
		
		for(int k1 = k + 2; k1 < k + 4; k1++)
		{
			for(int j1 = j + 2; j1 < j + 4; j1++)
			{
				world.setBlockWithNotify(i + 2, j1, k1, stone);
				world.setBlockWithNotify(i + 4, j1, k1, stone);
			}
		}
		
		world.setBlockWithNotify(i + 3, j + 4, k + 2, stone);
		world.setBlockWithNotify(i + 3, j + 4, k + 3, stone);
		world.setBlockWithNotify(i + 3, j + 3, k + 4, stone);
		world.setBlockWithNotify(i + 3, j + 2, k + 5, stone);
		
		for(int i1 = i + 2; i1 < i + 5; i1++)
			world.setBlockWithNotify(i1, j + 2, k + 4, stone);
		
		
		world.setBlockWithNotify(i + 1, j + 2, k + 2, stone);
		world.setBlockWithNotify(i + 5, j + 2, k + 2, stone);
		
		/*
		 * ==================PLACEMENT COFFRE + UN DIAMAND=================== 
	     */
		
	    world.setBlock(i + 3, j + 2, k + 3, Block.chest.blockID); 
	    TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(i + 3, j + 2, k + 3);
	    ItemStack item = new ItemStack(Item.diamond, 1);
        tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), item);
		
        
		/*
		 * ==================BLOCS ALEATOIRES SUR LE SHARD=================== 
	     */
        
        for(int i1 = i; i1 < i + 7; i1++)
        {
        	for(int j1 = j + 1; j1 < j + 4; j1++)
        	{
        		for(int k1 = k; k1 < k + 8; k1++)
        		{
        			if(world.getBlockId(i1, j1 - 1, k1) != 0 && random.nextInt(20) == 0)
        			{
        				world.setBlockWithNotify(i1, j1, k1, random.nextInt(4)== 0 ? cobble : stone);
        			}
        		}
        	}
        }
        
		
		/*
		 * ==================GRASS ALEATOIRE AUTOUR DU SHARD=================== 
	     */
        int centreI = i + 3;
        int centreK = k + 4;
        
        for(int i1 = i - 10; i1 < i + 17; i1++)
        {
        	for(int j1 = j; j1 < j + 2; j1++)
        	{
        		for(int k1 = k - 10; k1 < k + 18; k1++)
        		{
        			if(world.getBlockId(i1, j1, k1) == Block.grass.blockID && random.nextInt(Math.abs(centreK)) == 0)
        			{
        				world.setBlockWithNotify(i1, j1, k1, grass);
        			}
        		}
        	}
        }
        
        
        
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
		return true;
	}
	
    public boolean canGenerate(World world, Random rand, int i, int j, int k)
    {
    	for(int i1 = i; i1 < i + 7; i1++)
    	{
    		for(int k1 = k; k1 < k + 8; k1++)
    		{
    			if(world.getBlockId(i1, j, k1) == 0 && world.getBlockId(i1, j, k1) != 0)
    			{
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }

}
