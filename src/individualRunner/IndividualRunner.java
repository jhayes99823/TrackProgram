package individualRunner;

public class IndividualRunner {

	// fields for indivual runners
	private String strname;
	private String strevent;
	private String strtime;
	
	private double dbltime;
	
	// constructor for indi runner 
	public IndividualRunner(String rname, String revent, String rtime) {
		
		strname = rname;
		strevent = revent;
		strtime = rtime;
		
		dbltime = convertStringToDouble(rtime);
		
	}
	
	// converts string to double for time comparisons
	private static double convertStringToDouble(String time) {
		
		double returnTime = 0;
		
		if (time.equals("")) {
			returnTime = 0.0;
		}
		else if (time.contains(":") == false) {
			String temp = "." + time.replace(".", "");
			returnTime = Double.valueOf(temp);
		} else  if (time.contains(":") == true){
			int indexOfSemi = time.indexOf(":");
			returnTime = Double.parseDouble(time.substring(0, indexOfSemi));
			String temp = "." + time.substring(indexOfSemi + 1).replace(".", "");
			returnTime += Double.parseDouble(temp);
		}
		
		return returnTime;
		
	}
	
	// getters and setters for private fields
	public String getRunnerName() {
		return strname;
	}
	
	public String getRunnerEvent() {
		return strevent;
	}
	
	public String getRunnerTime() {
		return strtime;
	}
	
	public double getRunnerTime_Dbl() {
		return dbltime;
	}
	
}
