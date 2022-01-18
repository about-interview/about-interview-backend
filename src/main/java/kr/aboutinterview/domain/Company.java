package kr.aboutinterview.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Builder
public class Company {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Builder.Default
    @Column(nullable = false)
    private double score = 0.0;

    @Builder.Default
    @Column(nullable = false)
    private long review_count = 0L;

    @Builder.Default
    @Column(nullable = false)
    private long visit_count = 0L;

    @Builder
    public Company(String name, String address) {
        this.name = name;
        this.address = address;
    }
}