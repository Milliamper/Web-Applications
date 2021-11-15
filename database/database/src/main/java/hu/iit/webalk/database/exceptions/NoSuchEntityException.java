package hu.iit.webalk.database.exceptions;

public class NoSuchEntityException extends RuntimeException {

	private Long id;

	public NoSuchEntityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public NoSuchEntityException(Long id) {
		super(String.format("No such entity", id));
		this.id = id;
	}

	public NoSuchEntityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
