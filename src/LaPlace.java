
public class LaPlace {
	private double e;
	private double globBudget;
	private boolean test;
	
	public LaPlace(double e, boolean test){
		this.e = e;
		this.globBudget = e;
		this.test = test;
	}

	
	public double genNoise( int sensibility, double budget) throws Exception{
		if(this.globBudget < budget){
			throw new Exception("il n'y a pas assez de budget");
		}
		double lambda = sensibility/budget;
		double U= Math.random() - 0.5;
		double x = 0- lambda * Math.signum(U)* Math.log(1-2*Math.abs(U));
		if(!test){
			this.globBudget -= budget;
		}
		return x;
	}
	
	public void setTest(boolean test){
		this.test = test;
	}
}
