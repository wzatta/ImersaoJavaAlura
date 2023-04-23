package cilazatta.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StandardErrorObject {

	private final String message;
	private final String field;
	private final Object parameter;
}
