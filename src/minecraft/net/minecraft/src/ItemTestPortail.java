package net.minecraft.src;

import net.minecraft.client.*;
import java.util.Random;

public class ItemTestPortail extends Item 
{
	Minecraft mc;
	Random rand;
	
	public ItemTestPortail(int i)
	{
		super(i);
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World theWorld, EntityPlayer thePlayer)
    {
        System.out.println("Toggling dimension!!");
        if(thePlayer.dimension == -1)
        {
            thePlayer.dimension = 0;
        } else
        {
            thePlayer.dimension = -1;
        }
        theWorld.setEntityDead(thePlayer);
        thePlayer.isDead = false;
        double d = thePlayer.posX;
        double d1 = thePlayer.posZ;
        double d2 = 8D;
        if(thePlayer.dimension == -1)
        {
            d /= d2;
            d1 /= d2;
            thePlayer.setLocationAndAngles(d, thePlayer.posY, d1, thePlayer.rotationYaw, thePlayer.rotationPitch);
            if(thePlayer.isEntityAlive())
            {
                theWorld.updateEntityWithOptionalForce(thePlayer, false);
            }
            World world = null;
            world = new World(theWorld, WorldProvider.getProviderForDimension(-1));
            
            if(theWorld == null)
            	System.out.println("theWorld est null");
            else
            	System.out.println("theWorld N'EST PAS null");
            if(thePlayer == null)
            	System.out.println("thePlayer est null");
            else
            	System.out.println("thePlayer N'EST PAS null");
            
            mc.changeWorld(world, "Entering the Nether", thePlayer);
        } else
        {
            d *= d2;
            d1 *= d2;
            thePlayer.setLocationAndAngles(d, thePlayer.posY, d1, thePlayer.rotationYaw, thePlayer.rotationPitch);
            if(thePlayer.isEntityAlive())
            {
                theWorld.updateEntityWithOptionalForce(thePlayer, false);
            }
            World world1 = null;
            world1 = new World(theWorld, WorldProvider.getProviderForDimension(0));
            mc.changeWorld(world1, "Leaving the Nether", thePlayer);
        }
        thePlayer.worldObj = theWorld;
        if(thePlayer.isEntityAlive())
        {
            thePlayer.setLocationAndAngles(d, thePlayer.posY, d1, thePlayer.rotationYaw, thePlayer.rotationPitch);
            theWorld.updateEntityWithOptionalForce(thePlayer, false);
            (new Teleporter()).func_4107_a(theWorld, thePlayer);
        }
        
        return itemstack;
    }
}
