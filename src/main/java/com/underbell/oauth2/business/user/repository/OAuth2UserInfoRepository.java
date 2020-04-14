package com.underbell.oauth2.business.user.repository;

import com.underbell.oauth2.business.user.domain.entity.OAuth2UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface OAuth2UserInfoRepository extends ReactiveMongoRepository<OAuth2UserInfo, String> {
    Mono<OAuth2UserInfo> findByName(String name);
}