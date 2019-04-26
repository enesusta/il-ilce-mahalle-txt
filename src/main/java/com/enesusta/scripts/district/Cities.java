package com.enesusta.scripts.district;

import com.enesusta.scripts.district.file.FileCreator;
import com.enesusta.scripts.district.jdbc.Database;
import com.enesusta.scripts.district.reader.Initialize;
import com.enesusta.scripts.district.reader.Read;
import lombok.Getter;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cities implements Read, Initialize {

    @Getter private Map<Integer, String> citiesMap;
    private Database database = Database.getInstance();

    public Cities() {
        init();
    }

    @Override
    public void init() {
        citiesMap = new HashMap<>();
    }


    @Override
    public void readResources() {

        String sql = "select * from harita.sehir"; // Ilgili SQL dosyasindaki isimlendirme budur.
        FileCreator fileCreator = new FileCreator(SharedConstans.relativePath+ "city" + File.separator+"city.txt");
        Connection connection = null;

        File createdFile = fileCreator.createFile();

        try (PrintStream printStream
                 = new PrintStream(new FileOutputStream(createdFile))
        ) {

            connection = database.getConnection();
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet resultSet = prst.executeQuery();

            while (resultSet.next()) {
                printStream.println
                    (resultSet.getString("sehir_title")+"#"+
                        resultSet.getString("sehir_key"));
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void initMap() {


        try(InputStream inputStream
                = new FileInputStream
                    (new File(SharedConstans.relativePath+ "city/cities.txt"))
        ) {

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter(System.lineSeparator());

            while (scanner.hasNext()) {

                String str = scanner.next();
                String[] arr = str.split("#");

                for(String x : arr) {
                    System.out.println(x + "\n");
                }

                Integer cityKey = Integer.parseInt(arr[1]);
                citiesMap.put(cityKey,arr[0]);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }

    }








}
