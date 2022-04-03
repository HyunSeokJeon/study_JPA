package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    /**
     * @Id : 직접 할당
     * @GeneratedValue : 자동 생성
     * IDENTITY : 데이터베이스에 위임, MYSQL
     * SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용, Oracle @SequenceGenerator
     * TABLE : 키 생성용 테이블 사용, 모든 DB에서 사용
     * AUTO : 방언에 따라 자동 지정, 기본값
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String userName;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
