package eventFeedbackAndRatingAnalyzer;

public class EventFeedbackMain {

	public static void main(String[] args) {
		EventFeedbackService service = new EventFeedbackService();
		try {
			service.addRating("EV101", 1);
			service.addRating("EV102", 2);
			service.addRating("EV103", 3);
			service.addRating("EV104", 4);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n----Event Feedback-----");
		service.displayFeedbacks();

		System.out.println("\nTop Rated Event: " + service.getTopRatedEvent());

	}

}
