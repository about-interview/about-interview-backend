package kr.aboutinterview.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Company {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private double score = 0.0;

    @Column(nullable = false)
    private long review_count = 0L;

    @Column(nullable = false)
    private long visit_count = 0L;

    public Company(final String name, final String address) {
        this.name = name;
        this.address = address;
    }
}