package logic.sorting;

import model.domain.Obligation;

import java.util.Comparator;
import java.util.List;

public interface ObligationsSorter {

    public List<Obligation> sort(List<Obligation> list, Comparator<Obligation> comparator);

}
