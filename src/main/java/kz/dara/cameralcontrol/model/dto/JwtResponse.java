package kz.dara.cameralcontrol.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String name;
	private String surname;
	private String middleName;
	private Set<String> roles;

	public JwtResponse(String token, Long id, String username, String email, String name,
                       String surname, String middleName, Set<String> roles) {
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.middleName = middleName;
		this.roles = roles;
	}
}
