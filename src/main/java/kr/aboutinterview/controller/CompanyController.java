package kr.aboutinterview.controller;

import kr.aboutinterview.domain.Company;
import kr.aboutinterview.dto.CommonResponseDto;
import kr.aboutinterview.dto.CompanyInfoDto;
import kr.aboutinterview.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("companies")
    public CommonResponseDto<CompanyInfoDto.Response> getCompanyInfo(@RequestParam("q") final String company_name) {

        Optional<Company> companyInfo = companyService.getCompanyInfo(company_name);

        CommonResponseDto<CompanyInfoDto.Response> commonResponseDto = null;
        if (companyInfo.isPresent()) {
            CompanyInfoDto.Response response = new CompanyInfoDto.Response(companyInfo.get());
            commonResponseDto = new CommonResponseDto<>("success", 200, "회사 정보 요청이 성공적으로 호출했습니다", response);
        } else {
            commonResponseDto = new CommonResponseDto<>("success", 200, "회사 정보 요청이 성공적으로 호출 되었지만 정보가 없습니다", null);
        }

        return commonResponseDto;
    }
}
