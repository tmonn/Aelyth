package net.minecraft.src;

import java.util.Random;

public class BlockAelythStone extends Block
{
	
    public BlockAelythStone(int i, int j)
    {
        super(i, j, Material.rock);
    }
    
    
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythCobble.blockID;
    }
}
