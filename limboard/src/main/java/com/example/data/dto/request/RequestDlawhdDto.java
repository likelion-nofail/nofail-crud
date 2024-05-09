package com.example.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RequestDlawhdDto {

    private String name;

    private String email;

    private String number;

    private String password;



    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNumber() {
        return this.number;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "RequestDlawhdDto(name=" + this.getName() + ", email=" + this.getEmail() + ", number=" + this.getNumber() + ", password=" + this.getPassword();
    }
}