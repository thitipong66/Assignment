/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thitipong
 */
public class DataItemDaoImpl {

    public String getUserById(String id) {
        String userId = "";
        JDBCConncetion connectionDb = new JDBCConncetion();
        Connection conn = connectionDb.getConnection();
        String sqlquery = "SELECT A.USER_ID FROM application_form_type_a  A \n"
                + "LEFT JOIN application_form_type_b B ON A.application_id = B.application_id "
                + "LEFT JOIN application_form_type_c C ON B.application_id = C.application_id \n"
                + "WHERE A.application_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlquery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userId = String.valueOf( rs.getInt("user_id"));
                System.out.println("UserId : "+ userId);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
        return userId;
    }

    public String getApplicationData(int runNumber, String createDate) {
        String applicationId = "";
        //ResultSet rs = null;
        JDBCConncetion connectionDb = new JDBCConncetion();
        Connection conn = connectionDb.getConnection();
        String sqlquery = "SELECT application_id FROM application_data where running_number=? "
                + " And created_date = ?";
        //String sqlquery = "SELECT application_id FROM application_data where running_number=? "
        //      + " And SUBSTRING(created_date,0,10) = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlquery);
            ps.setInt(1, runNumber);
            ps.setString(2, createDate);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    applicationId = rs.getString("application_id");
                    System.out.println("application_id :" + applicationId);
                }
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
            System.out.println(e.getMessage());
        }
        return applicationId;
    }
    
    public List getUserProfile(String id){
        List userData = new ArrayList();
        JDBCConncetion connectionDb = new JDBCConncetion();
        Connection conn = connectionDb.getConnection();
        String sqlquery = "SELECT * FROM user_profile  \n"
                + "WHERE user_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlquery);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserProfile item = new UserProfile();
                item.setUser_id(rs.getInt("user_id"));
                item.setName(rs.getString("name"));
                item.setAddress1(rs.getString("address1"));
                item.setAddress2(rs.getString("address2"));
                item.setAddress3(rs.getString("address3"));
                userData.add(item);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
        return userData;
    }
}
