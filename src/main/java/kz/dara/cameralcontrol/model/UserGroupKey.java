package kz.dara.cameralcontrol.model;

import javax.persistence.*;
import java.io.*;

/**
 * Created by td13605
 */
@Embeddable
public class UserGroupKey implements Serializable {
    public static final String FIELD_GROUP = "group";
    public static final String FIELD_USER = "user";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id", nullable = false, insertable = false, updatable = false)
    private Group group;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserGroupKey) {
            UserGroupKey other = (UserGroupKey)obj;
            boolean userFlag;
            if (getUser() == null)
                userFlag = other.getUser() == null;
            else
                userFlag = getUser().equals(other.getUser());

            boolean groupFlag;
            if (getGroup() == null)
                groupFlag = other.getGroup() == null;
            else
                groupFlag = getGroup().equals(other.getGroup());

            return userFlag && groupFlag;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
