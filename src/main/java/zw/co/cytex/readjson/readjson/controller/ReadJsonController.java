package zw.co.cytex.readjson.readjson.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.cytex.readjson.readjson.model.MessageA;
import zw.co.cytex.readjson.readjson.model.MessageR;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import zw.co.cytex.readjson.readjson.repository.MessageARepository;
import zw.co.cytex.readjson.readjson.repository.MessageRRepository;

import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class ReadJsonController {
    @Autowired
    MessageARepository messageARepository;
    @Autowired
    MessageRRepository messageRRepository;

    private void saveMessageA(MessageA messageA) throws IOException {
        JSONParser parser = new JSONParser();

        try {
            URL oracle = new URL("http://localhost:5001/api/instrument/"+messageA.getInstrumentID()); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if(Boolean.parseBoolean(parser.parse(inputLine).toString())){
                   // System.out.println( parser.parse(inputLine + messageA.toString()));
                    messageARepository.save(messageA);
                }


            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void saveMessageR(MessageR messageR){
        JSONParser parser = new JSONParser();

        try {
            URL oracle = new URL("http://localhost:5001/api/instrument/"+messageR.getInstrumentID()); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if(Boolean.parseBoolean(parser.parse(inputLine).toString())){
                  //  System.out.println( parser.parse(inputLine + messageR.toString()));
                    messageRRepository.save(messageR);
                }


            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping("/add")
     void add() {
        JSONParser parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(new FileReader("data.json"));

            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;

            //Reading the array
            JSONArray countries = (JSONArray)jsonObject.get("data");

            for(int i=0; i<countries.size(); i++)
            {
                JSONObject jsonObject1=(JSONObject) countries.get(i) ;

                String len=jsonObject1.get("Length").toString();
                if(len.equals("35")  ||len.equals("332") ){
                    if(jsonObject1.get("MessageType").toString().equals("A")){
                        MessageA messageA=new MessageA();
                        messageA.setLength(jsonObject1.get("Length").toString());
                        messageA.setMessageType(jsonObject1.get("MessageType").toString());
                        messageA.setNanosecond(jsonObject1.get("Nanosecond").toString());
                        messageA.setInstrumentID(jsonObject1.get("InstrumentID").toString());
                        messageA.setReserved1(jsonObject1.get("Reserved1").toString());
                        messageA.setReserved2(jsonObject1.get("Reserved2").toString());
                        messageA.setFlags(jsonObject1.get("Flags").toString());
                        messageA.setMessageTypeString(jsonObject1.get("MessageTypeString").toString());
                        messageA.setHeaderId(jsonObject1.get("HeaderId").toString());
                        messageA.setOrderID(jsonObject1.get("OrderID").toString());
                        messageA.setSide(jsonObject1.get("Side").toString());
                        messageA.setQuantity(jsonObject1.get("Quantity").toString());
                        messageA.setPrice(jsonObject1.get("Price").toString());

                        this.saveMessageA(messageA);

                     //   System.out.println(messageA.toString());

                    }
                    else if(jsonObject1.get("MessageType").toString().equals("R")){
                        MessageR messageR=new MessageR();
                        messageR.setLength(jsonObject1.get("Length").toString());
                        messageR.setMessageType(jsonObject1.get("MessageType").toString());
                        messageR.setNanosecond(jsonObject1.get("Nanosecond").toString());
                        messageR.setInstrumentID(jsonObject1.get("InstrumentID").toString());
                        messageR.setReserved1(jsonObject1.get("Reserved1").toString());
                        messageR.setReserved2(jsonObject1.get("Reserved2").toString());
                        messageR.setFlags(jsonObject1.get("Flags").toString());
                        messageR.setMessageTypeString(jsonObject1.get("MessageTypeString").toString());
                        messageR.setHeaderId(jsonObject1.get("HeaderId").toString());
                        messageR.setSymbolStatus(jsonObject1.get("SymbolStatus").toString());
                        messageR.setISIN(jsonObject1.get("ISIN").toString());
                        messageR.setSymbol(jsonObject1.get("Symbol").toString());
                        messageR.setTIDM(jsonObject1.get("TIDM").toString());
                        messageR.setSegment(jsonObject1.get("Segment").toString());
                        messageR.setPrevClosePrice(jsonObject1.get("PrevClosePrice").toString());
                        messageR.setExpirationDate(jsonObject1.get("ExpirationDate").toString());
                        messageR.setUnderlying(jsonObject1.get("Underlying").toString());
                        messageR.setStrikePrice(jsonObject1.get("StrikePrice").toString());
                        messageR.setOptionType(jsonObject1.get("OptionType").toString());
                        messageR.setIssuer(jsonObject1.get("Issuer").toString());
                        messageR.setIssueDate(jsonObject1.get("IssueDate").toString());
                        messageR.setCoupon(jsonObject1.get("Coupon").toString());
                        messageR.setSubBook(jsonObject1.get("SubBook").toString());
                        messageR.setCorporateAction(jsonObject1.get("CorporateAction").toString());

                       // System.out.println(messageR.toString());

                    }





                }

            }
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
