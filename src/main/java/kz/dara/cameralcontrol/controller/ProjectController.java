//package kz.dara.cameralcontrol.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import kz.dara.cameralcontrol.model.Project;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.ServletException;
//import javax.validation.Valid;
//import java.io.IOException;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value = "/api/project", produces = APPLICATION_JSON_VALUE)
//@Tag(name = "Project", description = "Project management resource")
//public class ProjectController {
//    @GetMapping()
//    public ResponseEntity<Project> getAll() {
//
//        return null;
//    }
//
//    @PostMapping()
//    public ResponseEntity<Project> save(@RequestBody Project project) {
//        return null;
//    }
//
//
//}
