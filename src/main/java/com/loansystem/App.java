package com.loansystem;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {

        try (Connection conn = ConnectionFactory.getConnection();){
            System.out.println("deu boa");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
}
