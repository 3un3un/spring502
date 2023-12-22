package org.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@RequiredArgsConstructor // 생성자 매개변수 data
public class JSONData<T> { // 지네릭 타입 추천

    private boolean success = true;
    private HttpStatus status = HttpStatus.OK; // 응답 상태 코드 200 (가장 많음)
    @NonNull // + @RequiredArgsConstructor => 많이 사용하게 될 것 예상하여 생성자 매개변수 이용하기 위하여
    private T data; // 성공 시 Body 데이터

    private String message; // 실패 시 메세지

}
