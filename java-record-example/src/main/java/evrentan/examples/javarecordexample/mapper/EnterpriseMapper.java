package evrentan.examples.javarecordexample.mapper;

import evrentan.examples.javarecordexample.dto.EnterpriseLombok;
import evrentan.examples.javarecordexample.dto.EnterpriseRecord;
import evrentan.examples.javarecordexample.entity.EnterpriseEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface EnterpriseMapper {

  EnterpriseMapper INSTANCE = Mappers.getMapper(EnterpriseMapper.class);

  @Mappings({
      @Mapping(target = "id", ignore = true)
  })
  EnterpriseEntity toEntityFromLombokDto(EnterpriseLombok enterpriseLombok);

  EnterpriseLombok toLombokDtoFromEntity(EnterpriseEntity enterpriseEntity);

  EnterpriseLombok toLombokDtoFromRecord(EnterpriseRecord enterpriseRecord);

  List<EnterpriseEntity> toEntityListFromLombokDtoList(List<EnterpriseLombok> enterpriseLombokList);

  List<EnterpriseLombok> toLombokDtoListFromEntityList(List<EnterpriseEntity> enterpriseEntityList);

  List<EnterpriseLombok> toLombokDtoListFromRecordList(List<EnterpriseRecord> enterpriseRecordList);

  @AfterMapping
  default void setEntityId(EnterpriseLombok enterpriseLombok, @MappingTarget EnterpriseEntity enterpriseEntity) {
    if(Objects.nonNull(enterpriseLombok.getId()))
      enterpriseEntity.setId(enterpriseLombok.getId());
  }
}
