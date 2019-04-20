package com.roxi.vote.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Roxi酱
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    String openId;
    int ticket;
}
