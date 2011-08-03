package net.minecraft.src;

import java.util.Random;


/* =============BUGS=============
 * 
 * 
 * 
 */


public class WorldGenShard extends WorldGenerator 
{
	public WorldGenShard()
	{
	}

	public boolean generate(World world, Random random, int i, int j, int k) 
	{
		
		int longueurrel = 5;
		int hauteurrel = 5;
		int largeurrel = 5;
		
		for(int longueur = i; longueur < i + longueurrel; longueur++)//axe x
		{
			for(int hauteur = j; hauteur < j + hauteurrel; hauteur++)//axe y
			{
				for(int largeur = k; largeur < k + largeurrel; largeur++)//axe z
				{			
					if(longueur - i == longueurrel - 3 && hauteur - j == hauteurrel - 3 && largeur - k == largeurrel - 3)
					{
					    world.setBlock(longueur, hauteur, largeur, Block.chest.blockID); 
					    TileEntityChest tileentitychest = (TileEntityChest)world.getBlockTileEntity(longueur, hauteur, largeur);
					    ItemStack item = new ItemStack(Item.diamond, 1);
	                    tileentitychest.setInventorySlotContents(random.nextInt(tileentitychest.getSizeInventory()), item);
					}
					else
					{
						world.setBlock(longueur, hauteur, largeur, mod_Aelyth.AelythDirt.blockID);   
					}
				}
			}
		}
		return true;
	}
}
