package com.github.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class Developer implements Serializable {

  private Integer id;
  private String name;
  private List<Integer> favPrimes;

  @Override
  public String toString() {
    return "Id : " + id + " Name : " + name + " Fav Primes : " + favPrimes.toString();
  }

}
