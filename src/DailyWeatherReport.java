import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport {

    private GregorianCalendar date;
    private LinkedList<Double> tempReading;
    private LinkedList<Double> rainfallReading;

    public DailyWeatherReport(GregorianCalendar date, LinkedList<Double> tempReading, LinkedList<Double> rainfallReading) {
        this.date = date;
        this.tempReading = tempReading;
        this.rainfallReading = rainfallReading;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    //totalRainfallReading: consumes a daily weather report then returns the average temperature reading for that day.
    public double avgTempReading() {
        double sum = 0;
        int n = 0;

        for(Double d : this.tempReading){
            sum += d;
            n++;
        }

        return sum / n;
    }

    //totalRainfallReading: consumes a daily weather report then returns the total rainfall reading for that day.
    public double totalRainfallReading() {
        double sum = 0;

        for(Double d : this.rainfallReading){
            if(d > 0)
                sum += d;
        }

        return sum;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setTempReading(LinkedList<Double> tempReading) {
        this.tempReading = tempReading;
    }

    public void setRainfallReading(LinkedList<Double> rainfallReading) {
        this.rainfallReading = rainfallReading;
    }
}
