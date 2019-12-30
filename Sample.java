package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Sample {
	
	public static void main(String[] args) {
		
//		------>			Task 1###########################
		   int i =0;		  
		   int k =0;
		   
		      ArrayList<String> dup_ids = new ArrayList<String>();
		      ArrayList<Integer> inloop = new ArrayList<Integer>();
		      
		      String prv_Ids = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50";
		      System.out.println("ID to Check :- "+prv_Ids);
		      StringTokenizer prv_Ids_st = new StringTokenizer(prv_Ids, ",");
		      String new_ids =	"51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100"; 
	    	  System.out.println("ID's bunch :- "+new_ids);
		      
		      while (prv_Ids_st.hasMoreTokens()) {
		    	  String token1 =	prv_Ids_st.nextToken();
		    	  i++;
		    	  StringTokenizer new_ids_st = new StringTokenizer(new_ids, ",");
		    	  int j = 0;
		    	  while (new_ids_st.hasMoreTokens()) {
		    		  j++;
		    		  String token2 =	new_ids_st.nextToken();
		    		  if(token1.equalsIgnoreCase(token2)) {
		    			  dup_ids.add(new_ids_st.nextToken()) ;
		    			  k++;
		    			  break;
		    		  }
			      }
		    	  inloop.add(j);
		      }
		      if(dup_ids.size()>0) {
		    	  System.err.println("--->dup_ids	=====----->	");
		    	  for(String dup_id:dup_ids) {
		    		  System.out.println(dup_id+",	");
		    	  }
		      }else
		    	  System.err.println("No match Found");
		      
//				------>			Task 2###########################
		      Bean src = new Bean();
		      src.setFullName("Mr. XYZ");
		      src.setBookingNumber("1545235");
		      src.setJourneyDate("07 Oct 2019");
		      src.setStartTime("14:45 Hrs");        
		      src.setFullPhoneNo("+91-45154815717");
		      src.setPhoneNo("+91-1543234812");
		      src.setEmail("xyz@abc.com");        
		      src.setServiceType("Luxurious Drives");
		      src.setRentalType("Point to Point Transfer");
		      src.setPickUpLocation("abc point, xyz city, mno country");
		      src.setDropLocation("abc point, xyz city, mno country");
		      src.setVehicleName("Economy Sedan or Toyota prius or Similar");
		      src.setPassengers("3");
		      src.setLuggage("3");
		      src.setPickUpSign("Hi! Mr. XYZ");
		      src.setMeetingPoint("Outside station :- abc point, xyz city, mno country");
		      genratePDF(src);
	}

    public static void genratePDF(Bean src) {
    	//   #######Maven Dependencies###########
    	/*
			<dependencies>
        		<dependency>
		             <groupId>com.itextpdf</groupId>
		             <artifactId>itextpdf</artifactId>
		             <version>5.5.13</version>
         		</dependency>
    		</dependencies>
    	 */    			
        try {
//	          Instantiation of Document Object............
                Document document = new Document();
//	          Name and addresspath of a PDF File............
                String PdfName = "PDF-"+src.getBookingNumber()+"-"+src.getFullName();
                File fileName = new File(PdfName);
//	          Font and Styling of a PDF File............
                Font font = new Font();
                font.setSize(15);
                Font firstfont = new Font(Font.FontFamily.TIMES_ROMAN,13,Font.BOLD);
                Font seconfont = new Font(Font.FontFamily.TIMES_ROMAN,13,Font.NORMAL); 
//	          Instantiation of PdfWriter Object............                
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(PdfName));
 //         Open Document for updation............ 
                document.open();        
 //         Paragraph Writing............                 
                Paragraph para1 = new Paragraph();
                para1.add(Chunk.NEWLINE);
                para1.add(new Chunk("Dear ",seconfont));
                para1.add(new Chunk(src.getFullName(),firstfont));
                para1.add(Chunk.NEWLINE);
                para1.add(Chunk.NEWLINE);
                document.add(para1);
	       
                Paragraph para2 = new Paragraph();
                para2.add(new Chunk("We are pleased to confirm the below mentioned reservation", seconfont));
                para2.add(Chunk.NEWLINE);
                para2.add(Chunk.NEWLINE);
                document.add(para2);
                
	       
                Paragraph para3 = new Paragraph();
                para3.add(new Chunk("Trip Details",firstfont));
                para3.add(Chunk.NEWLINE);
                document.add(para3);

//	      Table data instantiation....................        
                Phrase  booking_number = new Phrase();
                booking_number.add(new Chunk("Booking Number ",firstfont));
                
                Phrase  booking_numberDB = new Phrase();
                booking_numberDB.add(new Chunk(":   "+src.getBookingNumber(),seconfont));
                
                Phrase start_Date_Time = new Phrase();
                start_Date_Time.add(new Chunk("Start Date & Time ",firstfont));
                
                Phrase start_Date_TimeDB = new Phrase();
                start_Date_TimeDB.add(new Chunk(":   "+src.getJourneyDate()+" - "+src.getStartTime()+" Hrs",seconfont));

                Phrase Mobile_Number = new Phrase();
                Mobile_Number.add(new Chunk("Mobile Number ",firstfont));
                
                Phrase Mobile_NumberDB = new Phrase();
                Mobile_NumberDB.add(new Chunk(":   "+src.getFullPhoneNo(),seconfont));

                Phrase Email_ID = new Phrase();
                Email_ID.add(new Chunk("Email ID",firstfont));
                
                Phrase Email_IDDB = new Phrase();
                Email_IDDB.add(new Chunk(":   "+src.getEmail(),seconfont));

                Phrase Service_Type = new Phrase();
                Service_Type.add(new Chunk("Service Type ",firstfont));
                
                Phrase Service_TypeDB = new Phrase();
                Service_TypeDB.add(new Chunk(":   "+src.getServiceType(),seconfont));

                Phrase Rental_Type = new Phrase();
                Rental_Type.add(new Chunk("Rental Type ",firstfont));
                
                Phrase Rental_TypeDB = new Phrase();
                Rental_TypeDB.add(new Chunk(":   "+src.getRentalType(),seconfont));

                Phrase Pick_Up_Location = new Phrase();
                Pick_Up_Location.add(new Chunk("Pick Up Location",firstfont));
                
                Phrase Pick_Up_LocationDB = new Phrase();
                Pick_Up_LocationDB.add(new Chunk(":   "+src.getPickUpLocation(),seconfont));

                Phrase Drop_Off_Location = new Phrase();
                Drop_Off_Location.add(new Chunk("Drop Off Location ",firstfont));
                
                Phrase Drop_Off_LocationDB = new Phrase();
                Drop_Off_LocationDB.add(new Chunk(":   "+src.getDropLocation(),seconfont));

                Phrase Car = new Phrase();
                Car.add(new Chunk("Car ",firstfont));
                
                Phrase CarDB = new Phrase();
                CarDB.add(new Chunk(":   "+src.getVehicleName(),seconfont));

                Phrase Passenger_Luggage = new Phrase();
                Passenger_Luggage.add(new Chunk("Passenger // Luggage ",firstfont));
                
                Phrase Passenger_LuggageDB = new Phrase();
                Passenger_LuggageDB.add(new Chunk(":   "+src.getPassengers()+" & "+src.getLuggage(),seconfont));

                Phrase Pick_up_sign = new Phrase();
                Pick_up_sign.add(new Chunk("Pick-up sign ",firstfont));
                
                Phrase Pick_up_signDB = new Phrase();
                Pick_up_signDB.add(new Chunk(":   "+src.getPickUpSign(),seconfont));
                
                Phrase Meeting_Point = new Phrase();
                Meeting_Point.add(new Chunk("Meeting Point ",firstfont));
                
                Phrase Meeting_PointDB = new Phrase();
                Meeting_PointDB.add(new Chunk(":   "+src.getMeetingPoint(),seconfont));
                
//	      Table formation...............
                PdfPTable table = new PdfPTable(10);
                table.setTotalWidth(document.getPageSize().getWidth()-70);
                table.setLockedWidth(true);
                
                PdfPCell booking_numberCell= new PdfPCell(booking_number);
                booking_numberCell.setBorder(Rectangle.NO_BORDER);
                booking_numberCell.setColspan(3);
                table.addCell(booking_numberCell);
                
                PdfPCell booking_numberDBCell= new PdfPCell(booking_numberDB);
                booking_numberDBCell.setBorder(Rectangle.NO_BORDER);
                booking_numberDBCell.setColspan(7);
                table.addCell(booking_numberDBCell);
                
                
                PdfPCell start_Date_TimeCell= new PdfPCell(start_Date_Time);
                start_Date_TimeCell.setBorder(Rectangle.NO_BORDER);
                start_Date_TimeCell.setColspan(3);
                table.addCell(start_Date_TimeCell);
                
                PdfPCell start_Date_TimeDBCell= new PdfPCell(start_Date_TimeDB);
                start_Date_TimeDBCell.setBorder(Rectangle.NO_BORDER);
                start_Date_TimeDBCell.setColspan(7);
                table.addCell(start_Date_TimeDBCell);                
                
                PdfPCell Mobile_NumberCell= new PdfPCell(Mobile_Number);
                Mobile_NumberCell.setBorder(Rectangle.NO_BORDER);
                Mobile_NumberCell.setColspan(3);
                table.addCell(Mobile_NumberCell);
                
                PdfPCell Mobile_NumberDBCell= new PdfPCell(Mobile_NumberDB);
                Mobile_NumberDBCell.setBorder(Rectangle.NO_BORDER);
                Mobile_NumberDBCell.setColspan(7);
                table.addCell(Mobile_NumberDBCell);                
                
                PdfPCell Email_IDCell= new PdfPCell(Email_ID);
                Email_IDCell.setBorder(Rectangle.NO_BORDER);
                Email_IDCell.setColspan(3);
                table.addCell(Email_IDCell);

                PdfPCell Email_IDDBCell= new PdfPCell(Email_IDDB);
                Email_IDDBCell.setBorder(Rectangle.NO_BORDER);
                Email_IDDBCell.setColspan(7);
                table.addCell(Email_IDDBCell);                
                
                PdfPCell Service_TypeCell= new PdfPCell(Service_Type);
                Service_TypeCell.setBorder(Rectangle.NO_BORDER);
                Service_TypeCell.setColspan(3);
                table.addCell(Service_TypeCell);

                PdfPCell Service_TypeDBCell= new PdfPCell(Service_TypeDB);
                Service_TypeDBCell.setBorder(Rectangle.NO_BORDER);
                Service_TypeDBCell.setColspan(7);
                table.addCell(Service_TypeDBCell);                
                
                PdfPCell Rental_TypeCell= new PdfPCell(Rental_Type);
                Rental_TypeCell.setBorder(Rectangle.NO_BORDER);
                Rental_TypeCell.setColspan(3);
                table.addCell(Rental_TypeCell);
                
                PdfPCell Rental_TypeDBCell= new PdfPCell(Rental_TypeDB);
                Rental_TypeDBCell.setBorder(Rectangle.NO_BORDER);
                Rental_TypeDBCell.setColspan(7);
                table.addCell(Rental_TypeDBCell);
                
                PdfPCell Pick_Up_LocationCell= new PdfPCell(Pick_Up_Location);
                Pick_Up_LocationCell.setBorder(Rectangle.NO_BORDER);
                Pick_Up_LocationCell.setColspan(3);
                table.addCell(Pick_Up_LocationCell);
                
                PdfPCell Pick_Up_LocationDBCell= new PdfPCell(Pick_Up_LocationDB);
                Pick_Up_LocationDBCell.setBorder(Rectangle.NO_BORDER);
                Pick_Up_LocationDBCell.setColspan(7);
                table.addCell(Pick_Up_LocationDBCell);                
                
                PdfPCell Drop_Off_LocationCell= new PdfPCell(Drop_Off_Location);
                Drop_Off_LocationCell.setBorder(Rectangle.NO_BORDER);
                Drop_Off_LocationCell.setColspan(3);
                table.addCell(Drop_Off_LocationCell);
                
                PdfPCell Drop_Off_LocationDBCell= new PdfPCell(Drop_Off_LocationDB);
                Drop_Off_LocationDBCell.setBorder(Rectangle.NO_BORDER);
                Drop_Off_LocationDBCell.setColspan(7);
                table.addCell(Drop_Off_LocationDBCell);
                
                PdfPCell CarCell= new PdfPCell(Car);
                CarCell.setBorder(Rectangle.NO_BORDER);
                CarCell.setColspan(3);
                table.addCell(CarCell);
                
                PdfPCell CarDBCell= new PdfPCell(CarDB);
                CarDBCell.setBorder(Rectangle.NO_BORDER);
                CarDBCell.setColspan(7);
                table.addCell(CarDBCell);                
                
                PdfPCell Passenger_LuggageCell= new PdfPCell(Passenger_Luggage);
                Passenger_LuggageCell.setBorder(Rectangle.NO_BORDER);
                Passenger_LuggageCell.setColspan(3);
                table.addCell(Passenger_LuggageCell);
                
                PdfPCell Passenger_LuggageDBCell= new PdfPCell(Passenger_LuggageDB);
                Passenger_LuggageDBCell.setBorder(Rectangle.NO_BORDER);
                Passenger_LuggageDBCell.setColspan(7);
                table.addCell(Passenger_LuggageDBCell);

                PdfPCell Pick_up_signCell= new PdfPCell(Pick_up_sign);
                Pick_up_signCell.setBorder(Rectangle.NO_BORDER);
                Pick_up_signCell.setColspan(3);
                table.addCell(Pick_up_signCell);
                
                
                PdfPCell Pick_up_signDBCell= new PdfPCell(Pick_up_signDB);
                Pick_up_signDBCell.setBorder(Rectangle.NO_BORDER);
                Pick_up_signDBCell.setColspan(7);
                table.addCell(Pick_up_signDBCell);
                
                PdfPCell Meeting_PointCell= new PdfPCell(Meeting_Point);
                Meeting_PointCell.setBorder(Rectangle.NO_BORDER);
                Meeting_PointCell.setColspan(3);
                table.addCell(Meeting_PointCell);
                
                PdfPCell Meeting_PointDBCell= new PdfPCell(Meeting_PointDB);
                Meeting_PointDBCell.setBorder(Rectangle.NO_BORDER);
                Meeting_PointDBCell.setColspan(7);
                table.addCell(Meeting_PointDBCell);  

//	      add table to document and close document and writer...................
                document.add(table);
                              
                PdfPTable table_2 = new PdfPTable(20);   
                table_2.setTotalWidth(document.getPageSize().getWidth()-50);
                table_2.setLockedWidth(true);
             
                
                Phrase para4 = new Phrase();
                para4.add(new Chunk("Good to know for your trip",firstfont));

                PdfPCell para4Cell = new PdfPCell(para4);
                para4Cell.setBorder(Rectangle.NO_BORDER);
                para4Cell.setColspan(17);
                para4Cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
                para4Cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
                para4Cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
                para4Cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
                table_2.addCell(para4Cell);
                
                document.add(table_2);
                document.add(Chunk.NEWLINE);
                
 //         List Writing (For bullets and the statement)............                 
                Chunk bullet = new Chunk("\u2022", font);
                        
				List list = new List(List.UNORDERED);
				list.setListSymbol(bullet);  
                
                Phrase para5 = new Phrase();
                para5.add(new Chunk("Including waiting time of 45 Minutes.",seconfont));
                para5.add(Chunk.NEWLINE);
                list.add(new ListItem(para5));               

                Phrase para6 = new Phrase();
                para6.add(new Chunk("Details will be shared 1 hour prior to the pickup time.",seconfont));
                para6.add(Chunk.NEWLINE);
                list.add(new ListItem(para6));
                                
                Phrase para7 = new Phrase();
                para7.add(new Chunk("Please make sure that your mobile phone is charged and turned on before and ",firstfont));
                para7.add(new Chunk("during the pickup.",firstfont));
                para7.add(Chunk.NEWLINE);
                list.add(new ListItem(para7));          
                                
                Phrase para8 = new Phrase();
                para8.add(new Chunk("If you can't find your driver at the pickup location, please call the driver directly ",seconfont));
                para8.add(new Chunk("on the number provided in the SMS and Email with driver and vehicle details. In case you ",seconfont));
                para8.add(new Chunk("cannot reach the driver, please call 24*7 Support | +91-155-548585158",seconfont));
                                
                list.add(new ListItem(para8));
                
                document.add(list);                 
                                       
//	      Close document and writer..................
                document.close();
                writer.close();
                
        } catch (DocumentException dex) {
                dex.printStackTrace();
        } catch (FileNotFoundException fnf){
                fnf.printStackTrace();
        } catch (Exception e){
                e.printStackTrace();
        }
    }

//	------>			Task 3###########################    
    private static LocalDateTime dateToLocalDateTime(Date date) {
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}

	private static Long localDateTimeToDate(LocalDateTime localDateTime) {
		Date dt = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		return dt.getTime() / 1000;
	}
	public static Long atStartOfDay(LocalDateTime localDateTime) {
		// LocalDateTime localDateTime = dateToLocalDateTime(date);
		LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
		return localDateTimeToDate(startOfDay);
	}

	public static Long atEndOfDay(LocalDateTime localDateTime) {
		// LocalDateTime localDateTime = dateToLocalDateTime(date);
		LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
		return localDateTimeToDate(endOfDay);
	}
}