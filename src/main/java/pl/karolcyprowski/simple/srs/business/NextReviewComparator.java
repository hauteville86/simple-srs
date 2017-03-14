package pl.karolcyprowski.simple.srs.business;

import java.util.Comparator;

import pl.karolcyprowski.simple.srs.entities.Card;
import pl.karolcyprowski.simple.srs.entities.Reviewable;

public class NextReviewComparator implements Comparator<Reviewable>{
	
	@Override
	public int compare(Reviewable o1, Reviewable o2) {
		return o1.getNextRepeat().compareTo(o2.getNextRepeat());
	}

}
