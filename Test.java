public class Test {
	public static void main(String[] args) {
		GameDriver main = new GameDriver();
		Biometrics bio = main.runGame();
		System.out.print(bio);
	}
	public static Biometrics hello() {
		GameDriver main = new GameDriver();
		Biometrics bio = main.runGame();
		System.out.print(bio);
		return bio;
	}
}
