package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/dto1")
	public ResponseEntity<DTO1> dto1() {
		return new ResponseEntity<DTO1>(new DTO1("prop1", "prop2", "prop3"), HttpStatus.OK);
	}

	@RequestMapping("/dto2")
	public ResponseEntity<DTO2> dto2() {
		return new ResponseEntity<DTO2>(new DTO2("prop1", "prop2", "prop3"), HttpStatus.OK);
	}

}
