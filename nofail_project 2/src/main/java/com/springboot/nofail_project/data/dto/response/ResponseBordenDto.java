package com.springboot.nofail_project.data.dto.response;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ResponseBordenDto {

    private Long id;
    private String name;
    private String contents;
    private String title;
    private int password;



    public Long getId(){
        return this.id;
    }
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



    public void setId(Long id){
        this.id = id;
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
