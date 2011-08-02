package net.minecraft.src;

import java.util.Random;

public class BlockAelythDirt extends Block
{
	public BlockAelythDirt(int i, int j)
	{
		super(i, j, Material.ground);
	}
	
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythDirt.blockID;
    }
}
