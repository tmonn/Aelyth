package net.minecraft.src;

import java.util.Random;

public class BlockAelythCobble extends Block
{
	
    public BlockAelythCobble(int i, int j)
    {
        super(i, j, Material.rock);
    }
    
    
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythCobble.blockID;
    }
    
}
