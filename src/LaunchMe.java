import java.io.*;
import java.util.Random;


public class LaunchMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = (10)^3;
		int m = 20;
		double e= 10^-4;
		int nb = 10;
		int[] data = new int[n];
		
		Random rand = new Random();
		for(int i = 0; i<n ; i++){
			data[i] = rand.nextInt(m) ;	
		}
		double sumCount = 0;
		double sumPerturbe = 0;
		File file = new File("./Laplace.csv");

		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw1 = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.append("nb \n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		FileWriter fw;
		try {
			
			fw = new FileWriter(file.getAbsoluteFile(), true);

			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i =0; i <nb; i++){
				LaPlace laPlace = new LaPlace(e, false);
				try{
					double noise = laPlace.genNoise(1, e);
					int count =0;
					for(int j=0; j<n; j++){
						if(data[j] > m/2)
							count++;
					}					
					
					
					System.out.println("Non perturbé : " + count);
					System.out.println("Bruit: " + noise);
					System.out.println("Perturbé : " + (count+noise));

					sumCount += count;

					sumPerturbe += (count+noise);

					bw.append((i+1) +" "+(sumCount/(i+1)) +" "+ (sumPerturbe/(i+1)) +'\n');

				}catch (Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		
			
				bw.flush();
				bw.close();		
			
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		
		
	}

}
