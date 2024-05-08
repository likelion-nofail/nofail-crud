package org.springboot.nofail_crud.data.dto.response;

import lombok.*;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBoardDto {
    private Long id;
    private String title;
    private String content;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "ResponseBoard(name=" + this.getName() + ", id=" + this.getId() + ", content=" + this.getContent() + ", title=" + this.getTitle() + ")";
    }

}
