package kz.dara.cameralcontrol.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class UserDto {
    private Long id;
    private String username;
    private String emailAddress;
    private String password;
    private String lastName;
    private String middleName;
    private String firstName;
    private Boolean active;
    private List<String> userGroups;

}
