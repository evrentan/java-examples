package evrentan.examples.javarecordexample.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record EnterpriseRecord(String id, @NotNull String name, @NotNull @Length(min = 2, max = 255) String address) implements Serializable {
}
