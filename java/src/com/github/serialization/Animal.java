package com.github.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public class Animal implements Externalizable {

  private Integer id;
  private String name;
  private String category;
  private Entity entity;

  public Animal() {
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.write(1);
    out.writeInt(id);
    out.writeObject(name);
    out.writeObject(category);
    out.writeObject(entity);
    System.out.println("Written externally successful");
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    int version = in.read();
    int id = in.readInt();
    String name = (String) in.readObject();
    String category = (String) in.readObject();
    Entity entity1 = (Entity) in.readObject();

    System.out.println(id + " " + name + " " + category + " " + entity1.getId());
  }

  @Override
  public String toString() {
    return "Id : " + id + " Name : " + name + " Category : " + category;
  }


}
