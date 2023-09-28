import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Theatre {

    class Seat {
        private char row;
        private int seatNumber;
        private boolean reserved = false;

        public Seat(char row, int seatNumber) {
            this.row = row;
            this.seatNumber = seatNumber;
        }

        public char getRow() {
            return row;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        @Override
        public String toString() {
            String reservedFlag = reserved ? "(*)" : "";
            return String.format("%c%03d%s", row, seatNumber, reservedFlag);
        }

    }

    private TreeSet<Seat> seats;

    public Theatre(String name, int numberOfRows, int numberOfSeatsInRow) {
        int numberOfSeatsTotal = numberOfSeatsInRow * numberOfRows;

        Comparator<Seat> mySort = Comparator
                .comparing(Seat::getRow)
                .thenComparing(Seat::getSeatNumber);

        this.seats = new TreeSet<>(mySort);
        for(char row = 'A'; row < 'A' + numberOfRows; row++){
            for(int j = 1; j <= numberOfSeatsInRow; j++){
                seats.add(new Seat(row, j));
            }
        }
    }

    public void reserveSeat(char row, int seatNum){

        if(!areSeatsValid(row, seatNum)) return;

        Seat seatBooking = seats.floor(new Seat(row, seatNum));

        if (seatBooking == null) {
            System.out.println("Seat does not exist");
            return;
        }
        if(!seatBooking.reserved){
            System.out.println("Your seat " + seatBooking + " has been successfully reserved");
            seatBooking.setReserved(true);
        } else System.out.println("Your seat " + seatBooking + " is already reserved");
    }

    public void reserveMultiSeats(char rowRangeStart, char rowRangeEnd, int seatRangeStart, int seatRangeEnd){

        if(!areSeatsValid(rowRangeStart, seatRangeStart) || !areSeatsValid(rowRangeEnd, seatRangeEnd)) return;

        List<Seat> seatBookingList = new ArrayList<>();
        boolean cancelBooking = false;

        for (char i = rowRangeStart; i <= rowRangeEnd; i++) {
            for (int j = seatRangeStart; j <= seatRangeEnd; j++){
                Seat seatBooking = seats.floor(new Seat(i, j));

                if (seatBooking == null) {
                    System.out.println("Seat does not exist");
                    return;
                }
                if(!seatBooking.reserved) seatBookingList.add(seatBooking);
                else {
                    System.out.println("Your seat " + seatBooking + " is already reserved");
                    cancelBooking = true;
                    break;
                }
            }
        }

        if (cancelBooking){
            System.out.println("Your booking was unsuccessful, please try another row");
        } else {
            System.out.println("Your booking was successful, you have booked seats " + seatRangeStart + " to " + seatRangeEnd
            + " in rows " + rowRangeStart + " to " + rowRangeEnd);
            seatBookingList.forEach(seat -> seat.setReserved(true));
        }
    }

    public boolean areSeatsValid(char row, int seatNum) {
        if (seats.contains(new Seat(row, seatNum))) {
            return true;
        } else {
            System.out.println("Seats are invalid");
            return false;
        }
    }

    public void printSeatMap() {
        char currentRow = 'A';
        boolean firstSeatInRow = true;

        System.out.println("-".repeat(60));
        for (Seat seat : seats) {
            if (currentRow != seat.getRow()) {
                System.out.println();
                currentRow = seat.getRow();
                firstSeatInRow = true;
            }

            if (!firstSeatInRow) System.out.print(", ");
            firstSeatInRow = false;

            System.out.print(seat);
        }
        System.out.println();
        System.out.println("-".repeat(60));
    }
}
