package org.springboot.nofail_crud.data.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequestBoardDto {
    private String title;
    private String content;
    private Long id;
    private String name;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "RequestBabyBoard(name=" + this.getName() + ", title=" + this.getTitle() + ", content=" + this.getContent() + ", id=" + this.getId() + ")";
    }
}

