//��T�t  F74009038 �U�ͤ�
//��URL��Ū�JJSON�榡����Ʀs�JJSON Array���A�ŧi�����ƶq��Strnig�MInteger Array�s�J�qJSON array��
//��JSON Object���X�Q�n����ơA�b��loop�h���String(�Y�OInteger�h�নString�h���)

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
													          URL oracle = new URL(url);
														          BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream(),"utf-8"));
															          JSONArray jsondata = new JSONArray(new JSONTokener(in));
																            // new the array
																	            townJSON = new String[jsondata.length()];
																		            roadJSON = new String[jsondata.length()];
																			            yearJSON = new Integer[jsondata.length()];
																				            priceJSON = new Integer[jsondata.length()];
																					              // assign value to array
																						              for(int i=0;i<jsondata.length();i++){
																							              	townJSON[i] = jsondata.getJSONObject(i).getString("�m����");
																									        	roadJSON[i] = jsondata.getJSONObject(i).getString("�g�a�Ϭq��m�Ϋت��Ϫ��P");
																											        	yearJSON[i] = jsondata.getJSONObject(i).getInt("����~��");
																													        	priceJSON[i] = jsondata.getJSONObject(i).getInt("�`����");
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
