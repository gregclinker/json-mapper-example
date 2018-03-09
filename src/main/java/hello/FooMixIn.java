package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface FooMixIn {

	@JsonIgnore
	Object getProperty2();
}