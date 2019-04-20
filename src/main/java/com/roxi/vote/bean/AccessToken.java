package com.roxi.vote.bean;

import lombok.Data;

/**
 * @author Roxi酱
 */
@Data
public class AccessToken {
    private String accessToken;

    private int expiresin;
}
