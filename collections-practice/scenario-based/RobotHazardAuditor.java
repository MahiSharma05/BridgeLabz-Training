package scenariio;
import java.util.*;

// Custom Exception
class RobotSafetyException extends Exception{
	public RobotSafetyException(String message) {
		super(message);
	}	
}

public class RobotHazardAuditor {
	
	// calculate Hazard Risk
	public static double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)throws RobotSafetyException{
		    // Validate
			if(armPrecision < 0.0 || armPrecision > 1.0) {
				throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
			}
			if(workerDensity < 1 || workerDensity > 20) {
				throw new RobotSafetyException("Error: Worker density must be 1-20");
			}
			if(!machineryState.equals("Worn") && !machineryState.equals("Faulty") && !machineryState.equals("Critical")) {
				throw new RobotSafetyException("Error: Unsupported machinery state");
			}
			
			// Set Machinary Risk Factor
			double machinaryRiskFactor = 0.0;
			if(machineryState.equals("Worn")) {
				machinaryRiskFactor = 1.3;
			}
			else if(machineryState.equals("Faulty")) {
				machinaryRiskFactor = 2.0;
			}
			else {
				machinaryRiskFactor = 3.0;
			}
			
			// Calculate
			double hazardRisk = ((1.0 - armPrecision) * 15.0)+ (workerDensity * machinaryRiskFactor);
		    return hazardRisk;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		try {
			System.out.println("Enter Arm Precision(0.0 - 1.0): ");
			double armPrecision = input.nextDouble();
			System.out.println("Enter Worker Density(1 - 20):");
			int workerDensity = input.nextInt();
			System.out.println("Enter Machinery State(Worn/Faulty/Critical):");
			input.nextLine();
			String machineryState = input.nextLine();
	        System.out.println("Robot Hazard Risk Score:" + calculateHazardRisk(armPrecision, workerDensity, machineryState));
		}
        catch( RobotSafetyException e) {
			System.out.println(e.getMessage());
		}
	}

}
