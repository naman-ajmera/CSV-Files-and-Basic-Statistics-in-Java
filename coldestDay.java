import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;
/**
 * Write a description of coldestDay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class coldestDay {
  public CSVRecord coldestHourInFile(CSVParser parser){
      CSVRecord coldestsofar = null;
      for(CSVRecord currentRow: parser){
          if(coldestsofar == null){coldestsofar = currentRow;}
          //String tempf = record.get("TemperatureF");
          else{
              double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
              double coldestTemp = Double.parseDouble(coldestsofar.get("TemperatureF"));
               if( currentTemp < coldestTemp){ coldestsofar = currentRow;}
                         
      
      
         }  }  
        return coldestsofar;
        }
  public void testcolldestinday(){
    FileResource fr = new FileResource();
    CSVRecord smallest =coldestHourInFile(fr.getCSVParser());
    System.out.println("Coldest Temperature was " + smallest.get("TemperatureF") + " at " 
       + smallest.get("TimeEDT"));
    }
  public CSVRecord fileWithColdestTemperature(){
      CSVRecord coldestsofar = null;
      
      DirectoryResource dr = new DirectoryResource();
     for ( File f : dr.selectedFiles()){
        FileResource fr = new FileResource(f);
        CSVRecord currentRow =coldestHourInFile(fr.getCSVParser());
         if (coldestsofar == null){
             coldestsofar = currentRow; }
         else{
             double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
             double coldestTemp = Double.parseDouble(coldestsofar.get("TemperatureF"));
             if(currentTemp == -9999){ currentTemp = coldestTemp;}   
             if( currentTemp < coldestTemp)
               { coldestsofar = currentRow;}
               
            // System.out.println("Coldest day was in file " + f.getName());
             //System.out.println("ALL the Temperature on the coldest day were:");
             
         }  
        }  
     
        return coldestsofar;   
    
    }
    public void testcoldestinmanydays(){
     CSVRecord smallest = fileWithColdestTemperature();
     System.out.println("coldest temp was " + smallest.get("TemperatureF") + " at " + smallest.get("DateUTC"));
    
    
   }
   public CSVRecord lowestHumidityInFile(CSVParser parser){
      CSVRecord lowesthumiditysofar = null;
      for(CSVRecord currentRow : parser){
          if(lowesthumiditysofar == null){ lowesthumiditysofar = currentRow;}
          else{
           if(!currentRow.get("Humidity").equals("N/A")){   
          double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
        
          double coldestTemp = Double.parseDouble(lowesthumiditysofar.get("Humidity"));
           
          if(currentTemp < coldestTemp){lowesthumiditysofar = currentRow;}



        }
      }   }
     return lowesthumiditysofar;}
    
 public void testlowestHumidityInFile(){
    FileResource fr = new FileResource();
    CSVRecord smallest =lowestHumidityInFile(fr.getCSVParser());
    System.out.println("Lowest Humidity was " + smallest.get("Humidity") + " at " 
        + smallest.get("DateUTC")); 
    }
  public CSVRecord filewithlowesthumidity(){
      CSVRecord lowesthumiditysofar = null;
    DirectoryResource dr = new DirectoryResource();
    for( File f : dr.selectedFiles()){
      FileResource fr = new FileResource(f);  
    CSVRecord currentRow =lowestHumidityInFile(fr.getCSVParser());
    if(lowesthumiditysofar == null){ lowesthumiditysofar = currentRow;}
          else{
          double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
          double coldestTemp = Double.parseDouble(lowesthumiditysofar.get("Humidity"));
           if(currentTemp < coldestTemp){lowesthumiditysofar = currentRow;}



        } }
        return lowesthumiditysofar;}
   public void humidityinFILES(){
       CSVRecord smallest = filewithlowesthumidity();
     System.out.println("coldest humidity was " + smallest.get("Humidity") + " at " + smallest.get("DateUTC"));
    
    
    
    
    }
    
    public double  averageTemperatureInFile(CSVParser parser){
        double count = 0; 
        double answer = 0;
        int numberOfReadings = 0;
       for(CSVRecord currentRow : parser){
        double avgtemp = Double.parseDouble(currentRow.get("TemperatureF"));
        count = avgtemp + count;
        numberOfReadings += 1;
      }
      answer = (count/numberOfReadings);
      return answer;
    }
   public void testaverageTemperaturesInFile(){
    FileResource fr = new FileResource();
    CSVParser AVGtemp = fr.getCSVParser();
    System.out.println("Average temperatures in file is " + //AVGtemp.get("TemperatureF"));
     averageTemperatureInFile(AVGtemp));
   }
  }
