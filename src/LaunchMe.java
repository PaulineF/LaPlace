import java.io.*;
import java.util.Random;


public class LaunchMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//question6();
		question7();

	}

	private static void question7() {
		int n = 1000;
		double e = 0.0001;
		int m = 1000;
		int[] data = createData(n, m);

		double sumPerturbation = 0;
		for(int i=0; i<1000; i++){
			LaPlace laPlace = new LaPlace(e, false);
			try{
				double noise = laPlace.genNoise(m, e);					

				sumPerturbation += (noise);


			}catch (Exception ex){
				System.out.println(ex.getMessage());
			}
		}
		
		System.out.println(sumPerturbation/1000);
		
		
	}

	public static void question6 (){
		int n = 1000;
		int m = 1000;
		double e= 0.001;
		int[] data = createData(n, m);

		

		int count =0;
		for(int j=0; j<n; j++){
			if(data[j] > (m/2))
				count++;
		}		
		double sumCount = 0;
		double sumPerturbe = 0;
		File file = new File("./Laplace.csv");

		if (!file.exists()) {
			try {
				file.createNewFile();
				FileWriter fw1 = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.append("nb,MOYnonperturbe,MOYperturbe,ratio \n");
				bw1.flush();
				bw1.close();		

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		FileWriter fw;
		try {

			fw = new FileWriter(file.getAbsoluteFile(), true);

			BufferedWriter bw = new BufferedWriter(fw);

			for(int i =0; i <500; i++){
				LaPlace laPlace = new LaPlace(e, false);
				try{
					double noise = laPlace.genNoise(1, e);					

					/*System.out.println("Non perturbé : " + count);
					System.out.println("Bruit: " + noise);
					System.out.println("Perturbé : " + (count+noise));
					 */

					sumPerturbe += (count+noise);

					bw.append((i+1) +","+count +","+ (sumPerturbe/(i+1)) +","+ (sumPerturbe/(i+1))/(count)+'\n');

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

	private static int[] createData(int n, int m) {
		int[] data = new int[n];
		for(int i = 0; i<n ; i++){
			int val= (int) Math.round(Math.random() * m);
			data[i] =  val;	
		}
		return data;
	}

}
