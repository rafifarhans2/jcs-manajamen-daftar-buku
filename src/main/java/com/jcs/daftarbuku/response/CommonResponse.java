package com.jcs.daftarbuku.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse<T>{
    private Integer statusCode;
    private String message;
    private T data;
    private PagingResponse pagingResponse;
}
