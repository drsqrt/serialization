package main

type Entity struct {
	ID int `json:"id"`
}

type Animal struct {
	ID     int    `json:"id"`
	Name   string `json:"name"`
	Type   string `json:"type"`
	Entity Entity `json:"entity"`
}
