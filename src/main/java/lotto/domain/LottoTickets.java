package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.RandomUtils;

public class LottoTickets {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> ALL_LOTTO_NUMBERS = IntStream
        .range(START_LOTTO_NUMBER, END_LOTTO_NUMBER + 1).boxed().collect(Collectors.toList());

    private final List<Lotto> lottoTickets;

    public LottoTickets(final int buyLottoSize) {
        this(buyLottoSize, ALL_LOTTO_NUMBERS);
    }

    public LottoTickets(final int buyLottoSize, final List<Integer> LottoNumbers) {
        lottoTickets = createLottoTickets(buyLottoSize, LottoNumbers);
    }

    private List<Lotto> createLottoTickets(final int buyLottoSize, final List<Integer> LottoNumbers) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < buyLottoSize; i++) {
            lottoTickets
                .add(new Lotto(RandomUtils.generateRandomNumbers(LottoNumbers, LOTTO_SIZE)));
        }
        return lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public Rewords getResult(final WinningLotto winningLotto) {
        List<Reword> rewords = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            rewords.add(winningLotto.match(lotto));
        }
        return new Rewords(rewords);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
