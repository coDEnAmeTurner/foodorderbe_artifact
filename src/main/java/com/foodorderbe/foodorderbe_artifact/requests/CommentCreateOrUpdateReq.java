package com.foodorderbe.foodorderbe_artifact.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateOrUpdateReq {
    private String content = "";
    private Long parentId = 0L;
    private Long dishId = 0L;
    private Long shopId = 0L;


}
