package com.enesusta.scripts.district.file;

import java.io.File;
import java.io.IOException;

public interface FileProvider {
    File provide(String path) throws IOException;
}
