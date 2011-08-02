package net.minecraft.src;

import java.util.Random;

public class BlockAelythGrass extends Block
{

	protected BlockAelythGrass(int i, int j)
	{
		super(i, j, Material.grassMaterial);
	}
	
	
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythDirt.blockID;
    }

}
