package com.enesusta.scripts.district.reader;

import com.enesusta.scripts.district.jdbc.Database;

import java.util.ArrayList;
import java.util.List;

public class Reader implements Read,Initialize {

    private List<String> citiesList;
    private Database database = Database.getInstance();

    public Reader() {

    }



    @Override
    public void readResources() {

    }


    @Override
    public void init() {
        citiesList = new ArrayList<>();
    }
}
