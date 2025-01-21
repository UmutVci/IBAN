package com.umutavci;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void checkIban(String iban) throws FalscheIBANException {
       if(!iban.substring(0,2).toUpperCase().equals("DE") || iban.length() != 22){
           throw new FalscheIBANException("Thats not german IBAN");
       }
    }
    public static List<String> liesIbanAusDatei(String dataPath){
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath)))
        {
            String s;
        while((s = br.readLine()) != null){
            try {
                checkIban(s);
            }
            catch (FalscheIBANException e){
                list.add(s);
            }
        }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
    public static Map<String, List<String>> liesIbanAusDateien(List<String> dataPaths){
        Map<String, List<String>> map = new HashMap<>();
        for(String dataPath : dataPaths){
            map.put(dataPath, liesIbanAusDatei(dataPath));
        }
        return map;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}