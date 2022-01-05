package evrentan.examples.javarecordexample.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class EnterpriseLombok implements Serializable {
  String id;
  String name;
  String address;
}
