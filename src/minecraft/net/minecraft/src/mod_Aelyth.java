package net.minecraft.src;

import java.util.Random;

public class mod_Aelyth extends BaseMod
{
	
	public static int ObliviousDirtTexture;
	public static int ObliviousGrassTexture;
	public static int ObliviousLogTexture;
	public static int ObliviousWoodTexture;
	public static int ObliviousStoneTexture;
	public static int ObliviousCobbleTexture;
    public static int ObliviousSandTexture;
    public static int DestroyedStoneTexture;
    public static int ObliviousStickTexture;

	public mod_Aelyth()
	{
		RegisterBlock();
		setupName();
		setupTexture();
		AddRecipe();
	}
	
	
	
	public void RegisterBlock()
	{
		ModLoader.RegisterBlock(ObliviousDirt);
		ModLoader.RegisterBlock(ObliviousGrass);
		ModLoader.RegisterBlock(ObliviousLog);
		ModLoader.RegisterBlock(ObliviousWood);
		ModLoader.RegisterBlock(ObliviousStone);
		ModLoader.RegisterBlock(ObliviousCobble);
		ModLoader.RegisterBlock(ObliviousSand);
		ModLoader.RegisterBlock(DestroyedStone);
	}
	
	
	
	public void setupName()
	{
		ModLoader.AddName(ObliviousDirt, "Oblivious Dirt");
		ModLoader.AddName(ObliviousGrass, "Oblivious Grass");
		ModLoader.AddName(ObliviousLog, "Oblivious Log");
		ModLoader.AddName(ObliviousWood, "Oblivious Wood");
		ModLoader.AddName(ObliviousStone, "Oblivious Stone");
		ModLoader.AddName(ObliviousCobble, "Oblivious Cobblestone");
	    ModLoader.AddName(ObliviousSand, "Oblivious Sand");
	    ModLoader.AddName(DestroyedStone, "Destroyed Stone");
	    ModLoader.AddName(ObliviousStick, "Oblivious Stick");
	    
	}
	
	
	
	public void setupTexture()
	{
		/*ObliviousDirtTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousDirt.png");
		ObliviousGrassTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousGrass.png");
		ObliviousLogTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousLog.png");
		ObliviousWoodTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousWood.png");
		ObliviousStoneTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousStone.png");
		ObliviousCobbleTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousCobble.png");
		ObliviousSandTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousSand.png");
		DestroyedStoneTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/DestroyedStone.png");
		ObliviousStickTexture = ModLoader.addOverride("/terrain.png", "/Aelyth/ObliviousStickTexture.png");
		*/
	}
	
	
	
	public void AddRecipe()
	{
		ModLoader.AddRecipe(new ItemStack(ObliviousWood, 4), new Object[]
				{"#", Character.valueOf('#'), ObliviousLog});
		
		ModLoader.AddRecipe(new ItemStack(ObliviousStick, 2), new Object[]
				{"#", "#", Character.valueOf('#'), ObliviousWood});
	}
	
	public void GenerateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
	    int randPosX = chunkX + rand.nextInt(16);
	    int randPosY = rand.nextInt(20) + 70;
	    int randPosZ = chunkZ + rand.nextInt(16);
	    (new WorldGenShard()).generate(world, rand, randPosX, randPosY, randPosZ);
	}
	
	
	public static final Block ObliviousDirt = (new BlockObliviousDirt(100, ObliviousDirtTexture))
													.setHardness(0.6F)
													.setStepSound(Block.soundGravelFootstep)
													.setBlockName("obliviousdirt");
	
	public static final Block ObliviousGrass = (new BlockObliviousGrass(101, ObliviousGrassTexture))
													.setHardness(0.7F)
													.setStepSound(Block.soundGrassFootstep)
													.setBlockName("obliviousgrass");
	
	public static final Block ObliviousLog = (new BlockObliviousLog(102, ObliviousLogTexture))
													.setHardness(2.0F)
													.setStepSound(Block.soundWoodFootstep)
													.setBlockName("obliviouslog");
	
	public static final Block ObliviousWood = (new BlockObliviousWood(103, ObliviousWoodTexture))
													.setHardness(2.0F)
													.setResistance(5F)
													.setStepSound(Block.soundWoodFootstep)
													.setBlockName("obliviouslog");
	
	public static final Block ObliviousStone = (new BlockObliviousStone(104, ObliviousStoneTexture))
													.setHardness(2.0F)
													.setResistance(10F)
													.setStepSound(Block.soundStoneFootstep)
													.setBlockName("obliviousstone");
	
	public static final Block ObliviousCobble = (new BlockObliviousCobble(105, ObliviousCobbleTexture))
													.setHardness(1.8F)
													.setResistance(8F)
													.setStepSound(Block.soundStoneFootstep)
													.setBlockName("obliviouscobble");
													
	public static final Block ObliviousSand = (new BlockObliviousSand(106, ObliviousSandTexture))
													.setHardness(0.5F)
													.setResistance(8F)
													.setStepSound(Block.soundSandFootstep)
													.setBlockName("oblivioussand");	

	public static final Block DestroyedStone = (new BlockDestroyedStone(107, DestroyedStoneTexture))
													.setHardness(1.8F)
													.setResistance(8F)
													.setStepSound(Block.soundStoneFootstep)
													.setBlockName("destroyedstone");
	
	
	
	public static Item ObliviousStick = (new ItemObliviousStick(5000)).setIconIndex(ObliviousStickTexture).setItemName("obliviousstick");
	
	public String Version()
	{
		return "En developpement ...";
	}

}
