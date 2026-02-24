package com.loansystem;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

import model.Client;
import model.Item;
import model.Rarity;
import service.ClienteService;
import service.ItemService;
import service.RarityService;

public class App 
{
    public static void main( String[] args )
    {

        ClienteService cs = new ClienteService();
        Client c = new Client(10, "Teste", "teste@gmail.com", 500);

        System.out.println(cs.save(c));



    }
}
