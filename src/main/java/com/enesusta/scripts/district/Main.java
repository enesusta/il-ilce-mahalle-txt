package com.enesusta.scripts.district;

import com.enesusta.scripts.district.file.FileCreator;

public class Main implements SharedConstans {

    public static void main(String ... args) {

        Cities cities = new Cities();
        cities.readResources();

    }
}
