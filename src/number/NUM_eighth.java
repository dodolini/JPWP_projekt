package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_eighth extends SuperNumber{
	public NUM_eighth() {
		name = "Eighth";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/7-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
