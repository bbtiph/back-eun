package kz.dara.cameralcontrol.util;

import kz.dara.cameralcontrol.model.Group;
import kz.dara.cameralcontrol.model.User;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserHelper {
    public static Collection<String> getRoles(User user) {
        return user.getUserGroups().stream()
                .map(u -> u.getGroup().getName())
                .collect(Collectors.toList());
    }
}
