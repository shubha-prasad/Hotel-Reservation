package com.shubha.hotel.controller;

import com.shubha.hotel.entity.Hotels;
import com.shubha.hotel.enums.Customer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelController {

    static Hotels hotels = new Hotels();
    static Scanner s = new Scanner(System.in);
    public Map<String, Hotels> addHotel(Map<String, Hotels> map){
        System.out.println("Enter Hotel Name");
        String hotelName=s.next();
        hotels.setName(hotelName);
        System.out.println("Enter Rating");
        hotels.setRating(s.nextInt());
        System.out.println("Enter Week Day Rate");
        hotels.setWeekDayRate(s.nextInt());
        System.out.println("Enter week end reward rate");
        hotels.setWeekEndRate(s.nextInt());
        System.out.println("Enter Week day reward price");
        hotels.setWeekDayReward(s.nextInt());
        System.out.println("Enter Weekend reward price");
        hotels.setWeekEndReward(s.nextInt());
        map.put(hotelName,hotels);
        return map;
    }

    public void display(Map<String, Hotels> map) {
        Set<String> keys=map.keySet();
        for(String key:keys){
            Hotels hotel=map.get(key);
            System.out.println(hotel);
            System.out.println("--------------------------------------");
        }
    }

    public void findCheapestHotel(Map<String, Hotels> hotel) {
        int minCost = Integer.MAX_VALUE;
        String cheapestHotel = "";
        int maxRating = Integer.MIN_VALUE;
        List<String> date=new ArrayList<>();
        String customerType;
        System.out.println("Enter the Customer Type :\n1: Regular\n2: Reward");
        int type=s.nextInt();
        if (type==1){
            customerType=String.valueOf(Customer.REGULAR);
        }
        else{
            customerType=String.valueOf(Customer.REWARD);
        }
        System.out.println("Enter how many days you need hotel");
        int days=s.nextInt();
        System.out.println("Enter "+days+" dates that u need");
        for (int i = 1; i <=days ; i++) {
            System.out.println("DATE FORMAT => DD/MON/YYYY/DAY(SAT)");
            String dateFormat=s.next();
            date.add(dateFormat);
        }
        for (Hotels h: hotel.values()){
            int total=0;
            for (String d:date){
                d.toUpperCase();
                if(d.contains("SAT") || d.contains("SUN")){
                    total+=customerType.equalsIgnoreCase("REWARD")?h.getWeekEndReward():h.getWeekDayRate();
                }
                else{
                    total+=customerType.equalsIgnoreCase("REWARD")?h.getWeekDayReward():h.getWeekDayRate();
                }
            }
            if (total < minCost || (total == minCost && h.getRating() > maxRating)) {
                minCost = total;
                cheapestHotel = h.getName();
                maxRating = h.getRating();
            }
        }
        System.out.println("Cheapest Hotel: "+cheapestHotel);
        System.out.println("--------------------------------------");
    }
}



