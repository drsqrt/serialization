package main

import (
	"encoding/gob"
	"fmt"
	"os"
)

// go binary serialization
func GobSerialization() {
	fileName := "animal.gob"

	dog := Animal{ID: 1, Name: "puffy", Type: "Dog"}
	err := serializeToGobFile(fileName, dog)
	if err != nil {
		fmt.Println("Error during serialization:", err)
		return
	}
	fmt.Println("Gob Serialization successful.")

	var deserializedAnimal Animal
	err = deserializeFromGobFile(fileName, &deserializedAnimal)
	if err != nil {
		fmt.Println("Error during deserialization:", err)
		return
	}
	fmt.Printf("Gob Deserialization successful: %+v\n", deserializedAnimal)
}

// Serialize struct to Gob and save to file
func serializeToGobFile(fileName string, data interface{}) error {
	file, err := os.Create(fileName)
	if err != nil {
		return err
	}
	defer file.Close()

	encoder := gob.NewEncoder(file)
	return encoder.Encode(data)
}

// Deserialize Gob from file into a struct
func deserializeFromGobFile(fileName string, data interface{}) error {
	file, err := os.Open(fileName)
	if err != nil {
		return err
	}
	defer file.Close()

	decoder := gob.NewDecoder(file)
	return decoder.Decode(data)
}
