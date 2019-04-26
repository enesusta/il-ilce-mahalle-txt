package com.enesusta.scripts.district.file;

import java.io.FileNotFoundException;

public class NoFileException extends FileNotFoundException {

    public NoFileException() {
        super();
    }
    public NoFileException(String str) {
        super(str);
    }

}
