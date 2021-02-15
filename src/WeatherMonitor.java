import java.util.GregorianCalendar;
import java.util.LinkedList;

public class WeatherMonitor {

    private IReport allDailyReport;

    public WeatherMonitor(IReport allDailyReport) {
        this.allDailyReport = allDailyReport;
    }

    //averageTempForMonth: takes a month and a year and produces the average temperature over all days that month.
    public double averageTempForMonth(int month, int year) {
        return allDailyReport.averageTemp(month, year);
    }

    //totalRainfallForMonth: takes a month and a year and produces the total rainfall over all days that month.
    public double totalRainfallForMonth(int month, int year) {
        return allDailyReport.totalRainfall(month, year);
    }

    //addDailyReport: consumes a date and a list of readings (nominally for that date) and stores a daily report for the given date.
    public void addDailyReport(GregorianCalendar date, LinkedList<Reading> readings) {
        allDailyReport.addReport(date, readings);
    }

}
