package com.loansystem;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

import model.Item;
import model.Rarity;
import service.ItemService;
import service.RarityService;

public class App 
{
    public static void main( String[] args )
    {

        ItemService itemService = new ItemService();
        RarityService rarityService = new RarityService();
        System.out.println(itemService.itemIsAvailable(2));
        Rarity r = rarityService.getById(3);
        Item i = new Item("testesda", true, r);



    }
}
