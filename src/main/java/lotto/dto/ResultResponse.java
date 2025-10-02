package lotto.dto;

import lotto.model.Statistics;

public class ResultResponse {

    private final Statistics stats;
    private final int paid;

    public ResultResponse(Statistics stats, int paid) {
        this.stats = stats;
        this.paid = paid;
    }

    public Statistics getStats() {
        return stats;
    }

    public int getPaid() {
        return paid;
    }
}
