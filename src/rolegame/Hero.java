package rolegame;
public abstract class Hero {
	// 省略 getter/setter...
	private String name;
	private int level;
	private double exp;
	
	private Moving moving;
	private Defending defending;
	
	public void setmoving(Moving moving) {
		this.moving = moving;
	}
	public void setdefend(Defending defending) {
		this.defending = defending;
	}
	
	public Hero() {
		this("David", 1, 0);
	}
	
	public Hero(String name, int level, double exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}
	
	public abstract void attack();
	
	protected void moving() {
		moving.move();
	}
	protected void defending() {
		defending.defend();
	}
}
	
