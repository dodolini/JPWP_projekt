package number;

import java.io.IOException;

import javax.imageio.ImageIO;

public class NUM_ninth extends SuperNumber{
	public NUM_ninth() {
		name = "Ninth";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/numbers/3-Number-PNG.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
