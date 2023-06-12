package com.refactor.tech.nullObject.model;

public class NullUser extends User{
	
	public NullUser() {
        setId(-1L);
        setName("NULL_USER");
        setEmail("");
        // set other properties as necessary
    }

}
