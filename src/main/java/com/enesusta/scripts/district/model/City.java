package com.enesusta.scripts.district.model;

import lombok.Data;

import java.util.List;

@Data
public class City {

    private String cityTitle;
    private byte cityID;
    private List<String> list;

    @Override
    public String toString() {
        return cityTitle;
    }


}
