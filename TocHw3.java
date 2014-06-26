//資訊系  F74009038 顧凱云
//由URL中讀入JSON格式的資料存入JSON Array中，宣告對應數量的Strnig和Integer Array存入從JSON array中
//的JSON Object取出想要的資料，在用loop去比對String(若是Integer則轉成String去比對)

import java.net.*;
import java.io.*;
import org.json.*;

public class TocHw3 {

    public static void main(String[] args) throws Exception {
    	  // declare the variables 
    	String url = args[0];  
    	String town = args[1];
    	String road = args[2];
    	Integer year = Integer.parseInt(args[3]);
    	String[] townJSON;  // for JSON data
    	String[] roadJSON;
    	Integer[] yearJSON;
    	Integer[] priceJSON;
    	Integer totalPrice = 0;
    	Integer matchNum = 0;
    	  // handle url and get data of JSON type
        URL urlStr = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(urlStr.openStream(),"utf-8"));
        JSONArray jsondata = new JSONArray(new JSONTokener(in));
          // new the array
        townJSON = new String[jsondata.length()];
        roadJSON = new String[jsondata.length()];
        yearJSON = new Integer[jsondata.length()];
        priceJSON = new Integer[jsondata.length()];
          // assign value to array
        for(int i=0;i<jsondata.length();i++){
        	townJSON[i] = jsondata.getJSONObject(i).getString("鄉鎮市區");
        	roadJSON[i] = jsondata.getJSONObject(i).getString("土地區段位置或建物區門牌");
        	yearJSON[i] = jsondata.getJSONObject(i).getInt("交易年月");
        	priceJSON[i] = jsondata.getJSONObject(i).getInt("總價元");
        }
          // compare the data
        for(int j=0;j<jsondata.length();j++){
        	if(townJSON[j].contains(town) && roadJSON[j].contains(road) && yearJSON[j].toString().substring(0,3).equals(year.toString())){
        		System.out.println(townJSON[j]+"    "+roadJSON[j]+"    "+yearJSON[j]+"    "+priceJSON[j]);
        	    totalPrice += priceJSON[j];
        	    matchNum++;
        	}	
        }
        
        System.out.println(totalPrice/matchNum);
        
        in.close();
    }
}
