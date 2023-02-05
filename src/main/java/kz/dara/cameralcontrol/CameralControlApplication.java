package kz.dara.cameralcontrol;

import kz.dara.cameralcontrol.util.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CameralControlApplication implements WebMvcConfigurer {

    private static final Logger log = Logger.getLogger(CameralControlApplication.class);
    @Value("${reports.relative.path}")
    private String reportsPath;
    @Value("${images.relative.path}")
    private String imagesPath;

    public static void main(String[] args) {
        SpringApplication.run(CameralControlApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String pathFile = "file:///" + Utils.getOsPath(true) + reportsPath + imagesPath;
        registry
                .addResourceHandler(reportsPath + imagesPath + "/**")
                .addResourceLocations(pathFile);
        log.info(pathFile);
    }



}
