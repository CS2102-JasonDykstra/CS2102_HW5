import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyReportList implements IReport{

    private LinkedList<DailyWeatherReport> DailyReportList;

    public DailyReportList(LinkedList<DailyWeatherReport> dailyReportList) {
        DailyReportList = dailyReportList;
    }

    //averageTemp: takes a month and a year and produces the average temperature over all days that month.
    public double averageTemp(int month, int year) {
        LinkedList<Double> monthTemp = new LinkedList<>();
        double sum = 0;
        int n = 0;

        for (DailyWeatherReport d : DailyReportList) {
            if (d.getDate().get(GregorianCalendar.MONTH) == month && d.getDate().get(GregorianCalendar.YEAR) == year)
                monthTemp.add(d.avgTempReading());
        }

        if(monthTemp.size() == 0) {
            return 0;
        }
        for (double t : monthTemp) {
            sum += t;
        }
        return sum / monthTemp.size();
    }

    //totalRainfall: takes a month and a year and produces the total rainfall over all days that month.
    public double totalRainfall(int month, int year) {
        double total = 0;

        for (DailyWeatherReport d : DailyReportList) {
            if (d.getDate().get(GregorianCalendar.MONTH) == month && d.getDate().get(GregorianCalendar.YEAR) == year)
                total += d.totalRainfallReading();
        }
        return total;
    }

    //addReport: consumes a date and a list of readings (nominally for that date) and stores a daily report for the given date.
    public void addReport(GregorianCalendar date, LinkedList<Reading> readings) {
        DailyWeatherReport Report = new DailyWeatherReport(new GregorianCalendar(0, 0, 0), new LinkedList<>(), new LinkedList<>());
        LinkedList<Double> tempReport = new LinkedList<>();
        LinkedList<Double> rainfallReport = new LinkedList<>();

        if (readings.size() != 0) {
            for (Reading r : readings) {
                tempReport.add(r.getTemp());
                rainfallReport.add(r.getRainfall());
            }

            Report.setDate(date);
            Report.setTempReading(tempReport);
            Report.setRainfallReading(rainfallReport);
            this.DailyReportList.add(Report);
        }
    }
}
