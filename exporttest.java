import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of exporttest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exporttest {
   public String countryInfo(CSVParser parser, String country){
    
        for (CSVRecord record : parser){
        String export = record.get("Country");
        if(export.contains(country)){
        System.out.print(record.get("Country" )+ ": ");
        System.out.print(record.get("Exports") + ": ");
        System.out.println(record.get("Value (dollars)"));}
    }   
    
   return "NOT FOUND"; }
   public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2){
     for(CSVRecord record : parser){  
      String export = record.get("Exports");
       if( export.contains(exportitem1) && export.contains(exportitem2) ){
          System.out.println(record.get("Country"));}
        }
        
        }
   public int numberofExporters(CSVParser parser, String exportItem){
        int count =  0;
       for(CSVRecord record : parser){
        
       String export = record.get("Exports");
        if ( export.contains(exportItem)){
          count = count + 1;}
       
       }
       
            return count ;}
   public void bigExports(CSVParser parser, String amount){
     for(CSVRecord record : parser){
         String value = record.get("Value (dollars)");
         if( value.length() > amount.length()){
             System.out.print(record.get("Country") + " ");
             System.out.println(record.get("Value (dollars)"));
       
       
       
       
    }}}
            
   public void  tester(){
   FileResource fr = new FileResource();
   CSVParser parser = fr.getCSVParser();
   countryInfo(parser,"Nauru");
   //listExportersTwoProducts(parser,"gold","diamonds");
   }
   public void tester1(){
    FileResource fr = new FileResource();
   CSVParser parser = fr.getCSVParser();
   listExportersTwoProducts(parser,"cotton","flowers");

   }
     public void  tester2(){
     FileResource fr = new FileResource();
   CSVParser parser = fr.getCSVParser();
    int number = numberofExporters(parser,"cocoa");
    System.out.println(number);
   }
    public void tester3(){
   FileResource fr = new FileResource();
   CSVParser parser = fr.getCSVParser();
   bigExports(parser,"$999,999,999,999");


   }}
