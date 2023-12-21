package org.choongang.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "file") // 자동으로 파일 url, path 설정
public class FileProperties {
    private String url;
    private String path;
}
