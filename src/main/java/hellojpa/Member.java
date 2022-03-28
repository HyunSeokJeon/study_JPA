package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    /**
     * Column
     *
     * name : 필드와 매핑할 테이블의 컬럼 이름
     * insertable : 등록 가능여부
     * updatable : JPA를 사용할때는 값이 변경되지 않게 하고싶을 때 false
     * nullable(DDL) : null의 허용 여부 false -> not null
     * unique : unique constraint 제약조건 (테스트 할때만 사용 제약조건 이름이 랜덤하게 나와서 알기 힘듬)
     *          Table 어노테이션에서 uniqueConstraints으로 사용할 때에는 제약조건 이름까지 설정 가능
     * length(DDL) : 문자 길이 제약조건, String 타입에서만 사용한다.
     * columnDefinition : 기타 정의를 넣고싶은 경우
     * precision, scale(DDL) : BigDecimal 타입에서 사용한다.(BigInteger도 사용할 수 있다)
     * precision은 소수점을 포함한 전체 자릿수를 , cale은 소수점 자수, Double, float 타입에는 적용되지 않는다.
     * 아주 큰 숫자나 정밀한 소수를 다루어야 할 때만 사용.
     */
    @Column(name = "name")
    private String userName;

    private Integer age;

    /**
     * ORDINAL이 default이지만 enum순서를 저장 USER : 0, ADMIN : 1
     * enum 순서가 바뀌어도 그 순서를 소급해주지 않아 굉장히 위험할 수 있음
     * STRING으로 사용
     */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /**
     * java.util.Date, java.util.Calendar 매핑 할 때 사용
     * LocalDate, LocalDateTime을 사용하는 경우 생략 가능(최신 하이버네이트 지원)
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /**
     * 문자 매핑 : CLOB
     * 나머지 : BLOB
     */
    @Lob
    private String description;

    /**
     * 필드 매핑X
     * 데이터베이스에 저장X, 조회X
     * 주로 메모리상에서만 임시로 어떤 값을 보관하고 싶을 때 사용
     */
    @Transient
    private int temp;

    public Member() {
    }

}
