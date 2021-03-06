package ink.bonismo.security;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

import java.util.Optional;

/**
 * Created by bonismo@hotmail.com on 2019/3/19 8:35 PM
 *
 * @Description:
 * @Version: 1.0
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String auditor = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication) {
            auditor = "anonymousUser";
        } else {
            auditor = authentication.getPrincipal().toString();
        }
        return Optional.of(auditor);
    }
}
