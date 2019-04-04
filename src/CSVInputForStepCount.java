import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVInputForStepCount {
    private String sourceName;
    private String sourceVersion;
    private String creationDate;
    private String value;

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceVersion() {
        return sourceVersion;
    }

    public void setSourceVersion(String sourceVersion) {
        this.sourceVersion = sourceVersion;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            Date date = df.parse(creationDate);
            DateFormat targetDf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.creationDate = targetDf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}