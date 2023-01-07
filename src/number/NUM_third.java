package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_third extends SuperNumber{

	public NUM_third() {
		name = "Third";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/2-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
