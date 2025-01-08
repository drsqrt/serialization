package main

import (
	"encoding/json"
	"fmt"
	"os"
)

func JSONSerialization() {
	fileName := "animal.json"

	dog := Animal{
		ID:   1,
		Name: "puffy",
		Type: "Dog",
		Entity: Entity{
			ID: 1,
		},
	}

	// Serialize (write to file)
	err := serializeToFile(fileName, dog)
	if err != nil {
		fmt.Println("Error during serialization:", err)
		return
	}
	fmt.Println("Serialization successful.")

	// Deserialize (read from file)
	var deserializedAnimal Animal
	err = deserializeFromFile(fileName, &deserializedAnimal)
	if err != nil {
		fmt.Println("Error during deserialization:", err)
		return
	}
	fmt.Printf("Deserialization successful: %+v\n", deserializedAnimal)
}

// Serialize struct to JSON and save to file
func serializeToFile(fileName string, data interface{}) error {
	file, err := os.Create(fileName)
	if err != nil {
		return err
	}
	defer file.Close()

	encoder := json.NewEncoder(file)
	return encoder.Encode(data)
}

// Deserialize JSON from file into a struct
func deserializeFromFile(fileName string, data interface{}) error {
	file, err := os.Open(fileName)
	if err != nil {
		return err
	}
	defer file.Close()

	decoder := json.NewDecoder(file)
	return decoder.Decode(data)
}
