package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

	@Autowired
	private QuoteService service;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Quote getQuote() {
		return service.getQuote();
	}

	@GetMapping("/{actor}")
	@ResponseStatus(HttpStatus.OK)
	public Quote getQuoteByActor(@PathVariable("actor") String actor) {
		return service.getQuoteByActor(actor);
	}

}
