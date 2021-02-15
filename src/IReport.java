import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IReport {

    public double averageTemp(int month, int year);

    public double totalRainfall(int month, int year);

    public void addReport(GregorianCalendar date, LinkedList<Reading> readings);

}
