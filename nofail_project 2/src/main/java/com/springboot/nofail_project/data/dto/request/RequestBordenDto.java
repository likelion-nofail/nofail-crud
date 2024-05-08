package com.springboot.nofail_project.data.dto.request;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RequestBordenDto {

    private String name;
    private String contents;
    private String title;
    private int password;



    public String getContents(){
        return this.contents;
    }
    public String getTitle(){
        return this.title;
    }
    public String getName(){
        return this.name;
    }
    public int getPassword(){
        return this.password;
    }



    public void setContents(String contents){
        this.contents = contents;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(int password){
        this.password = password;
    }

}
