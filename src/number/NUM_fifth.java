package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_fifth extends SuperNumber{
	public NUM_fifth() {
		name = "Fifth";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/4-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
