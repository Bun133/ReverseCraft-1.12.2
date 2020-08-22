package com.bun133.reversecraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Blocks {
    public static List<Block> blocks=new ArrayList<Block>();
    public static List<Item> items=new ArrayList<Item>();
    private Blocks(){
        addAll();
    }

    private void addAll(){
        add(
        );
    }

    public static void add(BlockBase... block){
        for(BlockBase b:block){
            add(b);
        }
    }

    public static void add(BlockBase block){
        blocks.add(block);
    }
}
