package hu.me.iit.haladojava.SpringMVC.service;

import org.springframework.stereotype.Service;

@Service
public class SzamologepServiceImpl implements SzamologepService {

	@Override
	public double osszead(double a, double b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public double kivon(double a, double b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public double szoroz(double a, double b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double oszt(double a, double b) {
		// TODO Auto-generated method stub
		return a / b;
	}

}
