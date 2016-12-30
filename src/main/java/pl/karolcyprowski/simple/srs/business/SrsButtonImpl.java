package pl.karolcyprowski.simple.srs.business;

public class SrsButtonImpl implements SrsButton {

	private String text;
	
	private int srsLevel;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getSrsLevel() {
		return srsLevel;
	}

	public void setSrsLevel(int srsLevel) {
		this.srsLevel = srsLevel;
	}
}
