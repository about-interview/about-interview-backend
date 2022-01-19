package kr.aboutinterview.dto;

import kr.aboutinterview.domain.Company;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class CompanyInfoDto {

    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final String name;
        private final String address;
        private final double score;
        private final long review_count;
        private final long visit_count;

        public Response(final Company company) {
            this.name = company.getName();
            this.address = company.getAddress();
            this.score = company.getScore();
            this.review_count = company.getReview_count();
            this.visit_count = company.getVisit_count();
        }
    }
}
