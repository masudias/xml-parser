import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVInputForPList {
    private String BSSID;
    private Date lastRoamed;
    private Date lastJoined;
    private Date lastAutoJoined;
    private Double networkUsage;

    public String getBSSID() {
        return BSSID;
    }

    public void setBSSID(String BSSID) {
        this.BSSID = BSSID;
    }

    public String getLastRoamed() {
        if (lastRoamed == null) return null;

        DateFormat targetDf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return targetDf.format(lastRoamed);
    }

    public void setLastRoamed(Date lastRoamed) {
        this.lastRoamed = lastRoamed;
    }

    public String getLastJoined() {
        if (lastJoined == null) return null;

        DateFormat targetDf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return targetDf.format(lastJoined);
    }

    public void setLastJoined(Date lastJoined) {
        this.lastJoined = lastJoined;
    }

    public String getLastAutoJoined() {
        if (lastAutoJoined == null) return null;

        DateFormat targetDf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return targetDf.format(lastAutoJoined);
    }

    public void setLastAutoJoined(Date lastAutoJoined) {
        this.lastAutoJoined = lastAutoJoined;
    }

    public Double getNetworkUsage() {
        return networkUsage;
    }

    public void setNetworkUsage(Double networkUsage) {
        this.networkUsage = networkUsage;
    }

    public boolean isAllFieldsAreNull() {
        return (lastJoined == null && lastAutoJoined == null && lastRoamed == null && networkUsage == null);
    }
}