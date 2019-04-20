package com.roxi.vote.excpetion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Roxi酱
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException {
    int code;
    String message;
}
