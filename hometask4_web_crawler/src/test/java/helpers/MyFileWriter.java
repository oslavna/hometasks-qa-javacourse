package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyFileWriter {
    public static final Logger logger = LogManager.getLogger(MyFileWriter.class);
    protected java.io.FileWriter writer;
    protected File file;

    public void createFile() {
        SimpleDateFormat formatSimple = new SimpleDateFormat("dd_MM.hh.mm.ss");
        file = new File(String.format("hometask4_web_crawler/logs/all_audio_books_%s.csv", formatSimple.format(new Date())));
        logger.info("File " + file.getName() +" created");
    }

    public void writeNewLine (ArrayList<String> array) throws IOException {
        writer = new java.io.FileWriter(file, true);
            for (String s : array) {
                writer.write(s + "\n");

            }
                writer.close();

    }
}
