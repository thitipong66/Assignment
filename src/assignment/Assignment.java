/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import DAO.DataItemDaoImpl;

import DTO.UserProfile;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thitipong
 */
public class Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String inFile = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String dataLine = null;
        String createDate = null;
        String runNumber = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyMMMdd");
        String dd = "";
        String MM = "";
        String yyyy = "";
        String ret = null;
        int number;
        try {
            // read file input
            if (args.length == 1) {
                inFile = args[0];
                try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
                    while ((dataLine = br.readLine()) != null) {
                        System.out.println("Input Data : " + dataLine);
                        // substring APPL-180120180005
                        createDate = dataLine.substring(5, 13); // 18012018 => yyyyMMdd
                        dd = createDate.substring(0, 2);
                        MM = createDate.substring(2, 4);
                        yyyy = createDate.substring(4, 8);
                        createDate = yyyy + "-" + MM + "-" + dd; // 2018-01-18
                        runNumber = dataLine.substring(13, 17); // 0005 > convert int
                        number = Integer.parseInt(runNumber);
                        System.out.println("Running number Data : " + number);
                        System.out.println("Create Date : " + createDate);
                        DataItemDaoImpl dataItemDaoImpl = new DataItemDaoImpl();
                        String applicationId = dataItemDaoImpl.getApplicationData(number, createDate);

                        // find UserProfile
                         String userId= null;
                        if (applicationId != null && applicationId != "") {
                           
                            userId = dataItemDaoImpl.getUserById(applicationId);
                        }
                        if (userId != null) {
                             ArrayList<UserProfile> userList = new ArrayList<UserProfile>();
                             userList = (ArrayList<UserProfile>) dataItemDaoImpl.getUserProfile(userId);
                            ret = sendPostRequest(String.valueOf(userList.get(0).getUser_id()), userList.get(0).getAddress1(), userList.get(0).getAddress2(), userList.get(0).getAddress3());
                        }

                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }

    private static String sendPostRequest(String id, String address1, String address2, String address3) {
        String jStr = null;
        BufferedReader rd;
        String line = null;
        String strResponse = null;
        try {
            String requestUrl = "service16.scb.co.th:9898";
            URL obj = new URL(requestUrl);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //add request header

            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json");
            // send Post request
            con.setDoOutput(true);
            jStr = "{\"name\":\"" + id + "\",\"address1\":\"" + address1 + "\",\"address2\":\"" + address2 + "\",\"address3\":\"" + address3 + "\"}";
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(jStr.getBytes());
            wr.flush();
            //wr.close();
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((con.getInputStream())));
            String output;
            System.out.println("Output from Server : \n");
            while ((output = responseBuffer.readLine()) != null) {
                System.out.println(output);
            }
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strResponse;
    }
}
