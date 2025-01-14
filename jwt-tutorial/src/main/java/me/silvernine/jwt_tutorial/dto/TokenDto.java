package me.silvernine.jwt_tutorial.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto { //token 정보를 response할때 사용
    private String token;
}
