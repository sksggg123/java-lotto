package edu.nextstep.step4.domain;

import edu.nextstep.step4.utils.RandomNumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-26 23:00
 */
public class LottoStore {

    public static Lottos publishLotto(Money money) {
        List<Lotto> exNumber = new ArrayList<>();
        int issueNumber = money.getNumberOfExtract();

        for (int i = 0; i < issueNumber; i++) {
            exNumber.add(issueLottoNumber());
        }

        return new Lottos(exNumber);
    }

    private static Lotto issueLottoNumber() {
        return new Lotto(RandomNumberUtils.getExtractNumber().stream()
                .map(number -> Number.of(number))
                .collect(Collectors.toList()));
    }
}