package com.underbell.oauth2.business.user.web.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OAuth2UserInfoDto {

    private String name;

    private String email;

    private String nickName;

    private String authProvider;

    private String image;

    @Builder
    private OAuth2UserInfoDto(String name, String email, String nickName, String authProvider, String image) {
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.authProvider = authProvider;
        this.image = image;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UpdateDto {
        private String nickName;

        private String image;

        @Builder
        private UpdateDto(final String nickName, final String image) {
            this.nickName = nickName;
            this.image = image;
        }
    }
}
