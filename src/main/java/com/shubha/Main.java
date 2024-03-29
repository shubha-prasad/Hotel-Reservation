package com.shubha;

import com.shubha.hotel.entity.HotelController;
import com.shubha.hotel.entity.Hotels;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Map<String, Hotels> hotel = new HashMap<>();
    static Scanner s = new Scanner(System.in);

    static HotelController h = new HotelController();

    static {
        hotel.put("Lakewood", new Hotels("Lakewood",3, 110, 90, 80, 80));
        hotel.put("Bridgewood", new Hotels("Bridgewood", 4, 160, 60, 110, 50));
        hotel.put("Ridgewood", new Hotels("Ridgewood", 5, 220, 150, 100, 40));
    }

    public static void main(String[] args) {
       boolean flag = true;
       while(flag)
       {
           System.out.println("Enter choice");
           System.out.println("---------------------");
           System.out.println("1: Add Hotel\n2: Display hotels\n13: Exit");
           System.out.println("-------------------------");
           int choice = s.nextInt();
           switch(choice){
               case 1 :
               {
                   hotel = h.addHotel(hotel);
                   break;
               }
               case 2 :
               {
                   h.display(hotel);
                   break;
               }
               case 13 :
               {
                   flag=false;
                   break;
               }
           }
        }
    }
}