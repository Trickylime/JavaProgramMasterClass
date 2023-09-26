public class BookingAgent {

    public static void main(String[] args) {

        Theatre test = new Theatre("Test", 26, 10);
        test.printSeatMap();
        test.reserveSeat('A', 1);
        test.reserveSeat('A', 1);
        test.reserveSeat('A', 111);
        test.printSeatMap();

    }

    public void reserveSeat(Theatre theatre, char row, int seatNum){

        theatre.reserveSeat(row, seatNum);
    }
}
