package eventFeedbackAndRatingAnalyzer;
import java.util.*;

public class EventFeedbackService {
	Map<String , List<Integer>> feedbackMap = new HashMap<>();
	
	// Add
	public void addRating(String eventId , int rating) throws InvalidRatingException   {
		if(rating < 1 || rating > 5) {
			throw new InvalidRatingException("Enter rating between 1-5");
		}
		feedbackMap.putIfAbsent(eventId , new ArrayList<>());
		feedbackMap.get(eventId).add(rating);
	}
	
	// Average
	public double getAverageRating(String eventId) {
		List<Integer> ratings = feedbackMap.get(eventId);
		if(ratings == null || ratings.isEmpty()) {
			return 0.0;
		}
		int sum = 0;
		for(int r : ratings) {
			sum += r;
			return sum;
		}
		return (double)sum / ratings.size();
	}
	
	// top rated events
	public String getTopRatedEvent() {
        String topEvent = null;
        double highestAverage = 0.0;

        for (String eventId : feedbackMap.keySet()) {
            double avg = getAverageRating(eventId);
            if (avg > highestAverage) {
                highestAverage = avg;
                topEvent = eventId;
            }
        }

        return topEvent;
    }
	
	// display feedBack
	public void displayFeedbacks() {
		for(Map.Entry<String,List<Integer>> entry : feedbackMap.entrySet()) {
			System.out.println("Event: " + entry.getKey() + "Rating: " + entry.getValue() + "Average: " + getAverageRating(entry.getKey()));
		}
	}
}
