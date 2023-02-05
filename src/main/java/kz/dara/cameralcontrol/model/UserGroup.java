package kz.dara.cameralcontrol.model;


import javax.persistence.*;
import java.io.*;
import java.sql.*;

@Entity
@Table(name="user_group")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user",
                joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "pk.group",
                joinColumns = @JoinColumn(name = "group_id")) })
public class UserGroup implements Serializable {
    @EmbeddedId
    private UserGroupKey pk = new UserGroupKey();

    public UserGroupKey getPk() {
        return pk;
    }

    public void setPk(UserGroupKey pk) {
        this.pk = pk;
    }

    @Transient
    public User getUser() {
        return getPk().getUser();
    }

    public void setUser(User user) {
        getPk().setUser(user);
    }

    @Transient
    public Group getGroup() {
        return getPk().getGroup();
    }

    public void setGroup(Group group) {
        getPk().setGroup(group);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserGroup) {
            UserGroup other = (UserGroup)obj;
            if (this.pk == null || other.pk == null)
                return false;
            return this.pk.equals(other.pk);
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return pk != null ? pk.hashCode() : 0;
    }
}
