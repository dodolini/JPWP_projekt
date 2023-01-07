package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_first extends SuperNumber{

	public NUM_first() {
		name = "First";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/0-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
