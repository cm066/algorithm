package main

import (
	"fmt"
	"sync"
)

type User struct {
	username string
	password string
}

func main() {
	str := "abbb %s  %s"
	sprintf := fmt.Sprintf(str, "A", "")
	fmt.Println(sprintf)
	s := []string{"a", "b", "c"}
	s1 := make([]string, 0)
	var wg sync.WaitGroup

	for _, v := range s {
		wg.Add(1)
		vv := v
		go func() {
			defer wg.Done()
			strings := test(vv)
			s1 = append(s1, strings...)
		}()
	}
	wg.Wait()
	fmt.Println(s1)
}

//type: mongo
//hosts: "127.0.0.1:27017"
//database: "loggie"
//collection: "test"

func test(s string) []string {

	ret := make([]string, 0)

	ret = append(ret, s)
	return ret
}
