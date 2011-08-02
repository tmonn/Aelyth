package net.minecraft.src;

import java.util.Random;

public class BlockAelythSand extends Block
{
	
    public BlockAelythSand(int i, int j)
    {
        super(i, j, Material.ground);
    }
    
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythSand.blockID;
    }
    
}
