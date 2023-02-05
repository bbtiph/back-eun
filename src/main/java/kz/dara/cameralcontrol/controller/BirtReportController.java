package kz.dara.cameralcontrol.controller;

import kz.dara.cameralcontrol.model.dto.OutputType;
import kz.dara.cameralcontrol.model.dto.Report;
import kz.dara.cameralcontrol.service.BirtReportService;
import org.apache.log4j.Logger;
import org.eclipse.birt.report.engine.api.EngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class BirtReportController {
    private static final Logger log = Logger.getLogger(BirtReportController.class);

    @Autowired
    private BirtReportService reportService;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET, value = "/report")
    @ResponseBody
    public List<Report> listReports() {
        return reportService.getReports();
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET, value = "/report/reload")
    @ResponseBody
    public ResponseEntity reloadReports(HttpServletResponse response) {
        try {
            log.info("Reloading reports");
            reportService.loadReports();
        } catch (EngineException e) {
            log.error("There was an error reloading the reports in memory: ", e);
            return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/report/{name}")
    @ResponseBody
    public void generateFullReport(HttpServletResponse response, HttpServletRequest request,
                                   @PathVariable("name") String name,
                                   @RequestParam("id") Object id,
                                   @RequestParam("output") String output,
                                   @RequestParam("lang") String lang) {
        try {
            id = URLDecoder.decode((String) id, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        log.info("Generating full report: " + name + "; id: " + id + "; format: " + output + "; lang: " + lang);
        OutputType format = OutputType.from(output);
        reportService.generateMainReport(name, format, id, lang, response, request);
    }
}
