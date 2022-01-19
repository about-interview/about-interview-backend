package kr.aboutinterview.service;

import kr.aboutinterview.domain.Company;
import kr.aboutinterview.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
class CompanyServiceTest {

    private final CompanyService companyService;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceTest(CompanyService companyService, CompanyRepository companyRepository) {
        this.companyService = companyService;
        this.companyRepository = companyRepository;
    }

    @BeforeEach
    public void beforeEach() {
        companyRepository.deleteAll();
    }

    @Test
    void 회사_정보_가져오기() {
        String company_name = "회사이름";
        String company_address = "회사주소";

        companyService.createCompany(company_name, company_address);
        Company companyInfo = companyService.getCompanyInfo("회사이름").orElseGet(() -> fail("fail"));

        assertThat(companyInfo.getName()).isEqualTo(company_name);
        assertThat(companyInfo.getAddress()).isEqualTo(company_address);
    }

    @Test
    void 회사_생성() {
        String company_name = "회사이름";
        String company_address = "회사주소";

        Company company = companyService.createCompany(company_name, company_address).orElseGet(() -> fail("fail"));

        assertThat(company.getName()).isEqualTo(company_name);
        assertThat(company.getAddress()).isEqualTo(company_address);
    }

    @Test
    void 회사_중복_생성() {
        String company1_name = "회사이름1";
        String company1_address = "회사주소1";

        companyService.createCompany(company1_name, company1_address);
        Company company = companyService.createCompany(company1_name, company1_address).orElseGet(() -> fail("fail"));

        assertThat(company.getName()).isEqualTo(company1_name);
        assertThat(company.getAddress()).isEqualTo(company1_address);
    }
}