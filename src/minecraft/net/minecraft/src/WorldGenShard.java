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
		for(int longueur = i; longueur < i + 5; longueur++)//axe x
		{
			for(int hauteur = j; hauteur < j + 5; hauteur++)//axe y
			{
				for(int largeur = k; largeur < k + 5; largeur++)//axe z
				{
				    world.setBlockWithNotify(longueur, hauteur, largeur, mod_Aelyth.ObliviousDirt.blockID);
				}
			}
		}
		return true;
	}

}
