package org.springboot.nofail_crud.data.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
public class ChangeBoardTitleDto {
    private String title;

    public ChangeBoardTitleDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String toString() {
        return "ChangeBoardTitleDto(pid=" + this.getTitle() + ")";
    }

}
