package kz.dara.cameralcontrol.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.dara.cameralcontrol.model.Organization;
import kz.dara.cameralcontrol.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Organization", description = "Organization management resource")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping
    public Organization createOrganization(@RequestBody Organization Organization) {
        return organizationService.createOrganization(Organization);
    }

    @GetMapping("/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        return organizationService.getOrganization(id);
    }

    @GetMapping
    public Page<Organization> getAllOrganizations(Pageable pageable) {
        return organizationService.getAllOrganizations(pageable);
    }

    @PutMapping
    public Organization updateOrganization(@RequestBody Organization Organization) {
        return organizationService.updateOrganization(Organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteOrganization(id);
    }


}
