package com.bun133.reversecraft.item;

import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static List<Item> items=new ArrayList<>();
    private Items(){
        addAll();
    }

    public static void addAll(){
        add(

        );
    }

    @SuppressWarnings({"ManualArrayToCollectionCopy", "UseBulkOperation"})
    public static void add(Item... item){
        for(Item i:item){
            items.add(i);
        }
    }
}
