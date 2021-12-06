package hu.iit.webalk.zh.practice.student.exception;

public class NoSuchEntityException extends RuntimeException {
	
	Long id;

	public NoSuchEntityException(Long id) {
		super(String.format("No such entity!", id));
		this.id = id;
	}
	
	

}
