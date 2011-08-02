package net.minecraft.src;

import java.util.Random;

public class BlockAelythLog extends Block
{
    public BlockAelythLog(int i, int j)
    {
        super(i, j, Material.wood);
    }
    
    public int idDropped(int i, Random random)
    {
        return mod_Aelyth.AelythLog.blockID;
    }
}
