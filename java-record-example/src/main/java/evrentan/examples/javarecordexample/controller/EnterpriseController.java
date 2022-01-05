package evrentan.examples.javarecordexample.controller;

import evrentan.examples.javarecordexample.dto.EnterpriseLombok;
import evrentan.examples.javarecordexample.dto.EnterpriseRecord;
import evrentan.examples.javarecordexample.service.IEnterpriseService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/enterprise", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class EnterpriseController {

  private final IEnterpriseService enterpriseService;

  public EnterpriseController(IEnterpriseService enterpriseService) {
    this.enterpriseService = enterpriseService;
  }

  @PostMapping
  public ResponseEntity<EnterpriseLombok> createEnterprise(@Valid @RequestBody EnterpriseRecord enterpriseRecord) {
    return ResponseEntity.ok(this.enterpriseService.createEnterprise(enterpriseRecord));
  }

  @GetMapping
  public ResponseEntity<List<EnterpriseLombok>> getAllEnterprises() {
    final List<EnterpriseLombok> enterpriseLombokList = this.enterpriseService.getAllEnterprises();

    if (CollectionUtils.isNotEmpty(enterpriseLombokList))
      return ResponseEntity.ok(enterpriseLombokList);

    return ResponseEntity.notFound().build();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<EnterpriseLombok> getEnterpriseById(@PathVariable final String id) {
    final EnterpriseLombok enterpriseLombok = this.enterpriseService.getEnterpriseById(id);

    if (Objects.nonNull(enterpriseLombok))
      return ResponseEntity.ok(enterpriseLombok);

    return ResponseEntity.notFound().build();
  }
}
