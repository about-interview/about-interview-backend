package kr.aboutinterview.repository;

import kr.aboutinterview.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByName(@NotBlank String name);
    Optional<Company> findByNameAndAddress(@NotBlank String name, @NotBlank String address);
    boolean existsByNameAndAddress(@NotBlank String name, @NotBlank String address);
}
