package com.enesusta.scripts.district.file;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileCreator {

    private String filePath;
    private File temporaryFile;

    public FileCreator(final String filePath) {
        this.filePath = filePath;
    }

    public File createFile() {

        File file = new File(filePath);

        try {
                file.getParentFile().mkdirs();
                file.createNewFile();

        }catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}
