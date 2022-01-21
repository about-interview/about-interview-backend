package kr.aboutinterview.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommonResponseDto<T> {
    private final String result;
    private final int code;
    private final String desc;
    private final T data;
}
