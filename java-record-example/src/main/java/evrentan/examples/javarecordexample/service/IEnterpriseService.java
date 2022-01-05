package evrentan.examples.javarecordexample.service;

import evrentan.examples.javarecordexample.dto.EnterpriseLombok;
import evrentan.examples.javarecordexample.dto.EnterpriseRecord;

import java.util.List;

public interface IEnterpriseService {

  /**
   * create a customer instance in the database
   *
   * @param enterpriseRecord enterprise to be created
   * @return EnterpriseRecord
   */
  EnterpriseLombok createEnterprise(EnterpriseRecord enterpriseRecord);

  /**
   * return all enterprise instances in the database
   *
   * @return List<EnterpriseRecord>
   */
  List<EnterpriseLombok> getAllEnterprises();

  /**
   * return an enterprise instance by using its id in the database
   *
   * @param id enterprise id to be filtered
   * @return EnterpriseRecord
   */
  EnterpriseLombok getEnterpriseById(String id);
}
