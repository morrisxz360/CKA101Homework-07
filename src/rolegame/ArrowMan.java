package rolegame;
public class ArrowMan extends Hero {
	
	public ArrowMan() {
		super();
	}

	public ArrowMan(String name, int level, double exp) {
		super(name, level, exp);
		setmoving(new Normalmoving());
		setdefend(new Normaldefending());
	}

	@Override
	public void attack() {
		System.out.println("放弓箭");
	}

	
}
