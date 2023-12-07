package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListService {

    private MemberDao memberDao;

    // 호출시에 매개변수 투입해서 주입하기 위하여 멤버변수가 아닌 setter메서드에 어노테이션!
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void print() {
        List<Member> members = memberDao.getList();
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
