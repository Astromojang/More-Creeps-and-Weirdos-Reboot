package creeps.item;

import creeps.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBlorpCola extends Item{
	

	
	private final String name = "blorp_cola";
	public ItemBlorpCola(){
		
	GameRegistry.registerItem(this, name);
	setUnlocalizedName(Reference.MOD_ID + "_" + name);
	setCreativeTab(CreativeTabs.tabMisc);
	
	}
	
	public String getName(){
		
	return name;
	
	}
	
	
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }
	

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }
        
        

        if (!worldIn.isRemote)
        {
            playerIn.heal(2);
        }
     
        
        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return stack;
        
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 32;
    }

  

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        worldIn.playSoundAtEntity(playerIn, "creeps:blorpcola", 1.0F, 0.6F);
        
        return itemStackIn;
    }
}