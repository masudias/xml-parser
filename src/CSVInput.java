import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CSVInput {
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
            DateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm", Locale.ENGLISH);
            Date date = df.parse(creationDate);
            this.creationDate = df.format(date);
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