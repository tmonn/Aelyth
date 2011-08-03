package net.minecraft.src;

import java.util.Random;

public class mod_Aelyth extends BaseMod
{
	
	public static int AelythDirtTexture;
	public static int AelythGrassTexture;
	public static int AelythLogTexture;
	public static int AelythWoodTexture;
	public static int AelythStoneTexture;
	public static int AelythCobbleTexture;
    public static int AelythSandTexture;
    public static int DestroyedStoneTexture;
    public static int AelythStickTexture;

	public mod_Aelyth()
	{
		RegisterBlock();
		setupName();
		setupTexture();
		AddRecipe();
	}
	
	
	
	public void RegisterBlock()
	{
		ModLoader.RegisterBlock(AelythDirt);
		ModLoader.RegisterBlock(AelythGrass);
		ModLoader.RegisterBlock(AelythLog);
		ModLoader.RegisterBlock(AelythWood);
		ModLoader.RegisterBlock(AelythStone);
		ModLoader.RegisterBlock(AelythCobble);
		ModLoader.RegisterBlock(AelythSand);
		ModLoader.RegisterBlock(DestroyedStone);
	}
	
	
	
	public void setupName()
	{
		ModLoader.AddName(AelythDirt, "Aelyth Dirt");
		ModLoader.AddName(AelythGrass, "Aelyth Grass");
		ModLoader.AddName(AelythLog, "Aelyth Log");
		ModLoader.AddName(AelythWood, "Aelyth Wood");
		ModLoader.AddName(AelythStone, "Aelyth Stone");
		ModLoader.AddName(AelythCobble, "Aelyth Cobblestone");
	    ModLoader.AddName(AelythSand, "Aelyth Sand");
	    ModLoader.AddName(DestroyedStone, "Destroyed Stone");
	    ModLoader.AddName(AelythStick, "Aelyth Stick");
	    
	}
	
	
	
	public void setupTexture()
	{
	/*	AelythDirtTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythDirt.png");
		AelythGrassTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythGrass.png");
		AelythLogTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythLog.png");
		AelythWoodTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythWood.png");
		AelythStoneTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythStone.png");
		AelythCobbleTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythCobble.png");
		AelythSandTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythSand.png");
		DestroyedStoneTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/DestroyedStone.png");
		AelythStickTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/AelythStickTexture.png");
	*/
	}
	
	
	
	public void AddRecipe()
	{
		ModLoader.AddRecipe(new ItemStack(AelythWood, 4), new Object[]
				{"#", Character.valueOf('#'), AelythLog});
		
		ModLoader.AddRecipe(new ItemStack(AelythStick, 2), new Object[]
				{"#", "#", Character.valueOf('#'), AelythWood});
	}
	
	public void GenerateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
			int randPosX = chunkX + rand.nextInt(16);
		    int randPosY = rand.nextInt(20) + 50;
		    int randPosZ = chunkZ + rand.nextInt(16);
		    (new WorldGenShard()).generate(world, rand, randPosX, randPosY, randPosZ);
	}
	
	
	public static final Block AelythDirt = (new BlockAelythDirt(100, AelythDirtTexture))
													.setHardness(0.6F)
													.setStepSound(Block.soundGravelFootstep)
													.setBlockName("Aelythdirt");
	
	public static final Block AelythGrass = (new BlockAelythGrass(101, AelythGrassTexture))
													.setHardness(0.7F)
													.setStepSound(Block.soundGrassFootstep)
													.setBlockName("Aelythgrass");
	
	public static final Block AelythLog = (new BlockAelythLog(102, AelythLogTexture))
													.setHardness(2.0F)
													.setStepSound(Block.soundWoodFootstep)
													.setBlockName("Aelythlog");
	
	public static final Block AelythWood = (new BlockAelythWood(103, AelythWoodTexture))
													.setHardness(2.0F)
													.setResistance(5F)
													.setStepSound(Block.soundWoodFootstep)
													.setBlockName("Aelythlog");
	
	public static final Block AelythStone = (new BlockAelythStone(104, AelythStoneTexture))
													.setHardness(2.0F)
													.setResistance(10F)
													.setStepSound(Block.soundStoneFootstep)
													.setBlockName("Aelythstone");
	
	public static final Block AelythCobble = (new BlockAelythCobble(105, AelythCobbleTexture))
													.setHardness(1.8F)
													.setResistance(8F)
													.setStepSound(Block.soundStoneFootstep)
													.setBlockName("Aelythcobble");
													
	public static final Block AelythSand = (new BlockAelythSand(106, AelythSandTexture))
													.setHardness(0.5F)
													.setResistance(8F)
													.setStepSound(Block.soundSandFootstep)
													.setBlockName("Aelythsand");	

	public static final Block DestroyedStone = (new BlockDestroyedStone(107, DestroyedStoneTexture))
													.setHardness(1.8F)
													.setResistance(8F)
													.setStepSound(Block.soundStoneFootstep)
													.setBlockName("destroyedstone");
	
	
	
	public static Item AelythStick = (new ItemAelythStick(5000)).setIconIndex(AelythStickTexture).setItemName("Aelythstick");
	
	public String Version()
	{
		return "En developpement ...";
	}

}
