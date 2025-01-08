package com.github.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Objects;

public class Main {

  private static final String AYUSH = "ayush.ser";
  private static final String YUVRAJ = "yuvraj.ser";

  public static void main(String[] args) {
    Developer ayush = new Developer(1, "Ayush", List.of(1, 2, 3));
    Developer yuvraj = new Developer(2, "Yuvraj", List.of(1,2));
    Main tool = new Main();
    tool.serialise(ayush, AYUSH);
    tool.serialise(yuvraj, YUVRAJ);

    Developer deSerializeAyush = tool.deSerialise(AYUSH);
    Developer deSerializeYuvraj = tool.deSerialise(YUVRAJ);
    System.out.println("Serialize dev and deSerialize dev are same ? " + tool.compareDevs(ayush, deSerializeYuvraj));
    System.out.println(deSerializeAyush);
    System.out.println(deSerializeYuvraj);
  }

  private void serialise(Developer dev, String fileName) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
      oos.writeObject(dev);
      System.out.println("Serialized successfully!!");
    } catch (IOException | SecurityException e) {
      System.out.println(e.getMessage());
    }
  }

  private Developer deSerialise(String fileName) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
      Developer dev = (Developer) ois.readObject();
      return Objects.isNull(dev) ? null : dev;
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  private boolean compareDevs(Developer devA, Developer devB) {
    if (Objects.isNull(devA) || Objects.isNull(devB)) return false;
    return devA.getId().equals(devB.getId()) && devA.getName().equals(devB.getName()) && devA.getFavPrimes().equals(devB.getFavPrimes());
  }

}
