package com.enesusta.scripts.district.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

public class FileProviderImpl implements FileProvider {


    @Override
    public File provide(String path) throws IOException {

        File file = new File(path);
        file.getParentFile().mkdirs();
        file.createNewFile();

        return file;
    }
}
