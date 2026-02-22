package com.loansystem;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import service.ItemService;

public class App 
{
    public static void main( String[] args )
    {

        ItemService itemService = new ItemService();
        System.out.println(itemService.getItem(15));
        System.out.println(itemService.getAllItems());


    }
}
