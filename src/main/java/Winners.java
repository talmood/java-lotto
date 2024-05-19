public class Winners {
    private final Integer firstWinner;
    private final Integer secondWinner;
    private final Integer thirdWinner;
    private final Integer fourthWinner;
    private final Integer fifthWinner;

    public Winners(Integer firstWinner, Integer secondWinner, Integer thirdWinner, Integer fourthWinner, Integer fifthWinner) {
        this.firstWinner = firstWinner;
        this.secondWinner = secondWinner;
        this.thirdWinner = thirdWinner;
        this.fourthWinner = fourthWinner;
        this.fifthWinner = fifthWinner;
    }

    public Integer getFirstWinner() {
        return firstWinner;
    }

    public Integer getSecondWinner() {
        return secondWinner;
    }

    public Integer getThirdWinner() {
        return thirdWinner;
    }

    public Integer getFourthWinner() {
        return fourthWinner;
    }

    public Integer getFifthWinner() {
        return fifthWinner;
    }
}
