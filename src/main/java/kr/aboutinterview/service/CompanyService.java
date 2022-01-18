package kr.aboutinterview.service;

import kr.aboutinterview.domain.Company;
import kr.aboutinterview.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public Optional<Company> getCompanyInfo(@NotBlank final String company_name) {
        return companyRepository.findByName(company_name);
    }

    public Optional<Company> createCompany(@NotBlank final String company_name, @NotBlank final String company_address) {
        if (!companyRepository.existsByNameAndAddress(company_name, company_address)) {
            Company newCompany = Company.builder()
                    .name(company_name)
                    .address(company_address)
                    .build();
            companyRepository.save(newCompany);
        }

        return companyRepository.findByNameAndAddress(company_name, company_address);
    }
}
