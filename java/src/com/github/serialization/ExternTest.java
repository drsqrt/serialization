package com.github.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternTest {

  private static final String FILE_NAME = "extern.ser";

  public static void main(String[] args) {
    new ExternTest().execute();
  }

  private void execute() {
    try {
      ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
      Animal dog = new Animal(1, "puffy", "Dog", new Entity(1));
      Animal fish = new Animal(1, "golden", "Fish", new Entity(1));
      fish.writeExternal(oo);
      oo.close();

      ObjectInput oi = new ObjectInputStream(new FileInputStream(FILE_NAME));
      fish.readExternal(oi);
      oi.close();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println( "Error : " + e.getMessage());
    }
  }

}
