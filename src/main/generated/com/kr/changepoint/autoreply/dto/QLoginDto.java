package com.kr.changepoint.autoreply.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.kr.changepoint.autoreply.dto.QLoginDto is a Querydsl Projection type for LoginDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QLoginDto extends ConstructorExpression<LoginDto> {

    private static final long serialVersionUID = -639853952L;

    public QLoginDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> refer, com.querydsl.core.types.Expression<String> replyed) {
        super(LoginDto.class, new Class<?>[]{long.class, String.class, String.class}, id, refer, replyed);
    }

}

