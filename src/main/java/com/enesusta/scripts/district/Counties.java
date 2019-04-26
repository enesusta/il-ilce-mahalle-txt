package com.enesusta.scripts.district;

/*
 * @author : Enes Usta
 * @date : 26 04 2019
 */

import com.enesusta.scripts.district.jdbc.Database;
import com.enesusta.scripts.district.model.County;
import com.enesusta.scripts.district.reader.Read;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Counties implements Read {

    private Database database = Database.getInstance();
    private Map<Integer, County> countyMap = new HashMap<>();

    @Override
    public void readResources() {

        String sql = "select * from harita.ilce";


    }

    public List<String> getCounties(byte cityID) {

        List<String> temp = new ArrayList<>();
        String sql = "select * from harita.ilce where ilce_sehirkey = ?";

        try(Connection connection = database.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setByte(1,cityID);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                temp.add(resultSet.getString("ilce_title"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
