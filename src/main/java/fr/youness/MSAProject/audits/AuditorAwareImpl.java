package fr.youness.MSAProject.audits;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl  implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mr. YC");
    }
}
