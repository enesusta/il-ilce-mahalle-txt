package com.enesusta.scripts.district;

import com.enesusta.scripts.district.database.Database;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Cities {


    public void readResources() {

        String sql = "SELECT * FROM harita.sehir inner join harita.ilce on harita.sehir.sehir_key = harita.ilce.ilce_sehirkey";
        String path = SharedConstans.relativePath.concat("city").concat(File.separator).concat("city.txt");


        try (Connection connection =
                 Database.getInstance().getConnection();
        ) {


            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {

                String filePath = SharedConstans.relativePath + "city/" +
                    rs.getString("sehir_title") + "/" + rs.getString("ilce_title") + ".txt";

                // FileCreator fileCreator = new FileCreator(filePath);
                //File temp = fileCreator.createFile();
                List<String> mahalleBilgisi = mahalleVerisiniGetir(Integer.parseInt(rs.getString("ilce_key")));

/**                try (PrintStream printStream =
 new PrintStream(new FileOutputStream(temp))) {

 for(String str : mahalleBilgisi)
 printStream.println(str);

 } catch (FileNotFoundException e) {
 e.printStackTrace();
 }
 */
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private List<String> mahalleVerisiniGetir(int ilceKey) {

        String sql = "select * from harita.mahalle where mahalle_ilcekey = ?";
        List<String> temp = new ArrayList<>();

        try (Connection connection =
                 Database.getInstance().getConnection()) {

            PreparedStatement prst = connection.prepareStatement(sql);
            prst.setInt(1, ilceKey);
            ResultSet rs = prst.executeQuery();

            while (rs.next())
                temp.add(rs.getString("mahalle_title"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temp;

    }


}
