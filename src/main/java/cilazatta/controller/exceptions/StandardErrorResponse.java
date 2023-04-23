package cilazatta.controller.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardErrorResponse {
	private String message;
	private int code;
	private String status;
	private String objectName;
	private List<StandardErrorObject> errors;

}
