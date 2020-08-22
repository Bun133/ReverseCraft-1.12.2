package com.bun133.reversecraft.block.reversecrafter;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseCrafterRecipe {
    public static final ReverseCrafterRecipe INSTANCE = new ReverseCrafterRecipe();
    private ReverseCrafterRecipe(){init();}

    private void init() {

    }

    public Map<Item,ItemStack[]> recipe_map=new HashMap<Item,ItemStack[]>();

    public static ItemStack[] getBaseStack(){
        ItemStack[] returnable = new ItemStack[49];
        Arrays.fill(returnable, ItemStack.EMPTY);
        return returnable;
    }

    public ItemStack[] getRecipeResult(ItemStack stack){
        for(Map.Entry<Item,ItemStack[]> e:recipe_map.entrySet()){
            if(e.getKey().equals(stack.getItem()))
                return givePower(e.getValue(),getRecipeResultCount(stack));
        }
        return getBaseStack();
    }

    public ItemStack[] getRecipeResult(IItemHandler handler){
        return getRecipeResult(handler,0);
    }

    public ItemStack[] getRecipeResult(IItemHandler handler,int index){
        return getRecipeResult(handler.getStackInSlot(index));
    }

    public int getRecipeResultCount(ItemStack stacks) {
        return stacks.getCount();
    }

    public static ItemStack[] givePower(ItemStack[] stacks,int count){
        for(ItemStack stack:stacks){
            stack.setCount(stack.getCount()*count);
        }
        return stacks;
    }

    public static class Recipes{
        public static ItemStack[] getDiamondOre_Re(){
            ItemStack[] stacks = getBaseStack();
            stacks[0]= new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE));
            stacks[2]= new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE));
            stacks[4]= new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE));
            stacks[6]= new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE));
            stacks[8]= new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE));
            stacks[1]= new ItemStack(Items.DIAMOND);
            stacks[3]= new ItemStack(Items.DIAMOND);
            stacks[5]= new ItemStack(Items.DIAMOND);
            stacks[7]= new ItemStack(Items.DIAMOND);
            return stacks;
        }
    }
}
