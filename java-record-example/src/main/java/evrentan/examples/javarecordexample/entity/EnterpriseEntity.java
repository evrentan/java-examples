package evrentan.examples.javarecordexample.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Document(collection = "enterprise")
public class EnterpriseEntity implements Serializable {
  @Id
  private String id;
  private String name;
  private String address;
}
