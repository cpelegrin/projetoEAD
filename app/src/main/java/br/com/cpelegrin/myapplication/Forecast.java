
package br.com.cpelegrin.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("weekday")
    @Expose
    private String weekday;
    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("condition")
    @Expose
    private String condition;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}
