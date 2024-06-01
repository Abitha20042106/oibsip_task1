public class Reservation {
    private String pnr;
    private String userId;
    private String trainNumber;
    private String classType;
    private String dateOfJourney;
    private String destination;

    public Reservation(String pnr, String userId, String trainNumber, String classType, String dateOfJourney, String destination) {
        this.pnr = pnr;
        this.userId = userId;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.destination = destination;
    }

    public String getPnr() {
        return pnr;
    }

    public String getUserId() {
        return userId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + ", Train Number: " + trainNumber + ", Class: " + classType + ", Date: " + dateOfJourney + ", Destination: " + destination;
    }
}
