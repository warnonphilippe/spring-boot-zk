package be.civadis.stc.web;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public String getName() {
		return "date " + System.nanoTime();
	}
}
