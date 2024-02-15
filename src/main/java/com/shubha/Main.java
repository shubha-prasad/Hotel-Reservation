package com.shubha;

import com.shubha.hotel.controller.HotelController;
import com.shubha.hotel.entity.Hotels;

import java.text.ParseException;
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

    public static void main(String[] args) throws ParseException {
       boolean flag = true;
       while(flag)
       {
           System.out.println("Enter choice");
           System.out.println("---------------------");
           System.out.println("1: Add Hotel\n2: Display hotels\n3: Cheapest Hotel\n4 : Update Rate"
                   + "\n5: find cheapest hotel for date range\n6: Update ratings\n13: Exit");
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
               case 3 :
               {
                   h.findCheapestHotel(hotel);
                   break;
               }
               case 4 :
               {
                   h.updateHotelRates(hotel);
                   break;
               }
               case 5 :
               {
                   h.addratings(hotel);
                   break;
               }
               case 6 :
               {
                   h.findCheapestHotelForDateRange(hotel);
                   break;
               }
               case 7:{
                   h.findCheapestBestRatedHotelForDateRange(hotel);
                   break;
               }
               case 8:{
                   h.findBestRatedHotel(hotel);
                   break;
               }
               case 9:{
                   h.addSpecialRates(hotel);
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