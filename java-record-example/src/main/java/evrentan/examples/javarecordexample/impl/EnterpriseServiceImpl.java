package evrentan.examples.javarecordexample.impl;

import evrentan.examples.javarecordexample.dto.EnterpriseLombok;
import evrentan.examples.javarecordexample.dto.EnterpriseRecord;
import evrentan.examples.javarecordexample.entity.EnterpriseEntity;
import evrentan.examples.javarecordexample.mapper.EnterpriseMapper;
import evrentan.examples.javarecordexample.repository.EnterpriseRepository;
import evrentan.examples.javarecordexample.service.IEnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements IEnterpriseService {

  private final EnterpriseRepository enterpriseRepository;
  private final EnterpriseMapper enterpriseMapper;

  public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository, EnterpriseMapper enterpriseMapper) {
    this.enterpriseRepository = enterpriseRepository;
    this.enterpriseMapper = enterpriseMapper;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public EnterpriseLombok createEnterprise(EnterpriseRecord enterpriseRecord) {
    return this.save(enterpriseRecord);
  }

  @Override
  @Transactional(propagation =  Propagation.REQUIRED)
  public List<EnterpriseLombok> getAllEnterprises() {
    return this.enterpriseMapper.toLombokDtoListFromEntityList(this.enterpriseRepository.findAll());
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public EnterpriseLombok getEnterpriseById(String id) {
    Optional<EnterpriseEntity> enterpriseEntity = this.enterpriseRepository.findById(id);

    return enterpriseEntity.map(this.enterpriseMapper::toLombokDtoFromEntity).orElse(null);
  }

  private EnterpriseLombok save(EnterpriseRecord enterpriseRecord) {
    EnterpriseLombok enterpriseLombok = this.enterpriseMapper.toLombokDtoFromRecord(enterpriseRecord);
    EnterpriseEntity enterpriseEntity = this.enterpriseMapper.toEntityFromLombokDto(enterpriseLombok);
    enterpriseEntity = this.enterpriseRepository.save(enterpriseEntity);
    return this.enterpriseMapper.toLombokDtoFromEntity(enterpriseEntity);
  }
}
