package graphics;

public class SpriteSheet {
	
	private int xCount, yCount;
	
	private Texture[] textures;
	
	//sw = sprite width
	//sh = sprite height
	public SpriteSheet(Texture texture, int sw, int sh){
		xCount = texture.getWidth() / sw;
		yCount = texture.getHeight() / sh;
		
		textures = new Texture[xCount * yCount];
		int spriteIndex = 0;
		int[] sheet = texture.pixels;
		
		for (int ys = 0; ys < yCount; ys++) {
			for (int xs = 0; xs < xCount; xs++) {
				int[] sprite = new int[sw * sh];
				int sx = xs * sw;
				int sy = ys * sh;
				for (int y = 0; y < sh; y++) {
					for (int x = 0; x < sw; x++) {
						int xo = sx + x;
						int yo = sy + y;
						sprite[x + y * sw] = sheet[xo + yo * texture.getWidth()];
					}
				}
				textures[spriteIndex++] = new Texture(sprite, sw, sh);
			}
		}
	}
	
	public Texture getTexture(int x, int y) {
		if (x < 0 || x >= xCount || y < 0 || y >=yCount)
			return null;
		
		return textures[x + y * xCount];	}
}
