package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_second extends SuperNumber{

	public NUM_second() {
		name = "Second";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/1-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
