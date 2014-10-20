public class Almacen {
	private int galletas = 10;

	/**
	 * Comer Galletas
	 */
	public void comer(int i) {
		this.galletas = this.galletas - i;
		if (this.galletas < 0)
			galletas = 0;
		System.out.println("Hemos comido " + i + " quedan " + this.galletas);
	}

	/**
	 * Reponer Galletas
	 */
	public void reponer() {
		this.galletas = 10;
		System.out.println("Reponemos hay 10");
	}

	/**
	 * @return the galletas
	 */
	public int getGalletas() {
		return galletas;
	}

	/**
	 * @param galletas
	 *            the galletas to set
	 */
	public void setGalletas(int galletas) {
		this.galletas = galletas;
	}

}
