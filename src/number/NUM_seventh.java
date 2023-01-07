package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_seventh extends SuperNumber{
	public NUM_seventh() {
		name = "Seventh";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/6-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
