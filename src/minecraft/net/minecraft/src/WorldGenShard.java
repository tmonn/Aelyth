package net.minecraft.src;

import java.util.Random;


/* =============BUGS=============
 * 
 * génération uniquement sur l'axe z
 * 
 */


public class WorldGenShard extends WorldGenerator 
{
	public WorldGenShard()
	{
	}

	public boolean generate(World world, Random random, int i, int j, int k) 
	{
		int i1 = i + 10;
		int j1 = j + 20;
		int k1 = k + 10;
		for(; i < i1; i++)//axe x
		{
			for(; j < j1; j++)//axe y
			{
				for(; k < k1; k++)//axe z
				{
					System.out.println("i: " + i + " i1: " + i1);
					System.out.println("j: " + j + " j1: " + j1);
					System.out.println("k: " + k + " k1: " + k1);
				    world.setBlockWithNotify(i, j, k, mod_Aelyth.ObliviousDirt.blockID);
				}
			}
		}
		return true;
	}

}
