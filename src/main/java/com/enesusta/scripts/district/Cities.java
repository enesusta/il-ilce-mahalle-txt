package com.enesusta.scripts.district;

import com.enesusta.scripts.district.reader.Read;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Cities implements Read {

    private List<String> citiesList;



    @Override
    public void readResources() {

        citiesList = new ArrayList<>();
        String sql = "select * from harita.sehir"; // Ilgili SQL dosyasindaki isimlendirme budur.




    }
}
