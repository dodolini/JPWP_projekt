package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_sixth extends SuperNumber{
	public NUM_sixth() {
		name = "Sixth";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/5-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
