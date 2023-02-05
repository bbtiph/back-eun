package kz.dara.cameralcontrol.util;

import kz.dara.cameralcontrol.service.BirtReportService;
import org.apache.log4j.Logger;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author Aha
 */
public class Utils {
    private static final Logger log = Logger.getLogger(BirtReportService.class);

    public static String getOsPath(Boolean isDocker) {
        String userFolder = System.getProperty("user.dir") + File.separatorChar;
        if (!isDocker && "linux".equals(System.getProperty("os.name").toLowerCase()))
            userFolder = Paths.get(System.getProperty("java.class.path")).getParent().toString() + File.separatorChar;
        return userFolder;
    }
}
