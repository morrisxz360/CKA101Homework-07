package rolegame;
public class SwordMan extends Hero {
	
	public SwordMan() {
		super();
	}
	
	public SwordMan(String name, int level, double exp) {
		super(name, level, exp);
		setmoving(new Normalmoving());
		setdefend(new Normaldefending());
	}
	
	@Override
	public void attack() {
		System.out.println("揮劍");
	}
	
	
	
}
