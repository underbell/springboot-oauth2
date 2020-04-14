package com.underbell.oauth2.business.user.web.controller;

import com.underbell.oauth2.business.user.domain.entity.OAuth2UserInfo;
import com.underbell.oauth2.business.user.domain.provider.CurrentUser;
import com.underbell.oauth2.business.user.service.OAuth2UserInfoService;
import com.underbell.oauth2.business.user.web.dto.OAuth2UserInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("api/me")
public class OAuth2UserInfoController {

    private final OAuth2UserInfoService oAuth2UserInfoService;

    public OAuth2UserInfoController(OAuth2UserInfoService oAuth2UserInfoService) {
        this.oAuth2UserInfoService = oAuth2UserInfoService;
    }

    @GetMapping
    public Mono<OAuth2UserInfoDto> getUserInfo(@CurrentUser OAuth2UserInfo oAuth2UserInfo) {
        return Mono.just(OAuth2UserInfoDto.builder()
                .name(oAuth2UserInfo.getName())
                .nickName(oAuth2UserInfo.getNickName())
                .email(oAuth2UserInfo.getEmail())
                .image(oAuth2UserInfo.getImage())
                .authProvider(oAuth2UserInfo.getAuthProvider())
                .build());
    }

    @PutMapping
    public Mono<OAuth2UserInfoDto> updateUserInfo(@Valid @RequestBody OAuth2UserInfoDto.UpdateDto updateDto, @CurrentUser OAuth2UserInfo oAuth2UserInfo) {
        return oAuth2UserInfoService.updateUserInfo(updateDto, oAuth2UserInfo);
    }
}