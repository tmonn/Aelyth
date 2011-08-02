package net.minecraft.src;

import java.util.Random;

public class BlockAelythWood extends Block
{
	
    public BlockAelythWood(int i, int j)
    {
        super(i, j, Material.wood);
    }
    
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythWood.blockID;
    }
    
}
