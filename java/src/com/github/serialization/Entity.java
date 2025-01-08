package com.github.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Entity implements Serializable {

  private Integer id;

}
