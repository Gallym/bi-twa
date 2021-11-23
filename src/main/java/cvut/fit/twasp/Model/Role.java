package cvut.fit.twasp.Model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, GROUP_MEMBER, ROOM_MANAGER, GROUP_MANAGER;

    @Override
    public String getAuthority() {
        return name();
    }


}
