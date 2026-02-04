package FunctionalInterfaces;

public class BackgroundJobExecution {

	public static void main(String[] args) {
		// lambda Expression
		Runnable task = () -> {
			System.out.println("Background taks Started.");
		};
		new Thread(task).start();
	}
}
