package controllers.admin;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class MemberSearch {
    @DateTimeFormat(pattern = "yyyy/MM/dd") // 형식 알려주면 사용 가능
    private LocalDate sdate;
    @DateTimeFormat(pattern = "yyyy/MM/dd") // 형식 알려주면 사용 가능
    private LocalDate edate;


}
