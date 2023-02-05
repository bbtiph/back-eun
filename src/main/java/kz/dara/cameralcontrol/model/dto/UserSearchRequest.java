package kz.dara.cameralcontrol.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UserSearchRequest {
    private String search;
    private String iin;
}
